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

public class TheGirls extends ListFragment {

    private WorkoutEntityDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            datasource = new WorkoutEntityDataSource(getActivity());
            datasource.open();

            List<WorkoutEntity> workouts = datasource.getAllGirls();

            // use the SimpleCursorAdapter to show the elements in a list view
            ArrayAdapter<WorkoutEntity> adapter = new ArrayAdapter<WorkoutEntity>(this.getActivity(), android.R.layout.simple_expandable_list_item_1, workouts);
            setListAdapter(adapter);
        }
        catch (Exception ex)
        {
            Log.e("TheGirls", ex.toString());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_thegirls, container, false);
    }
}
