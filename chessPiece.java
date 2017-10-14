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
    //Black Pawn
    //1 Pawn
    //With that could read in first part as which player and second as which piece
    String pieceName;
    int posX;
    int posY;
    boolean enemyPresent = false;
    
    public chessPiece(String inputName,int posX,int posY){
        pieceName = inputName;
        this.posX = posX;
        this.posY = posY;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isEnemyPresent() {
        return enemyPresent;
    }

    public void setEnemyPresent(boolean enemyPresent) {
        this.enemyPresent = enemyPresent;
    }
    
    
    @Override
    public boolean canMoveTo(int inputX, int inputY){
        //Check if position is within the bounds of the board
        //inputX = inputX - 1;
        //inputY = inputY - 1;
        if(inputX > 7 || inputX < 0){
            return false;
        }
        if(inputY > 7 || inputY < 0){
            return false;
        }
        if(inputX == 0 || inputY == 0 || inputX == posX && inputY == posY){
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
        if(pieceName == "P1") {
            if (inputY != posY + 1 || inputX != posX)
            return false;
        }
        if(pieceName == "P2"){
            if(inputY != posY - 1 || inputX != posX)
            return false;
        }
        if(pieceName == "B1" || pieceName == "B2"){ 
            if(Math.abs(inputX-posX) - Math.abs(inputY-posY) != 0)
            return false;
        }
        if(pieceName== "R1" || pieceName == "R2"){
            if(inputX != posX && inputY != posY)
            return false;
        }
        if(pieceName=="C1" || pieceName == "C2"){
            if(inputX == posX + 2 &&inputY == posY + 1 || inputY == posY - 1)
                return true;
            else if(inputX == posX - 2 && inputY == posY + 1 || inputY == posY - 1)
                return true;
            if(inputY == posY + 2 && inputX == posX + 1 || inputX == posX - 1)
                return true;
            else if(inputY == posY - 2 && inputX == posX + 1 || inputX == posX - 1)
                return true;
            else
                return false;
        }
        if(pieceName== "Q1" || pieceName== "Q2"){
            if(Math.abs(inputX-posX) - Math.abs(inputY-posY) == 0)
                return true;
            else if (inputX == posX && inputY != posY || inputX != posX && inputY == posY)
                return true;
            else
                return false;
        }
        if(pieceName== "K1" || pieceName=="K2"){
            if(inputX > posX + 1 || inputX < posX - 1 || inputY > posY + 1 || inputY < posY - 1)
            return false;
        }
        
        return true;
    }
    
    @Override
    public void moveTo(int row, int col){
        //Could check here
        if(canMoveTo(col,row)){
         //row -= 1;
         //col -= 1;
         posX = col;
         posY = row;
        }
        else{
        System.out.println("Can't move there");
        }
    }
}
