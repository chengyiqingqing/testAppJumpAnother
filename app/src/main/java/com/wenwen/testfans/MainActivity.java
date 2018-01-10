package com.wenwen.testfans;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    PackageManager packageManager=null;

//    String packageName="com.wenwen.another";
//    String packageName="com.tencent.mobileqq";
    String packageName="com.facebook.katana";

    private static final String TAG = "sww";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.bt_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: asdfsadfdf" );
                if (packageManager==null){
                    Log.e(TAG, "onClick: packageManager==null" );
                    packageManager = getPackageManager();
                }
                Log.e(TAG, "onClick:   --1    " );
                if (checkPackInfo(packageName)) {
                    Log.e(TAG, "onClick:  ----  "+packageName);
                    Intent intent = packageManager.getLaunchIntentForPackage(packageName);

                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "没有安装" + packageName,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 检查包是否存在
     *
     * @param packname
     * @return
     */
    private boolean checkPackInfo(String packname) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(packname, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

}
