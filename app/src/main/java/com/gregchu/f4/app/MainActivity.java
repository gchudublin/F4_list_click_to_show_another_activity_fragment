package com.gregchu.f4.app;

import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements FragmentA.Communicator {
    private FragmentTransaction fragmentTransaction;
    private static final String MainActivity = "Main Activity";
    FragmentManager fm;
    FragmentTransaction ft;
    FragmentA f1;
    FragmentB f2;
    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ViewServer.get(this).addWindow(this);
        Log.d(MainActivity, "main activity onCreate ");
        setContentView(R.layout.activity_main);
        fm=getSupportFragmentManager();
        //below is viewpager
        viewPager= (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(fm));
        //below is listview
        f1= (FragmentA) fm.findFragmentById(R.id.fragment);
        f1.setCommunicator(this);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
     //   ft.hide(f1);
        ft.commit();

     //   viewPager= (ViewPager) findViewById(R.id.pager);
        //android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();

     //   viewPager.setAdapter(new MyAdapter(fm));
//        f2= (FragmentB) manager.findFragmentById(R.id.fragment2);
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.show (f2);
//        ft.commit();
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
//        Log.d(MainActivity, "get Item is called "+i);
            if (i == 0) {
                fragment = new Fragment1();
            }
            if (i == 1) {
                fragment = new Fragment2();
            }
            if (i == 2) {
                fragment = new Fragment3();
                android.support.v4.app.FragmentManager fm  = fragment.getFragmentManager();
            }
            return fragment;
        }

        @Override
        public int getCount() {
//        Log.d(MainActivity, "get Count is called");
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Tab 1";
            }
            if (position == 1) {
                return "Tab 2";
            }
            if (position == 2) {
                return "Tab 3";
            }
            return null;
        }

    }



    @Override
    public void respond(int index) {
        Log.d(MainActivity, " Inside main activity ");
        FragmentB f2= (FragmentB) fm.findFragmentById(R.id.fragmentB);
        if(f2!=null && f2.isVisible())
        {
            Log.d(MainActivity, " f2 change data ");
            f2.changeData(index);
        }
        else
        {
            Log.d(MainActivity, " calling intent ");
            Intent intent=new Intent(this, AnotherActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }
}
