package com.gregchu.f4.app;

/**
 * Created by GRCHU01 on 6/10/2014.
 */


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.support.v4.app.Fragment;
import android.view.Menu;

public class AnotherActivity extends FragmentActivity {
    private static final String AnotherActivity = "AnotherActivity";
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Intent intent=getIntent();
        Log.d(AnotherActivity, " Inside another activity ");
        int index=intent.getIntExtra("index",0);
        FragmentB f2= (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        Log.d(AnotherActivity, "  "+(f2==null));
        if(f2!=null)
        {
            f2.changeData(index);
        }
    }


}
