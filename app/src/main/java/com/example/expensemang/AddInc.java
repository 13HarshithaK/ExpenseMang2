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
import android.widget.Toast;
public class AddInc extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public EditText tv;
    public Button butt;
    private OnFragmentInteractionListener mListener;

    public AddInc() {
        // Required empty public constructor
    }
    public static AddInc newInstance(String param1, String param2) {
        AddInc fragment = new AddInc();
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
        View view=inflater.inflate(R.layout.fragment_add_inc, container, false);
        tv=view.findViewById(R.id.etMoneyadd);
        butt=view.findViewById(R.id.btaddmon);
        act2();
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

    public void act2()
    {
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tv.getText().toString();
                if(str.equals(""))
                    Toast.makeText(getActivity(),"Enter amount", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(),"Rs."+str+"  added", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
