package searcher;

import searchable.Searchable;
import state.State;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public abstract class CommonSearcher<T> implements Searcher<T> {

    Queue<State<T>> openList;
    HashSet<State<T>> closedSet;

    @Override
    public abstract List<State<T>> search(Searchable<T> s);
}
