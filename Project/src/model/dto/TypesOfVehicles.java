package model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class TypesOfVehicles {
    private  static ArrayList<String> vehicleLists = new ArrayList<String>(Arrays.asList("아반테", "소나타", "그랜져"));

    public void setOptionList(String vehicle) {
        vehicleLists.add(vehicle);
    }

    public static void printTypesOfVehicles() {
        System.out.println("------------");
        System.out.println("| 차종 List |");
        System.out.println("------------");
        for (int i = 0; i < vehicleLists.size(); i++) {
            if (i == vehicleLists.size() -1)
                System.out.print(vehicleLists.get(i) + "\n");
            else
                System.out.print(vehicleLists.get(i) + ", ");
        }

    }
}
