/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mw.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mitch
 */
public class HumanPlayer implements Player{
    private Scanner SC = new Scanner(System.in);
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
        int move;
        System.out.println("Please select a tile: ");
        move = Integer.parseInt(SC.nextLine());
        if (move > 8) {
            System.out.println("Please enter the appropriate number.");
            getMove();
        }
        return move;
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
