/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessassignment;
import chessStuff.chessInterface;
import chessStuff.chessPiece;

/**
 *
 * @author User
 */
public class ChessAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Chess boards are 8 by 8                        [y][x]
        chessInterface[][] gameBoard = new chessInterface[8][8];
        
        for(int i = 0; i < gameBoard[0].length; i++){
            for(int j = 0; j < gameBoard[1].length; j++){
                if(i == 3 && j == 3){
                    gameBoard[3][3] = new chessPiece("K1",3,3);
                }
                else{
                    gameBoard[i][j] = new chessPiece("  ",i,j);
                }
            }
        }
        
        gameBoard[3][3].moveTo(3,3);
    }
}
