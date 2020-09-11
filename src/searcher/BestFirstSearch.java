package searcher;

import searchable.Searchable;
import state.State;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class BestFirstSearch<T> extends CommonSearcher<T> {

    public BestFirstSearch() {
        openList = null;
    }

    @Override
    public List<State<T>> search(Searchable<T> s) {
        openList = new PriorityQueue<>(Comparator.comparingDouble(State::getCost));
        openList.add(s.getInitialState());
        HashSet<State<T>> closedSet = new HashSet<>();

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

        return null;
    }
}
