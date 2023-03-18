import java.io.*;
import java.util.*;

class PriorityQueueException extends Exception
{
}

class Priority_Queue_Min {
private ArrayList<String> heap;
public Priority_Queue_Min()
{
heap= new ArrayList<>();
}	
public boolean isEmpty()
{ 
return heap.size() == 0;
} 	
public int size()
{
return heap.size();
}	
public String getMin() throws PriorityQueueException
{
if( heap.size() == 0  )
{
throw new PriorityQueueException();
}		
return heap.get(0);		
}	
public void insert( String element )
{
heap.add(element);	
int childIndex= heap.size()-1;
int parentIndex= ( childIndex-1 )/2; 
while( childIndex > 0 )
{
if( ( heap.get(childIndex).compareTo(heap.get(parentIndex)) < 0 )  )
{
String temp= heap.get(childIndex);
heap.set(childIndex, heap.get(parentIndex));
heap.set(parentIndex, temp);
childIndex= parentIndex;
parentIndex= ( childIndex-1 )/2;				
}
else
{
return;
}			
}		
}	
public String remove() throws PriorityQueueException
{ 
if( heap.size() == 0 )
{
throw new PriorityQueueException();
}		
String ans= heap.get(0);		
int lastIndex= heap.size()-1;
heap.set(0, heap.get(lastIndex));
heap.remove(lastIndex);
int index= 0;
int minIndex= index;	
int leftChildIndex= 1;
int rightChildIndex= 2;	
while( leftChildIndex < heap.size() )
{
if( ( heap.get(leftChildIndex).compareTo( heap.get(minIndex) ) ) < 0 )
{
minIndex= leftChildIndex;
}
if( rightChildIndex < heap.size() && ( heap.get(rightChildIndex).compareTo(heap.get(minIndex) ) ) < 0 )  
{								 
minIndex= rightChildIndex;
}
if( minIndex == index )
{
break;
}
else
{
String temp= heap.get(index);
heap.set(index, heap.get(minIndex));
heap.set(minIndex, temp);
index= minIndex;
leftChildIndex= 2*index + 1;
rightChildIndex= 2*index + 2;	
} 
}
return ans;	
}
public void Display()
{
for( String s : heap )
{
System.out.print(s + ", ");
}
System.out.println();
}
}
public class lab8 {
public static void main(String[] args) {
Priority_Queue_Min pq= new Priority_Queue_Min();
try
{
File obj= new File("heapin.txt");
Scanner sc= new Scanner(obj);
while( sc.hasNextLine() )
{
String s= sc.nextLine();
pq.insert(s);
pq.Display();				
}
}
catch( Exception e )
{			
}
}
}
