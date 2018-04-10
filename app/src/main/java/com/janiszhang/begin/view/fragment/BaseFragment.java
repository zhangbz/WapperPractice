package com.janiszhang.begin.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;

/**
 * Created by janiszhang on 2018/4/2.
 *
 * BaseFragment介于功能fragment和系统api之间
 *
 * 主要就是为我们所有的fragment提供公共的行为或事件
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
