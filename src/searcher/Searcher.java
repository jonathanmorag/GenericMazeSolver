package searcher;

import searchable.Searchable;
import state.State;
import java.util.List;

public interface Searcher<T> {
    List<State<T>> search(Searchable<T> s);
}
