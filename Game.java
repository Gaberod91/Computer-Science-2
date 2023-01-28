import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    //Declare the 2D int array and char array
    public static int board[][];
    char moves[] = new char[16];
    
        //Game constructor that creates the board and calls the readMoves method to create read from the file and
        //create the char arrray containing the moves of player 1.
        Game(int size, String file) throws FileNotFoundException {
            board = new int[size][size];
            readMoves(file);
        }
        //Method that reads from a file with the name stored in string object fileName, uses a while loop
        //to read everything from the file and adds the characters from the file to the char array moves
        public void readMoves(String fileName) throws FileNotFoundException {

            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            int i = 0;
            String s;
            //While loop that runs until the file has no next line and stores the char from the file in a char array moves
            while(sc.hasNextLine())
            {
                s = sc.nextLine();
                moves[i] = s.charAt(0);
                i++;
            }
            sc.close();
        }
        //Play method that simulates one round of the game and takes a parameter of an integer which will be either 1 or 2
        //this determines the player that we want to win the game. The function uses a while loop and if/else conditions
        //in order to determine the winner of the round based on the parameter num. 
        public int play(int num) {
            int row = 0;
            int column = 0;
            int i = 0;
            int j = 0;
                //While loop that runs until the knight is at the end of the bottom right spot of the board.
                while(row <= 7 && column <= 7) {
                    //System.out.print("Player 1 move: ");
                    //The following code contains several if/else statements that determine what course of action we selecting moves.
                    //If we are either at the last row or column, we can only move one way. If we are at the bottom right spot on 
                    //the array, then we break out of the loop. Other than these scenarios, the game runs based on the implemented 
                    //strategy below.

                    //Player 1's move
                    //Condition if we are at the last row and we can only move right
                    if(row == 7) {
                        column++;
                       
                        board[row][column] = 1;
                    }
                    //Condition if we are at the last column and can only move down
                    else if(column == 7) {
                        row++;
                      
                        board[row][column] = 1;
                    }
                    //else if statement for move r condition
                     else if(moves[i] == 'r') {

                        column++;
                    
                        board[row][column] = 1;
                        j = 0;
                    }
                    //else if statement for move b condition
                    else if(moves[i] == 'b') {

                        row++;
                       
                        board[row][column] = 1;
                        j = 1;
                    }
                    //else if statement for move d condition
                    else if(moves[i] == 'd') {
                    
                        row++;
                        column++;
                        
                        board[row][column] = 1;
                        j = 2;
                    }
                    //Breaks the loop here if player 1 moves the knight into the winning position
                    if(row == 7 && column == 7)
                    {
                        break;
                    }

                    //Player 2's move
                    
                    //Condition if we are at the last row and can only move right
                    if(row == 7) {
                    
                        column++;
                        
                        board[row][column] = 2;
                    }
                    //Condition if we are at the last column and can only move down
                    else if(column == 7) {
                    
                        row++;
                        
                        board[row][column] = 2;
                    }
                    //Pattern for player 1 set of moves to always win using if/else statements
                    else { 
                        if(num == 1) {
                        if(row == column) {

                    row++;
                    
                    board[row][column] = 2;
                        }

                        else if(row != column) {

                            column++;
                            row++;
                            
                            board[row][column] = 2;
                        }
                    }
                    //Pattern for player 2 set of moves to always win using if/else statements 
                    else if(num == 2) {
                        if(j == 0){
                            row++;
                        
                        board[row][column] = 2;
                        }

                        else if(j == 1) {
                            column++;
                       
                        board[row][column] = 2;
                        } 

                        else if(j == 2) {
                            if((row == 5 && column == 5) && moves[i + 1] == 'd')
                            {
                                row++;
                               
                                board[row][column] = 2;
                            }
                            else {
                        row++;
                        column++;
                        
                        board[row][column] = 2;
                            }
                        }          
                    }           
                    }
                    //Breaks the loop here if player 2 moves the knight into the winning position
                    if(row == 7 && column == 7)
                    {
                        break;
                    }
                    i++;
            }
            return board[row][column];
        }
}