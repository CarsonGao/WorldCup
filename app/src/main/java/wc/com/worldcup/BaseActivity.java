package wc.com.worldcup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    /*
    BaseActivity继承AppCompatActivity重写onCreate()方法，用于显示当前页面是哪个Activity
     */
    //获取当前Class名称
    private final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, getClass().getSimpleName());
        //本页面添加时将Activity添加入List中
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //本页面销毁时将Activity从List中移除
        ActivityCollector.removeActivity(this);
    }
}

