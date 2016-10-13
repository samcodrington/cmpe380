import java.util.*;

public class graphAidan {
    private ArrayList<vertex> vertexList = new ArrayList<>();

    public graphAidan(ArrayList<String> inputStrings) {
        String stringValues = inputStrings.get(0);
        int numberOfVertices = Integer.parseInt(stringValues);

        for (int id = 1; id <= numberOfVertices; id++) {

            stringValues = inputStrings.get(id);

            //noColon[0] contains vertex, noColon[1] contains string of neighbors
            String[] noColon = stringValues.split(":");
            String trimmed = noColon[1].trim();
            String[] neighbors = trimmed.split("\\s+");

            //Create an array the same size as neighbors to store the integer equivalent
            int[] neighborValues = new int[neighbors.length];

            //Turn the strings representing the neighbors into integers
            for (int i = 0; i < neighborValues.length; i++)
                neighborValues[i] = Integer.parseInt(neighbors[i]);

            //Add a vertex with an ID number between 1 and n
            addVertex(new vertex(id, neighborValues));
        }
    }

    private void addVertex(vertex newVertex) {
        vertexList.add(newVertex);
    }

    public ArrayList<vertex> getVertexList() {
        return vertexList;
    }

    public vertex getVertex(int num) {
        return vertexList.get(num);
    }
}
