/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessStuff;

/**
 *
 * @author User
 */
public class chessPiece implements chessInterface{
    //Example would be
    //P1
    //With that could read in first part as which player and second as which piece
    String pieceName;
    int posX;
    int posY;
    
    @Override
    public boolean canMoveTo(int x, int y){
        //Check if position is within the bounds of the board
        if(x-1 > 7 || x-1 < 0){
            return false;
        }
        if(y-1 > 7 || y < 0){
            return false;
        }
        //If within the bounds of the board
        //Could do a switch case statement for the role of the piece
        //Then check if the move is capable
        //Pawn - one infront or diagonal if enemy piece is present
        //Bishop - diagonal
        //Rook - horizontal and vertical
        //Knight(C) - two squares horizontal or vertical then one square perpindicular
        //Queen - horizontal, vertical, and diagonal
        //King - one sqaure horizontal or vertical (will not check for check or checkmate, game will end once a players King is dead)
        
        
        return true;
    }
    
    @Override
    public void moveTo(int x, int y){
        //Could check here
        /*if(canMoveTo(x,y)){
            
        }
        else{
        System.out.println("Can't move there");
        }*/
    }
}
