package chessassignment;

//The Pieces
import chessStuff.piecePawn;
import chessStuff.pieceRook;
import chessStuff.pieceKnight;
import chessStuff.pieceBishop;
import chessStuff.pieceQueen;
import chessStuff.pieceKing;
import chessStuff.pieceInterface;
//Scanner
import java.util.Scanner;

public class BoardManager {
    
    pieceInterface[][] arBoard = new pieceInterface[8][8]; //Board is 8 by 8
    int[][] arBoard2 = new int[8][8]; //Tracks who controls what pieces
    
    int nPlayerTurn; //Tracks whose turn it is
    
    int nPieceX; //For piece selection
    int nPieceY; //For piece selection
    
    int nMoveX; //For piece movement
    int nMoveY; //For piece movement
    
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
                    
                }else if(i>5){                      //Bottom 2 rows of the board
                    arBoard2[j][i] = 2;             //Set arBoard2[x][y] to P2
                    arBoard[j][i].setPlayer(2);     //Set piece controller to P2
                    
                }else{
                    arBoard2[j][i] = 0;             //Board position is empty
                }
            }
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
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
        
    }
    
    
    public void playerTurn(){

        System.out.println();
        System.out.println("PLAYER " + nPlayerTurn);
        
        //Player selects piece
        if(pieceSelection() == false){ return; } //If invalid piece selected, resets turn
        if(pieceMovement() == false){ return; } //If invalid movement made, resets turn
        
        nPlayerTurn ++; //Next turn
        if(nPlayerTurn>2){ //Make sure it's always P1's or P2's turn
            nPlayerTurn = 1;
        }
    }
    
    
    public boolean pieceSelection(){
        
        System.out.println("Enter the X coordinate (0-7) of the piece you want to move.");
        nPieceX = scScanner.nextInt();
        if(checkBounds(nPieceX) == false){ return false; } //Checks if X coord is valid
        
        System.out.println("Enter the Y coordinate (0-7) of the piece you want to move.");
        nPieceY = scScanner.nextInt();
        if(checkBounds(nPieceY) == false){ return false; } //Checks if Y coord is valid
        
        if(arBoard2[nPieceX][nPieceY] != nPlayerTurn){ //If piece selected belongs to the player
            System.out.println("Invalid piece.  Please try again.");
            return false;
        }
        return true;
    }
    
    public boolean pieceMovement(){
        System.out.println("Enter the X coordinate (0-7) of the space you want to move.");
        nMoveX = scScanner.nextInt();
        if(checkBounds(nPieceX) == false){ return false; } //Checks if X coord is valid
        
        System.out.println("Enter the Y coordinate (0-7) of the space you want to move.");
        nMoveY = scScanner.nextInt();
        if(checkBounds(nPieceY) == false){ return false; } //Checks if Y coord is valid
        
        if(arBoard[nPieceX][nPieceY].movePiece(nMoveX, nMoveY, arBoard2) == true){ //If the move is valid
            arBoard[nMoveX][nMoveY] = arBoard[nPieceX][nPieceY]; //Moves piece to new location
            arBoard[nPieceX][nPieceY] = null; //Deletes piece from old location
            
            arBoard2[nMoveX][nMoveY] = nPlayerTurn; //Declares controller of piece
            arBoard2[nPieceX][nPieceY] = 0; //Removes control from void space
        }else{
            return false;
        }
        
        return true;
    }
    
    
    public boolean checkBounds(int _nCoord){
        if(_nCoord < 0 || _nCoord > 7){
            System.out.println("Invalid coordinate.  Please try again.");
            return false;
        }
        return true;
    }
}