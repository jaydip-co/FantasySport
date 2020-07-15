package com.jaydip.fantasysport.models;

import java.io.Serializable;
import java.util.List;

public class selectedContest implements Serializable {
    double totalCredit;
    Contest contest;
    List<Player> selectedPlayers;

    public selectedContest(Contest contest,List<Player> selectedPlayers,double totalCredit) {
        this.contest = contest;
        this.selectedPlayers = selectedPlayers;
        this.totalCredit = totalCredit;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Player> getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(List<Player> selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }
}
