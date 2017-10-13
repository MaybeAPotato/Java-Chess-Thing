package chessassignment;
import chessStuff.chessInterface;
//import chessStuff.pieceTemplate;
import chessStuff.piecePawn;
import chessStuff.pieceRook;
import chessStuff.pieceKnight;
import chessStuff.pieceBishop;
import chessStuff.pieceQueen;
import chessStuff.pieceKing;

//Connor's edition

public class ChessAssignment {
    
    
    
    public static void main(String[] args) {
        
        chessInterface[][] arBoard = new chessInterface[8][8]; //Board is 8 by 8
        int[][] arBoard2 = new int[8][8]; //Tracks who controls what pieces

        //setBoard();
        //printBoard();
        
        //This, uh, probably shouldn't all be in main
        for(int i = 0; i<8; i++){
          arBoard[i][1] = new piecePawn();
          arBoard[i][6] = new piecePawn(); 
        }
        
        arBoard[0][0] = new pieceRook();
        arBoard[7][0] = new pieceRook();
        arBoard[0][7] = new pieceRook();
        arBoard[7][7] = new pieceRook();
        
        arBoard[1][0] = new pieceKnight();
        arBoard[6][0] = new pieceKnight();
        arBoard[1][7] = new pieceKnight();
        arBoard[6][7] = new pieceKnight();
        
        arBoard[2][0] = new pieceBishop();
        arBoard[5][0] = new pieceBishop();
        arBoard[2][7] = new pieceBishop();
        arBoard[5][7] = new pieceBishop();
        
        arBoard[4][0] = new pieceQueen();
        arBoard[4][7] = new pieceQueen();
        
        arBoard[3][0] = new pieceKing();
        arBoard[3][7] = new pieceKing();
        
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i<2){
                    arBoard2[j][i] = 1;
                    arBoard[j][i].setPlayer(1);
                }else if(i>5){
                    arBoard2[j][i] = 2;
                    arBoard[j][i].setPlayer(2);
                }else{
                    arBoard2[j][i] = 0;
                }
            }
        }
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(arBoard[j][i] != null){
                    System.out.print("[" + arBoard[j][i].getName() + "]");
                }else{
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
    }
    
    public static void setBoard(){
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
        PIECES
        [R1][C1][B1][K1][Q1][B1][C1][R1]
        [P1][P1][P1][P1][P1][P1][P1][P1]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [  ][  ][  ][  ][  ][  ][  ][  ]
        [P2][P2][P2][P2][P2][P2][P2][P2]
        [R2][C2][B2][K2][Q2][B2][C2][R2]
        */
        
        /*
        for(int i = 0; i<8; i++){
          arBoard[i][1] = new piecePawn();
          arBoard[i][6] = new piecePawn(); 
        }
        
        arBoard[0][0] = new pieceRook();
        arBoard[7][0] = new pieceRook();
        arBoard[0][7] = new pieceRook();
        arBoard[7][7] = new pieceRook();
        
        arBoard[1][0] = new pieceKnight();
        arBoard[6][0] = new pieceKnight();
        arBoard[1][7] = new pieceKnight();
        arBoard[6][7] = new pieceKnight();
        
        arBoard[2][0] = new pieceBishop();
        arBoard[5][0] = new pieceBishop();
        arBoard[2][7] = new pieceBishop();
        arBoard[5][7] = new pieceBishop();
        
        arBoard[4][0] = new pieceQueen();
        arBoard[4][7] = new pieceQueen();
        
        arBoard[3][0] = new pieceKing();
        arBoard[3][7] = new pieceKing();
        
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if(i<2){
                    arBoard2[j][i] = 1;
                    arBoard[j][i].setPlayer(1);
                }else if(i>5){
                    arBoard2[j][i] = 2;
                    arBoard[j][i].setPlayer(2);
                }else{
                    arBoard2[j][i] = 0;
                }
            }
        }
        */
    }

    
    public void printBoard(){
        
        /*
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(arBoard[j][i] != null){
                    System.out.print("[" + arBoard[j][i].getName() + "]");
                }else{
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
        */
    }
}
