package xifuyin.tumour.com.a51ehealth.mvpdemo.utils;

import android.support.design.widget.TabLayout;
import android.view.View;

/**
 * Created by Administrator on 2018/5/10.
 */

public class ViewUtils {


    /**
     * 根据Tab合起来的长度动态修改tab的模式
     *
     * @param tabLayout TabLayout
     */
    public static void dynamicSetTabLayoutMode(TabLayout tabLayout) {
        int tabTotalWidth = 0;
        for (int i = 0; i < tabLayout.getChildCount(); i++) {
            final View view = tabLayout.getChildAt(i);
            view.measure(0, 0);
            tabTotalWidth += view.getMeasuredWidth();
        }
        if (tabTotalWidth <= ScreenUtils.getScreenSize(tabLayout.getContext()).x) {
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }
}
