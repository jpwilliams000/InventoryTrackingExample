# InventoryTrackingExample

Expanded on 03/03/18 to include basic inheritance and polymorphism for specific types of vending machine items.

Standalone Java SE application that demonstrates foundational data encapsulation.

Project 
Number	 
Project 5
 
Project Name	 
Program Filenames: VendingMachine.java, VendingItem.java, Driver.java, Snack.java, BottledBeverage.java, CannedBeverage.java
 
Project Folder Name	 
Project5_Firstname_Lastname
(example: Project5_Walter_White)
 
The project folder will contain the following files:
•	BottledBevearge.java
•	CannedBeverage.java
•	Snack.java
•	VendingMacnine.java
•	VendingItem.java
•	ProductListNew.txt
•	Project3Report.txt
•	Do not submit the class file(s) automatically created when the Java files compile.
Zip the folder and upload in Blackboard.
 
Do not submit .rar files.
 
Chapter Review	 
Chapters 1-8
 
 
Points	 
50 – See Grading Score Card
 
Assistance	 
Instructors and teaching assistants have been available to assist with all practice work. Students are now expected to complete this project without assistance from others (this includes receiving assistance from individuals inside or outside of CPCC). Students should consider projects as non-proctored exams. Please review the academic integrity policy on your syllabus.
 
Please note: students can continue to receive assistance with practice work up to 5:00 p.m. on the due date (review the late period policy on the syllabus).

In this part of the project, the vending machine company wants you to implement functionality into the vending machines so that Route Service Representatives can stock, restock, and remove items from the vending machines in addition to customers making purchases from the vending machines.
 
The following additions need to be added on to the functionality of each one of the Java classes.
VendingItem class:
•	Create three more classes to be used as subclasses.
•	Add a method called restock() that will be overridden in the following subclasses:
•	Snack class:
	Add a private constant to hold the maximum number of any snack item that can be added to the vending machine. The maximum number of any one type of snack item that can be added is 30. 
	Override the restock method to restock the snack vending item to the maximum quantity (30) if there are less than 30 of the snack in the vending machine. Give an error message if there are 30 of the type of snack in the vending machine.
	Override the toString method from the superclass to add an appropriate item type to the output produced from the super class when called.
•	BottledBevarage class:
	Add a private constant to hold the maximum number of any bottled beverage item that can be added to the vending machine. The maximum number of any one type of bottled beverage item that can be added is 20. 
	Override the restock method to restock the bottled beverage vending item to the maximum quantity (20) if there are less than 20 of the bottled beverage in the vending machine. Give an error message if there are 20 of the type of bottled beverage in the vending machine.
	Override the toString() method from the superclass to add an appropriate item type to the output produced from the super class when called.
•	CannedBeverage class:
	Add a private constant to hold the maximum number of any canned beverage item that can be added to the vending machine. The maximum number of any one type of canned beverage item that can be added is 24. 
	Override the restock method to restock the canned beverage vending item to the maximum quantity (24) if there are less than 24 of the canned beverage in the vending machine. Give an error message if there are 24 of the type of bottled beverage in the vending machine.
	Override the toString() method from the superclass to add an appropriate item type to the output produced from the super class when called.
 
 
VendingMachine class:
You are required to make the following additions:
•	title() method – Modify this method so that it displays the Project Part 5 and the date that you are submitting Project Part 5.
•	Modify the method that you used to load the data from the file so that it ONLY loads the vending items into the vending machine. This method needs to be called automatically once when the program starts executing so that the vending machine is instantly loaded. If the method is called, it needs to clear the contents in the vending machine and then re-load contents from the file. Display appropriate messages.
•	Modify the method that you used to display the menu and get a VALIDATED menu choice to have an additional option from Project 2:
1.	Option 1 will still allow the user to manually enter new items into the vending machine
	When selected, display a menu that allows the user to Restock 1 vending item, restock all vending items, add a new vending item, reload the vending machine using a text file, or return to the main menu.
	Modify the Project 2 method that you used to allow the user to enter a number of vending items so that the method now limits the number of items that can be added to the vending machine. The maximum number of items that can be in the vending machine at one time is 20. Users should not be allowed to enter more than 20 total items in the machine at one time. Validate the input and display appropriate messages.
	Modify the Project 2 method that you used to manually add a vending item to NOT allow an item to be added if there are 20 different vending items in the vending machine already.
	Modify the Project 2 method that you used to get the quantity of the item to be added so that no more than the correct amount of the new subclass of that type of vending item can be added to the machine.
	** Do not allow items to be added to the vending machine if they already exist **
	
2.	Option 2 will now allow for the user to remove an item or items from the vending machine. 
	Display a menu that will allow the user to remove an existing vending item from the vending machine, remove all vending items from the vending machine, or return to the main menu
3.	Option 3 will allow the user to purchase an item from the vending machine
	Create a method that allows the user to purchase an item from the vending machine. If there are no vending items in the machine, display a message that there or no vending items. Otherwise, display the contents of the vending machine along with the costs and the quantities in a menu. If there are no more of an item available in the menu, display the text SOLD OUT instead of zero for the quantity.
	
4.	Option 4 will allow the user to exit the program. This option also must create a file that displays the amount of sales for each item, along with the total items sold from the machine as well as the total sales generated by all of the items purchased from the vending machine.
 
 
 
 
 
 
 
 
 
