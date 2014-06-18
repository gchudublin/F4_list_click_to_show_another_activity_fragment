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

import com.gregchu.f4.app.R;

/**
 * Created by Vivz on 10/25/13.
 */
public class Fragment2 extends Fragment {

    private static final String Fragment2 = "Fragment2";
    FragmentA.Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(Fragment2, "onAttach");
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
            Log.d(Fragment2,"onCreate FIRST TIME");
        }
        else
        {
            Log.d(Fragment2,"onCreate SUBSEQUENT TIME");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        Log.d(Fragment2,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                Log.d(Fragment2,"onTouch");
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    Log.d(Fragment2,"onTouch move");
                }
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d(Fragment2,"onTouch down");
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.d(Fragment2,"onTouch up");
                    Log.d(Fragment2,(communicator==null)+"");
                    communicator.respond(1);
                }
                return true;
            }
        });

        return view;
    }

}
