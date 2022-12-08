package com.bluerocktms.lightsout.util;

import com.bluerocktms.lightsout.model.Coordinate;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PiecesSumUtilTest {

    @Test
    public void shouldSumPieces_WhenDepthTwo(){
        Integer depth = 2;

        int[][] boardState = new int[][]{{0,0,1},{0,1,1},{0,1,1}};
        List<int[][]> pieceList = List.of(new int[][]{{0,1},{1,1}},
                new int[][]{{1,1}},new int[][]{{0,1},{0,1},{1,1}});
        List<Coordinate> coordinateList = List.of(new Coordinate(0,1),
                new Coordinate(0,2), new Coordinate(1,0));

        assertArrayEquals(new Integer[][]{{0,0,0},{0,0,0},{0,0,0}},
                PiecesSumUtil.sum(depth,boardState,pieceList,coordinateList));

    }

    @Test
    public void shouldSumPieces_WhenDepthThree(){
        Integer depth = 3;
        int[][] boardState = new int[][]{{0,0,1},{0,1,1},{0,1,1}};
        List<int[][]> pieceList = List.of(new int[][]{{0,1},{1,1}},
                new int[][]{{1,1}},new int[][]{{0,1},{0,1},{1,1}});
        List<Coordinate> coordinateList = List.of(new Coordinate(0,1),
                new Coordinate(0,2), new Coordinate(1,0));

        assertArrayEquals(new Integer[][]{{0,0,2},{0,2,2},{2,1,2}},
                PiecesSumUtil.sum(depth,boardState,pieceList,coordinateList));

    }

    @Test
    public void shouldSumPieces_WhenDepthFour(){
        Integer depth = 4;
        int[][] boardState = new int[][]{{0,0,1},{0,1,1},{0,1,1}};
        List<int[][]> pieceList = List.of(new int[][]{{0,1},{1,1}},
                new int[][]{{1,1}},new int[][]{{0,1},{0,1},{1,1}});
        List<Coordinate> coordinateList = List.of(new Coordinate(0,1),
                new Coordinate(0,2), new Coordinate(1,0));

        assertArrayEquals(new Integer[][]{{0,0,2},{0,2,2},{2,0,2}},
                PiecesSumUtil.sum(depth,boardState,pieceList,coordinateList));

    }

    @Test
    public void testNegativeModulus(){
        Assert.assertEquals(2, Math.floorMod(-1,3));
    }

}
