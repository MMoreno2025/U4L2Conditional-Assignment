//Malia Moreno | 13 November 2024//
package com.mycompany.u4l2conditonalsassignment;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class U4L2ConditonalsAssignment {
    public static void main(String[] args) {
        //create a constant variable MAX_BUDGET and set to $250.00//
        final double MAX_BUDGET = 250.00;
        Scanner scan = new Scanner(System.in);      //set up scanner as "scan"//
        Item priceOfItem = new Item();
        //set variablle to count how much money spent so far//
        double moneySpent = 0;
        
        //set prices of items using Item class//
        
        while(moneySpent <= MAX_BUDGET){
            //ask user to enter variables for items//
            System.out.print("\nPlease enter an item:\t");
            priceOfItem.setName(scan.nextLine());
            
            if((priceOfItem.getPrice()+moneySpent)>MAX_BUDGET){
                System.out.println("\nWow, that's a very expensive "+priceOfItem.getName());
                System.out.println("So expensive that it costs "+priceOfItem.getPrice()+" and you can't afford that");
                
                if((MAX_BUDGET-moneySpent)<29.99){
                    System.out.println("\nActually, it looks like you can't afford anything else in this store");
                    System.out.println("Thank you for you busines, not get out");
                    break;
                }else{
                    System.out.println("Please choose another item");
                }
            }else{
                moneySpent += priceOfItem.getPrice();
                System.out.println(priceOfItem.toString());
                System.out.println("Money Spent:\t"+moneySpent+"\nMoney Remaining:\t"+(MAX_BUDGET-moneySpent));
            }
        }
    }
}


class StorePrices{
    private double shirtPrice = 29.99;
    private double shoePrice = 125.99;
    private double jeanPrice = 60.99;
    private double jacketPrice = 250.00;
    private double hatPrice = 25.99;
    private double shortPrice = 75.99;
    private double blousePrice = 88.99;
    
    //constructor//
    public StorePrices(){}
    
    public double setPrice(String item){
        if(item.equalsIgnoreCase("T Shirt")){
            return shirtPrice;
        }else if(item.equalsIgnoreCase("Shoes")){
            return shoePrice;
        }else if(item.equalsIgnoreCase("Jeans")){
            return jeanPrice;
        }else if(item.equalsIgnoreCase("Jacket")){
            return jacketPrice;
        }else if(item.equalsIgnoreCase("Hat")){
            return hatPrice;
        }else if(item.equalsIgnoreCase("Shorts")){
            return shortPrice;
        }else if(item.equalsIgnoreCase("Blouse")){
            return blousePrice;
        }else{
            return 0;
        }
    }
}


class Item{
    //Item variables - private//
    private String strName;
    private double dblPrice;
    
    //set "Store Prices" Class in this class//
    StorePrices something = new StorePrices();
    
    
    //constructors//
    public Item(){
        strName = null;
        dblPrice = 0;
    }
    public Item(String name){
        strName = name;
        dblPrice = something.setPrice(name);
    }
    public Item(String name, double price){
        strName = name;
        dblPrice = price;
    }
    
    //mutator classes//
    public void setName(String name){
        strName = name;
        dblPrice = something.setPrice(name);
    }
    public void setPrice(double price){
        dblPrice = price;
    }
    
    //accessor classes//
    public String getName(){
        return strName;
    }
    public double getPrice(){
        return dblPrice;
    }
    
    //to string method//
    @Override
    public String toString(){
        return "Item:\t"+strName+
                "\nPrice:\t$"+String.valueOf(dblPrice);
    }

}
