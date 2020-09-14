package searchable.word_game;

import searchable.Searchable;
import state.State;

import java.util.ArrayList;
import java.util.List;

public class WordGame implements Searchable<String> {

    String initial;
    String goalState;

    public WordGame(String initial, String goalState) {
        this.initial = initial;
        this.goalState = goalState;
    }

    public static double calcCost(String current, String goal) {
        double cost = 0.0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != goal.charAt(i)) {
                cost += 1.0;
            }
        }

        return cost;
    }

    @Override
    public State<String> getInitialState() {
        return new State<>(initial, calcCost(initial, goalState), null);
    }

    @Override
    public boolean isGoalState(State<String> state) {
        return state.getValue().equals(goalState);
    }

    @Override
    public List<State<String>> getAllPossibleStates(State<String> state) {
        List<State<String>> states = new ArrayList<>();
        int N = initial.length();
        for (int i = 0; i < N - 1; i++) {
            String temp = swapLetters(state.getValue(), i);
            states.add(new State<>(temp, calcCost(temp, goalState) + 1, state));
        }
        return states;
    }

    private static String swapLetters(String s, int i) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(i + 1));
        sb.setCharAt(i + 1, s.charAt(i));
        return sb.toString();
    }

}