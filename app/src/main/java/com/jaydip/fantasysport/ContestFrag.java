package com.jaydip.fantasysport;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaydip.fantasysport.Addapter.ContestAddapter;
import com.jaydip.fantasysport.Addapter.selectedContestAdapter;
import com.jaydip.fantasysport.models.Contest;
import com.jaydip.fantasysport.models.selectedContest;

import java.util.List;

public class ContestFrag extends Fragment {


    RecyclerView recyclerView;

    List<selectedContest> contests;
    ContestFrag(List<selectedContest> contestsList){
        this.contests = contestsList;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contest, container, false);
        recyclerView = view.findViewById(R.id.ContestRecycler);

        selectedContestAdapter adapter = new selectedContestAdapter(getContext(),getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setSelectedContestList(contests);
        return view;
    }

}