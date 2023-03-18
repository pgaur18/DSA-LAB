import java.util.*;
import java.io.*;

class StackEmptyException extends Exception
{
}

class StackFullException extends Exception
{
}

class Train
{
private String name;
private String startStation;
private String endStation;
private String noOfDays;

public Train(String name, String startStation, String endStation, String noOfDays )
{
this.name = name;
this.startStation = startStation;
this.endStation = endStation;
this.noOfDays = noOfDays;
}

public String getName() 
{
return this.name;
}

public String getStartStation() 
{
return this.startStation;
}

public String getEndStation()
{
return this.endStation;
}

public String getNoOfDays()
{
return this.noOfDays;
}
public void Display()
{
System.out.println(" Name : " + this.getName());
System.out.println(" Start Station : " + this.getStartStation());
System.out.println(" End Station : " + this.getEndStation());
System.out.println(" No. Of Days : " + this.getNoOfDays());
System.out.println();		
}	
}

class stack
{
private Train data[];
private int top;	
	
public stack()
{
data= new Train[10];
top= -1;
}
		
public stack( int capacity )
{
data= new Train[capacity];
top= -1;
}
public boolean isEmpty()
{
if( top == -1 )
{
return true;
}
return false;
}

public int size()
{
return top+1;	
}

public void push( Train element ) throws StackFullException
{
if( size() == data.length )
{
throw new StackFullException();
}
		
top++;
data[top]= element;
}

public Train pop() throws StackEmptyException
{
if( size() == 0 )
{
StackEmptyException e= new StackEmptyException();
throw e;
}

Train ans= data[top];
top--;
return ans; 

}

}

class lab1stack
{
public static void main(String[] args) {
		
stack st= new stack(5);

try
{
File obj= new File("trainin.dat");
Scanner sc= new Scanner(obj);

while( sc.hasNextLine() )
{
String s= sc.nextLine();
String arr[]= s.split("	");
Train trainObj= new Train(arr[0], arr[1], arr[2], arr[3]);
trainObj.Display();
try
{
st.push(trainObj);
}
catch( Exception e )
{
}
}
sc.close();			
}
catch( FileNotFoundException e )
{
System.out.println("Error");
e.toString();
}
try
{
FileWriter fw= new FileWriter("trainoutstack.dat");			
while( ! st.isEmpty() )
{
Train temp= st.pop();
String ans= temp.getName() + " " + temp.getStartStation() + " " + temp.getEndStation() + " "  + temp.getNoOfDays();
fw.write(ans + "\n");
}
fw.close();
}
catch( Exception e )
{
System.out.println(e);
}
}
}
