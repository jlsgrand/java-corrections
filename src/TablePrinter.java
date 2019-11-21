public class TablePrinter {

    private final static String[][] STANDARD_DELIMITERS = {{"┏", "┳", "┓"}, {"┣", "╋", "┫"}, {"┗", "┻", "┛"}};

    public static void printMultiplyTable(int[][] multiplyTable) {

        // Table size declaration
        int tableHeight = multiplyTable.length;
        int tableWidth;

        if (tableHeight <= 0) {
            return;
        } else {
            tableWidth = multiplyTable[tableHeight - 1].length;
        }

        // max number character number count (to know column width)

        int maxNumber = multiplyTable[multiplyTable.length - 1][multiplyTable[tableHeight - 1].length - 1];
        int maxNumberLength = Integer.toString(maxNumber).length();

        int columnWidth = 4 + maxNumberLength;

        // string array declaration (2 times multiply_table height + 1)
        String[] linesToPrint = new String[tableHeight * 2 + 1];

        int multiplyLineCounter = 0;
        for (int lineCounter = 0; lineCounter < tableHeight * 2 + 1; lineCounter++) {
            linesToPrint[lineCounter] = "";
            int multiplyColCounter = 0;

            // if even line, it is a delimiter line
            if (lineCounter % 2 == 0) {

                String[] lineDelimiters;

                if (lineCounter == 0) {
                    lineDelimiters = STANDARD_DELIMITERS[0];
                } else if (lineCounter == tableHeight * 2) {
                    lineDelimiters = STANDARD_DELIMITERS[2];
                } else {
                    lineDelimiters = STANDARD_DELIMITERS[1];
                }

                linesToPrint[lineCounter] = getDelimiterLine(lineDelimiters, tableWidth, columnWidth);

            } else {
                for (int colCounter = 0; colCounter < tableWidth; colCounter++) {
                    int numberToPrint = multiplyTable[multiplyLineCounter][multiplyColCounter];
                    linesToPrint[lineCounter] += String.format("| %" + maxNumberLength + "d ", numberToPrint);
                    multiplyColCounter++;
                }
                linesToPrint[lineCounter] += "|";
                multiplyLineCounter++;
            }
        }
        for (String lineToPrint : linesToPrint) {
            System.out.println(lineToPrint);
        }
    }

    private static String getDelimiterLine(String[] lineDelimiters, int tableWidth, int columnWidth) {
        String delimiterLine = "";
        for (int colCounter = 0; colCounter < tableWidth + 1; colCounter++) {
            if (colCounter == 0) {
                delimiterLine += lineDelimiters[0];
            } else if (colCounter == tableWidth) {
                delimiterLine += lineDelimiters[2];
            } else {
                delimiterLine += lineDelimiters[1];
            }

            for (int colWidthCounter = 0; colCounter < tableWidth && colWidthCounter < columnWidth - 2; colWidthCounter++) {
                delimiterLine += "-";
            }
        }

        return delimiterLine;
    }
}
