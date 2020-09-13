package state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State<T> {

    private T value;
    private double cost;
    private State<T> cameFrom;

    public State(T value) {
        this.value = value;
        this.cost = 0.0;
        this.cameFrom = null;
    }

    public State(T value, double cost, State<T> cameFrom) {
        this.value = value;
        this.cost = cost;
        this.cameFrom = cameFrom;
    }


    public T getValue() {
        return value;
    }

    public double getCost() {
        return cost;
    }

    public State<T> getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(State<T> state) {
        this.cameFrom = state;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean hasCameFrom() {
        return cameFrom != null;
    }

    public static <T> List<State<T>> backtrace(State<T> s) {
        List<State<T>> list = new ArrayList<>();
        list.add(s);
        while (s.hasCameFrom()) {
            State<T> cameFrom = s.getCameFrom();
            list.add(cameFrom);
            s = cameFrom;
        }
        Collections.reverse(list);
        return list;
    }

    @Override
    public String toString() {
        return "" + value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State<?> other = (State<?>) o;

        return this.cost == other.cost && value.equals(other.value);
    }

    public static void main(String[] args) {
        State<Integer> s1 = new State<>(1);
        State<Integer> s2 = new State<>(2);
        State<Integer> s3 = new State<>(3);
        State<Integer> s4 = new State<>(4);

        s2.setCameFrom(s1);
        s3.setCameFrom(s2);
        s4.setCameFrom(s3);

        backtrace(s4).forEach(s -> System.out.print(s + " -> "));
        System.out.println("end");
    }


}
