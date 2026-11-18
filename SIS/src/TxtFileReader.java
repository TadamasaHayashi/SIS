import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class TxtFileReader {
    static ArrayList<Student> Directory = new ArrayList<Student>();


        try (FileWriter writer = new FileWriter("data.txt")) 
        {
            writer.write(data);
        } 
        //AI
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        try 
        {
            chooseTheme();
        } 
        //AI
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        //AI
    }
    public static void chooseTheme() throws IOException 
    {
        try (Scanner myFile = new Scanner(new File("data.txt"))) 
        {
            while (myFile.hasNextLine()) {
                String line = myFile.nextLine();
                String[] parts = line.split(" ");
                Student student = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]
                );
                Directory.add(student);
            }
        }
    }
}
