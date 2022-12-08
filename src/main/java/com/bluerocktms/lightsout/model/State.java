package com.bluerocktms.lightsout.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class State {

    private List<int[][]> pieces;
    private int[][] boardState;

    public static State of(List<int[][]> pieces, int[][] boardState){
        return new State(pieces, boardState);
    }

    private State(List<int[][]> pieces, int[][] boardState) {
        this.pieces = pieces;
        this.boardState = boardState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(pieces, state.pieces) && Arrays.equals(boardState, state.boardState);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pieces);
        result = 31 * result + Arrays.hashCode(boardState);
        return result;
    }
}
