package com.example.sp3fragmentstabs.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sp3fragmentstabs.R;
import com.example.sp3fragmentstabs.data.Animal;
import com.example.sp3fragmentstabs.view.listscreen.MyOnClickAnimalAction;

import java.util.ArrayList;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder> {

    private ArrayList<Animal> animalArrayList;
    private MyOnClickAnimalAction animalActionListener;


    public AnimalListAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    public void setAnimalOnClickListener(MyOnClickAnimalAction animalActionListener) {
                this.animalActionListener = animalActionListener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_animal, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.animalTitle.setText(animalArrayList.get(position).animalTitle);
        holder.animalImage.setImageResource(animalArrayList.get(position).animalImageId);
    }

    @Override
    public int getItemCount() {
        return animalArrayList.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView animalTitle;
        ImageView animalImage;
        //TextView animalInfo;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalTitle = itemView.findViewById(R.id.animal_title);
            animalImage = itemView.findViewById(R.id.animal_image);
            //animalInfo = itemView.findViewById(R.id.fragment_animal_info);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    animalActionListener.onClick(getAdapterPosition());
                }
            });
        }


    }
}
