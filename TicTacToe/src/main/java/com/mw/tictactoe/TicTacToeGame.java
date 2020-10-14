/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mw.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mitch
 */
public class TicTacToeGame {
    static Scanner SC = new Scanner(System.in);
    static Integer[] gameBoard = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    static List<List<Integer>> winningConditions = new ArrayList<>();
    static List<Integer> temp;
    static boolean gameOver = true;
    static String winner;
    static Player player1;
    static Player player2;
    
    static int checkSpot(int nextMove, int player) {
        if (!temp.contains(-1)) {
                displayBoard();
                System.out.println("Draw. Game Over1.");
        }
        if (gameBoard[nextMove] != -1)
        {
            
            if (player1 instanceof ComputerPlayer) {
                nextMove = player1.getMove();
            }
            else if (player2 instanceof ComputerPlayer) {
                nextMove = player2.getMove();
            }
            else {
                System.out.println("This spot is taken. Please choose another tile.");
                nextMove = Integer.parseInt(SC.nextLine());
            }    
            return checkSpot(nextMove, player);
        }
        else {
            System.out.println(nextMove + " is taken!");
            gameBoard[nextMove] = player;
        }
        return nextMove;
    }
    
    static boolean checkBoard(ArrayList<Integer> moveSet, String player) {
        for (List<Integer> w : winningConditions) {
            int count = 0;
//            for(int i = 0, c = 0; i < moveSet.size() && c <= 3; i++, c++) {
            for(int i = 0;i < moveSet.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (moveSet.get(i) == w.get(j)) {      
                        count++;
                        if (count == 3) {
                            displayBoard();
                            winner = player;
                            System.out.println(player + " wins!");
                            System.exit(0);
                            return false;
                        }
                    }
                }
            }
        }   
        return true;
    }
    
    static void displayBoard() {
        
//        | 1 | 2 | 3 |
//        | 4 | 5 | 6 |
//        | 7 | 8 | 9 |
        
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
            System.out.print("|" + gameBoard[index] + "|");
            index++;
            }
            System.out.println();
        }
    }
    
    static void displayNumbers() {
        System.out.println("Here is how you select a tile.");
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
            System.out.print("|" + index + "|");
            index++;
            }
            System.out.println();
        }
    }
    
            
    public static void main(String [] args) {     
        
        winningConditions.add(Arrays.asList(0,1,2));
        winningConditions.add(Arrays.asList(3,4,5));
        winningConditions.add(Arrays.asList(6,7,8));
        winningConditions.add(Arrays.asList(0,4,8));
        winningConditions.add(Arrays.asList(0,3,6));
        winningConditions.add(Arrays.asList(1,4,7));
        winningConditions.add(Arrays.asList(2,5,8));
        winningConditions.add(Arrays.asList(2,4,6));
        
        String choice;
        System.out.println("Welcome to Tic Tac Toe!");
        
        System.out.println("What should Player 1 be?");
        choice = SC.nextLine();

        if (choice.equalsIgnoreCase("human")) {
            player1 = new HumanPlayer();
            System.out.println("What's your name?");
            player1.setName(SC.nextLine());
        }
        else {
            player1 = new ComputerPlayer();
            System.out.println("What's your name?");
            player1.setName(SC.nextLine());
        }

        System.out.println("What should Player 2 be?");
        choice = SC.nextLine();

        if (choice.equalsIgnoreCase("human")) {
            player2 = new HumanPlayer();
            System.out.println("What's your name?");
            player2.setName(SC.nextLine());
        }
        else {
            player2 = new ComputerPlayer();
            System.out.println("What's the computer's name?");
            player2.setName(SC.nextLine());
        }

        while (gameOver) {

            temp = Arrays.asList(gameBoard);
            System.out.println("-----------Next Round--------------");
            displayNumbers();
            System.out.println("Here is the current board.");
            displayBoard();
            
            
            System.out.println(player1.getName() + "'s turn:");
            player1.setList(checkSpot(player1.getMove(), 0));
            gameOver = checkBoard(player1.getList(), player1.getName());
            if (gameOver == false || !temp.contains(-1)) {
                displayBoard();
                System.out.println("Draw. Game Over2.");
                break;
            }
            displayNumbers();
            System.out.println("Current Board:");
            displayBoard();
            temp = Arrays.asList(gameBoard);
            System.out.println(player2.getName() + "'s turn:");
            player2.setList(checkSpot(player2.getMove(), 1));
            gameOver = checkBoard(player2.getList(), player2.getName());
            if (gameOver == false || !temp.contains(-1)) {
                displayBoard();
                System.out.println("Draw. Game Over3.");
                break;
            }


        
        }
    } 
}
