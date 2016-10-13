import java.util.Scanner;

public class graph {
	public int num; //Number of vertices
	public int[][] vertices = null;
	public graph (int n){
		num =n;
		vertices=new int[n][n];		
	}
	public void addVert(String line){
		int i=0;
		while (line.charAt(i)!=':'){i++;} //find index of colon
		String vertString=line.substring(0,i-1);
		String nghbrString=line.substring(i+1);
		int vert=Integer.parseInt(vertString); //find vertice of line
		
		Scanner input=new Scanner(nghbrString); 
		while (input.hasNextInt()){ //put neighbours into the appropriate array
			vertices[vert][i]=input.nextInt();
			i++;
		}
		int j=i;//stupid syntax thing because for (i;i<num;i++) isn't allowed
		for (i=j;i<num;i++){vertices[vert][i]=num+1;} //sets remainder of array to an invalid vertice
		input.close();
	}
}
