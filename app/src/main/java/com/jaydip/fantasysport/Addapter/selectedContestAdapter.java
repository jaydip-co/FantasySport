package com.jaydip.fantasysport.Addapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.jaydip.fantasysport.ContestFrag;
import com.jaydip.fantasysport.R;
import com.jaydip.fantasysport.SelectedFrag;
import com.jaydip.fantasysport.models.Contest;
import com.jaydip.fantasysport.models.selectedContest;

import java.util.ArrayList;
import java.util.List;

public class selectedContestAdapter extends RecyclerView.Adapter<selectedContestAdapter.selectedContestHolder> {

    LayoutInflater inflater;
    List<selectedContest> selectedContestList;
    FragmentActivity activity;
    public selectedContestAdapter(Context context, FragmentActivity activity){
        inflater = LayoutInflater.from(context);
        selectedContestList = new ArrayList<selectedContest>();
        this.activity = activity;
    }
    @NonNull
    @Override
    public selectedContestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = inflater.inflate(R.layout.contest_item,parent,false);
       return new selectedContestHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull selectedContestHolder holder, int position) {

        if(selectedContestList != null){
            final selectedContest single = selectedContestList.get(position);
            holder.teamA.setText(single.getContest().getTeamA());
            holder.teamB.setText(single.getContest().getTeamB());
            holder.match.setText(single.getContest().getMatchName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framLayout,new SelectedFrag(single)).addToBackStack(null).commit();
                }
            });
        }

    }

    public void setSelectedContestList(List<selectedContest> contests){
        this.selectedContestList = contests;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return selectedContestList.size();
    }

    class  selectedContestHolder extends RecyclerView.ViewHolder{
        TextView teamA;
        TextView teamB;
        TextView time;
        TextView match;
        public selectedContestHolder(@NonNull View itemView) {
            super(itemView);
            teamA = itemView.findViewById(R.id.teamA);
            teamB = itemView.findViewById(R.id.teamB);
            match = itemView.findViewById(R.id.matchName);
        }
    }
}
