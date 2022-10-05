/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the VegetableClass Objects      *
*        using constructors, mutators as well as validation   *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/
import java.util.*; 
    
     public class VegetableClass extends FoodClass  
     { 
       private double weight;
  

/***********************************************************
* DEFAULT CONSTRUCTOR: VegetableClass                      *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: default values for veg  are set if the        *
*            object does not have any specs                *
************************************************************/    
     public VegetableClass ()
      {
         super(); 
         weight  = 1.0;
      }
/************************************************************
* ALTERNATE CONSTRUCTOR: VegetableClass                     *
* IMPORT: theName (String),  theWeight(Real)                *
          theStorageTemp (Real), theDate(GregorianCalendar) *
*         thePackaging (String),                            *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 
    public VegetableClass (String theName,double theWeight, double theStorageTemp, GregorianCalendar theDate, String thePackaging)
      {
        super (theName, theStorageTemp, thePackaging, theDate); 
        
        if ((validateW(theWeight)))
         {
           weight  = theWeight;
          }
           else
             {
              try
                {       
                  throw new IllegalArgumentException("Error VEG has not been created!!!");
                }
              catch (IllegalArgumentException e)
                {
                  System.out.println("Caught an IllegalArgumentException..." + e.getMessage());
                }
              }
       }
 /***********************************************************
* COPY CONSTRUCTOR: VegetableClass                          *
* IMPORT: TheVeg (VegtableClass)                            *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/
     public VegetableClass (VegetableClass theVeg)
       {
           super(theVeg);
           weight = theVeg.getWeight();
       }

       //ACCESSOR
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
        String vegString;
        vegString = new String (super.toString() + " This Vegetable has a weight of "  +weight);
        return vegString;
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
         writeString = new String (super.writeOut() +weight); 
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
         VegetableClass theVeg= null;
         if (theObject instanceof  VegetableClass)
         {
           theVeg = (VegetableClass)theObject;
            if ( super.equals(theVeg))
              if (weight == theVeg.getWeight())
                        isequalto = true;
          }
             return isequalto;

          }
/*************************************************************
 * SUBMODULE: clone                                          *
 * IMPORT: none                                              *
 * EXPORT: VegetableClass (VegetableClass Object)            *
 * ASSERTION: clones the object                              *
 *                                                           *
 * ************************************************************/

      public VegetableClass clone()
          {
           return new VegetableClass(this);
          }

//MUTATORS 
//MAKE SURE CLASSFIELDS ARE VALID BEFORE SETTING THEM
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
     private boolean validateW (double theWeight)
          {
            boolean validateW = false;
              if ((theWeight>=0.2)&&(theWeight<=5.0)) {
                  validateW = true; }
              return validateW;
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
             space = ((int)(weight * 1.025)); 
             return  space; 
      }

     }
