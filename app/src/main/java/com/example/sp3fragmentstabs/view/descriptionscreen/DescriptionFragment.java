package com.example.sp3fragmentstabs.view.descriptionscreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sp3fragmentstabs.R;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link DescriptionFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class DescriptionFragment extends Fragment {

    private ImageView animal_Image;
    private TextView animal_Title;
    private TextView animal_Info;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public DescriptionFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment DescriptionFragment.
//     */
    // TODO: Rename and change types and number of parameters
//    public static DescriptionFragment newInstance(String param1, String param2) {
//        DescriptionFragment fragment = new DescriptionFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animal_Image = view.findViewById(R.id.fragment_description_animal_Image);
        animal_Title = view.findViewById(R.id.fragment_description_animal_title);
        animal_Info = view.findViewById(R.id.fragment_description_animal_info);

        getParentFragmentManager().setFragmentResultListener("animalKey", this, new FragmentResultListener() {  //.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                animal_Image.setImageResource(bundle.getInt("animal_ImageIdKey"));
                animal_Title.setText(bundle.getString("titleKey"));
                animal_Info.setText(bundle.getString("animal_InfoKey"));
            }
        });
    }
}