package cn.easyar.samples.helloarvideo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //三个tab布局
    private RelativeLayout homeLayout, scanLayout, meLayout;
    //底部标签切换的Fragment
    private Fragment homeFragment, scanFragment, meFragment,loginFragment, currentFragment;

    //底部标签图片
    private ImageView homeImg, scanImg, meImg;
    //底部标签的文本
    private TextView homeTv, scanTv, meTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainly);
        initUI();
        initTab();
    }
    /**
     * 初始化UI
     */
    private void initUI() {
        homeLayout=(RelativeLayout)findViewById(R.id.rl_home);
        scanLayout=(RelativeLayout)findViewById(R.id.rl_order);
        meLayout=(RelativeLayout)findViewById(R.id.rl_me);

        homeLayout.setOnClickListener(this);
        scanLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);

        homeImg = (ImageView) findViewById(R.id.iv_home);
        scanImg = (ImageView) findViewById(R.id.iv_order);
        meImg = (ImageView) findViewById(R.id.iv_me);
        homeTv = (TextView) findViewById(R.id.tv_home);
        scanTv = (TextView) findViewById(R.id.tv_order);
        meTv = (TextView) findViewById(R.id.tv_me);
    }
    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (homeFragment == null) {

            homeFragment=new HomeFragment();
        }

        if (!homeFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, homeFragment).commit();

            // 记录当前Fragment
            currentFragment = homeFragment;
            // 设置图片文本的变化
            homeImg.setImageResource(R.drawable.btn_home_pre);
            homeTv.setTextColor(getResources()
                    .getColor(R.color.bottomtab_press));
            scanImg.setImageResource(R.drawable.btn_order_nor);
            scanTv.setTextColor(getResources().getColor(
                    R.color.bottomtab_normal));
            meImg.setImageResource(R.drawable.btn_my_nor);
            meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_home: // 知道
                clickTab1Layout();
                break;
            case R.id.rl_order: // 我想知道
                clickTab2Layout();
                break;
            case R.id.rl_me: // 我的
                clickTab3Layout();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void clickTab1Layout() {
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), homeFragment);

        // 设置底部tab变化
        homeImg.setImageResource(R.drawable.btn_home_pre);
        homeTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
        scanImg.setImageResource(R.drawable.btn_order_nor);
        scanTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
    }

    /**
     * 点击第二个tab
     */
    private void clickTab2Layout() {
        if (scanFragment == null) {
            scanFragment = new ScanFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), scanFragment);

        homeImg.setImageResource(R.drawable.btn_home_nor);
        homeTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        scanImg.setImageResource(R.drawable.btn_order_pre);
        scanTv.setTextColor(getResources().getColor(
                R.color.bottomtab_press));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    /**
     * 点击第三个tab
     */
    private void clickTab3Layout() {
        if (meFragment == null) {
                meFragment = new MeFragment();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), meFragment);

        homeImg.setImageResource(R.drawable.btn_home_nor);
        homeTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        scanImg.setImageResource(R.drawable.btn_order_nor);
        scanTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_pre);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_press));

    }

    /**
     * 添加或者显示碎片
     *
     * @param transaction
     * @param fragment
     */
    public void addOrShowFragment(FragmentTransaction transaction,
                                  Fragment fragment) {
        if (currentFragment == fragment)
            return;

        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }

        currentFragment = fragment;
    }

}
