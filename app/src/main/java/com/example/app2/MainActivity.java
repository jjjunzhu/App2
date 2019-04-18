package com.example.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context useCount = null;
        try {
            // 获取其他程序对应的Context
            useCount = createPackageContext("com.example.app1",
                    Context.MODE_PRIVATE);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        // 使用其他程序的COntext获取对应的SharedPreferences
        SharedPreferences ps = useCount.getSharedPreferences("count",
                Activity.MODE_PRIVATE);
        // 读取数据
        int count = ps.getInt("count", 0);
        TextView show = (TextView) findViewById(R.id.show);
        // 显示读取的数据内容
        show.setText("UseCount应用程序之前被使用了" + count + "次");
    }
}


