package chessassignment;

/*
//The Board
import chessassignment.BoardManager;
//The Pieces
import chessStuff.piecePawn;
import chessStuff.pieceRook;
import chessStuff.pieceKnight;
import chessStuff.pieceBishop;
import chessStuff.pieceQueen;
import chessStuff.pieceKing;
import chessStuff.pieceInterface;*/


//Connor's edition

public class ChessAssignment{
    public static void main(String[] args) {
        BoardManager objBoard = new BoardManager();
        
        //objBoard.launchGame();
        objBoard.setBoard();
        while(objBoard.gameOver == false){
            //System.out.println();
            //objBoard.printBoard();
            //objBoard.playerTurn();
            objBoard.checkKing();
            //objBoard.exitGame();
        }
        
        System.out.println("---------------GAME OVER---------------\tPlayer "+objBoard.winCheck +" wins");
    }
}