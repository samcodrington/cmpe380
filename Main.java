import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by aidan.gunda on 2016-10-11.
 */
public class Main {

    public static void main(String[] args) {
        questionOne("Graph1.txt");
        questionOne("Graph2.txt");
    }

    private static void questionOne(String fileName) {
        ArrayList<String> inputData = readFile(fileName);

        //Creates a graph of vertices, with numbers of 1 to n, indexed from 0 to n-1
        graphAidan tableMap = new graphAidan(inputData);

        //Iterate through each vertex of the table map
        for (vertex vert : tableMap.getVertexList()) {

            //Save the vertex's number, and the index it is located at in the list
            int vertexID = vert.getNumber();
            int vertexIndex = vertexID - 1;

            String currentColor = vert.getColor();

            //Color the vertex "Red" if it has not been previously colored yet
            if(currentColor == null) {
                vert.setColor("Red");
            }

            //Retrieve the list of neighbors associated with that vertex
            ArrayList<neighbor> neighborList = tableMap.getVertex(vertexIndex).getAllNeighbors();

            //Iterate through the list of neighbors, and color the vertex corresponding to them, accordingly
            for (neighbor n : neighborList) {
                int neighborID = n.getVertexEquivalent();
                int neighborIndex = neighborID - 1;

                if(vert.getColor() == "Red")
                    tableMap.getVertex(neighborIndex).setColor("Blue");
                else if (vert.getColor() == "Blue")
                    tableMap.getVertex(neighborIndex).setColor("Red");
            }
        }
        System.out.println("The graph, " + fileName + ", can be two-colored!");
    }

    /**
     * This function reads a text file, and outputs each line as a string into an ArrayList<>
     * @param fileName      The name of the file passed as a String
     * @return lineList     The list of strings representing each line of the text file
     */
    private static ArrayList<String> readFile(String fileName) {
        ArrayList<String> lineList = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            do {
                line = br.readLine();
                lineList.add(line);
            } while(line != null);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IO Error");
            ex.printStackTrace();
        }

        return lineList;
    }
}


