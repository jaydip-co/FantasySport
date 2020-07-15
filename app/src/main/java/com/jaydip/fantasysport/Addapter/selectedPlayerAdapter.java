package com.jaydip.fantasysport.Addapter;

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

import com.google.android.material.appbar.AppBarLayout;
import com.jaydip.fantasysport.R;
import com.jaydip.fantasysport.creditCounter;
import com.jaydip.fantasysport.models.Player;

import java.util.List;

public class selectedPlayerAdapter extends RecyclerView.Adapter<selectedPlayerAdapter.selectedPlayerViewHolder> {

    LayoutInflater inflater;
    List<Player> selected;
    public selectedPlayerAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public selectedPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= inflater.inflate(R.layout.player_single,parent,false);
        return new selectedPlayerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull selectedPlayerViewHolder holder, int position) {

        if(selected !=null){
            Player single = selected.get(position);
            holder.PlayreName.setText(single.getPlayreName());
            holder.age.setText(single.getAge());
            holder.Credit.setText(single.getCredit()+"");
        }
    }

    public void setSelected(List<Player> players){
        this.selected = players;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return selected.size();
    }

    class  selectedPlayerViewHolder extends RecyclerView.ViewHolder{

        TextView PlayreName;
        TextView age;
        TextView Credit;
        CardView cardView;
        public selectedPlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            PlayreName = itemView.findViewById(R.id.playerName);
            age = itemView.findViewById(R.id.playerAge);
            Credit = itemView.findViewById(R.id.Playercredit);
            itemView.findViewById(R.id.playerAdd).setVisibility(View.GONE);
            cardView = itemView.findViewById(R.id.playerCard);
            cardView.setBackgroundColor(Color.argb(100,200,0,10));
        }
    }
}
