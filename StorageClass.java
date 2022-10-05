/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the StorageClass Objects using  *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 7, 2018                                 *
* Date Modified: May 28, 2018                                 *
***************************************************************/
import java.util.*;

public class StorageClass { 
              
        //classfields

        private FoodClass [][] storageArray;
        private int fridgeMax = 10;
        private int freezerMax = 10; 
        private int pantryMax = 10; 
        private int freezerCount = 0; 
        private int pantryCount = 0; 
        private int fridgeCount = 0; 

        
/***********************************************************
* DEFAULT CONSTRUCTOR: StorageClass                        *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: default values for storage class are set if   *
*            object does not have any specs                *
************************************************************/
     public StorageClass()
        { 
           storageArray = new FoodClass[3][];
           storageArray[0] = new FoodClass [(pantryMax)]; 
           storageArray[1] = new FoodClass [(freezerMax)]; 
           storageArray[2] = new FoodClass [(fridgeMax)];
        }
     
 /***********************************************************
* ALTERNATE CONSTRUCTOR: StorageClass                       *
* IMPORT: theFridge (Integer), theFreezer (Integer),        *
*         thePantry (Integer)                               *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 

     public StorageClass(int theFridge, int theFreezer, int thePantry)
         { 
           
           storageArray = new FoodClass [3][];
           storageArray[0] = new FoodClass [(thePantry)]; 
           storageArray[1] = new FoodClass [(theFreezer)]; 
           storageArray[2] = new FoodClass [(theFridge)];

         }
 /***********************************************************
* COPY CONSTRUCTOR: StorageClass                            *
* IMPORT: TheStorage (StorageClass)                         *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/
    public StorageClass(StorageClass theStorage) 
         { 
          storageArray = theStorage.getArray(); 
          pantryMax = theStorage.getPantryMax(); 
          freezerMax = theStorage.getFreezerMax();
          fridgeMax = theStorage.getFridgeMax();  
         } 

//ACCESSORS 
    public FoodClass [][] getArray() 
       { 
         return storageArray; 
       } 

    public int getPantryMax()
       { 
         return pantryMax; 
       } 

    public int getFreezerMax()
       { 
         return freezerMax; 
       } 
    
    public int getFridgeMax()
      {
        return fridgeMax; 
      }
/***********************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/
    public String toString()
       { 
        String storageString; 
        storageString = new String ( "This storage array has the following elements "  + storageArray +  " and has a freezer capacity of: " +freezerMax+ " and a pantry capacity of: " +pantryMax+ " and a fridge capacity of: " +fridgeMax+ ".");
        return storageString; 
       } 
 /************************************************************
 * SUBMODULE: equals                                         *
 * IMPORT: theObject (Object)                                *
 * EXPORT: isequalto (boolean)                               *
 * ASSERTION: two storage classes are interchangeable        *
 *            if they have are equal                         *
 *                                                           *
 * ***********************************************************/
    public boolean equals (Object theObject) 
       { 
         boolean isequalto = false;
         StorageClass theStorage = null; 
         if (theObject instanceof  StorageClass) 
         { 
           theStorage = (StorageClass)theObject; 
            if (storageArray == theStorage.getArray())
              if (pantryMax == theStorage.getPantryMax())
                 if (freezerMax == theStorage.getFreezerMax())
                    if(fridgeMax == theStorage.getFridgeMax())
						isequalto = true; 
          }  
             return isequalto; 
             
          } 

//MUTATORS 
//MAKE SURE CLASSFIELDS ARE VALID BEFORE SETTING THEM

     public void setArray (FoodClass [][] theStorageArray)
          { 
           storageArray  = theStorageArray; 
          } 

     public void setFreezer (int theFreezer) 
          { 
            freezerMax = theFreezer; 
          } 
     public void setPantry (int thePantry) 
          { 
            pantryMax = thePantry; 
          }
     public void setFridge (int theFridge)
          {
            fridgeMax = theFridge; 
          }
/***********************************************************
* SUBMODULE: addFood                                       *
* IMPORT: theFood (FoodClass Object)                       *
* EXPORT: none                                             *
* ASSERTION: adds the food to the storage arrays depending *
*            on the storage temperature                    *
************************************************************/ 
      public FoodClass [][] addFood (FoodClass theFood)
      {
        try{
             try {
                   double temp; 

                   temp = theFood.getStorageTemp(); 

                    if(validatePantry(temp))
                    {         
                        storageArray[0][pantryCount+1] = theFood;      
                        pantryCount++;  
                    }

                    else if (validateFreezer(temp))
                    {
                        storageArray[1][freezerCount+1] = theFood; 
                        freezerCount++; 
                    }

                    else if (validateFridge(temp))
                    {
                        storageArray[2][fridgeCount+1] = theFood;
                        fridgeCount++;  
                    }

                    else 
                    {

                    }
               }
              catch(NullPointerException e)
              {
                 System.out.println("ERROR AN ELEMENT IS NULL & INVALID AND HAS NOT BEEN ADDED");
              }

            }

       catch (IndexOutOfBoundsException e)
        {
           System.out.println("INDEX OUT OF BOUNDS EXCEPTION");
        }

         return storageArray; 

      }
/***********************************************************
* SUBMODULE: validatePantry                                *
* IMPORT: temp (Real)                                      *
* EXPORT: isvalid (boolean)                                *
* ASSERTION: validates if the food belongs to the pantry   *
************************************************************/   
   public boolean validatePantry(double temp)
   {
     boolean isvalid = false; 
      if ((temp>= 8.0) && (temp <= 25.0))
      {
        isvalid = true; 
      }
    return isvalid; 
   }
/***********************************************************
* SUBMODULE: validateFridge                                *
* IMPORT: temp (Real)                                      *
* EXPORT: isvalid (boolean)                                *
* ASSERTION:  validates if the food belongs to the fridge  *
************************************************************/
   public boolean validateFridge(double temp)
   {
     boolean isvalid= false; 
      if ((temp >= -2.0) && (temp <= 6.0))
      {
        isvalid = true; 
      }
    return isvalid; 
   }
/***********************************************************
* SUBMODULE: validateFreezer                               *
* IMPORT: temp (Real)                                      *
* EXPORT: isvalid (boolean)                                *
* ASSERTION:  validates if the food belongs to the freezer *
************************************************************/
  public boolean validateFreezer(double temp)
  {
    boolean isvalid = false; 
    if((temp >= -27.0) && (temp <= -5.0))
    {
      isvalid = true; 
    }
    return isvalid; 
  }



}
         
