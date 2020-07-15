package com.jaydip.fantasysport.Addapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jaydip.fantasysport.R;
import com.jaydip.fantasysport.creditCounter;
import com.jaydip.fantasysport.models.Player;

import java.util.ArrayList;
import java.util.List;

public class playerAddapter extends RecyclerView.Adapter<playerAddapter.playerHolder> {
    List<Player> players;
    LayoutInflater inflater;
    creditCounter counter;
    List<Player> selected;
    final double MAX = 40.0;
    public playerAddapter(Context context, creditCounter counter){
        players = new ArrayList<Player>();
        selected = new ArrayList<Player>();
        inflater = LayoutInflater.from(context);
        this.counter = counter;
    }

    @NonNull
    @Override
    public playerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.player_single,parent,false);
        return new playerHolder(view);
}

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull playerHolder holder,  int position) {
        final int pos = position;
        if(players != null){
            final Player single = players.get(position);
            holder.PlayreName.setText(single.getPlayreName());
            holder.age.setText(single.getAge());
            holder.Credit.setText(single.getCredit()+"");
            if(single.isSelected()){
                holder.add.setVisibility(View.GONE);
                holder.remove.setVisibility(View.VISIBLE);
            }
            else {
                holder.add.setVisibility(View.VISIBLE);
                holder.remove.setVisibility(View.GONE);
            }
            if( single.isSelected())
            {
                holder.cardView.setBackgroundColor(Color.argb(100,200,0,10));
            }
            else if(!single.isSelected() && (counter.getValue()+single.getCredit()) <= MAX){
                holder.cardView.setBackgroundColor(Color.argb(100,0,200,10));
            }
            else if(  !single.isSelected() && counter.getValue()+single.getCredit() > MAX){
                holder.cardView.setBackgroundColor(android.R.color.darker_gray);
            }
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                       double curent = counter.getValue();
                       curent = curent + single.getCredit();
                       if(curent <= MAX){
                           single.setSelected(true);
                           players.remove(pos);
                           players.add(pos,single);
                           notifyDataSetChanged();
                           counter.settotal(curent);
                       }

                }
            });
            holder.remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    single.setSelected(false);
                    double current = counter.getValue();
                    current = current - single.getCredit();
                    players.remove(pos);
                    players.add(pos,single);
                    notifyDataSetChanged();
                    counter.settotal(current);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return players.size();
    }
    public List<Player> getPlayers(){
        return players;
    }
    public void setPlayers(List<Player> players){
        this.players = players;
        notifyDataSetChanged();
    }

    class playerHolder extends RecyclerView.ViewHolder{
        TextView PlayreName;
        TextView age;
        TextView Point;
        TextView Credit;
        Button add,remove;
        CardView cardView;
        public playerHolder(@NonNull View itemView) {
            super(itemView);
            PlayreName = itemView.findViewById(R.id.playerName);
            age = itemView.findViewById(R.id.playerAge);
            Credit = itemView.findViewById(R.id.Playercredit);
            add = itemView.findViewById(R.id.playerAdd);
            remove = itemView.findViewById(R.id.playedRemove);
            cardView = itemView.findViewById(R.id.playerCard);
        }
    }
}
