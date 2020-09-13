package searcher;

import searchable.Searchable;
import state.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HillClimbing<T> extends CommonSearcher<T> {

    @Override
    public List<State<T>> search(Searchable<T> s) {
        State<T> current = s.getInitialState();
        HashSet<State<T>> closedSet = new HashSet<>();
        if (s.isGoalState(current)) {
            System.out.println("GOAL!");
            return State.backtrace(current);
        }
        closedSet.add(current);
        List<State<T>> states = new ArrayList<>(s.getAllPossibleStates(current));
        for (State<T> st : states) {
            if (!closedSet.contains(st)) {
                closedSet.add(st);
                if (s.isGoalState(current)) {
                    System.out.println("GOAL!");
                    return State.backtrace(current);
                }
                if (st.getCost() < current.getCost()) {
                    current = st;
                }
            }
        }
        System.out.println("HILL CLIMBING: No solution");
        return new ArrayList<>();
    }
}
