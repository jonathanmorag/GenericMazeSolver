package solvers;

public interface Solver<T, R> {
    R solve(T problem);
}
