package com.example.yoga.Adapter;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoga.Model.Exercise;
import com.example.yoga.R;
import com.example.yoga.Interface.ItemClickListener;
import java.util.List;

// RecycleView used for listview

class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
public ImageView image;
public TextView text;

private ItemClickListener itemClickListener;

    public RecycleViewHolder( View itemView) {
        super(itemView);
        image =(ImageView)itemView.findViewById(R.id.ex_img);
        text =(TextView)itemView.findViewById(R.id.ex_name);
        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
itemClickListener.onClick(v,getAdapterPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {

    }
}


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecycleViewHolder>{

    private List<Exercise> exerciseList;      // for exercise class which has image of exercise and name list is created
    private Context context;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    //this method is used to inflate the item_exercise.xml

    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator= LayoutInflater.from(parent.getContext());
        View itemview = inflator.inflate(R.layout.item_exercise,parent,false);
        return  new RecycleViewHolder(itemview);
    }

    @Override
    //this method is used to set data to each row

    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
    holder.image.setImageResource(exerciseList.get(position).getImage_id());
    holder.text.setText(exerciseList.get(position).getName());
    holder.setItemClickListener(new ItemClickListener(){

    @Override
    public void onClick(View View, int position) {
        Toast.makeText(context,"Click to"+exerciseList.get(position).getName(),Toast.LENGTH_SHORT).show();
    }
});

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
