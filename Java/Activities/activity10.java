package Activities;

import java.util.HashSet;

public class activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        // Adding element to HashSet
        hs.add("Pen");
        hs.add("Pencil");
        hs.add("Board");
        hs.add("Chalk");
        hs.add("Pen");
        hs.add("Bell");
        
        //Print HashSet
        System.out.println("Original HashSet: " + hs);        
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hs.size());
        
        //Remove element
        System.out.println("Removing Chalk from HashSet: " + hs.remove("Chalk"));
        //Remove element that is not present
        if(hs.remove("School")) {
        	System.out.println("School removed from the Set");
        } else {
        	System.out.println("School is not present in the Set");
        }
        
        //Search for element
        System.out.println("Checking if Pen is present: " + hs.contains("Pen"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hs);
    }
}