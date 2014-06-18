package com.gregchu.f4.app;

import android.app.ActionBar;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by greg on 6/8/2014.
 */
public class FragmentB extends android.support.v4.app.Fragment {
    TextView text;
    ViewPager viewPager=null;
    LinearLayout layout;
    LinearLayout.LayoutParams params;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("VIVZ","View was created");
        View view=inflater.inflate(R.layout.fragment_b, container, false);
        text= (TextView) view.findViewById(R.id.textView);
        return view;
    }
    public void changeData(int index)
    {
        String[] descriptions=getResources().getStringArray(R.array.Desc);
        Log.d("VIVZ","Descriptions retrieved");
        text.setText(descriptions[index]);
    }
}
