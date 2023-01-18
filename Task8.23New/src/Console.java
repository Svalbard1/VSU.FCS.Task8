import java.io.FileNotFoundException;
import java.util.Scanner;

public class Console {
    public void start() throws FileNotFoundException {
        String[] nameFiles = readFromConsole();

        String coordinates = Logic.getCoordinates(FileUtils.readFile(nameFiles[0]));

        FileUtils.printToCertainFile(nameFiles[1], coordinates);
    }

    private String[] readFromConsole() {
        Scanner scan = new Scanner(System.in);

        String[] nameFiles = new String[2];

        String[] inputData = scan.nextLine().split(" ");

        if (inputData[0].equals("-i") && inputData[2].equals("-o")) {
            nameFiles[0] = inputData[1];
            nameFiles[1] = inputData[3];

        } else {
            System.out.println("Invalid input");
            System.exit(0);

        }
        return nameFiles;
    }
}
