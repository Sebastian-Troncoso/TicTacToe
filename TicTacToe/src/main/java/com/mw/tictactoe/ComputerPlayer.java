/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mw.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mitch
 */
public class ComputerPlayer implements Player {
    private Random choose = new Random();
    private String playerName;
    private ArrayList<Integer> moveList = new ArrayList<>();
    
    @Override
    public void setName(String name) {
        playerName = name;
    }
    
    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public int getMove() {
        return choose.nextInt(9);
    }
    
    @Override
    public ArrayList<Integer> getList() {
      return moveList;
    }
    
    @Override
    public void setList(int move) {
        moveList.add(move);
    }
    
    
    
}
