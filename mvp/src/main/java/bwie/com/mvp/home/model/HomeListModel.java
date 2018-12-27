package bwie.com.mvp.home.model;

import android.util.Log;

import bwie.com.mvp.network.MyTask;

public class HomeListModel implements IHomeListModel {
    ModuleInterface moduleInterface;

    public HomeListModel(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    @Override
    public void getModelData(final String url) {
        new Runnable(){
            @Override
            public void run() {

                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result: "+t);
                        if (t!=null){
                            moduleInterface.LoadSuccess(t);

                        }else{
                            moduleInterface.LoadFailed();
                        }

                    }
                }).execute();
            }
        }.run();


    }
    public interface ModuleInterface {
        //获取数据状态回调的接口
        void LoadSuccess(String data);

        void LoadFailed();
    }
}
