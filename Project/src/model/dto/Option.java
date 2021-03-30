package model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class Option {
    private static ArrayList<String> colorLists = new ArrayList<String> (Arrays.asList("red", "blue", "black"));
    private static String[] gearType = {"auto", "stick"};
    private static int[] cntDoor = {1, 2, 3, 4, 5, 6, 7, 8};

    public void setOptionList(String color) {
        colorLists.add(color);
    }

    public static void printOptionList() {

        System.out.println("--------------");
        System.out.println("| color List |");
        System.out.println("--------------");
        for (int i = 0; i < colorLists.size(); i++) {
            if (i == colorLists.size() -1)
                System.out.println(colorLists.get(i) + "\n");
            else
                System.out.print(colorLists.get(i) + ", ");
        }

        System.out.println("-----------------");
        System.out.println("| gearType List |");
        System.out.println("-----------------");
        for (int i = 0; i < gearType.length; i++) {
            if (i == gearType.length -1)
                System.out.println(gearType[i] + "\n");
            else
                System.out.print(gearType[i] + ", ");
        }

        System.out.println("----------------");
        System.out.println("| cntDoor List |");
        System.out.println("----------------");
        for (int i = 0; i < cntDoor.length; i++) {
            if (i == cntDoor.length -1)
                System.out.println(cntDoor[i] + "\n");
            else
                System.out.print(cntDoor[i] + ", ");
        }

    }
}
