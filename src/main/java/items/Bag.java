package items;


import java.util.ArrayList;
import java.util.Scanner;

public class Bag {
    private ArrayList<Item> items;
    private boolean full;
    private ArrayList<Item> bag;

    public Bag(ArrayList<Item> items, boolean full, ArrayList<Item> bag) {
        this.items = items;
        this.full = false;
        this.bag = bag;
    }

    public void addItem(Item i1){
       if (bag.size() == 12){
            full = true;
            System.out.println(" Your bag is full, please remove at least one item to pick this element.");
        }else {
           bag.add(i1);
       }

    }
    public void removeItem(Item i){
            bag.remove(i);
        }
    public void remove() {
        System.out.println("Which item do you want to delete?");
        for (Item items : bag) {
            System.out.println(bag);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter item: " );
        }

    }
}
