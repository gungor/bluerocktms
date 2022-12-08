package com.bluerocktms.lightsout.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterUtil {

    private ConverterUtil() {
    }

    public static int[][] convertStringToBoard(String board){
        return Arrays.stream(board.split(","))
                .map( b -> b.chars().map( c -> Integer.valueOf(""+((char)c) ) ).toArray() )
                .toArray(int[][]::new);
    }

    public static List<int[][]> convertStringToPiecesList(String pieces) {
        Map<Character,Integer> piecesMap = new HashMap<>();
        piecesMap.put('.',0);
        piecesMap.put('X',1);
        return Arrays.stream(pieces.split(" "))
                .map( p -> Arrays.stream(p.split(",")).map( s -> s.chars()
                        .map( c -> piecesMap.get(((char)c))  ).toArray() ).toArray(int[][]::new) )
                .collect(Collectors.toList());
    }
}
