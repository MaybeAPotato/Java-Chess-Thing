package chessStuff;

//Connor's edition

public class pieceKnight implements pieceInterface{
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
            sPieceName = "C1";
        }else if(nPlayer == 2){
            sPieceName = "C2";
        }
    }
    
    
    @Override
    public boolean movePiece(int _nX, int _nY,  int[][] _arBoard2){ //Attempts to move piece
        //nX = _nX;
        //nY = _nY;
        //return true;
        
        if(_nX == nX + 2 && _nY == nY + 1 || _nY == nY - 1){
                nX = _nX;
                nY = _nY;
                return true;
            }
            else if(_nX == nX - 2 && _nY == nY + 1 || _nY == nY - 1){
                nX = _nX;
                nY = _nY;
                return true;
            }
            if(_nY == nY + 2 && _nX == nX + 1 || _nX == nX - 1){
                nX = _nX;
                nY = _nY;
                return true;
            }
            else if(_nY == nY - 2 && _nX == nX + 1 || _nX == nX - 1){
                nX = _nX;
                nY = _nY;
                return true;
            }
            else
                return false;
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
