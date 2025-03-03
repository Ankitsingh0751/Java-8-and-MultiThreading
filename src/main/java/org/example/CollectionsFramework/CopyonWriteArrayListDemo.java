package org.example.CollectionsFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyonWriteArrayListDemo {
    public static void main(String[] args) {
        //CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();




        //where the exception comes in arraylist
//        List<String> shoppingList = new ArrayList<>();
//        shoppingList.add("Milk");
//        shoppingList.add("Eggs");
//        shoppingList.add("Bread");
//        System.out.println("Initial shopping list: " +shoppingList);
//
//
//        for(String item: shoppingList){
//            System.out.println(item);
//            //try to modify list while reading
//            if(item.equals("Eggs")){
//                shoppingList.add("Butter");
//                System.out.println("Added butter while reading");
//            }
//            System.out.println("Updates shopping list: " +shoppingList);
//        }


        //to remove the above exception
        List<String> shoppingList = new CopyOnWriteArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial shopping list: " +shoppingList);


        for(String item: shoppingList){
            System.out.println(item);
            //try to modify list while reading
            if(item.equals("Eggs")){
                shoppingList.add("Butter");
                System.out.println("Added butter while reading");
            }

        }
        System.out.println("Updates shopping list: " +shoppingList);







//        //concurrent modification exception
//        List<String> sharedList = new ArrayList<>();
//        sharedList.add("Item1");
//        sharedList.add("Item2");
//        sharedList.add("Item3");
//        Thread readThread = new Thread(() -> {
//            try{
//                while(true){
//                    //iterate through the list
//                    for(String item : sharedList){
//                        System.out.println("Reading item: " +item);
//                        Thread.sleep(100); //small delay to stimulate work
//
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("Exception in reader thread: " +e);
//            }
//        });
//
//
//        Thread writeThread = new Thread(() -> {
//            try{
//                Thread.sleep(500); //Delay to allow reading to start first
//                sharedList.add("Item4");
//                System.out.println("Added item4 to the list.");
//
//                Thread.sleep(500);
//                sharedList.remove("Item1");
//                System.out.println("Removed Item1 from the list");
//
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        readThread.start();
//        writeThread.start();
//
//


        //using copyonwritearraylist to remove the exception
        List<String> sharedList = new CopyOnWriteArrayList<>();
        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");
        Thread readThread = new Thread(() -> {
            try{
                while(true){
                    //iterate through the list
                    for(String item : sharedList){
                        System.out.println("Reading item: " +item);
                        Thread.sleep(100); //small delay to stimulate work

                    }
                }
            } catch (Exception e) {
                System.out.println("Exception in reader thread: " +e);
            }
        });


        Thread writeThread = new Thread(() -> {
            try{
                Thread.sleep(500); //Delay to allow reading to start first
                sharedList.add("Item4");
                System.out.println("Added item4 to the list.");

                Thread.sleep(500);
                sharedList.remove("Item1");
                System.out.println("Removed Item1 from the list");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readThread.start();
        writeThread.start();








    }
}
