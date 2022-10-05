/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the validation   *
*          that takes place between the classes regarding     *
*          user input and file I/O                            *
* Date Created: March 7, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/
import java.util.*; 

public class InputValidation
{

/************************************************************
* SUBMODULE: doubleValid                                    *
* IMPORT: value (Real), min (Real), max (Real)              * 
* EXPORT: validate (boolean)                                *
* Assertion: imports the min and max and compares it        * 
*            to value to make sure its in the range         *         
*************************************************************/

    public static boolean doubleValid (double value, double min, double max)
    {
      boolean validate = false;
        if ((value >= min)&&(value <=5.0))
        {
            validate = true; 
        }
        return validate;
    }
/************************************************************
* SUBMODULE: intValid                                       *
* IMPORT: value (Integer), min (Integer), max (Integer)     * 
* EXPORT: validate (boolean)                                *
* Assertion: imports the min and max and compares it        * 
*            to value to make sure its in the range         *         
*************************************************************/

    public static  boolean intValid(int value, int min, int max)
    {
      boolean validate = false;
        if ((value >= min)&&(value <= max)) 
        {
            validate = true; 
        }
        return validate;
    }
/************************************************************
* SUBMODULE: stringValid                                    *
* IMPORT: word (String)                                     * 
* EXPORT: validate (boolean)                                *
* Assertion: makes sure string is not null                  *        
*************************************************************/
    public static boolean stringValid(String word)
    {
       boolean validate = false; 
         if (word != null)
         {
             validate = true; 
         }
         return validate; 
    }
/************************************************************
* SUBMODULE: doubleInput                                    *
* IMPORT: prompt (String)                                   * 
* EXPORT: value (double)                                    *
* Assertion: handles all the inputs related to real         *        
*************************************************************/
    public static double doubleInput(String prompt)
    {
      Scanner sc = new Scanner (System.in); 
      double value; 

     try
          {
            System.out.println(prompt); 
            value = sc.nextDouble(); 
        
          }
     catch (InputMismatchException e)
          {
            String flush = sc.nextLine(); 
            System.out.println("DO NOT ENTER LETTERS"); 
            System.out.println("TRY AGAIN!!");
            value = sc.nextDouble(); 
          }
     return value;

    }
/************************************************************
* SUBMODULE: stringInput                                    *
* IMPORT: prompt (String) , errorPrompt (String)            * 
* EXPORT: answer (String)                                   *
* Assertion: handles all string inputs to make sure         *
*            they are not null                              *        
*************************************************************/    
    public static String stringInput (String prompt, String errorPrompt)
    {
      Scanner sc = new Scanner (System.in); 
      String answer; 
     
      System.out.println(prompt); 
      answer = sc.nextLine();

      if (stringValid(answer) == false)
      {
          String flush = sc.nextLine();
          System.out.println(errorPrompt);
          System.out.println ("Please try again!");                       
          answer = sc.nextLine();
      }

     return answer; 
    }

/************************************************************
* SUBMODULE: dateInput                                      *
* IMPORT: prompt (String)                                   * 
* EXPORT: theDate (GregorianCalendar Object)                *
* Assertion: handles the input of strings that are to be    *
*           converted into a calendar object                *        
*************************************************************/  
    public static GregorianCalendar dateInput (String prompt)
    {

      Scanner sc = new Scanner (System.in); 
      int year, month,dayOfMonth; 

      System.out.println(prompt);

      System.out.println("Enter the day in the form DD (e.g. 23)");
      dayOfMonth = sc.nextInt(); 

      System.out.println("Enter the month in the form MM (e.g. 09)"); 
      month = sc.nextInt(); 

      System.out.println("Enter the year in the form YYYY (e.g. 2018)"); 
      year = sc.nextInt(); 
      
      GregorianCalendar theDate = new GregorianCalendar(year, month, dayOfMonth); 
      return theDate;      
  
    }

/************************************************************
* SUBMODULE: validDate                                      *
* IMPORT: date (GregorianCalendar Object)                   * 
* EXPORT:valid (boolean)                                    *
* Assertion:check to make sure that the date is after       *
*           the GregorianCalendar Object compare            *        
*************************************************************/ 

    public static boolean validDate(GregorianCalendar date)
    {
      boolean valid = false; 
      GregorianCalendar compare = new GregorianCalendar(2018,01,01); //compares the date imported to this 

      if (date.after(compare))
         {
          valid = true; 
         }
      return valid; 
    }
/************************************************************
* SUBMODULE: intInput                                       *
* IMPORT: prompt (String)                                   * 
* EXPORT:value (Integer)                                    *
* Assertion:handles all the Integer inputs to               *
*           make sure they are all valid                    *        
*************************************************************/      
    public static int intInput(String prompt)
    {
        Scanner sc = new Scanner (System.in); 
        int value; 
  
       try
            {
              System.out.println(prompt); 
              value = sc.nextInt(); 
          
            }
       catch (InputMismatchException e)
            {
              String flush = sc.nextLine(); 
              System.out.println("DO NOT ENTER LETTERS"); 
              System.out.println("TRY AGAIN!!");
              value = sc.nextInt(); 
            }
       return value;
    }
/************************************************************
* SUBMODULE: storageSelection                               *
* IMPORT: none                                              * 
* EXPORT: selection (Integer)                               *
* Assertion:ensures the user inputs correct                 *
*           value by using a try catch                      *        
*************************************************************/  
    public static int storageSelection ()
    {
    
        Scanner sc = new Scanner(System.in);
        int selection;  
      try
       {

            System.out.println("What storage location would you like to display? Enter from the following options:");
            System.out.println("(1) Pantry"); 
            System.out.println("(2) Fridge"); 
            System.out.println("(3) Freezer");
            
            selection = sc.nextInt();
       }

     catch (InputMismatchException e)
       {
         String flush = sc.nextLine(); 
         System.out.println("DO NOT ENTER LETTERS"); 
         System.out.println("TRY AGAIN!!");
         selection = sc.nextInt(); 
       }
         return selection;
    }

   
}