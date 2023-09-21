import java.io.IOException;

public class InputManager {

    String readChar(){
        int read = -1;
        try {

            System.out.print("Move: ");
            read = System.in.read();

        } catch (IOException e) {
            System.err.println("I/O Exception");
        }
        
        return translateInput((char) read);
    }

    String translateInput(char input) { 

        String movement = "";
        input = Character.toLowerCase(input);

        switch (input) {
            case 'w':
                movement = "up";
                break;
            case 'a':
                movement = "left";
                break;
            case 's':
                movement = "down";  
                break;
            case 'd':
                movement = "right";
                break;
            case 'q':
                movement = "quit";
            default:
                break;
        }

        return movement;
    }


}
