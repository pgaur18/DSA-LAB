import java.util.*;
import java.io.*;
class Student
{
String name;
String idno;
String cgpa;
public Student(String name, String idno, String cgpa )
{
this.name= name;
this.idno= idno;
this.cgpa= cgpa;	
}
public void Display( )
{
System.out.print(this.idno + ", ");
}	
}
class bTreeNode {
public Student data;
public bTreeNode left;
public bTreeNode right;	
public bTreeNode( Student data )
{
this.data=data;
this.left= null;
this.right= null;
}
}
class BinarySearchTree {	
private static bTreeNode root;	
public bTreeNode insertDataHelper( bTreeNode root, Student data )
{
if( root == null )
{
bTreeNode newNode= new bTreeNode(data);
root= newNode;
return root;
}		
if( data.idno.compareTo(root.data.idno) > 0 )
{
root.right= insertDataHelper(root.right, data);
}		
else
{
root.left= insertDataHelper(root.left, data);
}		
return root;		
}	
public void insertData( Student data )
{
root= insertDataHelper(root, data );
}	
public void preOrderHelper( bTreeNode root )
{
if( root == null )
{
return;
}	
root.data.Display();	
preOrderHelper(root.left);
preOrderHelper(root.right);		
}	
public void preOrder()
{
preOrderHelper(root);	
}


public void postOrderHelper( bTreeNode root )
{
if( root == null )
{
return;
}

postOrderHelper(root.left);
postOrderHelper(root.right);		
root.data.Display();		
}	

public void postOrder()
{
postOrderHelper(root);	
}

public void inOrderHelper( bTreeNode root )
{
if( root == null )
{
return;
}

inOrderHelper(root.left);		
root.data.Display();	

inOrderHelper(root.right);
}

public void inOrder()
{
inOrderHelper(root);	
}		
}
public class lab7 {
public static void main(String[] args) {		
BinarySearchTree bst= new BinarySearchTree();		
try
{
File obj= new File("bstin.txt");
Scanner sc= new Scanner(obj);			
while( sc.hasNextLine() )
{
String s= sc.nextLine();
String arr[]= s.split(" ");				
Student newObj= new Student(arr[0], arr[1], arr[2]);				
bst.insertData(newObj);				
}			
sc.close();			
}
catch( FileNotFoundException e )
{
}		
System.out.println();
bst.preOrder();
System.out.println();
System.out.println();
bst.postOrder();
System.out.println();		
System.out.println();
bst.inOrder();
System.out.println();
}
}
