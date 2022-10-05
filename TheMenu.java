/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class handles the graphical user interafce    *
*          for users and is where all the invoking of classes *
*          is done                                            *
* Date Created: March 15, 2018                                *
* Date Modified: May 29, 2018                                 *
***************************************************************/
import java.util.*;
import java.util.Calendar;

public class TheMenu{

public static void main (String [] args)
{

  Scanner sc = new Scanner (System.in); 

  int theInput;
  String fileName; 
  int freezerNum, fridgeNum, pantryNum; 


    System.out.println("Please input the name of the file to initialise the values of the storage (pantry,fridge,freezer) or press enter to skip"); 
    fileName = sc.nextLine(); 

    fridgeNum = FileIO.getNum(fileName,"Fridge"); //getting the line numbers to initialise and create storage array 
    freezerNum = FileIO.getNum(fileName,"Freezer"); //getting the line numbers to initialise and create storage array 
    pantryNum = FileIO.getNum(fileName, "Pantry"); //getting the line numbers to initialise and create storage array 

    StorageClass storage = new StorageClass(fridgeNum,freezerNum,pantryNum);   //creating storage class to store items 
  
 
  do {
       try{
              //menu for users as part of GUI 
              System.out.println("===================");      
              System.out.println("     MAIN MENU    ");
              System.out.println("==================="); 
              System.out.println("Please select: ");
              System.out.println("1. Add a Food") ; 
              System.out.println("2. Display Contents");
              System.out.println("3. Find Expired"); 
              System.out.println("4. Read in Storage"); 
              System.out.println("5. Write out Storage");
              System.out.println("6. Remove Food"); 
              System.out.println("7. Exit");
              System.out.println("===================");            

              theInput = sc.nextInt(); 
          }
                
     
       catch (InputMismatchException e)  
            {

               String flush = sc.nextLine();
               System.out.println( "Error you cannot enter letters." );
               System.out.println ("Please try again!");
                    
               theInput = sc.nextInt();
            }

        switch (theInput) //switch that directs users to appropriate submodule from which ever input they choose 
        {
          case 1:
          addFood(storage); 
          break;

          case 2: 
          displayContents(storage);
          break;

          case 3:
          findExpired(storage);
          break;

          case 4:
          fileReader(storage);
          break;

          case 5:
          writeOut(storage); 
          break; 

          case 6:
          removeFood(storage);
          break;

          case  7:
          System.out.println ("Program will now exit");
          break;
        }
        
      } while ((theInput>7)||(theInput!=7)); //keeps looping until 7 is pressed to exit program 


}

/***********************************************************
* SUBMODULE: addFood                                       *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: Is the submodule that invokes all the         *
*            class   related to adding food                *
************************************************************/ 
public static void addFood(StorageClass storage)
{
  int userInput; 
  Scanner sc = new Scanner(System.in); 
  do
    {
        try 
        {
                System.out.println("                                            ");
                System.out.println("What type of food would you like to add?"); 
                System.out.println("                                      ");
                System.out.println("Select an option from the numbers below");
                System.out.println("=======================================");
                System.out.println("1. Meat"); 
                System.out.println("2. Grain"); 
                System.out.println("3. Fruit"); 
                System.out.println("4. Vegetables"); 
                System.out.println("5. Go back to the main menu");
                System.out.println("=======================================");

                userInput = sc.nextInt(); 
         } 

       catch (InputMismatchException e)
        {

               String flush = sc.nextLine();
               System.out.println( "Error you cannot enter letters." );
               System.out.println ("Please try again!");
                  
               userInput = sc.nextInt();
         }
      
               
      switch (userInput)
            {
              case 1:
              UserInput.meat(storage); //going to user input class to create the objects
              break;

              case 2:              
              UserInput.grain(storage);   //going to user input class to create the objects
              break;

              case 3:
              UserInput.fruit(storage); //going to user input class to create the objects
              break;

              case 4:
              UserInput.veg(storage); //going to user input class to create the objects
              break;     
              
              case 5: 
              System.out.println("Taking you back to the main!!"); //goes back to main menu 
              break; 
          }
        
    } while(userInput!=5); //keeps looping until user presses 5 
}   

/***********************************************************
* SUBMODULE: fileReader                                    *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION:deals with file I/O methods and class          *
************************************************************/ 
public static void fileReader(StorageClass storage)
{
  Scanner sc = new Scanner(System.in); 

  int lineNum;
  String fileName;  

  System.out.println("Please input the name of the file you are reading in from ");

  fileName = sc.nextLine();


  lineNum = FileIO.checkLine(fileName); //goes to file IO clas to get line number in file 

  FoodClass [] foodArray = new FoodClass [(lineNum)]; //creates array with line number 
  foodArray = FileIO.readFile (fileName, foodArray);  //reads file again and populates array 

  for(int i=0;i<foodArray.length;i++)  
  {
    storage.addFood(foodArray[i]);   //goes to storage class to add the food items that have been read in 
  }
   
}

/***********************************************************
* SUBMODULE: findExpired                                   *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION:deals with  the expired methods by invoking    *
* them from different classes                              *
************************************************************/ 
public static void findExpired (StorageClass storage) 
 {
   FoodClass [][] storageArray = storage.getArray(); 
 try{
      for (int i=0; i< storageArray[0].length; i++) //goes through array of row 0 to get the date and find expiry date 
      { 
        GregorianCalendar date; 
        date = storageArray[0][i].getDate();
      
        if(storageArray[0][i].calcExpiry(date) == true); 
        {
          UserInput.outputPantry(storage, i);  
        }

      }
    }
catch(NullPointerException e)
{
  System.out.println("There are no expired elements in the Pantry, hence NULL"); 
}

try {
  for (int i=0; i< storageArray[1].length; i++)
  { 
    GregorianCalendar thedate; 
    thedate = storageArray[1][i].getDate();
  
    if(storageArray[1][i].calcExpiry(thedate) == true); 
    {
      UserInput.outputFreezer(storage,i);
    }

  }
}
catch(NullPointerException e)
{
  System.out.println("There are no expired elements in the Freezer, hence NULL"); 
}

try {
  for (int i=0; i< storageArray[2].length; i++)
  { 
    GregorianCalendar indate; 
    indate = storageArray[2][i].getDate();
  
    if(storageArray[2][i].calcExpiry(indate) == true);
    {
      UserInput.outputFridge(storage, i);
    }

  }
}
catch(NullPointerException e)
{
  System.out.println("There are no expired elements, hence NULL"); 
}

 }

/***********************************************************
* SUBMODULE: displayContents                               *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: deals with the class user input that handle   *
*           displaying the contents of the storage         *
************************************************************/ 

public static void displayContents(StorageClass storage)
{
   int selection = InputValidation.storageSelection();

   UserInput.display(storage, selection);
        
}
/***********************************************************
* SUBMODULE: removeFood                                    *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: deals with deals with removing food by        *
*           invoking methods in other classes              *
************************************************************/ 
public static void removeFood(StorageClass storage)
{
  System.out.println("Welcome to the remove food section!");

  UserInput.removal(storage);
}

/***********************************************************
* SUBMODULE: writeOut                                      *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: deals with deals with writing out food by     *
*          invoking methods in File IO class               *
************************************************************/ 
public static void writeOut(StorageClass storage)
{
   
   Scanner sc = new Scanner(System.in);
   String fileName; 

   System.out.println("Please input the name of the file you want to write to"); 
   fileName = sc.nextLine(); 

   FileIO.writeToFile(storage, fileName);
}

}


 
    
