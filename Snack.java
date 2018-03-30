public class Snack extends VendingItem {
   private final static int MAX_CAPACITY = 30;
   private String itemType;
   
   public Snack(String itemName, double itemCost, int itemQuantity){
      super(itemName, itemCost, itemQuantity);
      this.itemType = "Snack";
   }
   
   public static int getMaxCapacity(){
      return MAX_CAPACITY;
   }
   
   @Override
   public void restock(){
      if(getItemQuantity() < MAX_CAPACITY){
         setItemQuantity(MAX_CAPACITY);
         System.out.println(getItemName() + " is now re-stocked to " + MAX_CAPACITY);
      } else {
         System.out.println(getItemName() + " is already fully stocked.");
      }
   }
   
   @Override
   public String toString()
   {
      String remaining = (getItemQuantity() > 0) ? remaining = Integer.toString(getItemQuantity()) : "SOLD OUT"; 
      return String.format(" - Item Type: %-20s" +
                           " - %-30s" +
                           " - Cost $%-15.2f" +
                           " - # Remaining: %-18s" 
                           , itemType, getItemName(), getItemCost(), remaining);
   }
}