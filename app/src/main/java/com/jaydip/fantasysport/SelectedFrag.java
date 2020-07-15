package com.jaydip.fantasysport;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.jaydip.fantasysport.Addapter.playerAddapter;
import com.jaydip.fantasysport.Addapter.selectedPlayerAdapter;
import com.jaydip.fantasysport.models.Contest;
import com.jaydip.fantasysport.models.Player;
import com.jaydip.fantasysport.models.selectedContest;

import java.util.List;

public class SelectedFrag extends Fragment {


    selectedContest selectedcontest;
    public SelectedFrag(selectedContest contest){
        this.selectedcontest = contest;
    }
    TextView teamA,teamB,match,total;
    RecyclerView recyclerView;
    List<Player> players;
    selectedPlayerAdapter addapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_select_team, container, false);
        recyclerView = v.findViewById(R.id.playerRecycle);
        teamA = v.findViewById(R.id.teamA);
        teamB = v.findViewById(R.id.teamB);
        match = v.findViewById(R.id.match);
        total = v.findViewById(R.id.total);
        teamA.setText(selectedcontest.getContest().getTeamA());
        teamB.setText(selectedcontest.getContest().getTeamB());
        match.setText(selectedcontest.getContest().getMatchName());
        total.setText(selectedcontest.getTotalCredit()+"");
        creditCounter counter = new creditCounter();
        counter.settotal(selectedcontest.getTotalCredit());
        addapter = new selectedPlayerAdapter(getContext());
        addapter.setSelected(selectedcontest.getSelectedPlayers());
        recyclerView.setAdapter(addapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}