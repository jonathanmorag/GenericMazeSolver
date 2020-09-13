package solvers;

import searchable.matrix.Position;
import searcher.Searcher;

public class MatrixSolver extends MazeSolver<Position> {

    public MatrixSolver(Searcher<Position> searcher) {
        super(searcher);
    }
}
