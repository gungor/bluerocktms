package com.bluerocktms.lightsout.solver;

import com.bluerocktms.lightsout.exception.SolutionNotFoundException;
import com.bluerocktms.lightsout.model.Coordinate;
import com.bluerocktms.lightsout.solver.LightsOutSolver;
import com.bluerocktms.lightsout.util.ConverterUtil;
import com.bluerocktms.lightsout.util.PiecesSumTestUtil;
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
                PiecesSumTestUtil.sum(depth,boardState,pieceList,solutionCoordinates));

    }


    @Test
    public void solveCase2() throws SolutionNotFoundException {
        Integer depth = 2;

        int[][] boardState = ConverterUtil.convertStringToBoard("0100,0110,1010,1110");
        List<int[][]> pieceList = ConverterUtil.convertStringToPiecesList("X.,XX,XX X...,XXXX XXX X,X XX XX,XX,.X,.X ..XX,XXX.");

        LightsOutSolver lightsOutSolver = new LightsOutSolver();
        List<Coordinate> solutionCoordinates = lightsOutSolver.solve(depth, boardState, pieceList);

        assertArrayEquals(new Integer[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},
                PiecesSumTestUtil.sum(depth,boardState,pieceList,solutionCoordinates));

    }

}
