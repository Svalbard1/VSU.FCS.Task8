import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //SwingUtilities.invokeLater(() -> new WindowApplication().setVisible(true));

        Console console = new Console();
        console.start();
    }
}