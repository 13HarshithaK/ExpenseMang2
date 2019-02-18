package com.example.expensemang;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Category extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public FragmentManager fragmentManager;
    public FragmentTransaction ft;
    public Fragment frag;
    private String mParam1;
    private String mParam2;
    public Button btcat1;
    public Button btcat2;
    public Button btcat3;
    public Button btcat4;
    public Button btcat5;
    public Button btcat6;
    public Button btaddcat;
    private OnFragmentInteractionListener mListener;

    public Category() {
        // Required empty public constructor
    }
    public static Category newInstance(String param1, String param2) {
        Category fragment = new Category();
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
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        btcat1=view.findViewById(R.id.cat1);
        btcat2=view.findViewById(R.id.cat2);
        btcat3=view.findViewById(R.id.cat3);
        btcat4=view.findViewById(R.id.cat4);
        btcat5=view.findViewById(R.id.cat5);
        btcat6=view.findViewById(R.id.cat6);
        btaddcat=view.findViewById(R.id.catadd);
        actbt();
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

    public void actint()
    {
        fragmentManager = getActivity().getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.LayoutFrame, new CatBreakup(),"findThisFragment");
        ft.addToBackStack(null).commit();
    }

    public void actbt()
    {
        btcat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });
        btcat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });
        btcat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });
        btcat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });
        btcat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });
        btcat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actint();
            }
        });

        btaddcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Added Category", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
