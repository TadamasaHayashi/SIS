import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class TxtFileReader 
{
	public static void readTextFile() throws IOException
	{
	Scanner file = new Scanner(new File("StudentsList.txt"));
	while (file.hasNext())
		{
		String line = file.nextLine();
		// add studet objec tot array 
		//student object holds everything else
		ArrayList<Student> students = new ArrayList<>();	
		students.add(null);
		}
	}
	
}