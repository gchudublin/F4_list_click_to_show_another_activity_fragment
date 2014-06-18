package com.gregchu.f4.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import  com.gregchu.f4.app.CustomBaseAdapter;
import  com.gregchu.f4.app.RowItem;

/**
 * Created by greg on 6/8/2014.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener{
    ListView list;
    List<RowItem> rowItems;
    Communicator communicator;
    private static final String FragmentA = "FragmentA";
    public static final String[] titles = new String[] { "Strawberry",
            "Banana", "Orange", "Mixed" };

    public static final String[] descriptions = new String[] {
            "It is an aggregate accessory fruit",
            "It is the largest herbaceous flowering plant", "Citrus Fruit",
            "Mixed Fruits" };

    public static final Integer[] images = { R.drawable.straw,
            R.drawable.banana, R.drawable.orange, R.drawable.mixed };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a, container, false);
        list= (ListView) view.findViewById(R.id.listView);

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        CustomBaseAdapter adapter = new CustomBaseAdapter(getActivity(), rowItems);
   //     ArrayAdapter adapter= ArrayAdapter.createFromResource(getActivity(),R.array.Chu,android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        return view;
    }
    public void setCommunicator(Communicator communicator)
    {
        this.communicator=communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(FragmentA,(communicator==null)+"");
        communicator.respond(i);
    }

    public interface Communicator
    {
        public void respond(int index);
    }

}
