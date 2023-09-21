class App{
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.clearConsole();
        //printer.drawEmpty();

        InputManager in = new InputManager();
        in.readChar();
    }
}