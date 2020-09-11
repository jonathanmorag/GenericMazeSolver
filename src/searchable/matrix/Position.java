package searchable.matrix;

public class Position {

    int i, j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setPosition(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "[" + i + "," + j + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (i != position.i) return false;
        return j == position.j;
    }

    public static void main(String[] args) {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(1, 4);
        Position p3 = new Position(1, 1);

        System.out.println(p1.equals(p2)); // should be false
        System.out.println(p1.equals(p3)); // should be true
    }

}
