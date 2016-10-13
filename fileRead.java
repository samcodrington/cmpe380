import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Class of methods for file reading
public class fileRead {
	public static graph fileToGraph(String s) throws IOException{
		BufferedReader br=null;
		try {
			br=new BufferedReader(new FileReader(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int vertNum=Integer.parseInt(br.readLine());
		graph g=new graph(vertNum);
		String line=br.readLine();
		while(line != null){
			g.addVert(line);
			line=br.readLine();
		}
		return g;
	}
	
	

}
