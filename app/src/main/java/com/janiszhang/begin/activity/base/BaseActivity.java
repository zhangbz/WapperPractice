package com.janiszhang.begin.activity.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by janiszhang on 2018/4/2.
 *
 * BaseActivity为我们所有的activity提供公共的行为
 *
 * AppCompatActivity由v4 support包提供，可以取代普通Activity和FragmentActivity
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * 输出日志，所需tag
     */
    public String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
