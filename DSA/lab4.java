import java.util.*;

class lab4{

public static void linearSearch( int arr[], int n )
{
for( int i= 0; i< arr.length; i++ )
{
if( arr[i] == n )
{
System.out.println("Element found at position " + i);
return;
}
}
System.out.println("Element not found ");
}

public static void binarySearch( int arr[], int n )
{
if( n >= arr.length )
{
	System.out.println("Element not found");
	return;
}

int lo= 0;
int hi= arr.length;
while( lo <= hi )
{
int mid= (lo + hi)/2;
if( arr[mid] == n )
{
System.out.println("Element found at position " + mid);
return;
}
if( arr[mid] > n )
{
hi= mid-1;
}
else
{
lo= mid+1;
}
}
System.out.println("Element not found");
}
public static void main(String[] args) {

int arr[]= new int[10000];
Scanner sc= new Scanner(System.in);
for( int i= 0; i< arr.length; i++ )
{
arr[i]= i;
}
System.out.println("Enter the no : ");
int n= sc.nextInt();
long startTime1= System.nanoTime();
linearSearch(arr, n);
long endTime1= System.nanoTime();
System.out.println("Time taken by Linear Search is : " + (endTime1-startTime1)/1000);
long startTime2= System.nanoTime();
binarySearch(arr, n);
long endTime2= System.nanoTime();
System.out.println("Time taken by Binary Search is : " + (endTime2-startTime2)/1000);
}
}
