import searchable.*;
import searchable.word_game.WordGame;
import searcher.*;
import solvers.WordGameSolver;

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

        new MatrixSolver(new DFS<>())
                .solve(matrix)
                .forEach(System.out::println);

        */

        /* ---------------------------------- EIGHT-PUZZLE ---------------------------------- */

        /*
        int[][] eightPuzzleMat = {
                {-1, 1, 3},
                {4, 2, 5},
                {7, 8, 6}
        };

        Searchable<Puzzle> puzzle = new EightPuzzle(eightPuzzleMat);

        // Let's solve the EightPuzzle puzzle, using dependency injection with Best First Search algorithm

        new EightPuzzleSolver(new BestFirstSearch<>())
                .solve(puzzle)
                .forEach(System.out::println);

         */

        /* ------------------------------------ WORD GAME ------------------------------------ */

        Searchable<String> wordGame = new WordGame("aecdb", "abcde");

        new WordGameSolver(new BFS<>())
                .solve(wordGame)
                .forEach(System.out::println);
    }


}
