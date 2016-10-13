import java.util.*;

public class vertex {
    private int number;
    private String color;
    private ArrayList<neighbor> neighborList = new ArrayList<>();

    public vertex(int num, int [] neighbors) {
        setNumber(num);

        for (int i = 0; i < neighbors.length; i++) {
            this.addNeighbor(new neighbor(neighbors[i]));
        }
    }

    private void setNumber(int num) {
        this.number = num;
    }

    private void addNeighbor(neighbor newNeighbor) {
        neighborList.add(newNeighbor);
    }

    public int getNumber() {
        return number;
    }

    public void setColor(String col) {
        if (color == null || color == col) {
            this.color = col;
        } else {
            throw new IllegalArgumentException("Nu, das nat allowed. Node: " + this.number + " iz color: " + this.color + ", but you want color: " + col);
        }
    }

    public String getColor() {
        return this.color;
    }

    public ArrayList<neighbor> getAllNeighbors() {
        return neighborList;
    }
}
