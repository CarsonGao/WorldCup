package wc.com.worldcup;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private int recLen = 5; //倒计时五秒
    private TextView tv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定义全屏参数(全屏参数已经在AndroidManifest.xml中定义了所以不需要再java代码中再处理了)
        //int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        //getWindow().setFlags(flag, flag);

        //点击图标不重复启动欢迎页面 再将android:launchMode="standard"去掉
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        setContentView(R.layout.activity_welcome);

        //影响系统顶部状态栏
        LinearLayout layout = findViewById(R.id.welcome);
        layout.setSystemUiVisibility(View.INVISIBLE);

        initView();

        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);//延迟5S后发送handler信息
    }

    private void initView() {
        tv = findViewById(R.id.tv);//跳过
        tv.setOnClickListener((View.OnClickListener) this);//跳过监听
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen -= 1;
                    tv.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    /**
     * 点击跳过
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }


}
