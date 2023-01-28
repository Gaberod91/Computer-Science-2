import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyChildren {
    //Declare Attributes of GreedyChildren class 
    int children[];
    int sweets[];
    int happy;
    int angry;
    
    //Overloaded constructor that takes the parameters of the int pieces of candy, int number of children
    //String name of file 1 and another string name of file2
    //This method makes a call to the read method that constructs the integer arrays by reading from the two files
    GreedyChildren(int pieces, int children, String file1, String file2) throws FileNotFoundException {
        this.sweets = new int[pieces];
        this.children = new int[children];
        read(file1, file2, pieces, children);
    }


    public void read(String file1, String file2, int pieces, int children) throws FileNotFoundException {
        //Initialize a file object and scanner object for reading from the file
        File file = new File(file1);
        Scanner sc = new Scanner(file);
        String s;

        //While loop to traverse the file and collect on the data from the file
        while(sc.hasNextLine()){
        
            //For loop for looping through the array and storing the integer that was read from the file
            for(int i = 0; i < children; i++){
                s = sc.nextLine();
            
                this.children[i] = Integer.parseInt(s);
            }
        }
        //Initialize a file object and scanner object for reading from the file
        File sfile = new File(file2);
        Scanner scan = new Scanner(sfile);
        //While loop to traverse the file and collect on the data from the file
        while(scan.hasNextLine()){
        
            //For loop for looping through the array and storing the integer that was read from the file
            for(int i = 0; i <pieces; i++){
                s = scan.nextLine();
            
                this.sweets[i] = Integer.parseInt(s);
            }
        }

        sc.close();
        scan.close();
        //Here we sort our arrays using the Arrays.sort method in order to implement the greedy algorithm easier
        Arrays.sort(this.children);
        Arrays.sort(this.sweets);
    }

    //greedyCandy method that implements a greedy algorithm
    //This method uses a for loop and starts with the greediest child and the sweetest piece of candy
    //If the candy satifies the child we decrement the sweets array and move to the next child
    //Else we give the child a piece of candy from the front of the array, and save the sweetest candy for the next child
    //happy child gets incremented in the if statement, angry child gets incremented in the else statement
    public void greedyCandy() {
        int j = this.sweets.length -1;

        for(int i = this.children.length-1; i >= 0; i--) {

            if(this.sweets[j] >= this.children[i]) {
                this.happy++;
                j--;
            }

            else {
                this.angry++;
            }

        }
    }

    //display method that prints the results of the program on two separate lines.
    //displays the number of happy and angry children in the greedy algorithm
    public void display() {
        System.out.println("There are " + this.happy + " happy children.");
        System.out.println("There are " + this.angry + " angry children.");
    }

}
