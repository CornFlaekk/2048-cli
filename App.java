class App{

    static Printer printer = new Printer();
    static GameLogic game = new GameLogic();
    static InputManager in = new InputManager();
    public static void main(String[] args) {
        
        gameCycle();
        gameCycle();
        
    }

    static void gameCycle(){
        printer.updateValues(game);
        printer.clearConsole();
        printer.drawGame();

        String str = in.readChar();
        game.movement(str);


    }
}