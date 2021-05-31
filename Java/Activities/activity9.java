package Activities;


import java.util.ArrayList;

public class activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Blue");
        myList.add("Green");
        myList.add("Yellow");
        //Adding object at specific index
        myList.add(3, "Black");
        myList.add(1, "White");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Violet is in list: " + myList.contains("Violet"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("Grey");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}