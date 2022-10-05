/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the FoodClass Objects using     *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/

import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

 public abstract class FoodClass implements Ifood
   { 
     private String name, packaging; 
     private GregorianCalendar date;  
     private double storageTemperature; 

  
 /***********************************************************
* DEFAULT CONSTRUCTOR: FoodClass                            *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION: default values for food are set if the         *
*            object does not have any specs                 *
*************************************************************/ 
    
    public FoodClass()
      { 
         name = "";
         storageTemperature = 0.0; 
         packaging = ""; 
         date = new GregorianCalendar();      
      }
 /***********************************************************
* ALTERNATE CONSTRUCTOR: FoodClass                          *
* IMPORT: theName (String),theStorageTemp (Real),           *
*         thePackaging (String), theDate(GregorianCalendar) *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 
     
    public FoodClass(String theName, double theStorageTemp, String thePackaging, GregorianCalendar theDate)
       { 
         if(validateString(theName)&&(validateString(thePackaging)) && validDate(theDate))
         {
            name = theName; 
            storageTemperature = theStorageTemp; 
            packaging = thePackaging; 
            date = theDate; 
         }

         else 
         {
            try
            {       
              throw new IllegalArgumentException("Error Grain has not been created!!!");
            }
          catch (IllegalArgumentException e)
            {
              System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
            }
         }
       
       } 
 /***********************************************************
* COPY CONSTRUCTOR: FoodClass                               *
* IMPORT: TheFood (FoodClass)                               *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/

    public FoodClass(FoodClass theFood) 
       { 
         name = theFood.getName(); 
         storageTemperature = theFood.getStorageTemp(); 
         packaging= theFood.getPackaging(); 
         date = theFood.getDate(); 
       }

//ACCESSORS 
//THEY JUST GET THE CLASSFIELD IF AN INDIVIDUALS CALLS FOR THEM 

    public String getName() 
       { 
         return  name; 
       } 
    public double getStorageTemp()
       { 
         return storageTemperature; 
       } 
    public String getPackaging()
       { 
         return packaging; 
       }    
     public GregorianCalendar getDate()
      {
        return date;  
      }
/***********************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/
      
    public String toString()
       { 
        String foodString; 
        foodString = new String ("This food is "  +name+  " and uses " + packaging+  " packaging " + ", with a storage temperature of " +storageTemperature+ " degrees." + " It has an expiration date of "  + date.getTime()+ ".");
        return foodString; 
       } 
/***********************************************************
* SUBMODULE: writeOut                                      *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: prints out the objects in the same format as  *
           input file                                      *
************************************************************/
      
    public String writeOut()
    {
      String writeString; 
      writeString = new String (name+ ", " +packaging+ ", " +storageTemperature+ ", " +date.getTime()+ ", "); 
      return writeString; 
    }
/*************************************************************
 * SUBMODULE: equals                                         *
 * IMPORT: theObject (Object)                                *
 * EXPORT: isequalto (boolean)                               *
 * ASSERTION: two foods are interchangeable                  *
 *            if they have are equal                         *
 *                                                           *
 * ************************************************************/

    public boolean equals (Object theObject) 
       { 
         boolean isequalto = false;
         FoodClass theFood = null; 
         if (theObject instanceof  FoodClass) 
         { 
           theFood = (FoodClass)theObject; 
            if (name == theFood.getName())
              if (storageTemperature == theFood.getStorageTemp())
                 if (packaging == theFood.getPackaging())
                   if(date == theFood.getDate())
						isequalto = true; 
          }  
             return isequalto; 
             
       } 

//MUTATORS

     public void setName (String theName)
     { 
       if(validateString(theName))
          {
             name = theName; 
          }
     } 

     public void setStorageTemperature (double theStorageTemp) 
      { 
        storageTemperature = theStorageTemp; 
      } 

     public void setPackaging (String thePackaging) 
     { 
          if(validateString(thePackaging))
            {
               packaging = thePackaging; 
            }
     }
     public void setDate (GregorianCalendar theDate)
     {
        if(validDate(theDate))
          {
            date = theDate; 
          }
     }     
     
/***********************************************************
* SUBMODULE: validateString                                *
* IMPORT: word (String)                                    *
* EXPORT: valid (boolean)                                  *
* ASSERTION: validates if the string is not null           *
************************************************************/

     private boolean validateString(String word)
     {
         boolean valid = false; 
       if (word != null)
          {
            valid = true; 
          }
         return valid; 
      }

/***********************************************************
* SUBMODULE: validDate                                     *
* IMPORT: date (GregorianCalendar Object)                  *
* EXPORT: valid (boolean)                                  *
* ASSERTION: validates if the date is after  1/01/2018     *
             to determine whether the food is expired      *
************************************************************/

      private boolean validDate(GregorianCalendar date)
      {
        boolean valid = false; 
        GregorianCalendar compare = new GregorianCalendar(2018,01,01);
  
        if (date.after(compare))
           {
            valid = true; 
           }
        return valid; 
      }
/***********************************************************
* SUBMODULE: calcExpiry                                    *
* IMPORT: date (GregorianCalendar Object)                  *
* EXPORT: valid (boolean)                                  *
* ASSERTION: validates if the date is before this instance *
             to determine whether the food is expired      *
************************************************************/

 
     public boolean calcExpiry (GregorianCalendar date)
     {
       Calendar today = Calendar.getInstance(); 
       boolean valid = false; 
       
       if(date.before(today))
       {
         valid = true; 
       }
      return valid; 
     }

  }