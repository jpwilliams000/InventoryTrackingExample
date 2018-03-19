import java.util.*;
import java.io.*;
public class VendingItem
{
   //static fields
   private static int holisticQuantitySold = 0;   
   
   //private fields
   private String itemName;
   private double itemCost;
   private int itemQuantity;
   private int itemQuantitySold;
   
   //constructors
   public VendingItem()
   {
      itemName = "";
      itemCost = 0;
      itemQuantity = 0;
      itemQuantitySold = 0;
   }
   public VendingItem(String itemName, double itemCost, int itemQuantity)
   {
      this.itemName = itemName;
      this.itemCost = itemCost;
      this.itemQuantity = itemQuantity;
      itemQuantitySold = 0;
   }
   //static mutator and accesser
   public static void setHolisticQuantitySold(int s)
   {
      holisticQuantitySold = s;
   }
   public static int getHolisticQuantitySold()
   {
      return holisticQuantitySold;
   }
   //non-static Mutators
   public void setItemName(String itemName)
   {
      this.itemName = itemName;
   }
   
   public void setItemCost(double itemCost)
   {
      this.itemCost = itemCost;
   }
   
   public void setItemQuantity(int itemQuantity)
   {
      this.itemQuantity = itemQuantity;
   }
   public void setItemQuantitySold(int itemQuantitySold)
   {
      this.itemQuantitySold = itemQuantitySold;
   }
   //non-static accessors
   public String getItemName()
   {
      return itemName;
   } 
   
   public double getItemCost()
   {
      return itemCost;
   }
   
   public int getItemQuantity()
   {
      return itemQuantity;
   }
   public int getItemQuantitySold()
   {
      return itemQuantitySold;
   }
   
   //non-static methods
   public void purchased()
   {
      itemQuantity--;
      itemQuantitySold++;
      holisticQuantitySold++;
      System.out.println("\n\tEnjoy your " + itemName +"!\n");  
   }
   public double calcItemRevenue()
   {
      double itemRevenue = itemQuantitySold * itemCost;
      return itemRevenue;
   }
   public String stats()
   {
      return String.format("%-20s" +
                           "%-15d" +
                           "%-8.2f"
                           , itemName, itemQuantitySold, calcItemRevenue());
   }
   
   //overridden tostring with formating
   public String toString()
   {
      String remaining = (itemQuantity > 0) ? remaining = Integer.toString(itemQuantity) : "SOLD OUT"; 
      return String.format(" - %-15s" +
                           " - Cost %-8.2f" +
                           " - # Remaining: %-18s" 
                           , itemName, itemCost, remaining);
   }
}