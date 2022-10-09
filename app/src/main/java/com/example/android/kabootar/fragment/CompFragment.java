package com.example.android.kabootar.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.kabootar.R;
import com.example.android.kabootar.SpecialRequestPage;


public class CompFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comp, container, false);
        Button button = (Button) view.findViewById(R.id.comp_item_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SpecialRequestPage.class);
                startActivity(intent);
            }
        });

        return view;
    }
}