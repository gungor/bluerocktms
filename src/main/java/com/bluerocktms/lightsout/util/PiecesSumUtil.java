package com.bluerocktms.lightsout.util;

import com.bluerocktms.lightsout.model.Coordinate;

import java.util.*;

public class PiecesSumUtil {


    private PiecesSumUtil(){
    }

    public static int[][] sum(Integer depth,
                               int[][] boardState,
                               List<int[][]> pieceList,
                               List<Coordinate> coordinates){

        for(int i=0; i< coordinates.size(); i++){
            Coordinate coordinate = coordinates.get(i);
            int[][] piece = pieceList.get(i);
            for(int y=0; y< piece.length; y++){
                for(int x=0; x< piece[y].length; x++){
                    boardState[coordinate.getY()+y][coordinate.getX()+x] =
                            (boardState[coordinate.getY()+y][coordinate.getX()+x] + piece[y][x])%depth;
                }
            }
        }

        return boardState;
    }

}
