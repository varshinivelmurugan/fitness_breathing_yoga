package com.example.yoga;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.yoga.Adapter.RecyclerViewAdapter;
import com.example.yoga.Model.Exercise;
import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {

    List<Exercise> exerciseList =new ArrayList<>();  //list to store the exercises

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    protected void onCreate(Bundle savedInstancestate) {

        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_list_exercises);  //
        initData();

        recyclerView = (RecyclerView)findViewById(R.id.list_ex);
        adapter = new RecyclerViewAdapter(exerciseList,getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {

        exerciseList.add(new Exercise(R.drawable.ashtanga_pose,"Ashtanga pose"));
        exerciseList.add(new Exercise(R.drawable.spinal_twist_pose,"Spinal Twist pose"));
        exerciseList.add(new Exercise(R.drawable.palm_tree_pose,"PalmTree pose"));
        exerciseList.add(new Exercise(R.drawable.childpose,"Child pose"));
        exerciseList.add(new Exercise(R.drawable.humming_bee_breathe,"Humming Bee Breathe pose"));
        exerciseList.add(new Exercise(R.drawable.corpse_pose,"Corpse pose"));
    }
}
