package solvers;

import searchable.Searchable;
import searchable.matrix.Position;
import searcher.Searcher;
import state.State;
import java.util.List;

public class MatrixSolver extends MazeSolver<Position> {

    public MatrixSolver(Searcher<Position> searcher) {
        super(searcher);
    }

    @Override
    public List<State<Position>> solve(Searchable<Position> s) {
        return searcher.search(s);
    }
}
