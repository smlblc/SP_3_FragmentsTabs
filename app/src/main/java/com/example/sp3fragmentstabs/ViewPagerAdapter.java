package com.example.sp3fragmentstabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sp3fragmentstabs.view.descriptionscreen.DescriptionFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0) {
            return new ListFragment();
        }else if(position == 1){
            return new DescriptionFragment();
        }else {
            return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
