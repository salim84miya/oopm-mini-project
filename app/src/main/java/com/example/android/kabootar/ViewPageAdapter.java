package com.example.android.kabootar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.kabootar.fragment.AimlFragment;
import com.example.android.kabootar.fragment.CompFragment;
import com.example.android.kabootar.fragment.ElecFragment;
import com.example.android.kabootar.fragment.IotFragment;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 : return new AimlFragment();

            case 1 : return new CompFragment();

            case 2 : return new IotFragment();

            case 3: return new ElecFragment();

            default: return new AimlFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
