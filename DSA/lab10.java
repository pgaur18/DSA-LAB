import java.io.File;
import java.util.*;
public class lab10 {
public static void printDFSHelper( int edges[][], int sv, boolean visited[] )
{
System.out.print(corrStr(sv) + " ");
visited[sv]= true;	
int n= edges.length;		
for( int i= 0; i< n; i++ ) 
{
if( edges[sv][i] == 1 && ! visited[i] )
{
printDFSHelper(edges, i, visited);
}
}		
}	
public static void printDFS( int edges[][] )
{
boolean visited[]= new boolean[edges.length];		
for( int i= 0; i< edges.length; i++ )		
{
if( ! visited[i] )
{
printDFSHelper(edges, i, visited);
System.out.println();
}			
}		
}
public static int corrIndex( String s )
{
if( s.equals("A") )
{
return 0;
}
else if( s.equals("B") )
{
return 1;
}
else if( s.equals("C") )
{
return 2;
}
else if( s.equals("D") )
{
return 3;
}
else if( s.equals("E") )
{
return 4;
}
else if( s.equals("F") )
{
return 5;
}
else if( s.equals("G") )
{
return 6;
}
else if( s.equals("H") )
{
return 7;
}		
return 100;		
}
public static String corrStr( int n )
{
if( n == 0 )
{
return "A";
}
else if( n == 1 )
{
return "B";
}
else if( n == 2 )
{
return "C";
}
else if( n == 3 )
{
return "D";
}
else if( n == 4 )
{
return "E";
}
else if( n == 5 )
{
return "F";
}
else if( n == 6 )
{
return "G";
}
else if( n == 7 )
{
return "H";
}		
return "a";		
}	
public static void main(String[] args) {	
int i= 0;
int arr[]= new int[2];		
ArrayList<String> first= new ArrayList<>();
ArrayList<String> second= new ArrayList<>();		
try
{
File obj= new File("graphin.txt");
Scanner sc= new Scanner(obj);			
while( sc.hasNextLine() )
{
String s= sc.nextLine();				
if( i < 2 )
{
arr[i]= Integer.parseInt(s);
i++;
}
else
{
String ans[]= s.split(" ");				
first.add(ans[0]);
second.add(ans[1]);
}								
}			
sc.close();			
}		
catch( Exception ex )
{				
}				
int n= arr[0];
int e= arr[1];		
int edges[][]= new int[n][n];		
for( int j= 0; j<e; j++ )
{
int fv= corrIndex(first.get(j));	
int sv= corrIndex(second.get(j));			
edges[fv][sv]= 1;					
}		
System.out.println("DFS"); 
printDFS(edges);		
}
}
