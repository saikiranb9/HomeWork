package MovieTheatre;
import java.util.*;
public class MovieTheatre{

    public static LinkedHashMap<Integer,Integer> h = new LinkedHashMap<Integer,Integer>();  // Using LinkedHashMap to store rows and empty seats
    public List<String> l = new ArrayList<String>();     
    public static int rows=0,cols=0;
    public static int total=0;
    
    public MovieTheatre(int rows, int cols){
        MovieTheatre.rows=rows;
        MovieTheatre.cols=cols;
        total = rows*cols;
    int mid  = rows/2;
    if(rows%2!=0){                                  // Here we are inserting row numbers into
        mid++;                                      //  hashmap based on priority order to getmax customer satisfaction
    }                                               // (middle row has bets viewing angle and audio reception than end rows)
    h.put(mid,cols);
    for(int i=1;i<rows;i++){
        if(i%2!=0){
         mid=mid+i;
         h.put(mid,cols);
        }
        else{
            mid=mid-i;
            h.put(mid, cols);
        }
    }
    }
    
    public void allocate(String reservation, int size){          // This function takes size(number of seats required) and allocate
        l.clear();                                               // seats based on empty seats in rows
        int flag = 0;
        HashSet<Integer> hs = new HashSet<Integer>();     
       if(validate(total, size)){                            
        if(size>=cols){     
          Set<Integer> keys = h.keySet();             // If size is larger than cols(20), then this logic greedily assignes                      
           for(Integer i: keys){                      // completely empty rows with 20 seats available         
               if(size<cols){
                   break;
               }
               if(h.get(i)==cols){
               char c = (char)('A' + i-1);
                appendTickets(c, cols-h.get(i)+1, cols);
                flag=1;
                hs.add(i);
                size = size - cols;
                total-=cols;
               }
           }
            
         for(Integer i : hs){                  // Removing the rows assigned in above logic from hashmap because they are filled
             h.remove(i);
         }
        }
    if(size!=0){                              // If remaining size is still not zero, then we allocate seats for it by traversing
       hs.clear();                            // hashmap and finding best possible row that can be allocated for this remaining size
        int key=0,m=0,n=0;
        int sum = size;
        Set<Integer> keys = h.keySet();



        for(Integer i: keys){
        if(h.get(i)>=size){
            if(h.get(i)>size){
                if(flag!=1){
                h.put(n, m);
                l.clear();
                }
                char c = (char)('A' + i-1);
                appendTickets(c, cols-h.get(i)+1, size);
                h.put(i,h.get(i)-size);
                hs.clear();
            }
            else{
                if(flag!=1){
                h.put(n, m);
                l.clear();
                }
            key = i; 
             char c = (char)('A' + i-1);
             appendTickets(c, cols-h.get(i)+1, size);
            }
        break;
        }

        else if(sum>0){
         int a = sum;
         sum -= h.get(i);
         if(sum<0){
             m=h.get(i);
             char c = (char)('A' + i-1);
             appendTickets(c, cols-h.get(i)+1, a);
              h.put(i,Math.abs(sum));
              n=i;
             
              }
         else{
         hs.add(i);
             }
        }
        else{
        }

        }




        if(key!=0){
            h.remove(key);
        }
     
        for(Integer i : hs){                                       
        char c = (char)('A' + i-1);
        appendTickets(c, cols-h.get(i)+1, h.get(i));
        h.remove(i);
        }

      }
    else{

    }
       total = total - size;

    }
        else{
        }

    }
    
    
    
    
    public void appendTickets(char c, int b, int limit){       // Appends the allocated seats to a list
      for(int j = b;j<b+limit;j++){
                String s = new String();
                s = s + c + String.valueOf(j);
                l.add(s);
            }
    }
    
    
    public String display(String reservation,int size){               // return the tickets as string to output
        String res = new String();
        res=res+reservation+" ";
        if(l.size()==0 && size!=0){
            res = res + "Not Enough available Seats";
        }
        else if(l.size()==0 && size==0){                   //if input size is 0, then returns only reservation number
        res = res + "---";
        }
        else{
       for(String s : l){
           if(res.charAt(res.length()-1) == ' '){
               res = res + s;
           }
           else{
        res = res+','+s;
           }
       }
    }
       return res;
    }
    
    public boolean validate(int total, int size){        //checks if theatre has enough empty seats to allocate
    
    if(size>total){
        return false;
    }
    else{
       return true;
    }
    }
    }
    