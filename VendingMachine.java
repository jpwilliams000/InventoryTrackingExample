import java.util.*;
import java.io.*; // Input / Output Package
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author      James Pata <jpata000#email.cpcc.edu>
 * @version     1.0  
 * 
 */

public class VendingMachine
{
   //private global fields
   private static Scanner keyboard = new Scanner(System.in);
   private static ArrayList<VendingItem> items = new ArrayList<>();
   private static final int MAX_ITEMS = 20;
   
   /**
   *
   *
   * MAIN METHOD: Controller Logic to Vending Machine. 
   *
   *
   */
   public static void main(String[] args)
   {
      printTitle();
      loadItemsFromFile();
      // 1st menu controller
      boolean goAgain = true; 
      do{ //prompt at least once
         switch(promptHomeMenuChoice()) {//Returned user choice is the argument of the switch 
            case 1: inputItemsController();
                    break;
            case 2: removeItemsMenu();
                    break;
            case 3: purchaseMenu();
                    break;
            case 4: goAgain = endProgram(); 
                    break;
         }
      } while(goAgain); //when true
   }
   
   // remove items menu print screen
   public static int promptRemoveItemsMenu()
   {
      String userInput;
      do{
         System.out.print("\nSelect from one of the following Choices:" +
                            "\n\t 1 - Remove an Existing Vending item from the Vending Machine" +
                            "\n\t 2 - Remove all Existing Vending Items from the Vending Machine" +
                            "\n\t 3 - Return to Main Menu" +
                            "\n\t Enter your choice (1-3): " );
        userInput = keyboard.nextLine();
      }while(!userInput.matches("[1-3]"));//Only number range from 1 to 3
      return Integer.parseInt(userInput);
   }
   
   // remove items menu controller
   public static void removeItemsMenu()
   {
      boolean goAgain = true;
      do{
         switch(promptRemoveItemsMenu()){
            case 1: removeItem();
                    goAgain = false;
                    break;
            case 2: emptyVendingMachine();
                    goAgain = false; 
                    break;
            case 3: goAgain = false; //return to main 'home' menu
                    break;
         }
      }while(goAgain);
   }
   
   //remove items menu option 1
   public static void removeItem()
   {
      printMachineContents();
      processRemoveItem(promptItemChoice());
   }
   
   public static void processRemoveItem(int choice)
   {
      int index = (choice - 1); 
      items.remove(index);
      System.out.println("\n" + items.get(index).getItemName() + " has been removed from the vending machine.");
   }
   
   // remove items menu option 2
   public static void emptyVendingMachine()
   {
      items = new ArrayList<>(); //re-instantiate arraylist, let garbage collector trash old list.
   }
   
   
   // input items menu print screen
   public static int promptInputItemMenuChoice()
   {
      String userInput;
      do{
         System.out.print("\nSelect from one of the following Choices:" +
                            "\n\t 1 - Re-Stock an Existing Vending Item" +
                            "\n\t 2 - Re-Stock all Exisitng Vending Items" +
                            "\n\t 3 - Add a new vending item to the machine" +
                            "\n\t 4 - Load vending items from a file" +
                            "\n\t 5 - Return to the Main Menu" +
                            "\n\t Enter your choice (1-5): " );
        userInput = keyboard.nextLine();
      }while(!userInput.matches("[1-5]"));//Only number range from 1 to 5
      return Integer.parseInt(userInput);
   }
   
   // input items menu controller
   public static void inputItemsController()
   {
      boolean goAgain = true;
      do{
         switch(promptInputItemMenuChoice()){
            case 1: restockItem();
                    goAgain = false;
                    break;
            case 2: reStockEntireVendingMachine();
                    goAgain = false; 
                    break;
            case 3: inputItemsManually();
                    goAgain = false;
                    break;
            case 4: loadItemsFromFile();
                    goAgain = false;
            case 5: goAgain = false; //return to home menu
                    break;
         }
      }while(goAgain);
   }
   
   // input items menu option 1
   public static void restockItem()
   {
      printMachineContents();
      processRestockItem(promptItemChoice());
   }
   
   public static void processRestockItem(int choice)
   {
      int index = (choice - 1); 
      items.get(index).restock();
   }
   
   public static int promptItemChoice()
   {
      int upperBound = items.size();
      String choice;
      do{
         System.out.print("Enter your choice: (1-"+upperBound+"): ");
         choice = keyboard.nextLine();
      }while(!choice.matches("^[1-9]\\d*\\.?[0]*$") //whole numbers only
            || Integer.parseInt(choice) > upperBound ); //nothing greater than number of items
     
     return Integer.parseInt(choice);
   }

   
   // input items menu option 2
   public static void reStockEntireVendingMachine()
   {
      for(VendingItem i : items) i.restock();
   }
      
   /**
   *
   *
   *  printTitle() will print the application information to the console.
   *
   *
   */
   private static void printTitle()
   {  
      System.out.println("*****************************");
      System.out.println("*VENDING MACHINE PROJECT 5  *");
      System.out.println("* \tAuthor: Mr. Just James   *");
      System.out.println("* \tProject 2 Date 02/19/18  *");
      System.out.println("* \tProject 5 Date 03/30/18  *");
      System.out.println("*****************************");
   }
      
   /**
   * 
   *
   * Main Menu - Promt User For Event
   *
   * The return is used as the argument in the 
   * main method's switch statement to determine controller logic.
   * 
   * @return userInput int The user's input.
   *
   *
   */
   public static int promptHomeMenuChoice()
   {
      String userInput;
      do{
         System.out.print("\nChoose from one of the following Menu Choices:" +
                            "\n\t 1 - Manually Enter Item(s) into the Vending Machine" +
                            "\n\t 2 - Manually Remove Item(s) from the Vending Machine" +
                            "\n\t 3 - Purchase something from the Vending Machine" +
                            "\n\t 4 - Exit the program" +
                            "\n\t Enter your choice (1,2, or 3): " );
        userInput = keyboard.nextLine();
      }while(!userInput.matches("[1-4]"));//Only number range from 1 to 4
      return Integer.parseInt(userInput);
   }
   
  /**
  * 
  * 
  * Choice # 1 - Input items into the Vending Machine Manually.
  *
  * 
  */
   public static void inputItemsManually()
   {  
      if(isSpace()){
         promptItemsManually();
      } else System.out.println("\nThe Vending Machine is Full");  
   }
  /**
  *
  *
  * Choice # 1's - checks if there is space in the vending machine
  *
  * @return boolean: True if there is space in the machine, false if there is no space.
  *
  *
  */
   public static boolean isSpace()
   {
      boolean space;
      space = (items.size() < MAX_ITEMS) ? true : false;
      return space;
   }
  /**
  *
  *
  * Choice # 1's - Prompt user for information about items to be input manually.
  *                **Only runs if isSpace is true.
  *
  *
  */
   public static void promptItemsManually()
   {
      int repeatCounter = 0, numberOfItems = promptNumberOfItemsToBeAdded();
         
         while (repeatCounter < numberOfItems) //Keep requesting product info until number to be added is met
         {   
            int itemTypeValue = promptItemType();
            String itemName = promptItemName();
            double itemCost = promptItemCost(itemName);
            int itemQuantity = promptItemQuantity(itemName, itemTypeValue);
            //TODO DRY from file reading method (can be enhanced)such as 'items.add(insertNewItem())'
            VendingItem itemInfo = new VendingItem();
            if(itemTypeValue == 1) itemInfo = new Snack(itemName, itemCost, itemQuantity);
            if(itemTypeValue == 2) itemInfo = new CannedBeverage(itemName, itemCost, itemQuantity);
            if(itemTypeValue == 3) itemInfo = new BottledBeverage(itemName, itemCost, itemQuantity);
            items.add(itemInfo);
            repeatCounter++;   
         }
         System.out.println("\nVending Machine Successfully Loaded.");
   }
   
  /**
  *
  *
  * Choice # 1's - Prompt user for number of items to be added.
  *
  *
  */
   public static int promptNumberOfItemsToBeAdded()
   {
      String numberOfItems;
      int upperBound = (MAX_ITEMS-items.size());
      do {
            System.out.print("Enter the number of vending machine items to be added "+ 
                             "to the machine: (Min: 1 - Max: " + upperBound + "): ");
            numberOfItems = keyboard.nextLine();
      } while(!numberOfItems.matches("^[1-9]\\d*\\.?[0]*$") //Natural Numbers
              || Integer.parseInt(numberOfItems) > upperBound); //while greater than upperbound is true
      return Integer.parseInt(numberOfItems);
   }
   
  /**
  *
  *
  * Choice # 1's - Prompt user for item name.
  *
  *
  */
   public static String promptItemName()
   {
      String itemName;
      do {
         System.out.print("Enter the name of the item to be added: ");
         itemName = keyboard.nextLine();
      } while(!itemName.matches("[a-zA-Z_ -]*") || itemName.equals("") || !isUnique(itemName));//characters, spaces, underscores and dashes   
      return itemName;
   }
  /**
  *
  *
  * Choice # 1's - Checks if the Item already exist in the vending machine.
  *                Prints an appropriate error message, if unique is false
  *
  * @return boolean unique: True if the item is unique, false if the item is already in the machine.
  *
  *
  */
   public static boolean isUnique(String addedName)
   {
      boolean unique = true;
      for(VendingItem i : items){
         if(i.getItemName().equalsIgnoreCase(addedName)) unique = false;
      }
      if (!unique) System.out.println("\tYou already have " + addedName + " in the vending machine. Add something new.");
      return unique;
   }
   
   /**
  * 
  * 
  * Choice # 1's - Prompt user for item encoded key value's type.
  *
  * 
  */
   public static int promptItemType()
   {
      String itemType;
      do{
         System.out.print("Choose from one of the following types of vending items to be added to the machine: "
                          + "\n\t 1 - Snack \n\t 2 - Canned Beverage \n\t 3 - Bottled Beverage"
                          + "\n\t Enter your choice (1, 2, or 3):");
         itemType = keyboard.nextLine();
      } while (!itemType.matches("[1-3]")); //numbers 1-3 only 
      return Integer.parseInt(itemType);
   }
   
  
  /**
  * 
  * 
  * Choice # 1's - Prompt user for item cost.
  *
  * 
  */
   public static double promptItemCost(String itemName)
   {
      String itemCost;
      do{
         System.out.print("Enter the cost of " + itemName + " (item must be between $0.50 and $0.85): ");
            itemCost = keyboard.nextLine();
      } while (!itemCost.matches("^\\d{0,2}(\\.\\d{1,2})?$") //Number form allowed: 'xy.za' where 'x''y' and 'a' are optional
               || itemCost.equals("")                        //no empty strings
               || Double.parseDouble(itemCost) < 0.50        //lower range
               || Double.parseDouble(itemCost) > 0.85        //upper range
               );      
      return Double.parseDouble(itemCost);
   }
   
  /**
  * 
  * 
  * Choice # 1's - Prompt user for quantity of said item.
  *
  * 
  */
   public static int promptItemQuantity(String itemName, int itemType)
   {
      String itemQuantity;
      int maxInputQuantity = determineMaxInputQuantity(itemType);
      do{
         System.out.print("Enter the quantity of " + itemName + " being loaded into the machine: (Max: " + maxInputQuantity + ") ");
         itemQuantity = keyboard.nextLine();
      } while (!itemQuantity.matches("^[1-9]\\d*\\.?[0]*$") || Integer.parseInt(itemQuantity) > maxInputQuantity);//Natural Numbers
      return Integer.parseInt(itemQuantity);
   }
   
   public static int determineMaxInputQuantity(int itemType)
   {
      int determineMaxInputQuantity = 0;
      if(itemType == 1) determineMaxInputQuantity = Snack.getMaxCapacity();
      if(itemType == 2) determineMaxInputQuantity = CannedBeverage.getMaxCapacity();
      if(itemType == 3) determineMaxInputQuantity = BottledBeverage.getMaxCapacity();
      return determineMaxInputQuantity;
   }
   
  /**
  * 
  * 
  * Choice # 2  - Purchase Menu
  * 
  *
  * purchaseMenu() is the controller method for the purchase screen 
  *
  */
  public static void purchaseMenu()
   {
      boolean goAgain;
      do{
         printMachineContents();
         processPayment(promptPurchaseChoice());
         goAgain = promptPurchaseGoAgain();
      }while(goAgain);
   }
   /**
   *
   * Choice # 2's - Print Machine Contents
   *
   *
   */
   public static void printMachineContents()
   {
      if(items.size() > 0){ 
         System.out.println("\nThis vending machine contains the following items: ");
         for(VendingItem i : items) System.out.printf("\t %-2d" + i +"%n", items.indexOf(i)+1 );
      } else System.out.println("\nThe vending machine is empty");
   }
   /**
   *
   * Choice # 2's - Prompt User for Purchase Choice
   *
   * @return int choice: The user's product selection, as arrayList index+1
   *
   */
   public static int promptPurchaseChoice()
   {
      int upperBound = items.size();
      String choice;
      do{
         System.out.print("Enter your choice: (1-"+upperBound+"): ");
         choice = keyboard.nextLine();
      }while(!choice.matches("^[1-9]\\d*\\.?[0]*$") //whole numbers only
            || Integer.parseInt(choice) > upperBound
            || items.get(Integer.parseInt(choice)-1).getItemQuantity() < 1); //no items sold out
      return Integer.parseInt(choice);
   }
   /**
   *
   * Choice # 2's - Process Payment based on userChoice
   *
   * @param int choice - the users input of product choice
   *
   */
   public static void processPayment(int choice)
   {
      int index = (choice - 1); 
      items.get(index).purchased();
   }
   /**
   *
   * Choice # 2's - Process Payment based on userChoice
   *
   * @return boolean goAgain - True if user wants to purchase more items, false if user is done purchasing
   *
   */ 
  public static boolean promptPurchaseGoAgain()
  {
      boolean goAgain;
      System.out.print("Would you like to purchase another Item?" +
                          "(Enter Y or Yes to purchase again, or anything else" +
                          "to return to the main menu): ");
      String input = keyboard.nextLine();
      goAgain = (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES")) ? true : false;
      return goAgain;
  }
 
  /**
  * 
  * 
  * Choice # 3 - End The Programn
  *
  * @return false boolean - False to end main menu controller logic, switch.
  *
  */
  public static boolean endProgram()
  {
      System.out.print("\nThank you for using this program!");
      printDataToReport();
      return false;
  }
  /**
  * 
  * 
  * Choice # 3's - Print Data to Report Log .txt file
  *
  * 
  *
  */
   public static void printDataToReport()
   {
      try(
          FileWriter fw = new FileWriter("Project2Report.txt", false); 
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter out = new PrintWriter(bw))
          {
            out.println("Vending Item   Number Sold   Total Sales Generated");
            for(VendingItem i : items) out.println(i.stats());
            out.println("-----------------------------------------------------");
            out.printf("\tTotal Vending items sold: %23d", VendingItem.getHolisticQuantitySold());
            double totalRevenue = 0;
            for(VendingItem i : items) totalRevenue += i.calcItemRevenue();
            out.printf("%n\tTotal Sales Generated by all Vending Items: $%4.2f", totalRevenue);
            out.println("\n-----------------------------------------------------");
      }catch(IOException e){ 
          System.out.println(e.getMessage());
        }
    }
    
   /**
   *
   *
   * loadItemsFromFile() - Load Items From Text File. Called immediately in main nmethod.
   *
   *  This method will load the vending machine using the contents from the text file.
   *
   *
   */
   public static void loadItemsFromFile()
   {
      //If vending machine has items, create new empty array and assign it to global field
      //Let the java garbage collector trash the old list.
      if(items.size()>0) items = new ArrayList<>(); 
      
      try {
         File file = new File("ProductListNew.txt");
         Scanner input = new Scanner(file);
         while (input.hasNext()) 
         {
            //initallize and declare variables from file
            String itemName = input.nextLine();
            String itemCostString = input.nextLine();
               Double itemCost = Double.parseDouble(itemCostString);
            String itemQuantityString = input.nextLine();
               int itemQuantity = Integer.parseInt(itemQuantityString);
            String itemTypeString = input.nextLine();
               int itemType = Integer.parseInt(itemTypeString);   
            //If blank line, then consume it               
            if(input.hasNext())input.nextLine();
            //**TODO DRY similar code in manual inserting method***
            VendingItem itemInfo = new VendingItem();
            if(itemType == 1) itemInfo = new Snack(itemName, itemCost, itemQuantity);
            if(itemType == 2) itemInfo = new CannedBeverage(itemName, itemCost, itemQuantity);
            if(itemType == 3) itemInfo = new BottledBeverage(itemName, itemCost, itemQuantity);
            //add VendingItem to global arraylist
            items.add(itemInfo);
         }
         input.close();
         //log success message
         System.out.print("\nNow Loading the Vending Machine...");
         System.out.println("\nVending Machine Successfully Loaded.");
         
      } catch(Exception ex) 
          { //if there was an error, log it
            System.out.println("There was an error: "  + ex.toString()); 
          }  
   }
  
}
