package bwie.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bwie.com.mvp.home.presanter.HomeListPresanter;
import bwie.com.mvp.home.view.IHomeListView;

public class MainActivity extends AppCompatActivity implements IHomeListView {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =findViewById(R.id.text1);
        HomeListPresanter homeListPresanter = new HomeListPresanter(this);
        homeListPresanter.getPresanterData();
    }

    @Override
    public void getViewData(String mViewData) {
    textView.setText(mViewData);
    }
}
