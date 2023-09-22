class App{

    static Printer printer = new Printer();
    static GameLogic game = new GameLogic();
    static InputManager in = new InputManager();
    public static void main(String[] args) {
        
        while(true){
            gameCycle();
        }
        
    }

    static void gameCycle(){
        
        printer.clearConsole();
        printer.updateValues(game.getValueArray());
        printer.drawGame();

        game.movement(in.readChar());

    }
}