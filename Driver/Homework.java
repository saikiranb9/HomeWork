package Driver;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import MovieTheatre.*;
public class HomeWork{

  public static void main(String[] args) throws Exception
  {
    File file = new File(args[0]);       //  Reading input file using it's path
    String output = args[0].replace("input.txt","output.txt");
    Scanner sc = new Scanner(file); 
    FileWriter fwrite = new FileWriter(output,true);                      // Instantiating object to write output to output file 
    MovieTheatre movieTheatre = new MovieTheatre(10,20);                  // MovieTheatre class instantiated 
    while(sc.hasNextLine()){
      String line[] = sc.nextLine().split("\\s+");                   // Reading input file line by line, separating reservation ID and number of seats
      movieTheatre.allocate(line[0], Integer.parseInt(line[1]));     //calling allocate function to allocate seats                    
      fwrite.write(movieTheatre.display(line[0], Integer.parseInt(line[1]))+"\n\n");
    }
  System.out.println(output);                                    // Printing output path
  fwrite.close();
  sc.close();

}
}

