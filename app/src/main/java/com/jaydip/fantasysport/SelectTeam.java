package com.jaydip.fantasysport;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.jaydip.fantasysport.Addapter.playerAddapter;
import com.jaydip.fantasysport.models.Contest;
import com.jaydip.fantasysport.models.Player;
import com.jaydip.fantasysport.models.selectedContest;

import java.util.ArrayList;
import java.util.List;

public class SelectTeam extends AppCompatActivity {

    TextView teamA,teamB,match,total;
    RecyclerView recyclerView;
    List<Player> players;
    playerAddapter addapter;
    Contest contest;
    creditCounter counter;


    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
        dialog.setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<Player> players = addapter.getPlayers();
                List<Player> selected = new ArrayList<Player>();
                for(int a =0; a < players.size();a++){
                    Player single = players.get(a);
                    if(single.isSelected()){
                        selected.add(single);
                    }
                }
                selectedContest contestList = new selectedContest(contest,selected,counter.getValue());
                Intent intent = new Intent();
                intent.putExtra("selectedResult",contestList);
                setResult(220,intent);
                SelectTeam.super.onBackPressed();
            }
        });
        dialog.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SelectTeam.super.onBackPressed();
            }
        });
        dialog.setCancelable(false);
        dialog.create();
        dialog.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);
        recyclerView = findViewById(R.id.playerRecycle);
        teamA = findViewById(R.id.teamA);
        teamB = findViewById(R.id.teamB);
        match = findViewById(R.id.match);
        total = findViewById(R.id.total);
        counter = new creditCounter();
        counter.getTotal().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double value) {
                total.setText(value+"");
            }
        });
         addapter = new playerAddapter(this,counter);
        players = new ArrayList<Player>();
        for(int a = 1 ;a <21 ; a++){
            Player single = new Player();
            single.setPlayreName("player"+a);
            single.setAge(20+a+"");

            single.setCredit(7.5);
            if(a>10){
                single.setCredit(8.0);
            }
            single.setSelected(false);
            players.add(single);

        }
        recyclerView.setAdapter(addapter);
        addapter.setPlayers(players);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            contest = (Contest) bundle.getSerializable("object");
            match.setText(contest.getMatchName());
        }

    }
}