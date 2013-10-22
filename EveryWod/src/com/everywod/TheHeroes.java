package com.everywod;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.everywod.data.WorkoutEntity;
import com.everywod.data.WorkoutEntityDataSource;

import java.util.List;

public class TheHeroes extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            WorkoutEntityDataSource datasource = new WorkoutEntityDataSource(getActivity());
            datasource.open();

            List<WorkoutEntity> workouts = datasource.getAllHeroes();

            // use the SimpleCursorAdapter to show the elements in a list view
            ArrayAdapter<WorkoutEntity> adapter = new ArrayAdapter<WorkoutEntity>(this.getActivity(), android.R.layout.simple_expandable_list_item_1, workouts);
            setListAdapter(adapter);
        }
        catch (Exception ex)
        {
            Log.e("TheHeroes", ex.toString());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_heroes, container, false);
    }
}
