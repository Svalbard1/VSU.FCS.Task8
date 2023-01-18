import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int[][] readFile(String nameFile) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("InputFiles\\" + nameFile));

        List<int[]> dataInList = new ArrayList<>();

        // Read file
        int rows = 0;
        int columns = 0;
        while (scan.hasNextLine()) {
            String[] dataRowString = scan.nextLine().split(" ");

            rows++;
            columns = dataRowString.length;

            int[] dataRowInt = new int[dataRowString.length];

            int count = 0;
            for (String elements : dataRowString) {
                dataRowInt[count++] = Integer.parseInt(elements);

            }

            dataInList.add(dataRowInt);
        }

        int[][] data = new int[rows][columns];

        int count = 0;
        for (int[] elements : dataInList) {
            data[count++] = elements;
        }

        scan.close();
        return data;
    }

    public static void printToCertainFile(String nameOutputFile, String coordinates) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("OutputFiles\\" + nameOutputFile);

        pw.print(coordinates);

        pw.close();
    }

    public static void printToNonCertainFile(String nameInputFile, String coordinates) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("OutputFiles\\" + getNameOutputFile(nameInputFile));

        pw.print(coordinates);

        pw.close();
    }

    private static String getNameOutputFile(String nameInputFile) {
        String nameOutputFile;

        switch (nameInputFile) {
            case ("InputFiles/input01.txt") -> nameOutputFile = "output01.txt";
            case ("input02.txt") -> nameOutputFile = "output02.txt";
            case ("input03.txt") -> nameOutputFile = "output03.txt";
            case ("input04.txt") -> nameOutputFile = "output04.txt";
            case ("input05.txt") -> nameOutputFile = "output05.txt";
            default -> nameOutputFile = "customOutput.txt";
        }

        return nameOutputFile;
    }
}