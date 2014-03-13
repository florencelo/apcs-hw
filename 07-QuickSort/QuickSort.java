import java.util.*;

public class QuickSort{

    static Random r = new Random();

    public static ArrayList<Integer> QuickSort(ArrayList<Integer> list) {
        if (list.size() <= 1) return list;
        int rotplace = r.nextInt(list.size());
        int rotation = list.get(rotplace);
        list.remove(rotplace);
        ArrayList<Integer> low = new ArrayList<Integer>();
        ArrayList<Integer> high = new ArrayList<Integer>();
        for (int num : list) {
            if (num <= rotation)
                low.add(num);
            else
                high.add(num);
        }
        QuickSort(low);
        QuickSort(high);

        list.clear();
        list.addAll(low);
        list.add(rotation);
        list.addAll(high);
        return list;
    }
    

    public static void main(String[] args) {
        int listsize = 10, range = 10;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<listsize; i++)
            list.add(r.nextInt(range));
        QuickSort(list);
        System.out.println(list);
    }
}
