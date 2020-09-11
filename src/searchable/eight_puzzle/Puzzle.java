package searchable.eight_puzzle;

import java.util.Arrays;

public class Puzzle {

    int[][] mat;
    int moves;

    public Puzzle(int[][] mat) {
        this.mat = mat;
        this.moves = 0;
    }

    public Puzzle(int[][] mat, int moves) {
        this.mat = mat;
        this.moves = moves;
    }

    public int getMoves() {
        return moves;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Puzzle)) return false;

        Puzzle puzzle = (Puzzle) o;

        return Arrays.deepEquals(mat, puzzle.mat);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(mat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int[] arr : mat) {
            sb.append(Arrays.toString(arr)).append("\n");
        }
        sb.append("***********");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] eightPuzzleMat = {
                {-1, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };

        Puzzle p = new Puzzle(eightPuzzleMat);

        System.out.println(p);
    }
}
