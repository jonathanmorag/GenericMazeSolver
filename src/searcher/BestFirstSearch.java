package searcher;

import searchable.Searchable;
import state.State;

import java.util.*;


public class BestFirstSearch<T> extends CommonSearcher<T> {

    @Override
    public List<State<T>> search(Searchable<T> s) {
        openList = new PriorityQueue<>(Comparator.comparingDouble(State::getCost));
        openList.add(s.getInitialState());
        closedSet = new HashSet<>();

        while (openList.size() > 0) {
            State<T> n = openList.poll();
            closedSet.add(n);

            if (s.isGoalState(n)) {
                System.out.println("GOAL!");
                return State.backtrace(n);
            }

            List<State<T>> successors = s.getAllPossibleStates(n);
            for (State<T> state : successors) {
                if (!closedSet.contains(state) && !openList.contains(state))
                    openList.add(state);
                else {
                    State<T> temp = null;
                    for (State<T> openListState : openList) {
                        if (state.equals(openListState) && state.getCost() < openListState.getCost()) {
                            temp = openListState;
                            break;
                        }
                    }
                    if (temp != null) {
                        openList.remove(temp);
                        openList.add(state);
                    }
                }
            }
        }
        System.out.println("BEST FIRST SEARCH: No solution");
        return new ArrayList<>();
    }
}
