package org.ies.tierno;

import java.util.Scanner;

public class BuildingAppMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var ownerReader = new OwnerReader(scanner);
        var apartmentReader = new ApartmentReader(scanner, ownerReader);
        var buildingReader = new BuildingReader(scanner, apartmentReader);
        var buildingApp = new BuildingApp1(scanner, buildingReader);

        buildingApp.run();
    }
}
