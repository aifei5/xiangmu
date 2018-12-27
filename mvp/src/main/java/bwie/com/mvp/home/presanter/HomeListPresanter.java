package bwie.com.mvp.home.presanter;

import android.util.Log;

import bwie.com.mvp.MainActivity;
import bwie.com.mvp.api.Api;
import bwie.com.mvp.home.model.HomeListModel;

public class HomeListPresanter implements IHomeListPresanter,HomeListModel.ModuleInterface {
    MainActivity mainActivity;
    private String modeInterDate;

    private final HomeListModel homeListModel;

    public HomeListPresanter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        homeListModel = new HomeListModel(this);

    }

    @Override
    public void getPresanterData() {
        homeListModel.getModelData(Api.SHOPLIST);
        Log.i("TAG", "getPresanterData: "+modeInterDate);

    }

    @Override
    public void LoadSuccess(String data) {
        mainActivity.getViewData(data);
    }

    @Override
    public void LoadFailed() {
        mainActivity.getViewData("加载失败");
    }
}
