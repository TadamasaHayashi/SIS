import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class TxtFileReader
	{
		public static void main(String[] args) 
			{
			String students = Files.readString(Path.of("TxtFile.txt"));
			System.out.println(students);
			}
	}
