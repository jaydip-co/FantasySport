package com.jaydip.fantasysport.models;

import java.io.Serializable;

public class Contest   implements Serializable {
    final String name;
    final String matchName;
    final String teamA;
    final String teamB;
    final String time;

    public Contest(String name, String matchName, String teamA, String teamB, String time) {
        this.name = name;
        this.matchName = matchName;
        this.teamA = teamA;
        this.teamB = teamB;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getMatchName() {
        return matchName;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getTime() {
        return time;
    }
}
