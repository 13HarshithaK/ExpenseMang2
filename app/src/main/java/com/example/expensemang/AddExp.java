package com.example.expensemang;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddExp.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddExp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddExp extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Spinner sp;
    public Button bt;
    public ArrayAdapter adapter;
    public EditText et;
    private OnFragmentInteractionListener mListener;
    View view;
    public AddExp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddExp.
     */
    // TODO: Rename and change types and number of parameters
    public static AddExp newInstance(String param1, String param2) {
        AddExp fragment = new AddExp();
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
        view=inflater.inflate(R.layout.fragment_add_exp, container, false);
        sett();
        disp();
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

    public void sett()
    {
        bt=view.findViewById(R.id.btaddmon2);
        sp =view.findViewById(R.id.spcategory);
        adapter= ArrayAdapter.createFromResource(this.getContext(),
                R.array.Select_Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp.setAdapter(adapter);
        et=view.findViewById(R.id.etMoneyrem);
    }

    public void disp()
    {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cate=sp.getSelectedItem().toString();
                String mon=et.getText().toString();
                if(mon.equals(""))
                    Toast.makeText(getActivity(),"Enter amount", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(),"Entry added for "+cate+", Rs."+mon+"  added", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
