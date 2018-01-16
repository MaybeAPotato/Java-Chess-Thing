package chessassignment;

//The Pieces
import chessStuff.emptySpace;
import chessStuff.piecePawn;
import chessStuff.pieceRook;
import chessStuff.pieceKnight;
import chessStuff.pieceBishop;
import chessStuff.pieceQueen;
import chessStuff.pieceKing;
import chessStuff.pieceInterface;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//IO
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Utils
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardManager extends JPanel{
    int winCheck = 0;
    boolean gameOver = false;
    private JButton[][] buttons;
    
    
    pieceInterface[][] arBoard = new pieceInterface[8][8]; //Board is 8 by 8
    int[][] arBoard2 = new int[8][8]; //Tracks who controls what pieces
    
    int nPlayerTurn; //Tracks whose turn it is
    
    int nPieceX; //For piece selection
    int nPieceY; //For piece selection
    
    int nMoveX; //For piece movement
    int nMoveY; //For piece movement
    
    int nPhase = 0;
    
    Scanner scScanner = new Scanner(System.in);
    
    public void setBoard(){
        /*
        COORDINATES
        [0,0][1,0][2,0][3,0][4,0][5,0][6,0][7,0]
        [0,1][1,1][2,1][3,1][4,1][5,1][6,1][7,1]
        [0,2][1,2][2,2][3,2][4,2][5,2][6,2][7,2]
        [0,3][1,3][2,3][3,3][4,3][5,3][6,3][7,3]
        [0,4][1,4][2,4][3,4][4,4][5,4][6,4][7,4]
        [0,5][1,5][2,5][3,5][4,5][5,5][6,5][7,5]
        [0,6][1,6][2,6][3,6][4,6][5,6][6,6][7,6]
        [0,7][1,7][2,7][3,7][4,7][5,7][6,7][7,7]
        */
        
        /*
        STARTING BOARD STATE
        [R1][C1][B1][K1][Q1][B1][C1][R1]
        [P1][P1][P1][P1][P1][P1][P1][P1]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [P2][P2][P2][P2][P2][P2][P2][P2]
        [R2][C2][B2][K2][Q2][B2][C2][R2]
        */
        
        nPlayerTurn = 1; //Player 1 goes first
        
        //Pawn placement
        for(int i = 0; i<8; i++){
          arBoard[i][1] = new piecePawn();
          arBoard[i][6] = new piecePawn(); 
        }
        
        //Rook placement
        arBoard[0][0] = new pieceRook();//P1
        arBoard[7][0] = new pieceRook();//P1
        arBoard[0][7] = new pieceRook();//P2
        arBoard[7][7] = new pieceRook();//P2
        
        //Knight placement
        arBoard[1][0] = new pieceKnight();//P1
        arBoard[6][0] = new pieceKnight();//P1
        arBoard[1][7] = new pieceKnight();//P2
        arBoard[6][7] = new pieceKnight();//P2
        
        //Bishop placement
        arBoard[2][0] = new pieceBishop();//P1
        arBoard[5][0] = new pieceBishop();//P1
        arBoard[2][7] = new pieceBishop();//P2
        arBoard[5][7] = new pieceBishop();//P2
        
        //Queen placement
        arBoard[4][0] = new pieceQueen();//P1
        arBoard[4][7] = new pieceQueen();//P2
        
        //King placement
        arBoard[3][0] = new pieceKing();//P1
        arBoard[3][7] = new pieceKing();//P2
        
        //arBoard2 tracks who controls what pieces
        //Setting control of pieces
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i<2){                            //Top 2 rows of the board
                    arBoard2[j][i] = 1;             //Set arBoard2[x][y] to P1
                    arBoard[j][i].setPlayer(1);     //Set piece controller to P1
                    arBoard[j][i].setPos(j, i);     //Set piece position
                    
                }else if(i>5){                      //Bottom 2 rows of the board
                    arBoard2[j][i] = 2;             //Set arBoard2[x][y] to P2
                    arBoard[j][i].setPlayer(2);     //Set piece controller to P2
                    arBoard[j][i].setPos(j, i);     //Set piece position
                    
                }else{
                    arBoard[j][i] = new emptySpace();
                    arBoard2[j][i] = 0;     
                    arBoard[j][i].setPlayer(0);//Board position is empty
                    arBoard[j][i].setPos(j, i);
                }
            }
        }       
        
        
        JFrame frame = new JFrame("Chess");
        this.setLayout(new GridLayout(8, 8));
        frame.setContentPane(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 1280, 720);
        frame.setVisible(true);
        
        initComponents();
    }
    
    public void loadBoard() throws IOException{
        try (BufferedReader in = new BufferedReader(new FileReader("save.txt"))) {
            
            String line;
            StringTokenizer inLine = new StringTokenizer("Place holder");
            for(int i = 0; i < arBoard.length;i++){
                line = in.readLine();
                inLine = new StringTokenizer(line);
                for(int j = 0; j < arBoard[1].length;j++){
                    switch(inLine.nextToken()){
                        case("P1"):
                            arBoard[j][i] = new piecePawn();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("R1"):
                            arBoard[j][i] = new pieceRook();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("C1"):
                            arBoard[j][i] = new pieceKnight();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("B1"):
                            arBoard[j][i] = new pieceBishop();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("Q1"):
                            arBoard[j][i] = new pieceQueen();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("K1"):
                            arBoard[j][i] = new pieceKing();
                            arBoard2[j][i] = 1;
                            arBoard[j][i].setPlayer(1);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("P2"):
                            arBoard[j][i] = new piecePawn();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("R2"):
                            arBoard[j][i] = new pieceRook();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("C2"):
                            arBoard[j][i] = new pieceKnight();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("B2"):
                            arBoard[j][i] = new pieceBishop();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("Q2"):
                            arBoard[j][i] = new pieceQueen();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("K2"):
                            arBoard[j][i] = new pieceKing();
                            arBoard2[j][i] = 2;
                            arBoard[j][i].setPlayer(2);
                            arBoard[j][i].setPos(j, i);
                            break;
                        case("--"):
                            arBoard[j][i] = new emptySpace();
                            arBoard[j][i].setPlayer(0);
                            arBoard[j][i].setPos(j, i);
                            arBoard2[j][i] = 0;
                            break;
                    }
                }
            }
            line = in.readLine();
            nPlayerTurn = Integer.parseInt(line);
        }
        
    }
    
    public void saveBoard() throws IOException{
       try(BufferedWriter out = new BufferedWriter(new FileWriter("save.txt"))){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(arBoard[j][i].getName() != null){
                    out.write(arBoard[j][i].getName() + " ");
                }
                else{
                    out.write("-- ");
                }
            }
            out.newLine();
        }
        out.write("\n"+nPlayerTurn);
        }
    }

    
    public void printBoard(){
        
        //Printing the board
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(arBoard2[j][i] != 0){
                    //Prints occupied board space, formatted as [PieceName]
                    System.out.print("[" + arBoard[j][i].getName() + "]");
                }else{
                    //Prints empty board space
                    System.out.print("[--]");
                }
            }
            System.out.println();
        }
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                buttons[i][j].setText(arBoard[j][i].getName());
            }
        }
        
    }
    
    //Manages the turn
    public void playerTurn(){

        System.out.println();
        System.out.println("PLAYER " + nPlayerTurn);
        
        //Player selects piece
        if(nPhase == 0){
            System.out.println("Player "+ nPlayerTurn +" select a piece");
            if(pieceSelection() == false){ return; } //If invalid piece selected, resets turn
        }
        else{
            System.out.println("Player "+ nPlayerTurn +" move your piece");
            if(pieceMovement() == false){ return; } //If invalid movement made, resets turn
        }
        
        nPlayerTurn ++; //Next turn
        if(nPlayerTurn>2){ //Make sure it's always P1's or P2's turn
            nPlayerTurn = 1;
        }
    }
    
    //Player selects a piece
    public boolean pieceSelection(){
        //If the player wants to play
        //System.out.println("Enter the X coordinate (0-7) of the piece you want to move.");
        //nPieceX = scScanner.nextInt();
        try{
        buttons.wait();
        }
        catch(InterruptedException e){
            System.out.println(e.toString());
        }
        if(checkBounds(nPieceX) == false){ return false; } //Checks if X coord is valid
        
        //System.out.println("Enter the Y coordinate (0-7) of the piece you want to move.");
        //nPieceY = scScanner.nextInt();
        if(checkBounds(nPieceY) == false){ return false; } //Checks if Y coord is valid
        
        if(arBoard2[nPieceX][nPieceY] != nPlayerTurn){ //If piece selected belongs to the player
            System.out.println("Invalid piece.  Please try again.");
            return false;
        }
        
        nPhase = 1;
        
        return true;
    }
    
    //Attempts to move a piece
    public boolean pieceMovement(){
        //System.out.println("Enter the X coordinate (0-7) of the space you want to move.");
        //nMoveX = scScanner.nextInt();
        if(checkBounds(nMoveX) == false){ return false; } //Checks if X coord is valid
        
        //System.out.println("Enter the Y coordinate (0-7) of the space you want to move.");
        //nMoveY = scScanner.nextInt();
        if(checkBounds(nMoveY) == false){ return false; } //Checks if Y coord is valid
        
        if(arBoard[nPieceX][nPieceY].movePiece(nMoveX, nMoveY, arBoard2) == true){ //If the move is valid
            arBoard[nMoveX][nMoveY] = arBoard[nPieceX][nPieceY]; //Moves piece to new location
            
            arBoard[nPieceX][nPieceY] = new emptySpace();
            arBoard[nPieceX][nPieceY].setPlayer(0);
            
            arBoard2[nMoveX][nMoveY] = nPlayerTurn; //Declares controller of piece
            arBoard2[nPieceX][nPieceY] = 0; //Removes control from void space
        }else{
            return false;
        }
        
        //Ask if you wish to exit if you do move
        //exitGame();
        nPhase = 0;
        
        return true;
    }
    
    //Checks boundaries of the board
    public boolean checkBounds(int _nCoord){
        if(_nCoord < 0 || _nCoord > 7){
            System.out.println("Invalid coordinate.  Please try again.");
            return false;
        }
        return true;
    }
    
    public void checkKing(){
        boolean playerOneKing = false;
        boolean playerTwoKing = false;
        
        for(int i = 0; i < arBoard[0].length; i++){
        for(int j = 0; j < arBoard[1].length; j++){
            if(arBoard[i][j] != null){
                if(arBoard[i][j].getName().equalsIgnoreCase("K1")){
                    playerOneKing = true;
                }
                else if(arBoard[i][j].getName().equalsIgnoreCase("K2")){
                    playerTwoKing = true;
                }
            }
            }
        }
        
        if(playerOneKing == false){
            winCheck = 2;
            gameOver = true;
        }
        else if(playerTwoKing == false){
            winCheck = 1;
            gameOver = true;
        }
    }
    
    public void exitGame(){
        //Ask if the player wants to quit
        System.out.print("Press X if you would like to quit?\n");
        String input = scScanner.next();
        if(input.equalsIgnoreCase("X")){
            System.out.print("Press S to the save game\n");
            //For save game
            input = scScanner.next();
            if(input.equalsIgnoreCase("S")){
                try{
                    saveBoard();
                }
                catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            gameOver = true;
        } 
    }
    
    public void launchGame(){
        System.out.print("Would you like to load a previous save Y/N?");
        
        String input = scScanner.next();
        
        if(input.equalsIgnoreCase("Y")){
            try{
                loadBoard();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            setBoard();
        }
    }
    
    public void initComponents() {
        buttons = new JButton[8][8];
        for (int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++){
            buttons[i][j] = new JButton("");
            buttons[i][j].setFont(new Font("Arial", Font.BOLD, 50));
            buttons[i][j].setText(arBoard[j][i].getName());
            buttons[i][j].addActionListener(new ActionListener() {    
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton)e.getSource();
                    if(nPhase == 0){
                        nPieceX = button.getX();
                        nPieceY = button.getY();
                    }
                    else{
                        nMoveX = button.getX()-1;
                        nMoveY = button.getY()-1;
                    }
                }
            });
            this.add(buttons[i][j]);
            }
        }
    }
}