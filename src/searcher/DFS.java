package searcher;

import searchable.Searchable;
import state.State;

import java.util.*;

public class DFS<T> extends CommonSearcher<T> {

    @Override
    public List<State<T>> search(Searchable<T> s) {
        Stack<State<T>> stack = new Stack<>();
        closedSet = new HashSet<>();

        stack.push(s.getInitialState());
        while (!stack.isEmpty()) {
            State<T> n = stack.pop();
            if (!closedSet.contains(n)) {
                closedSet.add(n);
                if (s.isGoalState(n)) {
                    System.out.println("GOAL!");
                    return State.backtrace(n);
                }
                List<State<T>> states = s.getAllPossibleStates(n);
                for (State<T> st : states) {
                    if (!closedSet.contains(st)) {
                        closedSet.add(st);
                        stack.push(st);
                    }
                }
            }
        }
        System.out.println("DFS: No solution");
        return new ArrayList<>();
    }
}
