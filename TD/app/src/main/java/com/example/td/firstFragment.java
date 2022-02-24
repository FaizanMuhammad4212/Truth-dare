package com.example.td;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class firstFragment extends Fragment {

    Button truthBtn,dareBtn;
    FragmentManager fragmentManager;


    public firstFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        truthBtn=view.findViewById(R.id.btn1);
        dareBtn=view.findViewById(R.id.btn2);

        truthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TruthActivity.class));
                getFragmentManager().beginTransaction().remove(firstFragment.this).commit();

            }
        });

        dareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DareActivity.class));
                getFragmentManager().beginTransaction().remove(firstFragment.this).commit();
            }
        });

        return view;
    }


    }
