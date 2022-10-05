/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the FruitClass Objects using    *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/
import java.util.*; 

public class FruitClass extends FoodClass 
         {
           private String type;
           private int numberOfPieces;
/***********************************************************
* DEFAULT CONSTRUCTOR: FruitClass                          *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: default values for fruit are set if the       *
*            object does not have any specs                *
************************************************************/ 
     public FruitClass ()
      {
      	 super(); 
         type = "Granny Smith";
         numberOfPieces = 4;
       
      }
/***********************************************************
* ALTERNATE CONSTRUCTOR: GrainClass                         *
* IMPORT: theName (String), theType(String),                *
          theStorageTemp (Real), theDate(GregorianCalendar) *
*         thePackaging (String), theNumberOfPieces(Integer) *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 
     public FruitClass (String theName, String theType, int theNumberOfPieces, double theStorageTemp, GregorianCalendar theDate, String thePackaging)
     {
        super(theName, theStorageTemp, thePackaging, theDate); 
          if ((validateP(theNumberOfPieces) && (validateString(type))))
            {
              type = theType; 
              numberOfPieces = theNumberOfPieces;
            }
           else
              {
                try
                  {       
                    throw new IllegalArgumentException("Error FRUIT has not been created!!!");
                  }
               catch (IllegalArgumentException e)
                  {
                    System.out.println("IllegalArgumentException was caught" + e.getMessage());
                  }
              }
      }
/***********************************************************
* COPY CONSTRUCTOR: FruitClass                              *
* IMPORT: TheFruit (FruitClass)                             *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/
     public FruitClass (FruitClass theFruit)
       {   
       	   super(theFruit); 
           type = theFruit.getType();
           numberOfPieces = theFruit.getPieces();
       }

//ACCESSORS
     public String getType ()
       {
         return type;
       }
     
     public int getPieces()
       { 
         return numberOfPieces; 
       } 
/***********************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/   
      public String toString()
       {
        String fruitString;
        fruitString = new String ( super.toString() + " This fruit is of the type " +type+ " with " +numberOfPieces+ " pieces");
        return fruitString;
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
         writeString = new String (super.writeOut() +type+  ", " +numberOfPieces ); 
         return writeString; 
       }
 /************************************************************
 * SUBMODULE: equals                                         *
 * IMPORT: theObject (Object)                                *
 * EXPORT: isequalto (boolean)                               *
 * ASSERTION: two foods are interchangeable                  *
 *            if they have are equal                         *
 *                                                           *
 * ***********************************************************/
     public boolean equals (Object theObject)
       {
         boolean isequalto = false;
         FruitClass theFruit= null;
         if (theObject instanceof  FruitClass)
         {
           theFruit = (FruitClass)theObject;
            if (type == theFruit.getType())
              if (numberOfPieces == theFruit.getPieces())
                        isequalto = true;
          }
             return isequalto;
        }
/*************************************************************
 * SUBMODULE: clone                                          *
 * IMPORT: none                                              *
 * EXPORT: GrainClass (GrainClass Object)                    *
 * ASSERTION: clones the object                              *
 *                                                           *
 * ************************************************************/

        public FruitClass clone()
        {
         return new FruitClass(this);
        }

//MUTATORS 
//MAKE SURE CLASSFIELDS ARE VALID BEFORE SETTING THEM 
      public void setType (String theType)
          {
            if(validateString(theType))
              {
                type  = theType;
              }
          }
    
     public void setPieces (int theNumberOfPieces) 
          { 
             if (validateP(theNumberOfPieces))
             { 
               numberOfPieces = theNumberOfPieces;
             }
          } 

/***********************************************************
* SUBMODULE: validateP                                     *
* IMPORT: theNumberOfPieces (Integer)                      *
* EXPORT: validateP (boolean)                              *
* ASSERTION: validates if the pieces is within the range   *
************************************************************/
     public boolean validateP (int theNumberOfPieces)
          {
            boolean validateP = false;
              if ((theNumberOfPieces>=1)&&(theNumberOfPieces<=20))
                 {
                    validateP = true;
                 }
              return validateP;
          }
/***********************************************************
* SUBMODULE: validateString                                *
* IMPORT: word (String)                                    *
* EXPORT: valid (boolean)                                  *
* ASSERTION: validates if the string is not null           *
************************************************************/
      public boolean validateString (String word)
      {
         boolean valid = false; 
         if (word != null)
         {
           valid = true; 
         }
        return valid; 
      }
/***********************************************************
* SUBMODULE: calcSpace                                     *
* IMPORT: food (FoodClass Object)                          *
* EXPORT: space (Integer)                                  *
* ASSERTION: calculates the space in pieces                *
************************************************************/
    public int calcSpace(FoodClass food)
      {
        int space; 
        space = ((int)(numberOfPieces * 1.95)); 
        return  space; 
      }
    }    