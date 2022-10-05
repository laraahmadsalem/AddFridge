/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the MeatClass Objects using     *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/

import java.util.*; 

public class MeatClass extends FoodClass
     {
       private String cut;
       private double weight;

/***********************************************************
* DEFAULT CONSTRUCTOR: MeatClass                           *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: default values for meat  are set if the       *
*            object does not have any specs                *
************************************************************/
     public MeatClass ()
      {  
      	 super(); 
         cut  = "Breast";
         weight  = 1.0;
      }
/************************************************************
* ALTERNATE CONSTRUCTOR: MeatClass                          *
* IMPORT: theName (String), theCut(String), theWeight(Real) *
          theStorageTemp (Real), theDate(GregorianCalendar) *
*         thePackaging (String),                            *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 
    public MeatClass (String theName, String theCut, double theWeight, double theStorageTemp, GregorianCalendar theDate, String thePackaging)
      {
        super(theName, theStorageTemp, thePackaging, theDate); 
        if ((validateW(theWeight)) && (validateString(theCut)))
         {
           cut = theCut;
           weight  = theWeight;
         }
           else
             {
                try
                {       
                  throw new IllegalArgumentException("Error MEAT has not been created!!!");
                }
              catch (IllegalArgumentException e)
                {
                  System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
                }
             }
      }

 /***********************************************************
* COPY CONSTRUCTOR: MeatClass                               *
* IMPORT: TheMeat (MeatClass)                               *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/
     public MeatClass (MeatClass theMeat)
      {
           super(theMeat);
           cut = theMeat.getCut();
           weight = theMeat.getWeight();
      }

//ACCESSORS

     public String getCut ()
       {
         return cut;
       }

     public double getWeight()
       {
         return weight;
       } 

/***********************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/

     public String toString()
       {
        String meatString;
        meatString = new String (super.toString() +  " This meat has a cut which is of the type " +cut+  " with a weight of "  +weight+ " kg" );
        return meatString;
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
         writeString = new String (super.writeOut() +cut+  ", " +weight ); 
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
         MeatClass theMeat= null;
         if (theObject instanceof  MeatClass)
         {
           theMeat = (MeatClass)theObject;
          if ( super.equals(theMeat))
            if (cut == theMeat.getCut())
              if (weight == theMeat.getWeight())
                        isequalto = true;
          }
             return isequalto;

          }
/*************************************************************
 * SUBMODULE: clone                                          *
 * IMPORT: none                                              *
 * EXPORT: MeatClass (MeatClass Object)                      *
 * ASSERTION: clones the object                              *
 *                                                           *
 * ************************************************************/

      public MeatClass clone()
          {
           return new MeatClass(this);
          }

//MUTATORS 
//MAKE SURE CLASSFIELDS ARE VALID BEFORE SETTING THEM
     public void setCut (String theCut)
          {
            if(validateString(theCut))
            {
             cut  = theCut;
            }
          }

     public void setWeight (double theWeight) 
          {
            if (validateW(theWeight))
            {
              weight = theWeight;
            }
          }
/***********************************************************
* SUBMODULE: validateW                                     *
* IMPORT: theWeight (Real)                                 *
* EXPORT: validateW (boolean)                              *
* ASSERTION: validates if the weight is within the range   *
************************************************************/
  
     public boolean validateW (double theWeight)
          {
            boolean validateW = false;
              if ((theWeight>=0.2)&&(theWeight<=5.0)) 
              {
                  validateW = true;
              }
              return validateW;
          }

/***********************************************************
* SUBMODULE: validateString                                *
* IMPORT: word (String)                                    *
* EXPORT: valid (boolean)                                  *
* ASSERTION: validates if the string is not null           *
************************************************************/

      private boolean validateString (String word)
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
* ASSERTION: calculates the space in volume                *
************************************************************/
        public int calcSpace(FoodClass food)
        {
          int space; 
          space = ((int)(weight * 0.86)); 
          return  space; 
        }
                                        
     }