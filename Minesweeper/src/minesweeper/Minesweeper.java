/*
*Model for Minesweeper program this is for the display
 */
package minesweeper;

import java.awt.Dimension;
import java.awt.GridLayout; //so we can make a grid of buttons
import javax.swing.JOptionPane;
import javax.swing.JFrame;//the canvas per say
import javax.swing.JPanel; //sizable windows for user 
import javax.swing.JLabel; //creates a text or string display are or both
import javax.swing.JButton;//to draw buttons
import java.awt.event.MouseAdapter; // creates an event listener for mouse motion
import java.awt.event.MouseEvent; //creates an event listener for mouseclicks
import java.awt.event.*; //this allows for ActionListeners



import java.util.Random; //import for use of randomizer


/**
 * @author Mitchell Vessair
 */
public class Minesweeper extends JFrame {
   
        static JPanel pnl = new JPanel(new GridLayout(5, 5));
    //adding interactive component to display
    
      
        static int[][] squares = new int[5][5];
        //size of the array
        
//        //these are buttons to click. They are blank buttons to begin with button we will format them to do what we want
//    JButton square = new JButton("");

    
    
    
    public Minesweeper() {
    //this is the constructor (or frame) to build the Window components
    
    //the very basic window is comprised of a width and height and a close button
        super("Minesweeper");
        //this is inheriting the title
            //the title that is shown at the very top of a window
        setSize(200, 230);
        //(width, height) in pixels
//        setResizable(false);
        //so everything fits
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //it is all capitalized because it is a constant value. Can apply to variables as well
        add(pnl);
        //this adds interactivity to the window
        makeGrid();
        setVisible(true);
        //the window will actually show up on the display now
        //only two values: true and false        
        
    }
    
    public static void makeGrid() {
        
        Random rng = new Random();
        int count = 0;
        //regulates the number of mines

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                //assigning the array to an individual button
                JButton tile = new JButton();
                JButton mine = new JButton();
                int randomNumber = rng.nextInt(2) + 1;
                    if(randomNumber == 2){
                        squares[i][j] = 1;
                        pnl.add(tile);
                        System.out.println("Tile made");
                    }
                    else if(randomNumber == 1) {
                        if (count < 5){
                            squares[i][j] = 0;
                            pnl.add(mine);
                            count++;
                            System.out.println("Bomb made");
                        }
                        else{
                            squares[i][j] = 2;
                            pnl.add(tile);
                            System.out.println("Max mines reached, added tile");
                        }
                    }

                //displays 
                tile.setPreferredSize(new Dimension(50, 50)); //sets size of square
                tile.setLocation(0,0); //supposedly sets square location
                    tile.addActionListener(new ActionListener() {
                    //when the tile is clicked, the ActionEvent will occur
                        public void actionPerformed(ActionEvent e) {
                            //tileClicked() occurs once clicked
                            tileClick(tile, mine);
                            tile.setVisible(false);
                        }
                    });
                    
                mine.setPreferredSize(new Dimension(30, 30)); //sets size of square
                mine.setLocation(0,0); //supposedly sets square location
                    mine.addActionListener(new ActionListener() {
                    //when the tile is clicked, the ActionEvent will occur
                        public void actionPerformed(ActionEvent e) {
                            //tileClicked() occurs once clicked
                            JOptionPane.showMessageDialog(pnl, "BOOM");
                        }
                    });
            }
            System.out.println("Next Row");
        }
        //these variable buttons are defined above
    }
    
    public static void tileClick(JButton tile, JButton mine) {
        
        // Fill boxes adjacent to mines with numbers
        OUTERLOOP:
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (squares[i][j]== 1) {
                        for (int k = 0; k <= 1 ; k++) {
                            for (int l = 0; l <= 1; l++) {
                                // In boundary cases
                                try {
                                    if (squares[i+k][j+l]!= 0) {
                                        squares[i+k][j+l] = 1;
                                        System.out.println("Checked Tile"); 
                                        JOptionPane.showMessageDialog(pnl, "Checked Tile" + squares[i][j]); ////using the check tile print out to see if program will properly recognise a tile thats been clicked.
                                        checkTile(i, j);
                                        break OUTERLOOP;
                                    }
                                }
                                catch (Exception e) {
                                    // Do nothing
                                }
                            }
                        }
                }
            }
        }
        tile.setVisible(false);
    }
    
    public static void checkTile(int i, int j) {
        
        
        
    }
    
    public static void main(String[] args) {
       
        Minesweeper gui = new Minesweeper();
        //making an object of the button class useless array i created for reference

//        int [][] square; //making minesweeper array in integer format
//        square = new int [10][10]; // creates 100 integers
//        square [0][0] = 5; // placing numbers at locations
//        square [1][1] = 2;
//        square[3][2] = 3;
//
//        //sub is tiles : colon means what it is going to be now
//        for (int[] sub : square) {
//            for (int x = 0; x < sub.length; x++) {
//                System.out.print(sub[x] + " ");
//            }
//            System.out.println();
//        }

    }  
}
