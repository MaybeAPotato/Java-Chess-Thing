package chessStuff;

//Connor's edition

public class pieceRook implements pieceInterface{
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
    public void setPos(int _nX, int _nY){
        nX = _nX;
        nY = _nY;
    }
    
    @Override
    public boolean movePiece(int _nX, int _nY,  int[][] _arBoard2){ //Attempts to move piece
        int nPiecePosX = _nX; // setting it as "enemy's position" to begin with to prevent it from stopping the turn unnecessarily
        int nPiecePosY = _nY;
        if (_nX > nX){
            for (int nDistance = (_nX - nX); nDistance > 0; nDistance --){
                if (_arBoard2[nX + nDistance][_nY] != 0) // stores the position of the most recently encountered enemy along the path
                    nPiecePosX = nDistance;
                if (_arBoard2[nX + nDistance][_nY] == nPlayer || nPiecePosX != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                }
        }
        if (_nX < nX){
            for (int nDistance = (nX - _nX); nDistance > 0; nDistance --){
                if (_arBoard2[nX - nDistance][_nY] != 0) // stores the position of the most recently encountered enemy along the path
                    nPiecePosX = nDistance;
                if (_arBoard2[nX - nDistance][_nY] == nPlayer || nPiecePosX != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                }
        }
        if (_nY > nY){
            for (int nDistance = (_nY - nY); nDistance > 0; nDistance --){
                if (_arBoard2[_nX][nY + nDistance] != 0) // stores the position of the most recently encountered enemy along the path
                    nPiecePosY = nDistance;
                if (_arBoard2[_nX][nY + nDistance] == nPlayer || nPiecePosY != _nY)
                    return false;
                }
        }
        if (_nY < nY){
            for (int nDistance = (nY - _nY); nDistance > 0; nDistance --){
                if (_arBoard2[_nX][nY - nDistance] != 0) // stores the position of the most recently encountered enemy along the path
                    nPiecePosY = nDistance;
                if (_arBoard2[_nX][nY - nDistance] == nPlayer || nPiecePosY != _nY)
                    return false;
                }
        }
        
        nX = _nX;
        nY = _nY;
        return true;
    }
    
    @Override
    public String getName(){ //Get piece name
        return sPieceName;
    }
}