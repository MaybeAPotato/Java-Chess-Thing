package chessStuff;

//Connor's edition

public interface chessInterface {
   
    void setPlayer(int _nPlayer); //Sets the piece's controlling player
    void movePiece(int _nX, int _nY); //Attempts to move piece
    
    boolean checkMove(int _nX, int _nY); //Checks to see if move is possible
    boolean onBoard(int _nX, int _nY); //Checks to see if coordinates are on the board
    
    String getName(); //Get piece name
}