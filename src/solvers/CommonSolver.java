package solvers;

import searchable.Searchable;
import searcher.Searcher;
import state.State;
import java.util.List;

public class CommonSolver<T> implements Solver<Searchable<T>, List<State<T>>> {

    Searcher<T> searcher;

    public CommonSolver(Searcher<T> searcher) {
        this.searcher = searcher;
    }

    @Override
    public List<State<T>> solve(Searchable<T> problem) {
        return searcher.search(problem);
    }
}