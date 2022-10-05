/**************************************************************
* Author:  Lara Ahmad Salem                                   *
* Purpose: This class is responsible for all the FileIO       *
*          submodules to handle all the files when reading in *
* Date Created: March 2, 2018                                 *
* Date Modified: May 29, 2018                                 *
***************************************************************/

import java.util.*; 
import java.io.*; 
import java.util.Calendar;
import java.util.GregorianCalendar; 



public class FileIO{

/************************************************************
* SUBMODULE: getNum                                         *
* IMPORT: fileName(String), word (String)                   *
* EXPORT: count (Integer)                                   *
* ASSERTION: goes through first 3 lines of the file so it   *
*            gets values for freezer,pantry,fridge to       *
*            construct the storage class                    *
*************************************************************/
 
public static int getNum(String fileName, String word)
{
    //counts the value of each of the storage arrays and initialises the length of each array
       Scanner sc = new Scanner (System.in); 
     
       int count =0;
        
       FileInputStream fileStrm = null;
       InputStreamReader rdr;
       BufferedReader bufRdr;
       String line;

               try {

                       fileStrm = new FileInputStream (fileName);
                       rdr = new InputStreamReader (fileStrm);
                       bufRdr = new BufferedReader (rdr);
                       line = bufRdr.readLine();
                       String storage="";
                       
                 //tokenizes the lines so that it gets values for length of arrays 
                       for(int i=0; i<3; i++)
                           {
                               StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                               storage=tokenizer.nextToken();
                               
                                if (storage.equalsIgnoreCase(word))
                                {
                                        count = Integer.parseInt(tokenizer.nextToken());
                                }

                              line = bufRdr.readLine();
                           }
                fileStrm.close();
              }

  catch (IOException e)
     {
      System.out.println(" Error in reading file, IO exception!! ");
     }   
     return count;         
 
  }

/************************************************************
* SUBMODULE: checkLine                                      *
* IMPORT: fileName    (String)                              *
* EXPORT: lineNum (Integer)                                 *
* ASSERTION: counts how many lines are in the file so it    *
*            knows the length of the array for food         *
*                                                           *
**************************************************************/
 
public static int checkLine (String fileName)
{ 
  
int lineNum = 0;
String line;
FileInputStream fileStrm = null;
InputStreamReader rdr; 
BufferedReader bufRdr;

try {

    fileStrm = new FileInputStream (fileName);
    rdr = new InputStreamReader (fileStrm);
    bufRdr = new BufferedReader (rdr);
    
     //reads the fourth line because first three are specs for the storage arrays
    
     line = bufRdr.readLine();
     line = bufRdr.readLine();
     line = bufRdr.readLine();
     line = bufRdr.readLine();

      while (line != null)

             {                
                 lineNum++;   
                 line = bufRdr.readLine() ;
             }

     fileStrm.close();
} 
catch (IOException e)
{
  if (fileStrm != null)
  {
      try
         {
           fileStrm.close(); 
         }
      catch(IOException ex2)
         {
             
         }
  }
  System.out.println("error reading file !!" +e.getMessage());
}

return lineNum;
}

/************************************************************
* SUBMODULE: readFile                                       *
* IMPORT: fileName (String), foodArray (ARRAY OF FoodClass) *
* EXPORT: foodArray (ARRAY OF FoodClass)                    *
* ASSERTION: reads over the file and decides which object   *
*            to create based on the  first column and then  *
*            returns a populated food array                 *
**************************************************************/
 
    
public static FoodClass [] readFile (String fileName, FoodClass [] foodArray)
{ 
  int index = 0; 
  String line;

  try {
        FileInputStream fileStrm = new FileInputStream (fileName);
        InputStreamReader  rdr = new InputStreamReader (fileStrm);
        BufferedReader  bufRdr = new BufferedReader (rdr);
        
        line = bufRdr.readLine();

        while (line != null)
          {
            String tWord =  processString(line);

               if ((tWord.equalsIgnoreCase("Meat")))
                  {
                      //processes the line and extracts each element and parses it depending on the data type 

                      StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                      

                      String iD = tokenizer.nextToken();
                      String name = tokenizer.nextToken();
                      String cut = tokenizer.nextToken();
                      double weight = Double.parseDouble(tokenizer.nextToken());
                      double storageTemp = Double.parseDouble(tokenizer.nextToken());
                      String useBy = tokenizer.nextToken();
                      String packaging = tokenizer.nextToken();
                      
                      StringTokenizer token = new StringTokenizer (useBy, "/"); 
                      int day = Integer.parseInt(token.nextToken()); 
                      int month = Integer.parseInt(token.nextToken());
                      int year = Integer.parseInt(token.nextToken());

                       //creates the date object which was extracted from the file   
                      GregorianCalendar theUseby = new GregorianCalendar(year, month, day); 
                        
                       
                        //validates from reading the file
                        if ((InputValidation.stringValid(name))&&(InputValidation.doubleValid(weight, 0.2, 5.0))&&(InputValidation.validDate(theUseby)))
                        {

                        MeatClass meat = new MeatClass(name, cut, weight, storageTemp, theUseby, packaging); //creation of object using alternate constructor
                        foodArray[(index)] = meat;
                        
                        index++;
                        }
                      }
                      else if((tWord.equalsIgnoreCase("Grain")))
                      {
                              //processes the line and extracts each element and parses it depending on the data type 

                              StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                              String iD = tokenizer.nextToken();
                              String theName = tokenizer.nextToken();
                              String theType = tokenizer.nextToken();
                              double theVolume = Double.parseDouble(tokenizer.nextToken());
                              double storageTemp = Double.parseDouble(tokenizer.nextToken());
                              String bestBefore = tokenizer.nextToken();
                              String packaging = tokenizer.nextToken();

                              StringTokenizer token = new StringTokenizer (bestBefore, "/"); 
                              int day = Integer.parseInt(token.nextToken()); 
                              int month = Integer.parseInt(token.nextToken());
                              int year = Integer.parseInt(token.nextToken());

                              //creates the date object which was extracted from the file 
                              GregorianCalendar theBest = new GregorianCalendar(year, month, day); 

                              //validates from reading the file 
                             if ((InputValidation.stringValid(theName))&&(InputValidation.doubleValid(theVolume, 0.2, 5.0))&&(InputValidation.validDate(theBest)))
                              {
      
                                GrainClass grain = new GrainClass(theName, theType, theVolume, storageTemp, theBest,  packaging); //creates the object from the values retrieved from the file
                                foodArray[(index)] = grain;  //populates the food array 
                                
                                index++;
                              }
                             else 
                             {
                                System.out.println("lara ur error is here"); 
                             }
                          }

                          else if ((tWord.equalsIgnoreCase("Fruit")))
                                  {
                                      //processes the line and extracts each element and parses it depending on the data type 

                                      StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                                      String iD = tokenizer.nextToken();
                                      String theName = tokenizer.nextToken();
                                      String theType = tokenizer.nextToken();
                                      int noPieces = Integer.parseInt(tokenizer.nextToken());
                                      double storageTemp = Double.parseDouble(tokenizer.nextToken());
                                      String useBy =  tokenizer.nextToken();
                                      String packaging = tokenizer.nextToken();

                                      StringTokenizer token = new StringTokenizer (useBy, "/"); 
                                      int day = Integer.parseInt(token.nextToken()); 
                                      int month = Integer.parseInt(token.nextToken());
                                      int year = Integer.parseInt(token.nextToken());
                                      
                                      //creates the date object which was extracted from the file 
                                      GregorianCalendar useByF = new GregorianCalendar(year, month, day); 

                                     //validates from reading the file 
                                     if ((InputValidation.stringValid(theName))&&(InputValidation.intValid(noPieces, 1, 20))&&(InputValidation.validDate(useByF)))
                                     {
                                      FruitClass fruit = new FruitClass(theName, theType, noPieces, storageTemp, useByF, packaging); //creates the object
                                      foodArray[(index)] = fruit; //populates the food array 
                                      
                                      index++;
                                     }
                                  }

                                  else if ((tWord.equalsIgnoreCase("Vegetable")))
                                      {
                                          //processes the line and extracts each element and parses it depending on the data type 

                                          StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                                          String iD = tokenizer.nextToken();
                                          String theName = tokenizer.nextToken();
                                          double theWeight = Double.parseDouble(tokenizer.nextToken());
                                          double storageTemp = Double.parseDouble(tokenizer.nextToken());
                                          String bestBefore = tokenizer.nextToken();
                                          String packaging = tokenizer.nextToken();

                                          StringTokenizer token = new StringTokenizer (bestBefore, "/"); 
                                          int day = Integer.parseInt(token.nextToken()); 
                                          int month = Integer.parseInt(token.nextToken());
                                          int year = Integer.parseInt(token.nextToken());
                                      
                                          //creates the date object which was extracted from the file 
                                          GregorianCalendar theBest = new GregorianCalendar(year, month, day); 

                                          //validates from reading the file 
                                         if ((InputValidation.stringValid(theName))&&(InputValidation.doubleValid(theWeight, 0.2, 5.0))&&(InputValidation.validDate(theBest)))
                                         {
                                          VegetableClass veg = new VegetableClass(theName,theWeight, storageTemp, theBest, packaging); //creates the object
                                          foodArray[(index)] = veg; //populates the food array 
                                          
                                          index++;
                                         }
                                      }

                          line = bufRdr.readLine();
                 
                   }
             
          }

   catch (IOException e)
        {
          System.out.println("error reading file !!");
        }
   return foodArray;
 }

 /************************************************************
* SUBMODULE: processString                                  *
* IMPORT: line (String)                                     *
* EXPORT: stringLine (String)                               *
* ASSERTION: splits first line                              *
*                                                           *
*************************************************************/ 
public static String processString(String line)
{
  String  stringline;
  String [] lineArray = line.split(","); //splits the line and gets the word 
  stringline = lineArray[0];

  return stringline;
}

/************************************************************
* SUBMODULE: writeToFile                                    *
* IMPORT: newArray (ARRAY OF String)                        *
* EXPORT: none                                              *
* ASSERTION: writes the array to a .txt file                *
*                                                           *
*                                                           *
*************************************************************/
public static void writeToFile (StorageClass storage, String fileName)
{
  Scanner sc = new Scanner(System.in);
  FileOutputStream fileStrm = null;
  PrintWriter pw;
  
  FoodClass [][] storageArray = storage.getArray(); //gets array from the storage class 

  try {
        fileStrm = new FileOutputStream(fileName);
        pw = new PrintWriter (fileStrm);
      
      //uses for loop to write to file depending on storage 
      for (int i=0; i< storageArray[0].length; i++)
          {  
            if(storageArray[0][i] != null)
            {
                  pw.println("(Location: Pantry) " +storageArray[0][i].writeOut());
            }
          } 

      for(int i=0; i<storageArray[1].length; i++)
          {
            if(storageArray[1][i] != null)
            {
                  pw.println("(Location: Freezer) " +storageArray[1][i].writeOut());
            }
          }

      for(int i=0; i<storageArray[2].length; i++)
          {
            if(storageArray[2][i] != null)
            {
                  pw.println("(Location: Fridge) " +storageArray[2][i].writeOut());
            }
          }

        pw.close();
    }
    catch (IOException e)
      {
        if (fileStrm != null)
        {
            try
              {
                fileStrm.close();
              }
                catch (IOException ex2)
                    {
                      }
        }
          System.out.println ("error in writing to file: " +e.getMessage());
      }
  }
  
 

}