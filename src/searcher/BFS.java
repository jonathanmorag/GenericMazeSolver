package searcher;

import searchable.Searchable;
import state.State;
import java.util.*;

public class BFS<T> extends CommonSearcher<T> {

    @Override
    public List<State<T>> search(Searchable<T> s) {
        openList = new LinkedList<>();
        closedSet = new HashSet<>();
        closedSet.add(s.getInitialState());
        openList.add(s.getInitialState());

        while (openList.size() > 0) {
            State<T> n = openList.poll();
            if (s.isGoalState(n)) {
                System.out.println("GOAL!");
                return State.backtrace(n);
            }

            List<State<T>> states = s.getAllPossibleStates(n);

            for (State<T> st : states) {
                if (!closedSet.contains(st)) {
                    closedSet.add(st);
                    st.setCameFrom(n);
                    openList.add(st);
                }
            }
        }
        System.out.println("BFS: No solution");
        return new ArrayList<>();
    }
}
