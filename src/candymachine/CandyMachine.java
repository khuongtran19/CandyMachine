/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candymachine;
import java.util.Scanner;
import java.io.*;
public class CandyMachine{
   static BufferedReader keyboard =
            new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException
    {   
        CashRegister  cashRegister = new CashRegister();      
        Dispenser Twix = new Dispenser(100,95);              
        Dispenser Snickers = new Dispenser(100,100);             
        Dispenser MarathonBar = new Dispenser(75,25);
        int choice;

        showSelection();                   
        choice = Integer.parseInt(keyboard.readLine());   

        while(choice != 9)     
        {
            switch(choice)
             {
             case 1: sellProduct(Twix, cashRegister);
                     break;
             case 2: sellProduct(Snickers, cashRegister);
                     break;
             case 3: sellProduct(MarathonBar, cashRegister);
                     break;
             default: System.out.println("Invalid Selection");
             }
        showSelection();  
        choice=Integer.parseInt(keyboard.readLine());
        }
    }
    public static void showSelection()
    {
          System.out.print("Credit:");
          Scanner c= new Scanner(System.in);
          double credit = c.nextInt();
          System.out.println("1 Twix: 95 cents");
          System.out.println("2 Snickers: 1.00");
          System.out.println("3 Marathon Bar: 25cents");
          System.out.println("4 Change Return");
          System.out.print("Section:");
          Scanner s= new Scanner(System.in);
          int section= s.nextInt();
    }

    public static void sellProduct(Dispenser product,
                                       CashRegister cRegister
                                          )throws IOException{
        int price;        
        int coinsInserted;  
        int coinsRequired;
        if(product.getCount() > 0){
            price = product.getProductCost();
            coinsRequired = price;
            coinsInserted = 0;

            while(coinsRequired > 0)
            {
                System.out.println("Please insert more money for this item.");
                coinsInserted = coinsInserted+Integer.parseInt(keyboard.readLine());
                coinsRequired = price-coinsInserted;
            }

            cRegister.acceptAmount(coinsInserted);
            product.makeSale(); 

            System.out.println("Enojoy!!!");
        }
        else
            System.out.println("Sorry this item is sold out.");
    }
}

