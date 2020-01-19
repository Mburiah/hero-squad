package models;

import java.util.ArrayList;

public class Squad {
    private int squadId;
    private String squadName;
    private String squadCause;
    private int maxSize;
    private static ArrayList<Squad> squadInstance = new ArrayList<>();
    private static ArrayList<Hero> heroes = new ArrayList<>();

    public Squad(String squadName, String squadCause, int maxSize) {
        this.squadName = squadName;
        this.squadCause = squadCause;
        this.maxSize = maxSize;
        this.squadId = squadInstance.size();
        this.squadInstance.add(this);
    }

    public String getSquadName() {
        return squadName;
    }

    public String getSquadCause() {
        return squadCause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public static ArrayList<Hero> getHeroes() { return heroes; }

    public static ArrayList<Squad> getSquadInstance() {
        return squadInstance;
    }
}
