package rssNewsBias;
import java.io.IOException; //handles errors
import java.io.BufferedReader; //reading csv
import java.io.FileReader; //reading csv
import java.io.FileNotFoundException; //handles if file can't be read

/**
 * The CSV program works with .csv files and returns different options
 * depending on what was examined.
 * 
 * @author James Liang
 * @version 1.0
 * @since 2022-01-06
 */
public class CSV {
  /**
   * This method takes in the .csv file and sets the parameter array's
   * values to those of the .csv file.
   * 
   * @param file      This is the .csv file that is being examined
   * @param csvArray  This is the array that is being modified
   * @return String[] This is the modified array
   * @throws IOException
   */
    public static String[] csvToArray(String file, String[] csvArray) throws IOException {
		try{
			//reads from the file
            BufferedReader infile = new BufferedReader (new FileReader(file));
			String line;
			System.out.println("Beginning to read the file now:");
            //set line to the contents of the file
			line=infile.readLine();
            int lineNum = 0;
            //checks to ensure there is a value on the line
			while (line!=null){
                //splits contents and turns it into array elements
                // String data[]=line.split(",");
                csvArray[lineNum] = line;
                //goes to the next line
				line=infile.readLine();
                lineNum++;
			}
			System.out.println("Closing file.");
			infile.close();
		}catch (FileNotFoundException e){
			System.out.println("Incorrect filename or location. Please verify path and filename. ");
		}
    return csvArray;
  }
  /**
   * This method takes in the .csv file and finds the amount of rows it has
   * 
   * @param file  This is the .csv file that is being examined
   * @return int  This is the number of rows
   * @throws IOException
   */
  public static int csvSize(String file) throws IOException {
    int lineNum = 0;
    try{
        //reads from the file
        BufferedReader infile = new BufferedReader (new FileReader(file));
        String line;
        System.out.println("Beginning to read the file now:");
        //set line to the contents of the file
        line=infile.readLine();
        while (line!=null){
            //goes to the next line
            line=infile.readLine();
            lineNum++;
        }
        System.out.println("Closing file.");
        infile.close();
    }catch (FileNotFoundException e){
        System.out.println("Incorrect filename or location. Please verify path and filename. ");
    }
    return lineNum;
    }
    /**
     * This method takes in the .csv file and sets the parameter array's
     * values to those of the .csv file.
     * 
     * @param file        This is the .csv file that is being examined
     * @param csvArray    This is the array that is being modified
     * @return String[][] This is the modified array
     * @throws IOException
     */
    public static String[][] csvToArray(String file, String[][] csvArray) throws IOException {
		try
    {
			//reads from the file
      BufferedReader infile = new BufferedReader (new FileReader(file));

			String line;
			System.out.println("Beginning to read the file now:");
      //set line to the contents of the file
			line=infile.readLine();

      int lineNum = 0;
      //checks to ensure there is a value on the line
			while (line!=null)
      {
				//splits contents and turns it into array elements
        String data[]=line.split(",");
        //converting the 1D array into a 2D array
        for (int i=0;i<data.length;i++)
        {
          if (i == 0)
          csvArray[lineNum][0] = data[i];
          else if (i == 1)
          csvArray[lineNum][1] = data[i];
        }
        //goes to the next line
				line=infile.readLine();
        lineNum++;
			}
			System.out.println("Closing file.");
			infile.close();
      
		}catch (FileNotFoundException e)
    {
			System.out.println("Incorrect filename or location. Please verify path and filename. ");
		}
    return csvArray;
  }
}
