public class LCS {
    //Class attributes to hold the character arrays and the grids
    char[] word1;
    char[] word2;
    int[][] grid;
    int[][] path;
    String solution = "";
    
    //Constructor method that takes the strings as parameters and stores them and uses the length
    //to inialize the arrays
    LCS(String first, String second) {
        this.word1 = first.toCharArray();
        this.word2 = second.toCharArray();
        this.grid = new int[first.length() +1][second.length() +1];
        this.path = new int[first.length() +1][second.length() +1];
    }

    //Void method that does the dynamic programming algorithm using a nested for loop with different coniditions
    //that keep track of the directional movement.
    public void lcsDynamicSol() {
        for(int i = 0; i <= this.word1.length; i++) {

            for(int j = 0; j <= this.word2.length; j++) {
                //Condition that sets the first row and column to 0
                if(i == 0 || j == 0) {
                    this.grid[i][j] = 0;
                }
                //Else statement if the letters are the same and we are moving diagonal
                else if(this.word1[i-1] == this.word2[j-1]) {
                    this.grid[i][j] = this.grid[i-1][j-1] + 1;
                    this.path[i][j] = 1;
                }
                //Else statement if we are either down up or left
                else {
                    //If condition if the previous row is greater than the previous column
                    if(this.grid[i-1][j] >= this.grid[i][j-1]) {
                        this.grid[i][j] = this.grid[i-1][j];
                        this.path[i][j] = 2;
                    }
                    //Else condition if the previous column is greater than the porevious row
                    else {
                        this.grid[i][j] = this.grid[i][j-1];
                        this.path[i][j] = 3;
                    }
                    
                }
            }
        }    
    }

    //Recursive method that is a shell to call the actual recursive method getLCSR and passes the proper
    //parameters to start from the final element in the 2D array. This method returns the sub sequence string
    public String getLCS() {
        this.solution = "";
        getLCSR(this.grid, this.word1, this.word1.length, this.word2.length);
        return this.solution;
    }

    //void method that does the recursion
    public void getLCSR(int[][] path, char[] string, int i, int j) {
        //If statement that returns from the recursion if i or j is equal to 0
        if(i == 0 || j == 0) {
            return;
        }

        //If condition that makes a recursive call if the directional arrow is diagonal
        if(this.path[i][j] == 1) {
            getLCSR(path, string, i-1, j-1);
            this.solution = this.solution + string[i-1];
        }
        //else condition that makes a recursive call if the directional arrow is down
        else if(this.path[i][j] == 2) {
            getLCSR(path, string, i-1, j);
        }
        //else condition that makes a recursive call if the directional arrow is left
        else {
            getLCSR(path, string, i, j-1);
        }
    }
    }