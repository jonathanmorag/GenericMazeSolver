package searchable.matrix;

import searchable.Searchable;
import state.State;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements Searchable<Position> {

    int[][] mat;
    Position start, end;

    public Matrix(int[][] mat, Position start, Position end) {
        this.mat = mat;
        this.start = start;
        this.end = end;
    }

    @Override
    public State<Position> getInitialState() {
        return new State<>(start, mat[start.i][start.j], null);
    }

    @Override
    public boolean isGoalState(State<Position> state) {
        return state.getValue().equals(end);
    }

    @Override
    public List<State<Position>> getAllPossibleStates(State<Position> state) {
        if (state == null || state.getValue() == null) return null;
        Position p = state.getValue();
        if (!isInBounds(p.i, p.j)) return null;

        List<State<Position>> states = new ArrayList<>();

        if (isInBounds(p.i - 1, p.j)) {
            states.add(new State<>(new Position(p.i - 1, p.j), mat[p.i - 1][p.j] + state.getCost(), state));
        }
        if (isInBounds(p.i + 1, p.j)) {
            states.add(new State<>(new Position(p.i + 1, p.j), mat[p.i + 1][p.j] + state.getCost(), state));
        }
        if (isInBounds(p.i, p.j - 1)) {
            states.add(new State<>(new Position(p.i, p.j - 1), mat[p.i][p.j - 1] + state.getCost(), state));
        }
        if (isInBounds(p.i, p.j + 1)) {
            states.add(new State<>(new Position(p.i, p.j + 1), mat[p.i][p.j + 1] + state.getCost(), state));
        }

        return states;
    }

    private boolean isInBounds(int i, int j) {
        int N = mat.length;
        return i < N && j < N && i >= 0 && j >= 0;
    }
}
