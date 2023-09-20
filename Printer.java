public class Printer {
    int arrayLength = 4;
    int arrayHeight = 4;
    int[][] valueArray;
    String emptyLine = "---------------------------------"; // 33 '-'

    public Printer() {
        valueArray = new int[arrayLength][arrayHeight];
        fillArray();
    }

    void fillArray() {
        for (int length = 0; length < arrayLength; length++) {
            for (int height = 0; height < arrayHeight; height++) {
                valueArray[length][height] = Math.round((int)(Math.random()*2048));
            }
        }

    }

    public void clearConsole() {
        System.out.println(System.lineSeparator().repeat(50));
    }

    void drawEmpty() {
        System.out.println(emptyLine);
        for (int i = 0; i < arrayHeight; i++) {
            drawNumberLine(i);
            System.out.println("\n" + emptyLine);
        }

    }

    void drawNumberLine(int lineHeight){
        System.out.print("|");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print((valueArray[i][lineHeight]<100) ? "   " : "  ");       //If number ocuppies 3 or 4 characters reduce left margin to 'center' the number in its cell.
            System.out.print(valueArray[i][lineHeight] + "\t|");
        }
    }
}
