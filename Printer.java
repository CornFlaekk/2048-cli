public class Printer {
    int arrayLength = 4;
    int arrayHeight = 4;
    int[][] valueArray;
    int[] possibleValues = {0,2,4,8,16,32,64,128,256,512,1024};
    String emptyLine = "---------------------------------"; // 33 '-'
    String ANSI_GREEN_BG = "\u001B[42m";
    String ANSI_GREEN_FG = "\u001B[32m";
    String ANSI_RESET = "\u001B[0m";

    public Printer() {
        valueArray = new int[arrayLength][arrayHeight];
        fillArray();
    }

    void fillArray() {
        for (int length = 0; length < arrayLength; length++) {
            for (int height = 0; height < arrayHeight; height++) {
                valueArray[length][height] = possibleValues[(int) Math.round(Math.random()*10)];
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
            printNumberString(lineHeight, i);
            System.out.print("|");
        }
    }

    void printNumberString(int numHeight, int numWidth) {
        
        int number = valueArray[numWidth][numHeight];
        String res = new String();

        if (number < 100) {
            res += "   " + number;
        } else {
            res += "  " + number;
        }

        while (res.length() < 7) {
            res += " ";
        }

        String ansi_color = new String();

        switch (number) {
            case 2:
                ansi_color = "\u001b[48;5;1m";
                break;
            case 4:
                ansi_color = "\u001b[48;5;2m";
                break;
            case 8:
                ansi_color = "\u001b[48;5;3m";
                break;
            case 16:
                ansi_color = "\u001b[48;5;4m";
                break;
            case 32:
                ansi_color = "\u001b[48;5;5m";
                break;
            case 64:
                ansi_color = "\u001b[48;5;6m";
                break;
            case 128:
                ansi_color = "\u001b[48;5;7m";
                break;
            case 256:
                ansi_color = "\u001b[48;5;8m";
                break;
            case 512:
                ansi_color = "\u001b[48;5;9m";
                break;
            case 1024:
                ansi_color = "\u001b[48;5;0m";
                break;
        
            default:
                res = "       ";    //In case value = 0 show as blank
                break;
        }
        System.out.print(ansi_color + res + ANSI_RESET);

    }
}