public class Main {

    public static void main(String[] args) {
        int[] intArray = {1, 5, 8, 9, 34, -34, 6783, 34, 435, 23, 1};
        System.out.println(maxValArray(intArray));

        String[] stringArray = {"Jules", "Bernard", "Jonathan", "Anticonsitutionnellement", "Java"};
        System.out.println(maxStringLengthArray(stringArray));

        int[][] multiplyTable = getMultiplyTable(5, 7);

        TablePrinter.printMultiplyTable(multiplyTable);
        TablePrinter.printMultiplyTable(getMultiplyTable(11, 7));
        TablePrinter.printMultiplyTable(getMultiplyTable(23, 5));
        TablePrinter.printMultiplyTable(getMultiplyTable(3, 70));

    }

    // 1D - nombres
    // Écrire un programme qui permette d'afficher la valeur maximale d'un tableau de nombres.
    private static int maxValArray(int[] array) {
        int maxVal = 0;
        for (int i = 0, length = array.length; i < length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }

    // 1D - caractères
    // Chaînes de caractères: Écrire un programme qui permette d'afficher la taille de la chaîne de caractères la plus longue d'un tableau de chaînes de caractères.
    private static int maxStringLengthArray(String[] array) {
        int maxStringLength = 0;
        for (int i = 0, length = array.length; i < length; i++) {
            if (array[i].length() > maxStringLength) {
                maxStringLength = array[i].length();
            }
        }
        return maxStringLength;
    }

    // Multiplication
    private static int[][] getMultiplyTable(int heigth, int width) {
        int[][] multiplyTable = new int[heigth][width];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                multiplyTable[i][j] = (i + 1) * (j + 1);
            }
        }

        return multiplyTable;
    }

}
