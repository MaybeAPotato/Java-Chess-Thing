package chessStuff;

//Connor's edition

public class pieceQueen implements pieceInterface{
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
            sPieceName = "Q1";
        }else if(nPlayer == 2){
            sPieceName = "Q2";
        }
    }
    
    
    @Override
    public boolean movePiece(int _nX, int _nY,  int[][] _arBoard2){ //Attempts to move piece
        if(Math.abs(_nX-nX) - Math.abs(_nY-nY) == 0){
            nX = _nX;
            nY = _nY;
            return true;
        }
        else if (_nX == nX && _nY != nY || _nX != nX && _nY == nY){
            nX = _nX;
            nY = _nY;    
            return true;
        }
        else
            return false;
        
        //nX = _nX;
        //nY = _nY;
        //return true;
    }
    
    @Override
    public String getName(){ //Get piece name
        return sPieceName;
    }
    
    public int getX(){ //Get X position
        return nX;
    }
    
    public int getY(){ //Get Y position
        return nY;
    }
}
