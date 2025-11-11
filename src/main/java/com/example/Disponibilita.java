package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disponibilita{
    List<Integer> disponibilita = new ArrayList<>();
    

    

    public void init(){ 
    disponibilita.add(10); // Gold
    disponibilita.add(30); // Pit
    disponibilita.add(60); // Parterre
    }
    int gold = 10;
    int pit = 30;
    int parterre = 60;

    public int getGold() {
        return gold;
    }

    public int getPit() {
        return pit;
    }

    public int getParterre() {
        return parterre;
    }


        
    }

