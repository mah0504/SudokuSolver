import java.util.*;

public class StackElement {
    private int x;
    private int y;
    private List<Integer> list;

    // Constructeur
    public StackElement(int x, int y, List<Integer> possibleValues) {
        this.x = x;
        this.y = y;
        this.list = possibleValues;
    }

    // Getters et Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Integer> getPossibleValues() {
        return list;
    }

    public void setPossibleValue(List<Integer> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "StackElement{" +
               "x=" + x +
               ", y=" + y +
               ", list=" + list +
               '}';
    }
}

