/**
 * Created by aidan.gunda on 2016-10-11.
 */

public class neighbor {
    private int vertexEquivalent;

    public neighbor (int number) {
        setVertexEquivalent(number);
    }

    private void setVertexEquivalent(int n) {
        this.vertexEquivalent = n;
    }

    public int getVertexEquivalent() {
        return vertexEquivalent;
    }
}


