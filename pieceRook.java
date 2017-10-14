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
        int nEnemyPosX = _nX; // setting it as "enemy's position" to begin with to prevent it from stopping the turn unnecessarily
        int nEnemyPosY = _nY;
        if (_nX > nX){
            for (int nDistance = (_nX - nX); nDistance > 0; nDistance --){
                if ( nPlayer == 1 && _arBoard2[nX + nDistance][_nY] == 2) // stores the position of the most recently encountered enemy along the path
                    nEnemyPosX = nDistance;
                else if (nPlayer == 2 && _arBoard2[nX + nDistance][_nY] == 1)
                    nEnemyPosX = nDistance;
                if (_arBoard2[nX + nDistance][_nY] == nPlayer || nEnemyPosX != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                }
        }
        if (_nX < nX){
            for (int nDistance = (nX - _nX); nDistance > 0; nDistance --){
                if ( nPlayer == 1 && _arBoard2[nX - nDistance][_nY] == 2) // stores the position of the most recently encountered enemy along the path
                    nEnemyPosX = nDistance;
                else if (nPlayer == 2 && _arBoard2[nX - nDistance][_nY] == 1)
                    nEnemyPosX = nDistance;
                if (_arBoard2[nX - nDistance][_nY] == nPlayer || nEnemyPosX != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                }
        }
        if (_nY > nY){
            for (int nDistance = (_nY - nY); nDistance > 0; nDistance --){
                if ( nPlayer == 1 && _arBoard2[_nX][nY + nDistance] == 2) // stores the position of the most recently encountered enemy along the path
                    nEnemyPosY = nDistance;
                else if (nPlayer == 2 && _arBoard2[_nX][nY + nDistance] == 1)
                    nEnemyPosY = nDistance;
                if (_arBoard2[_nX][nY + nDistance] == nPlayer || nEnemyPosY != _nY)
                    return false;
                }
        }
        if (_nY < nY){
            for (int nDistance = (nY - _nY); nDistance > 0; nDistance --){
                if ( nPlayer == 1 && _arBoard2[_nX][nY - nDistance] == 2) // stores the position of the most recently encountered enemy along the path
                    nEnemyPosY = nDistance;
                else if (nPlayer == 2 && _arBoard2[_nX][nY - nDistance] == 1)
                    nEnemyPosY = nDistance;
                if (_arBoard2[_nX][nY - nDistance] == nPlayer || nEnemyPosY != _nY)
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
