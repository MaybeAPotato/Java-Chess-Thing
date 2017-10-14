package chessStuff;

//Connor's edition

public interface pieceInterface {
   
    void setPlayer(int _nPlayer); //Sets the piece's controlling player
    
    boolean movePiece(int _nX, int _nY, int[][] _arBoard2); //Checks to see if move is possibles
    
    String getName(); //Get piece name
    int getX();
    int getY();
}