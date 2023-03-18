import java.util.*;
import java.io.*;

public class lab5 {

public static int[] mergeTwoSortedArrays( int arr1[], int arr2[] )
{

int i=0, j=0;
int ans[]= new int[ arr1.length + arr2.length ];
int k=0;	
while( i< arr1.length && j< arr2.length )
{
if( arr1[i] > arr2[j] )
{
ans[k]= arr1[i];
i++;
}
else
{
ans[k]= arr2[j];
j++;
}			
k++;
}	
while( i < arr1.length )
{
ans[k]= arr1[i];
i++;
k++;
}		
while( j < arr2.length )
{
ans[k]= arr2[j];
j++;
k++;
}
return ans;		
}

public static int[] mergeSort( int arr[], int lo, int hi )
{
if( lo == hi )
{
int ba[]= new int[1];
ba[0]= arr[lo];
return ba;
}
int mid= ( lo + hi )/2;
int left[]= mergeSort(arr, lo, mid);
int right[]= mergeSort(arr, mid+1, hi);
int fullAns[]= mergeTwoSortedArrays(left, right);
return fullAns;
}

public static void main(String[] args) {

int arr[]= new int[10000];
for( int i= 0; i< arr.length; i++ )
{
arr[i]= (int) ( Math.random() * 10000);
}
long startTime1= System.nanoTime();
arr= mergeSort(arr, 0, arr.length-1);
long endTime1= System.nanoTime();
System.out.println("Time taken by Merge Sort is : " + (endTime1-startTime1)/1000);

try
{
	FileWriter fw= new FileWriter("mergeout.txt");

	for( int i= 0; i< arr.length; i++ )
	{
		fw.write(arr[i] + "\n" );
	}

	fw.close();

}
catch( Exception e)
{
	System.out.println(e);
}

System.out.println("Sorted in descending order");
System.out.println("First 7 elements");

for( int i= 0; i< 7; i++ )
{
System.out.print(arr[i] + ", ");
}

System.out.println();

System.out.println("Last 7 elements");

for( int i= arr.length-7; i< arr.length; i++ )
{
System.out.print(arr[i] + ", ");
}


}
}
