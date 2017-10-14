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
    public void setPos(int _nX, int _nY){
        nX = _nX;
        nY = _nY;
    }
    
    @Override
    public boolean movePiece(int _nX, int _nY,  int[][] _arBoard2){ //Attempts to move piece
        
        boolean H_V = false;
        boolean Diagonal = false;
        //cHECK IF MOVEMENT WILL BE DIAGONAL OR HORIZONTAL
        if((nX == _nX && nY !=_nY) || (nY == _nY && nX !=_nX)){
            
            //moving horizontal
            H_V = true;
            
        }
        else {Diagonal = true;}
        
        if(H_V == true){
        /*H and V movement*/
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
       }//end if test movement direction
        
        /*END H & V*/
        if(Diagonal == true){
        int nPiecePos = _nX;
        
        if (Math.abs(_nX - nX) != Math.abs(_nY - nY))
            return false;
        
        if (_nX > nX && _nY > nY){ // moving right and down
            int nDistanceY = (_nY - nY);
            for (int nDistanceX = (_nX - nX); nDistanceX > 0; nDistanceX --){
                
                if (_arBoard2[nX + nDistanceX][nY + nDistanceY] != 0){ // stores the position of the most recently encountered enemy along the path
                    nPiecePos = nDistanceX;
                }
                if (_arBoard2[nX + nDistanceX][nY + nDistanceY] == nPlayer || nPiecePos != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                nDistanceY --;
            }
        }
        
        if (_nX < nX && _nY > nY){ // moving left and down
            int nDistanceY = (_nY - nY);
            for (int nDistanceX = (nX - _nX); nDistanceX > 0; nDistanceX --){
                
                if (_arBoard2[nX - nDistanceX][nY + nDistanceY] != 0){ // stores the position of the most recently encountered enemy along the path
                    nPiecePos = nDistanceX;
                }
                if (_arBoard2[nX - nDistanceX][nY + nDistanceY] == nPlayer || nPiecePos != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                nDistanceY --;
            }
        }
        
        if (_nX > nX && _nY < nY){ // moving right and up
            int nDistanceY = (nY - _nY);
            for (int nDistanceX = (_nX - nX); nDistanceX > 0; nDistanceX --){
                
                if ( _arBoard2[nX + nDistanceX][nY - nDistanceY] != 0){ // stores the position of the most recently encountered enemy along the path
                    nPiecePos = nDistanceX;
                }
                if (_arBoard2[nX + nDistanceX][nY - nDistanceY] == nPlayer || nPiecePos != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                nDistanceY --;
            }
        }
        
        if (_nX < nX && _nY < nY){ // moving left and up
            int nDistanceY = (nY - _nY);
            for (int nDistanceX = (nX - _nX); nDistanceX > 0; nDistanceX --){
                
                if (_arBoard2[nX - nDistanceX][nY - nDistanceY] != 0){ // stores the position of the most recently encountered enemy along the path
                    nPiecePos = nDistanceX;
                }
                if (_arBoard2[nX - nDistanceX][nY - nDistanceY] == nPlayer || nPiecePos != _nX) // if the most recently encountered enemy along the path is NOT the final destination, then the player cannot move
                    return false;
                nDistanceY --;
            }
        }
        
      }//end if test direction
        
        
        nX = _nX;
        nY = _nY;
        return true;
    }
    
    @Override
    public String getName(){ //Get piece name
        return sPieceName;
    }
}