package src.main.java;

public class Util {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void printErrorMsg(String errorMsg) {
        System.out.println(errorMsg);
    }

    public static boolean stringChecking(String userInput) {
        if (userInput.equals("quit") || userInput.equals("q")) {
            return true;
        }

        if (userInput.length() < 5 || userInput.length() > 7) {
            Util.printErrorMsg("Wrong userinput");
            return false;
        }

        String[] separateUserinputs = userInput.split("\\s");

        if (separateUserinputs.length < 2) {
            Util.printErrorMsg("You must separated the two coordinates by SPACE");
            return false;
        }
        if (separateUserinputs[0].length() != 2 && separateUserinputs[0].length() != 3) {
            Util.printErrorMsg("Invalid coordinates");
            return false;
        } else if (separateUserinputs[1].length() != 2 && separateUserinputs[1].length() != 3) {
            Util.printErrorMsg("Invalid coordinates");
            return false;
        }


        for (int i = 0; i < separateUserinputs.length; i++) {
            for (int j = 0; j < separateUserinputs[i].length(); j++) {
                char c = separateUserinputs[i].charAt(j);
                if (j == 0) {
                    if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                        Util.printErrorMsg("The First coordinate letter is wrong");
                        return false;
                    }
                } else {
                    if (!(c >= '0' && c <= '9')) {
                        if (j == 1) {
                            Util.printErrorMsg("The Second coordinate letter is wrong");
                        } else {
                            Util.printErrorMsg("The Third coordinate letter is wrong");
                        }

                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] UserCoordToArrayCoord(String coordinata) {
        int[] arrayCoordinates = new int[4];
        String[] separateUserinputs = coordinata.toUpperCase().split("\\s");

        arrayCoordinates[0] = separateUserinputs[0].charAt(0) - 65;
        arrayCoordinates[1] = Integer.parseInt(separateUserinputs[0].substring(1)) - 1;
        arrayCoordinates[2] = separateUserinputs[1].charAt(0) - 65;
        arrayCoordinates[3] = Integer.parseInt(separateUserinputs[1].substring(1)) - 1;


        return arrayCoordinates;
    }
}
