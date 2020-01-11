package models;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.ArrayList;

public class Hero {
    private String heroName;
    private String heroAge;
    private String specialPower;
    private String heroWeakness;
    private static ArrayList<Hero> heroInstance = new ArrayList<>();

    public Hero(String heroName, String heroAge, String specialPower, String heroWeakness) {
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.specialPower = specialPower;
        this.heroWeakness = heroWeakness;
        this.heroInstance.add(this);
    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroAge() {
        return heroAge;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public static ArrayList<Hero> getHeroInstance() {
        return heroInstance;
    }
}

