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
public interface chessInterface {
    //Checks if the piece can move to the input position
    //Position must be within board
    //Position must be free from friendly pieces
    //Available postions will be based off role
    //Pawn - one infront or diagonal if enemy piece is present
    //Bishop - diagonal
    //Rook - horizontal and vertical
    //Knight(C) - two squares horizontal or vertical then one square perpindicular
    //Queen - horizontal, vertical, and diagonal
    //King - one sqaure horizontal or vertical (will not check for check or checkmate, game will end once a players King is dead)
    boolean canMoveTo(int inputX, int inputY);
    //Will acutally move the piece
    void moveTo(int x, int y);
}
