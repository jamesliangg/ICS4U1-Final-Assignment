import java.io.IOException; //handles errors
import java.io.BufferedReader; //reading csv
import java.io.FileReader; //reading csv
import java.io.FileNotFoundException; //handles if file can't be read

public class CSV {
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
}
