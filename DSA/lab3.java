import java.util.*;
import java.io.*;
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
class DoublyNode
{
Train data;
DoublyNode next;
DoublyNode prev;
DoublyNode( Train data )
{
this.data= data;
this.next= null;
this.prev= null;
}
}
class DLL {
private static DoublyNode head;
private static DoublyNode tail;
private static int size;	
public void add( Train value )
{
DoublyNode node= new DoublyNode(value); 
size++;			
if( head == null )
{
head= tail= node;
}
else
{
tail.next= node;
node.prev= tail;
tail= node;
}
}	
public void deletePos( int pos )
{
if( head == null )
{
System.out.println("List is Empty");
}
if( head == tail )
{
System.out.println("Deleted Node is : "+ tail.data);
head= tail= null;
size= 0;	
}		
if( pos == 0 )
{
DoublyNode removed= head;
Train removedTrainObj= removed.data;
System.out.println("Deleted Record" + "\n");
removedTrainObj.Display();		
head= head.next;
head.prev= null;
size--;
}
else
{
DoublyNode temp= head;		
for( int i= 0; i< pos-1; i++ )
{
temp= temp.next;
}
DoublyNode removed= temp.next;
Train removedTrainObj= removed.data;
System.out.println("Deleted Record" + "\n");
removedTrainObj.Display();
temp.next= removed.next;
removed.next.prev= temp;
size--;
}	
}
public void display1()
{
if( head == null )
{
System.out.println("List is empty");
return;
}
System.out.print("Display -> " + "\n");
DoublyNode temp= head;
while( temp != null )
{
Train t= temp.data;
t.Display();
temp= temp.next;
}
System.out.println();		
}
public void revDisplay()
{
if( head == null )
{
System.out.println("List is empty ");	
return;
}
System.out.print("Reverse Display -> " + "\n");
DoublyNode rev= tail;		
while( rev != null )
{
Train t= rev.data;
t.Display();
rev= rev.prev;
}		
}
public void size()
{
System.out.println("Size -> "+size);
}	
}
class lab3 {
public static void main(String[] args) {		
DLL listObj= new DLL();
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
listObj.add(trainObj);				
}
sc.close();		
}
catch( FileNotFoundException e )
{
System.out.println("Error");
e.toString();
}		
System.out.println("2nd position record to be deleted from list");
listObj.deletePos(2);
listObj.display1();
listObj.revDisplay();
}
}

