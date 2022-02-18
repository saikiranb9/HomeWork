import java.util.ArrayList;
import java.util.*;
import MovieTheatre.*;
import java.io.*;
import java.util.Scanner;

class Testing{
	MovieTheatre test;

	public void testAllocation(MovieTheatre mt) throws Exception {
		test = mt;
		Noticket();
		Ticketsize();
		NotEnoughTickets();
		Ticketsizemorethanrow();
	}

	public void Noticket() throws Exception{
		
		FileWriter fwrite = new FileWriter("output.txt",true);
		test.allocate("R001", 0);
		fwrite.write(test.display("R001", 0));
		File file = new File("output.txt");
		Scanner sc = new Scanner(file);
		String line = new String();
		while(sc.hasNextLine()){
		line = sc.nextLine();
		String res[] = line.split("[\\s,]+");
		System.out.print(res[1]);
		
		}
		
		sc.close();
		fwrite.close();	
	}
	public void Ticketsize() throws Exception {
		FileWriter fwrite = new FileWriter("output.txt",true);
		test.allocate("R001", 15);
		fwrite.write(test.display("R001", 15));
		File file = new File("output.txt");
		Scanner sc = new Scanner(file); 
		int flag=0;
		String line = new String();
		while(sc.hasNextLine()){
			line= sc.nextLine(); 
		}
		sc.close();
		fwrite.close();
		String res[] = line.split("\\s+");
		System.out.print(line);
           for(int i=1;i<14;i++){
			   if(res[i].equals("E"+i)){continue;}
			   else{
             flag=1;
				   break;
			   }
		   }
		   if(flag==1){
			   System.out.print("Test successful");
		   }
		   else{
			   System.out.print("Test failed");
		   }
		
	}

	public void NotEnoughTickets() throws Exception{
		
		FileWriter fwrite = new FileWriter("output.txt",true);
		test.allocate("R001", 201);
		fwrite.write(test.display("R001", 201));
		File file = new File("output.txt");
		Scanner sc = new Scanner(file); 
		while(sc.hasNextLine()){
			String line[] = sc.nextLine().split("\\s+"); 
           if(line[1].equals("Not Enough available Seats")){
			   System.out.print("Test successful");
		   }
		   else{
			System.out.print("Test failed");
		   }
		}
		sc.close();
		fwrite.close();
	}

	public void Ticketsizemorethanrow() throws Exception {
      
		FileWriter fwrite = new FileWriter("output.txt",true);
		test.allocate("R001", 24);
		fwrite.write(test.display("R001", 24));
		File file = new File("output.txt");
		Scanner sc = new Scanner(file); 
		int flag=0;
		while(sc.hasNextLine()){
			String line[] = sc.nextLine().split("[\\s,]+"); 
           for(int i=1;i<=24;i++){
			   if(line[i].equals("E"+i) || line[i].equals("F"+i)){continue;}
			   else{
             flag=1;
				   break;
			   }
		   }
		   if(flag==1){
			   System.out.print("Test successful");
		   }
		   else{
			   System.out.print("Test failed");
		   }
		}
		sc.close();
		fwrite.close();
	}
	
	
	
	
}