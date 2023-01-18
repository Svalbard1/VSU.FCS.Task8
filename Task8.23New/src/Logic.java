import java.util.ArrayList;
import java.util.List;

public class Logic {
    private static List<Integer> solve(int[][] arr) {
        List<Integer> coordinates = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (isTrueSquare(arr[i], arr[i + 1], j)) {
                    coordinates.add(i);
                    coordinates.add(j);
                }
            }
        }

        return coordinates;
    }

    public static String getCoordinates(int[][] arr) {
        StringBuilder sb = new StringBuilder();

        List<Integer> coordinates = solve(arr);

        for (int i = 0; i < coordinates.size() - 1; i += 2) {
            sb.append("(R: ").append(coordinates.get(i)).append(", C: ").append(coordinates.get(i + 1)).append("), ");
        }

        if (sb != null) {
            return sb.substring(0, sb.length() - 2);

        } else {
            return "Координаты не найдены.";
        }
    }

    private static boolean isTrueSquare(int[] firstArray, int[] secondArray, int index) {
        boolean isTrueSquare = true;

        int value = firstArray[index];
        for (int i = index; i <= index + 1; i++) {
            if (firstArray[i] != value || secondArray[i] != value) {
                isTrueSquare = false;
                break;
            }
        }

        return isTrueSquare;
    }
}