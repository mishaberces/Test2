package home.misha.testnew;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Misha on 16.04.2016.
 */
public class PegerAdapter extends PagerAdapter {

    List<View> peges=null;

    public PegerAdapter (List<View> peges){
        this.peges=peges;

    }


    @Override
    public int getCount() {
        return peges.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


    @Override
    public void destroyItem(View container, int position, Object view) {
        ((ViewPager)container).removeView((View)view);

    }

    @Override
    public Object instantiateItem(View container, int position) {
        View v = peges.get(position);
        ((ViewPager) container).addView(v, 0);
        return v;
    }

    @Override
    public CharSequence getPageTitle(int position) {

          return "Завдання " + (position+1);
    }


}


