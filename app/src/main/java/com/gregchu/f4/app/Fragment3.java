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
public class Fragment3 extends Fragment {
    private static final String Fragment3 = "Fragment3";
    FragmentA.Communicator communicator;
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(Fragment3,"onAttach");
        communicator =(FragmentA.Communicator)activity;
    }

    public void setCommunicator(FragmentA.Communicator communicator)
    {
        this.communicator=communicator;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            Log.d(Fragment3,"onCreate FIRST TIME");
        }
        else
        {
            Log.d(Fragment3,"onCreate SUBSEQUENT TIME");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.d(Fragment3,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Log.d(Fragment3,"onTouch");
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    Log.d(Fragment3,"onTouch move");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d(Fragment3,"onTouch down");
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.d(Fragment3,"onTouch up");
                    Log.d(Fragment3,(communicator==null)+"");
                    communicator.respond(2);
                }
                return true;
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(Fragment3,"onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Fragment3,"onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Fragment3,"onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Fragment3,"onPause");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(Fragment3,"onSaveInstanceState");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Fragment3,"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Fragment3,"onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Fragment3,"onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Fragment3,"onDetach");

    }
}
