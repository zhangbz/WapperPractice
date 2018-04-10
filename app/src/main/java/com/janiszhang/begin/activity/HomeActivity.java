package com.janiszhang.begin.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.janiszhang.begin.R;
import com.janiszhang.begin.activity.base.BaseActivity;
import com.janiszhang.begin.view.fragment.HomeFragment;
import com.janiszhang.begin.view.fragment.MessageFragment;
import com.janiszhang.begin.view.fragment.MineFragment;

/**
 * @author janiszhang
 * @date 2018/4/2
 *
 *创建首页所有的fragment，并控制fragment之间的切换
 *
 * 扩展--fragment有几种切换方式
 * 1.replace(= remove + add) 或者 remove + add  replace使得栈中始终只有一个fragment(由于remove时实例会被回收掉，所以每次replace都是重新创建实例)
 * 2.hide + show -- 开发中最常用的切换方式  这种方式比较消耗内存，但是不会回收掉实例
 * 3.detach + attach 比较鸡肋，一般不用，调用detach不会销毁fragment，但会销毁view，attach时又要重新绘制view（内存上没有多少优化，额外导致了view的重新绘制）
 *
 * 注意：此种类型的Activity的启动模式通常都是singleTask
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    /**
     * fragment相关
     */
    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCommonFragmentOne;
    private Fragment mCurrent;


    private RelativeLayout mHomeLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;
//    private RelativeLayout mPondLayout;
    private TextView mHomeView;
    private TextView mMessageView;
    private TextView mMineView;
//    private TextView mPondView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        //初始话页面中所有的控件
        initView();

        //添加默认要显示的fragment
        mHomeFragment = new HomeFragment();
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();
    }

    /**
     * 初始化页面中的所有控件
     *
     * 注意：一个比较好的开发习惯是在页面初始化的时候集中完成全部UI元素的初始化，
     * 不要等到需要写相应的逻辑的时候采取初始化
     *
     * 关于注解框架的使用：一般小型应用程序的开发是可以使用的，但是企业级应用的开发不推荐使用注解框架，
     * 原因是使用注解框架肯定会对性能产生一定的影响，另外万一在某些系统上出现什么奇葩的问题会比较麻烦。
     */
    private void initView() {
        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);
//        mPondLayout = (RelativeLayout) findViewById(R.id.pond_layout_view);
//        mPondLayout.setOnClickListener(this);
        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);
        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);


        mHomeView = (TextView) findViewById(R.id.home_image_view);
//        mPondView = (TextView) findViewById(R.id.fish_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);
        mHomeView.setBackgroundResource(R.mipmap.comui_tab_home_selected);
    }


    /**
     * 用来隐藏具体的fragment
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home_selected);
//                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message);
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    fragmentTransaction.show(mHomeFragment);
                }

                break;

            case R.id.message_layout_view:
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home);
//                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    fragmentTransaction.show(mMessageFragment);
                }

                break;

//            case R.id.pond_layout_view:
//                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home);
//                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond_selected);
//                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message);
//                mMineView.setBackgroundResource(R.mipmap.comui_tab_person);
//                break;

            case R.id.mine_layout_view:
                mHomeView.setBackgroundResource(R.mipmap.comui_tab_home);
//                mPondView.setBackgroundResource(R.mipmap.comui_tab_pond);
                mMessageView.setBackgroundResource(R.mipmap.comui_tab_message);
                mMineView.setBackgroundResource(R.mipmap.comui_tab_person_selected);

                hideFragment(mCommonFragmentOne, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mHomeFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    fragmentTransaction.show(mMineFragment);
                }
                break;

            default:

                break;
        }

        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
