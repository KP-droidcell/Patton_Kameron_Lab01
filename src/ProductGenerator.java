import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<String> recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        boolean doneInput = false;
        String ID = "";
        String Name = "";
        String Description = "";
        Double Cost;
        String rec = "";
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the item ID 000001");
            Name = SafeInput.getNonZeroLenString(in, "Enter the Item Name");
            Description = SafeInput.getNonZeroLenString(in, "Enter the Item Description");
            Cost = SafeInput.getRangedDouble(in, "Enter the Price of the Item", 0, 9999);

            rec = ID + ", " + Name + ", " + Description + ", " + ", " + Cost;

            System.out.println(rec);

            recs.add(rec);

            doneInput = SafeInput.getYNConfirm(in, "Are you done?");

        } while (!doneInput);

        for (String p : recs)
            System.out.println(p);

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for (String r : recs) {
                writer.write(r, 0, r.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
