public class GameLogic {
    int[][] valueArray;
    int arrayLength = 4;
    int arrayHeight = 4;
    int[] possibleValues = { 0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };
    InputManager inputManager = new InputManager();

    public GameLogic() {
        valueArray = new int[arrayLength][arrayHeight];
        fillArrayStart();
    }

    /**
     * Put 2 2's in 2 random cells
     */
    void fillArrayStart() {
        int randl = (int) Math.round(Math.random() * (arrayLength - 1));
        int randh = (int) Math.round(Math.random() * (arrayHeight - 1));
        valueArray[randl][randh] = 2;

        while (valueArray[randl][randh] == 2) {
            randl = (int) Math.round(Math.random() * (arrayLength - 1));
            randh = (int) Math.round(Math.random() * (arrayHeight - 1));
        }
        valueArray[randl][randh] = 2;

    }

    /**
     * Fill array with random values. Used for testing
     */
    void fillArrayRandom() {
        for (int length = 0; length < arrayLength; length++) {
            for (int height = 0; height < arrayHeight; height++) {
                valueArray[length][height] = possibleValues[(int) Math.round(Math.random() * 10)];
            }
        }
    }

    /**
     * Handle action read by user input and redirect to specific function
     * 
     * @param direction
     */
    void movement(String direction) {
        switch (direction) {
            case "up":
                movement_up();
                break;
            case "down":
                movement_down();
                break;
            case "right":
                movement_right();
                break;
            case "left":
                movement_left();
                break;
            default:
                break;
        }
    }

    void movement_up() {
        for (int height = 1; height < arrayHeight; height++) {
            for (int length = 0; length < arrayLength; length++) {
                if (valueArray[length][height] != 0) {
                    int x = length;
                    int y = height;
                    boolean up_stop = false;
                    boolean merge = false;

                    while (y != 0 && !up_stop) {
                        y--;
                        if (valueArray[x][y] != 0) {
                            if (valueArray[x][y] == valueArray[length][height]) {
                                merge = true;
                            }
                            up_stop = true;
                            y++;
                        }
                    }
                    if (merge) {
                        valueArray[x][y - 1] = (valueArray[x][y - 1]) * 2;
                        valueArray[length][height] = 0;
                    } else if (x != length || y != height) {
                        valueArray[x][y] = valueArray[length][height];
                        valueArray[length][height] = 0;
                    }

                }
            }
        }
    }

    void movement_down() {
        for (int height = arrayHeight-1; height >= 0; height--) {        //From 2 to 0
            for (int length = 0; length < arrayLength; length++) {
                if (valueArray[length][height] != 0) {
                    int x = length;
                    int y = height;
                    boolean down_stop = false;
                    boolean merge = false;

                    while (y != 3 && !down_stop) {
                        y++;
                        if (valueArray[x][y] != 0) {
                            if (valueArray[x][y] == valueArray[length][height]) {
                                merge = true;
                            }
                            down_stop = true;
                            y--;
                        }
                    }
                    if (merge) {
                        valueArray[x][y + 1] = (valueArray[x][y + 1]) * 2;
                        valueArray[length][height] = 0;
                    } else if (x != length || y != height) {
                        valueArray[x][y] = valueArray[length][height];
                        valueArray[length][height] = 0;
                    }

                }
            }
        }
    }

    void movement_right() {
        for (int length = 0; length < arrayLength-1; length++) {
            for (int height = 0; height < arrayHeight; height++) {
                if (valueArray[length][height] != 0) {
                    int x = length;
                    int y = height;
                    boolean right_stop = false;
                    boolean merge = false;

                    while (x != 3 && !right_stop) {
                        x++;
                        if (valueArray[x][y] != 0) {
                            if (valueArray[x][y] == valueArray[length][height]) {
                                merge = true;
                            }
                            right_stop = true;
                            x--;
                        }
                    }
                    if (merge) {
                        valueArray[x + 1][y] = (valueArray[x + 1][y]) * 2;
                        valueArray[length][height] = 0;
                    } else if (x != length || y != height) {
                        valueArray[x][y] = valueArray[length][height];
                        valueArray[length][height] = 0;
                    }

                }
            }
        }
    }

    void movement_left() {
        for (int length = arrayLength -1; length > 0; length--) {
            for (int height = 0; height < arrayHeight; height++) {
                if (valueArray[length][height] != 0) {
                    int x = length;
                    int y = height;
                    boolean left_stop = false;
                    boolean merge = false;

                    while (x != 0 && !left_stop) {
                        x--;
                        if (valueArray[x][y] != 0) {
                            if (valueArray[x][y] == valueArray[length][height]) {
                                merge = true;
                            }
                            left_stop = true;
                            x++;
                        }
                    }
                    if (merge) {
                        valueArray[x - 1][y] = (valueArray[x - 1][y]) * 2;
                        valueArray[length][height] = 0;
                    } else if (x != length || y != height) {
                        valueArray[x][y] = valueArray[length][height];
                        valueArray[length][height] = 0;
                    }

                }
            }
        }
    }

    

}
