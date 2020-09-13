package searchable.eight_puzzle;

import searchable.Searchable;
import state.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightPuzzle implements Searchable<Puzzle> {

    int[][] initState;

    final int[][] goalState = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, -1}
    };

    public EightPuzzle(int[][] initState) {
        this.initState = initState;
    }

    public static double calcCost(int[][] mat) {
        double cost = 0.0;
        if (mat[0][0] != 1) cost += 1.0;
        if (mat[0][1] != 2) cost += 1.0;
        if (mat[0][2] != 3) cost += 1.0;
        if (mat[1][0] != 4) cost += 1.0;
        if (mat[1][1] != 5) cost += 1.0;
        if (mat[1][2] != 6) cost += 1.0;
        if (mat[2][0] != 7) cost += 1.0;
        if (mat[2][1] != 8) cost += 1.0;
        if (mat[2][2] != -1) cost += 1.0;

        return cost;
    }

    public static boolean isSolvable(Puzzle p) {
        int[] vec = new int[9];
        int i = 0;

        for (int[] arr : p.mat)
            for (int a : arr)
                vec[i++] = a;

        int inversions = 0;

        for (i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (vec[i] != -1 && vec[j] != -1 && vec[i] > vec[j])
                    inversions++;
            }
        }

        return inversions % 2 == 0;
    }

    @Override
    public State<Puzzle> getInitialState() {
        return new State<>(new Puzzle(initState), calcCost(initState), null);
    }

    @Override
    public boolean isGoalState(State<Puzzle> state) {
        return Arrays.deepEquals(state.getValue().mat, goalState);
    }

    @Override
    public List<State<Puzzle>> getAllPossibleStates(State<Puzzle> state) {
        List<State<Puzzle>> states = new ArrayList<>();

        // find i,j such that mat[i][j] == -1;

        int[][] currentMat = state.getValue().mat;
        int newI = 0, newJ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentMat[i][j] == -1) {
                    newI = i;
                    newJ = j;
                    break;
                }
            }
        }

        // check boundaries for possible inversions

        if (isInBounds(newI - 1, newJ)) {
            int[][] tempMat = new int[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(currentMat[i], 0, tempMat[i], 0, 3);
            }
            tempMat[newI][newJ] = tempMat[newI - 1][newJ];
            tempMat[newI - 1][newJ] = -1;
            states.add(new State<>(new Puzzle(tempMat), calcCost(tempMat) + 1, state));
        }

        if (isInBounds(newI + 1, newJ)) {
            int[][] tempMat = new int[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(currentMat[i], 0, tempMat[i], 0, 3);
            }
            tempMat[newI][newJ] = tempMat[newI + 1][newJ];
            tempMat[newI + 1][newJ] = -1;
            states.add(new State<>(new Puzzle(tempMat), calcCost(tempMat) + 1, state));
        }

        if (isInBounds(newI, newJ + 1)) {
            int[][] tempMat = new int[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(currentMat[i], 0, tempMat[i], 0, 3);
            }
            tempMat[newI][newJ] = tempMat[newI][newJ + 1];
            tempMat[newI][newJ + 1] = -1;
            states.add(new State<>(new Puzzle(tempMat), calcCost(tempMat) + 1, state));
        }

        if (isInBounds(newI, newJ - 1)) {
            int[][] tempMat = new int[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(currentMat[i], 0, tempMat[i], 0, 3);
            }
            tempMat[newI][newJ] = tempMat[newI][newJ - 1];
            tempMat[newI][newJ - 1] = -1;
            states.add(new State<>(new Puzzle(tempMat), calcCost(tempMat) + 1, state));
        }

        return states;
    }

    private boolean isInBounds(int i, int j) {
        return i < 3 && j < 3 && i >= 0 && j >= 0;
    }


    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        System.out.println(isSolvable(new Puzzle(mat)));   // should be false
    }
}
