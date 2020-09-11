package searcher;

import searchable.Searchable;
import state.State;

import java.util.List;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher<T> {

    protected PriorityQueue<State<T>> openList;

    @Override
    public abstract List<State<T>> search(Searchable<T> s);
}
