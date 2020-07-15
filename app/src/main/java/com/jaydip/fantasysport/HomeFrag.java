package com.jaydip.fantasysport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydip.fantasysport.Addapter.ContestAddapter;
import com.jaydip.fantasysport.models.Contest;

import java.util.ArrayList;
import java.util.List;

public class HomeFrag extends Fragment {

    List<Contest> contests;
    public HomeFrag() {
        // Required empty public constructor
        contests = new ArrayList<Contest>();
        for(int a =1 ;a <21;a++){
            Contest single = new Contest("Series A","match "+a,"Team A","Team B","2:30");
            contests.add(single);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView =  view.findViewById(R.id.HomeRecycler);
        ContestAddapter adapter = new ContestAddapter(getContext(),getActivity());
        adapter.setcontests(contests);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}