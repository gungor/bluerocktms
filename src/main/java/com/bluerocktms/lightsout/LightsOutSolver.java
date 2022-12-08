package com.bluerocktms.lightsout;


import com.bluerocktms.lightsout.exception.SolutionNotFoundException;
import com.bluerocktms.lightsout.model.Coordinate;
import com.bluerocktms.lightsout.model.State;

import java.util.*;

public class LightsOutSolver {

    private Set<State> unsolvableStateSet = new HashSet<>();
    public List<Coordinate> solve(Integer depth, int[][] boardState, List<int[][]> pieces) throws SolutionNotFoundException {
        int[][] solvedBoard = new int[boardState.length][boardState[0].length];
        List<Coordinate> coordinates = possibleBackwardSolution(depth, pieces, solvedBoard, boardState);
        Collections.reverse(coordinates);
        return coordinates;
    }

    private List<Coordinate> possibleBackwardSolution(Integer depth,
                                                      List<int[][]> pieces,
                                                      int[][] currentState,
                                                      int[][] targetState) throws SolutionNotFoundException {

        if( unsolvableStateSet.contains( State.of(pieces,currentState) ) ){
            System.out.println("unsolvable");
            throw new SolutionNotFoundException();
        }

        List<int[][]> previousPieces = null;
        if(pieces == null){
            if( Objects.deepEquals(currentState,targetState) ){
                System.out.println("found solution");
                return Collections.emptyList();
            }else {
                throw new SolutionNotFoundException();
            }
        }else if( pieces.size() > 1 ){
            previousPieces = pieces.subList(0, pieces.size()-1);
        }

        int[][] lastPiece = pieces.get(pieces.size()-1);
        List<Coordinate> possiblePieceCoordinates = findPossiblePieceCoordinates(currentState,lastPiece);
        List<List<Coordinate>> solutionCoordinates = new ArrayList<>();
        for( Coordinate coordinate : possiblePieceCoordinates){
            int[][] boardStateBeforePiece = null;
            try {
                List<Coordinate> coordinateList = new ArrayList<>();
                coordinateList.add(coordinate);
                boardStateBeforePiece = subtractPieceFromBoard(depth,currentState, lastPiece, coordinate);
                coordinateList.addAll( possibleBackwardSolution( depth ,
                        previousPieces ,boardStateBeforePiece , targetState ) );
                solutionCoordinates.add(coordinateList);
            } catch (SolutionNotFoundException e) {
                unsolvableStateSet.add( State.of(previousPieces, boardStateBeforePiece) );
            }
        }
        return solutionCoordinates.stream().findAny().orElseThrow(SolutionNotFoundException::new);
    }

    private List<Coordinate> findPossiblePieceCoordinates(int[][] currentState, int[][] piece) {
        List<Coordinate> coordinates = new ArrayList<>();
        for(int y=0; y<currentState.length-piece.length+1; y++){
            for(int x=0; x<currentState[y].length-piece[0].length+1; x++){
                coordinates.add(new Coordinate(x,y));
            }
        }
        return coordinates;
    }

    private int[][] subtractPieceFromBoard(int depth, int[][] currentState, int[][] lastPiece, Coordinate coordinate) {
        int[][] currentStateClone = new int[currentState.length][];
        for(int i=0; i<currentState.length; i++){
            currentStateClone[i] = currentState[i].clone();
        }

        for (int y = 0; y < lastPiece.length; y++) {
            for (int x = 0; x < lastPiece[y].length; x++) {
                currentStateClone[coordinate.getY() + y][coordinate.getX() + x] =
                        Math.floorMod(currentState[coordinate.getY() + y][coordinate.getX() + x] - lastPiece[y][x] ,depth);
            }
        }
        return currentStateClone;
    }


}
