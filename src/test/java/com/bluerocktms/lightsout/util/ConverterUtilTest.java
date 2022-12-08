package com.bluerocktms.lightsout.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ConverterUtilTest {

    @Test
    public void shouldConvertBoardStringTo2DIntArray(){
        assertArrayEquals(new int[][]{{0,0,1},{0,1,1},{0,1,1}},ConverterUtil.convertStringToBoard("001,011,011"));
    }

    @Test
    public void shouldConvertPiecesStringToListOf2DIntArray(){
        List<int[][]> piecesList = ConverterUtil.convertStringToPiecesList(".X,XX XX .X,.X,XX");
        assertArrayEquals(new int[][]{{0,1},{1,1}},piecesList.get(0));
        assertArrayEquals(new int[][]{{1,1}}, piecesList.get(1));
        assertArrayEquals(new int[][]{{0,1},{0,1},{1,1}}, piecesList.get(2));
    }

}
