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
        ArrayList<String> inputData = readFile("Graph1.txt");

        //Creates a graph of vertices, with numbers of 1 to n, indexed from 0 to n-1
        graph tableMap = new graph(inputData);

        int tableMapSize = tableMap.getNumberOfVertices();

        System.out.println(tableMapSize);
    }



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


