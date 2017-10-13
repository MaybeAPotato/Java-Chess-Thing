package chessStuff;

//Connor's edition

public class pieceRook implements Board{
    /*
    String pieceName formatting:
    King    = "K1/K2"
    Queen   = "Q1/Q2"
    Knight  = "C1/C2"
    Bishop  = "B1/B2"
    Rook    = "R1/R2"
    Pawn    = "P1/P2"
    Void    = "  /  " (Two spaces)
    */
    
    String sPieceName;
    int nPlayer; //The controlling player (P1 = 1, P2 = 2)
    int nX;
    int nY;
    
    
    @Override
    public void setPlayer(int _nPlayer){ //Sets the piece's controlling player
        nPlayer = _nPlayer;
        
         if(nPlayer == 1){
            sPieceName = "R1";
        }else if(nPlayer == 2){
            sPieceName = "R2";
        }
    }
    
    
    @Override
    public void movePiece(int _nX, int _nY){ //Attempts to move piece
        checkMove(_nX, _nY);
    }
    
    
    @Override
    public boolean checkMove(int _nX, int _nY){ //Checks to see if move is possible
        onBoard(_nX, _nY);
        return true;
    }
    
    
    @Override
    public boolean onBoard(int _nX, int _nY){ //Checks to see if coordinates are on the board
        if(_nX-1 > 7 || _nX-1 < 0) //Horizontal
        {
            return false;
        }
        else if(_nY-1 > 7 || _nY < 0) //Vertical
        {
            return false;
        }
        
        return true;
    }
    
    
    @Override
    public String getName(){ //Get piece name
        return sPieceName;
    }
}