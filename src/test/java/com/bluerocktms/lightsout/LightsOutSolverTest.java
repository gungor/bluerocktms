package com.bluerocktms.lightsout;

import com.bluerocktms.lightsout.exception.SolutionNotFoundException;
import com.bluerocktms.lightsout.model.Coordinate;
import com.bluerocktms.lightsout.util.ConverterUtil;
import com.bluerocktms.lightsout.util.PiecesSumUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class LightsOutSolverTest {

    @Test
    public void solveCase1() throws SolutionNotFoundException {
        Integer depth = 2;

        int[][] boardState = ConverterUtil.convertStringToBoard("001,011,011");
        List<int[][]> pieceList = ConverterUtil.convertStringToPiecesList(".X,XX XX .X,.X,XX");

        LightsOutSolver lightsOutSolver = new LightsOutSolver();
        List<Coordinate> solutionCoordinates = lightsOutSolver.solve(depth, boardState, pieceList);

        assertArrayEquals(new Integer[][]{{0,0,0},{0,0,0},{0,0,0}},
                PiecesSumUtil.sum(depth,boardState,pieceList,solutionCoordinates));

    }


    @Test
    public void solveCase2() throws SolutionNotFoundException {
        Integer depth = 2;

        int[][] boardState = ConverterUtil.convertStringToBoard("0100,0110,1010,1110");
        List<int[][]> pieceList = ConverterUtil.convertStringToPiecesList("X.,XX,XX X...,XXXX XXX X,X XX XX,XX,.X,.X ..XX,XXX.");

        LightsOutSolver lightsOutSolver = new LightsOutSolver();
        List<Coordinate> solutionCoordinates = lightsOutSolver.solve(depth, boardState, pieceList);

        assertArrayEquals(new Integer[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
                PiecesSumUtil.sum(depth,boardState,pieceList,solutionCoordinates));

    }

    @Test
    public void solveCase3() throws SolutionNotFoundException {
        Integer depth = 3;

        int[][] boardState = ConverterUtil.convertStringToBoard("2121,2212,1001,2011,1211,2111");
        List<int[][]> pieceList = ConverterUtil.convertStringToPiecesList("X...,X.X.,XXXX,XX.. XXX,X.X XX,X. XX,.X,.X XX.,.XX,.X.,.X. XX..,.XXX .X.,.X.,XX.,XXX ..XX,..XX,XXX. .X..,.XX.,X.X.,XXXX X,X,X,X .X.,.XX,.X.,.X.,XXX");

        LightsOutSolver lightsOutSolver = new LightsOutSolver();
        List<Coordinate> solutionCoordinates = lightsOutSolver.solve(depth, boardState, pieceList);

        assertArrayEquals(new Integer[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
                PiecesSumUtil.sum(depth,boardState,pieceList,solutionCoordinates));

    }

}
