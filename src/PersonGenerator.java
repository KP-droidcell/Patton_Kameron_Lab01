import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator
{

    public static void main(String[] args)
    {
        ArrayList<String> recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.txt");

        boolean doneInput = false;
        String ID = "";
        String fName = "";
        String lName = "";
        String title = "";
        String rec = "";
        int yob = 0;

        do
        {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID 000001");
            fName = SafeInput.getNonZeroLenString(in, "Enter your First Name");
            lName = SafeInput.getNonZeroLenString(in, "Enter your Last Name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            yob = SafeInput.getRangedInt(in,"Enter the year of your Birth", 1940, 2010 );

            rec = ID + ", " + fName + ", " + lName  + ", " + title + ", " + yob;

            System.out.println(rec);

            recs.add(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done?");

        }while(!doneInput);

        for (String p: recs)
            System.out.println(p);

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(String r : recs)
            {
                writer.write(r, 0, r.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
