import java.util.*;
import java.io.*;

class QueueEmptyException extends Exception 
{	
}

class QueueFullException extends Exception
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

class QueueUsingArray {
	
	private Train data[];
	private int front;
	private int rear;
	private int size;
	
	QueueUsingArray()
	{
		data= new Train[10];
		front= -1;	
		rear= -1;
		size= 0;
	}
	
	QueueUsingArray( int capacity )
	{
		data= new Train[capacity];
		front= -1;
		rear= -1;
		size= 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if( size == 0 )
		{
			return true;
		}
		
		return false;
		
//		return size == 0 ? true : false;
		
	}
	
	public Train Front() throws QueueEmptyException
	{
		if( size == 0 )
		{
			throw new QueueEmptyException();
		}
		
		return data[front];
		
	}
	
	public void Enqueue( Train element ) throws QueueFullException
	{
		if( size == data.length )
		{
			throw new QueueFullException();
		}
		
		if( size == 0 )
		{
			front= 0;
		}
		
		size++;
		
//		rear++;
//		
//		if( rear == data.length )
//		{
//			rear= 0;
//		}
		
		rear= ( rear + 1 ) % data.length;		// Same in Dequeue
		data[rear]= element;		
		
	}
	
	public Train Dequeue() throws QueueEmptyException
	{
		if( size == 0 )
		{
			throw new QueueEmptyException();
		}
		
		Train temp= data[front];
		front++; 
		size--; 
		
		if( front == data.length )
		{
			front= 0;
		}
		
		if( size == 0 )
		{
			front= rear= -1;
		}
		
		return temp;
		
	}

	
}

class lab2 {
	
	public static void main(String[] args) {
		
		QueueUsingArray q = new QueueUsingArray(5);

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
					q.Enqueue(trainObj);
				}
				catch( Exception e )
				{
				}

			}

			sc.close();

		}

		catch( FileNotFoundException e )
		{
			System.out.println("File not present");
			e.toString();
		} 
		
		ArrayList<String> ar= new ArrayList<>();
		String ans[]= new String[5];

		for( int i= 0; i< 5; i++ )
		{
			try
			{
				Train obj= q.Dequeue();
				ans[i]= obj.getName()+ "  " + obj.getStartStation() + "  " + obj.getEndStation() + "  " + obj.getNoOfDays() + "\n";

				if( obj.getNoOfDays().equals("7") )
				{
					ar.add(obj.getName());
					ar.add("\n");
				}

			}
			catch( Exception e )
			{
				
			}

		}


		try
		{	
			FileWriter fw= new FileWriter("trainout.dat");
			
			for( int i= 0; i< ar.size(); i++ )
			{
				fw.write(ar.get(i));		
			}

			for( int i= 0; i< 5; i++ )
			{	
				fw.write(ans[i]);
			}

			fw.close();

			
		}
		catch( Exception e )
		{
			System.out.println(e);
		}


	}


}
