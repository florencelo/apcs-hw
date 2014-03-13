import java.util.*;
import java.io.*;

public class StringMerge{
    
    
    public ArrayList<String> MStringSort(ArrayList<String> L){
        if (L.size()<=1){
            return L;
        }
        ArrayList<String> a = new ArrayList<String>(L.size()/2);
        
        int i;
        for (i = 0;i<L.size()/2;i++){
            a.add(i,L.get(i));
        }
	ArrayList<String> b =  new ArrayList<String>(L.size() - L.size()/2);
        for ( ;i<L.size();i++){
            b.add(i-a.size(),L.get(i));
	}

        a = new ArrayList<String>(MStringSort(a));
	b = new ArrayList<String>(MStringSort(b));
        L = new ArrayList<String>(merge(a,b));
        return L;
    }
    public ArrayList<String> merge(ArrayList<String>c,ArrayList<String>d){
        int size = 0;
        int size1 = 0;

        ArrayList<String> sorted = new ArrayList<String>(c.size() +d.size());
        for (int z =0;z < c.size()+d.size();z++){
            if (size == c.size()){
                
		sorted.add(z,d.get(size1));
                size1++;
            }
            else if (size1 == d.size() ){
                
		sorted.add(z,c.get(size));
                size++;
            }
            
	    else if(c.get(size).compareTo(d.get(size1)) <= 0){
                sorted.add(z,c.get(size));
		size++;
            }
            else{
                sorted.add(z,d.get(size1));
                size1++;
            }
        }
        return sorted;
    }

    /*
    public int compareTo(StringMerge other){
	int compared = 1;
	if(this.){
	}
    }
    */
     
    public static void main(String[] args){
	StringMerge sortp = new StringMerge();
	ArrayList<String> test = new ArrayList<String>(2);
	test.add(0,"Optimus Prime");
	test.add(1,"Wheeljack");
	test.add("Bumblebee");
	test.add("Cliffjumper");
	test.add("Ratchet");
	test.add("Wheelie");
	test = new ArrayList<String>(sortp.MStringSort(test));
	System.out.println(test);
    }
}
