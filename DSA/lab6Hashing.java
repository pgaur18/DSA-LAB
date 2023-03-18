import java.util.*;
import java.io.*;
class lab6Hashing {
static class MapNode 
{
String key;
MapNode next;
MapNode( String s )
{
this.key= s;
this.next= null;
}		
}
static class Map 
{
ArrayList<MapNode> buckets;
int size;  // total entries. we will use this so that we do not have to traverse LinkedList for size
int numBuckets;		
public Map()
{
buckets= new ArrayList<>();
numBuckets=6;
for( int i=0; i<numBuckets; i++)
{
buckets.add(null);
}	
}	
private int getHashCode( String s )
{
int sumOFAlphabets= 0;
int sumOfDigits= 0;
char arr[]= s.toCharArray();
for( char ch : arr )
{
if( ( ch >= 'a' && ch <= 'z' ) || ( ch >= 'A' && ch <= 'Z' ) )
{
sumOFAlphabets+= ch;
}
else if( ch >= '0' && ch<= '9' )
{
sumOfDigits+= ch;
}
}
int finalValue= ( ( sumOFAlphabets + (2*sumOfDigits) ) *17 ) + 5;
return finalValue;	
}
private int getBucketIndex( String key )
{
int hC= getHashCode(key);
System.out.println("Hash Value Of " + key + " : " + hC % numBuckets);
return hC % numBuckets;	
}	
public void display()
{
for( int i= 0; i< buckets.size(); i++ )
{
MapNode node= buckets.get(i);		
System.out.print("The Subset of " + i + " : ");
while( node != null )
{
System.out.print(node.key + ", ");
node= node.next;
}
System.out.println();
}	
}
public double loadFactor()
{
return ( 1.0 * size)/numBuckets;
} 
public void insert( String s )
{
int bucketIndex= getBucketIndex(s);
MapNode head= buckets.get(bucketIndex);
while( head != null ) 
{
if( head.key.equals(s) )
{
return;
}
head= head.next;
}
head= buckets.get(bucketIndex);
MapNode newNode= new MapNode(s);
size++;
newNode.next= head; 
buckets.set(bucketIndex, newNode);	
}
public int size()
{
return size;
}	
}
public static void main(String[] args) {	
Map m1= new Map();
try
{
File obj= new File("lab6source.txt");
Scanner sc= new Scanner(obj);
while( sc.hasNextLine() )
{
String s= sc.nextLine();
m1.insert(s);
}
sc.close();
}			
catch( FileNotFoundException e )
{
System.out.println("Error");
e.toString();
}
m1.display();
}
}
