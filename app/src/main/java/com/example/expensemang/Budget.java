package com.example.expensemang;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Budget.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Budget#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Budget extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    public RadioGroup rbgrp;
    public RadioButton rbtn;
    public EditText et1;
    public Button bt;

    public Budget() {
        // Required empty public constructor
    }
    public static Budget newInstance(String param1, String param2) {
        Budget fragment = new Budget();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_budget, container, false);
        rbgrp=view.findViewById(R.id.rbg);
        et1=view.findViewById(R.id.etBud);
        bt=view.findViewById(R.id.btset);
        act();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void act()
    {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ep=rbgrp.getCheckedRadioButtonId();
                String no=et1.getText().toString();
                rbtn=view.findViewById(ep);
                if(rbgrp.getCheckedRadioButtonId() == -1 || no.equals("")) {
                    Toast.makeText(getActivity(),"Select type of budget to set and amount", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getActivity(),"Budget Set", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
