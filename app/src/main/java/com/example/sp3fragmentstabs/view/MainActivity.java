package com.example.sp3fragmentstabs.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.sp3fragmentstabs.R;
import com.example.sp3fragmentstabs.ViewPagerAdapter;
import com.example.sp3fragmentstabs.data.Animal;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager2 viewPager;
    private TabLayout tabs;
    private String[] tabLabels = {"Animal_List", "Descriptions"};

ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.main_activity_viewPager);
        tabs = findViewById(R.id.main_activity_tabs);

        viewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabLabels[position]);
            }
        }).attach();
    }

    public void onClick(View view){
        viewPager.setCurrentItem(1);
    }

}