/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class creates the GrainClass Objects using    *
*          constructors, mutators as well as validation       *
*          submodules to ensure that all inputs are valid     *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/
import java.util.*; 

public class GrainClass extends FoodClass 
         { 
           private String type;
           private double volume;

/***********************************************************
* DEFAULT CONSTRUCTOR: GrainClass                          *
* IMPORT: none                                             *
* EXPORT: none                                             *
* ASSERTION: default values for grain are set if the       *
*            object does not have any specs                *
************************************************************/ 
 
     public GrainClass ()
      { 
      	 super();
         type = " "; 
         volume = 5.0;
      } 
/***********************************************************
* ALTERNATE CONSTRUCTOR: GrainClass                         *
* IMPORT: theName (String), theType(String), theVolume(Real)*
          theStorageTemp (Real), theDate(GregorianCalendar) *
*         thePackaging (String),                            *
* EXPORT: none                                              *
* ASSERTION: Before it creates the object it makes sure     *
*            that they are valid inputs                     *
*************************************************************/ 

     public GrainClass (String theName, String theType, double theVolume, double theStorageTemp, GregorianCalendar theDate, String thePackaging) 
      { 
         super(theName, theStorageTemp,thePackaging, theDate); 
          if ((validateV(theVolume)&& (validateString(theType))))
            { 
              type = theType; 
              volume = theVolume; 
            } 

           else 
             {  
               try
                {       
                   throw new IllegalArgumentException("Error Grain has not been created!!!");
                }
               catch (IllegalArgumentException e)
                {
                  System.out.println("IllegalArgumentException was caught" + e.getMessage());
                }
              } 
       }

 /***********************************************************
* COPY CONSTRUCTOR: GrainClass                              *
* IMPORT: TheGrain (GrainClass)                             *
* EXPORT: none                                              *
*ASSERTION:creates an object with an identical object state *
*************************************************************/
     public GrainClass (GrainClass theGrain)
       { 
       	   super(theGrain); 
           type = theGrain.getType(); 
           volume = theGrain.getVolume();
       }

//ACCESSORS
     public String getType () 
       { 
         return type; 
       }
 
     public double getVolume()
       { 
         return volume; 
       }
/***********************************************************
* SUBMODULE: toString                                       *
* IMPORT: none                                              *
* EXPORT: none                                              *
* ASSERTION:prints out a string representation of object    *
*************************************************************/
     public String toString()
       {
        String grainString;
        grainString = new String (super.toString() + " The type of this grain is " +type+  " with a volume of "  +volume+ " mL");
        return grainString;
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
         writeString = new String (super.writeOut() +type+  ", " +volume ); 
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
         GrainClass theGrain= null;
         if (theObject instanceof  GrainClass)
         {
           theGrain = (GrainClass)theObject;
             if ( super.equals(theGrain))
                if (type == theGrain.getType())
                   if (volume == theGrain.getVolume())
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

     public GrainClass clone()
          {
           return new GrainClass(this);
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

     public void setVolume (double theVolume)
          {
            if (validateV(theVolume))
            {
              volume = theVolume;
            }
          }

/***********************************************************
* SUBMODULE: validateV                                     *
* IMPORT: theVolume (Real)                                 *
* EXPORT: validateV (boolean)                              *
* ASSERTION: validates if the volume is within the range   *
************************************************************/

     private boolean validateV (double theVolume) 
          { 
            boolean validateV = false; 
              if ((theVolume>=0.2)&&(theVolume<=5.0)) { 
                  validateV = true; } 
              return validateV;
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
            space = ((int)(volume * 1.0)); 
            return  space; 
          }
      
     }

          
