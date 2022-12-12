package com.bluerocktms.lightsout;

import com.bluerocktms.lightsout.exception.SolutionNotFoundException;
import com.bluerocktms.lightsout.model.Coordinate;
import com.bluerocktms.lightsout.solver.LightsOutSolver;
import com.bluerocktms.lightsout.util.ConverterUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Solution {

    private static LightsOutSolver lightsOutSolver = new LightsOutSolver();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(args[0]));
        Integer depth = Integer.valueOf(lines.get(0));
        int[][] board = ConverterUtil.convertStringToBoard(lines.get(1));
        List<int[][]> pieces = ConverterUtil.convertStringToPiecesList(lines.get(2));
        try {
            List<Coordinate> solutionCoordinates = lightsOutSolver.solve(depth, board, pieces);
            solutionCoordinates.forEach( coordinate ->
                System.out.print("("+coordinate.getX()+","+coordinate.getY()+") ")
            );
        } catch (SolutionNotFoundException e) {
            System.out.println("No solution found");
        }

    }

}
