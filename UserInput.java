/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class handles the user inputs, removal and    *
*          expiration of the food                             *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 10, 2018                                *
* Date Modified: May 28, 2018                                 *
***************************************************************/
import java.text.SimpleDateFormat;
import java.util.*; 
import java.util.Calendar;

public class UserInput{

/***********************************************************
* SUBMODULE: meat                                          *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: This submodule calls the input validation     *
*            class and sends the inputs for validation     *
*            before constructing the object                *
************************************************************/ 

public static void meat (StorageClass storage)
{
     //gets user inputs and passes them to InputValidation class to handle all the exception and validation 

     String theName = InputValidation.stringInput("what is the name of your meat", "your name cannot be null!");  
            
     String theCut = InputValidation.stringInput("What is the cut of your meat","your cut cannot be null"); 
        
     double theWeight = InputValidation.doubleInput("Please input the weight of the meat (e.g 3.5) ");

     double theStorageTemp = InputValidation.doubleInput("Please input the storage temperature of the meat you would like to store");

     GregorianCalendar theDate = InputValidation.dateInput("Please input the useby date of the meat");  
         
     String thePackaging = InputValidation.stringInput("Please input the type of packaging of the meat", "your packaging cannot be null");  

     //checks to see whether these inputs are valid before constructing the meat object 
     
     if (InputValidation.doubleValid(theWeight,0.2,0.5)&&(InputValidation.validDate(theDate)))
     {
        MeatClass meat = new MeatClass(theName, theCut, theWeight, theStorageTemp, theDate, thePackaging);
        storage.addFood(meat);  
     }

    else 
    {
        System.out.println("INVALID MEAT, OBJECT NOT CREATED");
    }
                                             
}

/***********************************************************
* SUBMODULE: grain                                         *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: This submodule calls the input validation     *
*            class and sends the inputs for validation     *
*            before constructing the object                *
************************************************************/ 

public static void grain(StorageClass storage)
{    
     //gets user inputs and passes them to InputValidation class to handle all the exception and validation 

     String aName = InputValidation.stringInput("Please input the name of the grain","your grain name cannot be null");

     String theType = InputValidation.stringInput("Please input the type of grain","your grain type cannot be null");
                  
     GregorianCalendar theBestBefore = InputValidation.dateInput("Please input the best before date of the grain");
                   
     String aPackaging = InputValidation.stringInput("Please input the type of packaging of the grain","your grain pacakging cannot be null");
                        
     double theVolume =InputValidation.doubleInput("Please input the volume of the grain");
     
     double aStorageTemp = InputValidation.doubleInput("Please input the storage temperature of the grain you would like to store");

     if((InputValidation.doubleValid(theVolume,0.2,0.5))&&(InputValidation.validDate(theBestBefore)))
     {
        GrainClass grain = new GrainClass(aName, theType, theVolume, aStorageTemp, theBestBefore, aPackaging);
        storage.addFood(grain); 
     }

     else
     {
        System.out.println("INVALID GRAIN, OBJECT NOT CREATED!!");
     }              
        
}

/***********************************************************
* SUBMODULE: fruit                                         *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: This submodule calls the input validation     *
*            class and sends the inputs for validation     *
*            before constructing the object                *
************************************************************/ 

public static void fruit (StorageClass storage)
{
     //gets user inputs and passes them to InputValidation class to handle all the exception and validation 

    String setName = InputValidation.stringInput("Please input the name of the fruit","your fruit name cannot be null");       
    
    String setType = InputValidation.stringInput("Please input the type of the fruit","your fruit type cannot be null");
          
    int theNumberOfPieces  = InputValidation.intInput("Please input the number of pieces of the fruit");
                   
    GregorianCalendar theUseby = InputValidation.dateInput("Please input the useby date of the fruit");
                   
    String setPackaging = InputValidation.stringInput("Please input the type of packaging of the fruit","your fruit packaging cannot be null");
                   
    double theTemp = InputValidation.doubleInput("Please input the storage temperature of the fruit you would like to store");

    if(InputValidation.intValid(theNumberOfPieces,1,20)&&(InputValidation.validDate(theUseby)))
    {   
        FruitClass fruit = new FruitClass(setName, setType, theNumberOfPieces, theTemp, theUseby, setPackaging); //object creation occurs here 
        storage.addFood(fruit); 
    }

    else
    { 
        //if its invalid the message will be outputted 
       System.out.println("INVALID FRUIT, OBJECT NOT CREATED!!");
    }              
       
              
}

/***********************************************************
* SUBMODULE: veg                                           *
* IMPORT: storage (StorageClass Object)                    *
* EXPORT: none                                             *
* ASSERTION: This submodule calls the input validation     *
*            class and sends the inputs for validation     *
*            before constructing the object                *
************************************************************/ 

public static void veg(StorageClass storage)
{
    //gets user inputs and passes them to InputValidation class to handle all the exception and validation 

    String name = InputValidation.stringInput("Please input the name of the veg ","your veg name cannot be null");
                      
    double vegWeight = InputValidation.doubleInput("Please input the weight of veg");
         
    GregorianCalendar vegBestBefore = InputValidation.dateInput("Please enter the best before date of the veg");                
 
    String setPack = InputValidation.stringInput("Please input the type of packaging of the veg","your veg packaging cannot be null"); 
         
    double sTemp = InputValidation.doubleInput("Please input the storage temperature of the veg you would like to store");

    if(InputValidation.doubleValid(vegWeight,0.2,0.5)&&(InputValidation.validDate(vegBestBefore)))
    {
        //if the objects pass validation they will be created using the class responsible for it
        VegetableClass veg = new VegetableClass( name,vegWeight, sTemp, vegBestBefore, setPack); 

        //the foods are then passed to storage class to be stored according to their storage temperature 
        storage.addFood(veg); 
    }

    else
    {
       System.out.println("INVALID VEGETABLE, OBJECT NOT CREATED!!");
    }        
}

/***********************************************************
* SUBMODULE: display                                       *
* IMPORT: storage(StorageClass Object),selection (Integer) *
* EXPORT: none                                             *
* ASSERTION: calls in the storage and gets the food array  *
*           to output all the foods located in the various *
*           storage location                               *
************************************************************/ 

 public static void display(StorageClass storage, int selection)
    {
        // gets array so that it can output the values in the storage location 

        FoodClass [][] storageArray = storage.getArray();
    
        switch (selection)
        {

        case 1:
        try
            {
            if(storageArray[0] != null) //checks to see the object is not null 
                {
                System.out.println("The pantry includes the following foods:");

                  //using the for loop enables the elements located in the storage location to be outputted in to String format 

                    for (int i=0; i< storageArray[0].length; i++)
                        {  
                            if(storageArray[0][i] != null)
                            {       
                                System.out.println(storageArray[0][i].toString());
                            }
                        }
                }
            }
        catch(ArrayIndexOutOfBoundsException e)
            {
            System.out.println("PANTRY LOCATION WAS NOT INITIALISED HENCE EMPTY"); //if an exception exists it will be caught 
            }
        break; 
        

        case 2:
        try
        {
        if(storageArray[2] != null)
                {
                System.out.println("The fridge includes the following foods:"); 
                    
                    for (int i=0; i< storageArray[2].length; i++ )
                    {
                            if(storageArray[2][i] != null)
                            {
                                System.out.println(storageArray[2][i].toString()); //prints out all objects located in the fridge 
                            }
                    }
                }
        }
        catch(ArrayIndexOutOfBoundsException e)
            {
            System.out.println("FRIDGE LOCATION WAS NOT INITIALISED HENCE EMPTY"); // will handle the exception appropriately 
            }
        break;

        case 3:
        try
        {
            if(storageArray[1] != null)
                {
                System.out.println("The freezer contains the following foods:"); 

                for (int i=0; i< storageArray[1].length; i++ )
                    {
                    if(storageArray[1][i] != null)
                        {
                        System.out.println(storageArray[1][i].toString()); 
                        }
                    }
                }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("FREEZER LOCATION WAS NOT INITIALISED HENCE EMPTY");
        }
        break; 

        }
 }
/***********************************************************
* SUBMODULE: removal                                       *
* IMPORT: storage(StorageClass Object)                     *
* EXPORT: none                                             *
* ASSERTION: goes through the arrays based on user input   *
*            and removes the selected food                 *
************************************************************/ 
    public static void removal(StorageClass storage)
    {
        //goes to the InputValidation class to validate the inputs 
        int location = InputValidation.intInput("which storage location would you like to remove from? Enter a number from the following (1)Pantry (2)Fridge (3)Freezer ");
        int index = InputValidation.intInput("Please input the index of the food you would like to remove");
       
        //calls method from storage class to get array 
        FoodClass [][] storageArray = storage.getArray();

        switch(location)
        {
           case 1: 
           //output message to user so they know which element has been removed 
           System.out.println (storageArray[0][index]+ " will now be removed");

           // sets selected element to null, as a way of removing it 
           storageArray[0][index] = null; 

            for (int i=0; i< storageArray[0].length-1; i++)
               {  
                 if((storageArray[0][i]==null)&&(i<storageArray[0].length))
                 {
                    storageArray[0][i] = storageArray[0][i+1];
                    storageArray[0] [i+1] = null;   
                 }            
               }
            break; 
          
           case 2: 
           System.out.println (storageArray[2][index]+ " will now be removed");
           storageArray[2][index] = null; 

            for(int i=0;i<storageArray[2].length-1; i++)
                {
                  if((storageArray[2][i]==null)&&(i<storageArray[2].length))
                  {
                    storageArray[2][i] = storageArray[2][i+1]; 
                    storageArray[2][i+1] = null; 
                  }
                }
           break; 

           case 3:
           System.out.println (storageArray[1][index]+ " will now be removed");
           storageArray[1][index] = null; 

            for(int i=0; i< storageArray[1].length-1; i++)
                {
                  if((storageArray[1][i] == null)&&(i<storageArray[1].length))
                  {
                    storageArray[1][i] = storageArray[1][i+1]; 
                    storageArray[1][i+1] = null;
                  }
                }
            break; 
        }

       
    }
 
/***********************************************************
* SUBMODULE: outputPantry                                  *
* IMPORT: storage(StorageClass Object), i (Integer)        *
* EXPORT: none                                             *
* ASSERTION: gets array and outputs the expired elements   *
************************************************************/

    public static void outputPantry (StorageClass storage, int i)
    {
       FoodClass [][] foodArray = storage.getArray(); //gets array 

       System.out.println("This food located in the PANTRY is expired:" +foodArray[0][i].toString()); //outputting all the expired elements in for loop
    }

/***********************************************************
* SUBMODULE: outputFreezer                                 *
* IMPORT: storage(StorageClass Object), i (Integer)        *
* EXPORT: none                                             *
* ASSERTION: gets array and outputs the expired elements   *
************************************************************/

    public static void outputFreezer (StorageClass storage, int i)
    {
        FoodClass [][] foodArray = storage.getArray(); //gets array 
       
        System.out.println("This food located in the FREEZER is expired:" +foodArray[1][i].toString()); //outputting all the expired elements in for loop
    }
    
/***********************************************************
* SUBMODULE: outputFridge                                  *
* IMPORT: storage(StorageClass Object), i (Integer)        *
* EXPORT: none                                             *
* ASSERTION: gets array and outputs the expired elements   *
************************************************************/
    public static void outputFridge(StorageClass storage, int i)
    {
        FoodClass [][] foodArray = storage.getArray(); //gets array 
        System.out.println("This food located in the FRIDGE is expired:" +foodArray[2][i].toString()); //outputting all the expired elements in for loop
    }
}
   

