package solvers;

import searchable.Searchable;
import searchable.eight_puzzle.EightPuzzle;
import searchable.eight_puzzle.Puzzle;
import searcher.Searcher;
import state.State;
import java.util.ArrayList;
import java.util.List;

public class EightPuzzleSolver extends MazeSolver<Puzzle> {

    public EightPuzzleSolver(Searcher<Puzzle> searcher) {
        super(searcher);
    }

    @Override
    public List<State<Puzzle>> solve(Searchable<Puzzle> s) {
        if(!EightPuzzle.isSolvable(s.getInitialState().getValue())) {
            System.out.println("This Puzzle is not solvable!");
            return new ArrayList<>();
        }

        return searcher.search(s);
    }
}
