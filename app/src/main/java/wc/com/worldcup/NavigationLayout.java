package wc.com.worldcup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class NavigationLayout extends LinearLayout {

    public NavigationLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.navigation, this);
        Button home = findViewById(R.id.home);
        Button saicheng = findViewById(R.id.saicheng);
        Button qiuyuan = findViewById(R.id.qiuyuan);
        Button qiuchang = findViewById(R.id.qiuchang);
        home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked home",
                        Toast.LENGTH_SHORT).show();
            }
        });
        saicheng.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked saicheng",
                        Toast.LENGTH_SHORT).show();
            }
        });

        qiuyuan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked qiuyuan",
                        Toast.LENGTH_SHORT).show();
            }
        });

        qiuchang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked qiuchang",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
