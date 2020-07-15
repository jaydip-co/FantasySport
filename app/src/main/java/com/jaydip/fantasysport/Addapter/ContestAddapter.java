package com.jaydip.fantasysport.Addapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaydip.fantasysport.R;
import com.jaydip.fantasysport.SelectTeam;
import com.jaydip.fantasysport.models.Contest;

import java.util.ArrayList;
import java.util.List;

public class ContestAddapter extends RecyclerView.Adapter<ContestAddapter.ContextViehHolder> {
    List<Contest> Contests;
    LayoutInflater inflater;
    Activity activity;
    public ContestAddapter(Context context, Activity activity){
        inflater = LayoutInflater.from(context);
        Contests = new ArrayList<Contest>();
        this.activity = activity;
    }
    @NonNull
    @Override
    public ContextViehHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contest_item,parent,false);
        return new ContextViehHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContextViehHolder holder, int position) {
        if(Contests != null){
            final Contest single = Contests.get(position);
            holder.teamA.setText(single.getTeamA());
            holder.teamB.setText(single.getTeamB());
            holder.match.setText(single.getMatchName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent first  = new Intent(holder.itemView.getContext(), SelectTeam.class);

                    first.putExtra("name",single.getMatchName()+"");
                    first.putExtra("object",single);
                    Log.e("jaydip", "onClick: "+single.getMatchName());
                    activity.startActivityForResult(first,200);

                }
            });

        }

    }

    public void setcontests(List<Contest> contests){
        this.Contests = contests;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return Contests.size();
    }


    class ContextViehHolder extends RecyclerView.ViewHolder{

        TextView teamA;
        TextView teamB;
        TextView time;
        TextView match;
        public ContextViehHolder(@NonNull final View itemView) {
            super(itemView);
            teamA = itemView.findViewById(R.id.teamA);
            teamB = itemView.findViewById(R.id.teamB);
            match = itemView.findViewById(R.id.matchName);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent first  = new Intent(itemView.getContext(), SelectTeam.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("name",time.getText()+"");
//                    itemView.getContext().startActivity(first);
//                }
//            });
        }

    }
}
