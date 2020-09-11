import searchable.*;
import searchable.eight_puzzle.EightPuzzle;
import searchable.eight_puzzle.Puzzle;
import searchable.matrix.Matrix;
import searchable.matrix.Position;
import searcher.BestFirstSearch;
import searcher.Searcher;
import solvers.EightPuzzleSolver;
import solvers.MatrixSolver;

public class MainTrain {

    public static void main(String[] args) {

        /* ------------------------------- MATRIX BEST PATH ------------------------------- */

        /*
        int[][] mat = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 2, 3, 4},
                {4, 3, 2, 1}
        };

        Position start = new Position(0, 0);
        Position end = new Position(3, 3);

        Searchable<Position> matrix = new Matrix(mat, start, end);

        new MatrixSolver(new BestFirstSearch<>())
                .solve(matrix)
                .forEach(System.out::println);

        */

        /* ------------------------------- EIGHT-PUZZLE ------------------------------- */

        int[][] eightPuzzleMat = {
                {1, 8, 2},
                {-1, 4, 3},
                {7, 6, 5}
        };

        Searchable<Puzzle> puzzle = new EightPuzzle(eightPuzzleMat);

        // Let's solve the EightPuzzle puzzle, using dependency injection with Best First Search algorithm

        new EightPuzzleSolver(new BestFirstSearch<>())
                .solve(puzzle)
                .forEach(System.out::println);
    }
}
