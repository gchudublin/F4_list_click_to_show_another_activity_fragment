package com.gregchu.f4.app;

/**
 * Created by greg on 6/13/2014.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vivz on 10/25/13.
 */
public class Fragment1 extends Fragment implements View.OnTouchListener {

    private static final String Fragment1 = "Fragment1";
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(Fragment1,"onAttach");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            Log.d(Fragment1,"onCreate FIRST TIME");
        }
        else
        {
            Log.d(Fragment1,"onCreate SUBSEQUENT TIME");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.d(Fragment1,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Log.d(Fragment1,"onTouch");
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    Log.d(Fragment1,"onTouch move");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d(Fragment1,"onTouch down");
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.d(Fragment1,"onTouch up");
                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(Fragment1,"onActivityCreated");

    }



    @Override
    public void onStart() {
        super.onStart();
        Log.d(Fragment1,"onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Fragment1,"onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Fragment1,"onPause");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(Fragment1,"onSaveInstanceState");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Fragment1,"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Fragment1,"onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Fragment1,"onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Fragment1,"onDetach");

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(Fragment1,"onTouch");
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            Log.d(Fragment1,"onTouch move");
        }
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d(Fragment1,"onTouch down");
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            Log.d(Fragment1,"onTouch up");
        }
        return true;
    }
}
