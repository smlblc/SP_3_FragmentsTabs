package com.example.sp3fragmentstabs.view.listscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sp3fragmentstabs.R;
import com.example.sp3fragmentstabs.data.Animal;
import com.example.sp3fragmentstabs.view.AnimalListAdapter;
import com.example.sp3fragmentstabs.view.MainActivity;

import java.util.ArrayList;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link FirstFragment_Animals#newInstance} factory method to
// * create an instance of this fragment.
// */
public class ListFragment extends Fragment {

    private final ArrayList<Animal> animalArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first__animals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_animal);
        populateAnimalList();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        AnimalListAdapter animalAdapter = new AnimalListAdapter(animalArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(animalAdapter);

        animalAdapter.setAnimalOnClickListener(new MyOnClickAnimalAction() {
            @Override
            public void onClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("titleKey", animalArrayList.get(position).animalTitle);
                bundle.putInt("animal_ImageIdKey", animalArrayList.get(position).animalImageId);
                bundle.putString("animal_InfoKey", animalArrayList.get(position).AnimalInfo);

                getParentFragmentManager().setFragmentResult("animalKey", bundle);
                ((MainActivity) getActivity()).onClick(view);
            }
        });
    }

    public void populateAnimalList() {
        String[] animalTitle = getResources().getStringArray(R.array.animal_title);
        String[] animalImageName = getResources().getStringArray(R.array.animal_Image_Name);
        String[] animalInfo = getResources().getStringArray(R.array.animal_info);

        for (int i = 0; i < animalTitle.length; i++) {
            int imageId = getResources().getIdentifier(animalImageName[i], "drawable", getActivity().getPackageName());
            animalArrayList.add(new Animal(animalTitle[i], imageId, animalInfo[i]));
        }
    }
}