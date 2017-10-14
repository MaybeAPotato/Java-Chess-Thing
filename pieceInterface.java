package chessStuff;

//Connor's edition

public interface pieceInterface {
   
    void setPlayer(int _nPlayer); //Sets the piece's controlling player
    void setPos(int _nX, int _nY); //Sets the piece's position
    
    boolean movePiece(int _nX, int _nY, int[][] _arBoard2); //Checks to see if move is possibles
    
    String getName(); //Get piece name
    
}