/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mw.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mitch
 */
public interface Player {
    void setName(String name);
    String getName();
    int getMove();
    ArrayList<Integer> getList();
    void setList(int move);
    
}
