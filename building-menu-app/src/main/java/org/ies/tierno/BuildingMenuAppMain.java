package org.ies.tierno;

import java.util.Scanner;

public class BuildingMenuAppMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var ownerReader = new OwnerReader(scanner);
        var apartmentReader = new ApartmentReader(scanner, ownerReader);
        var buildingReader = new BuildingReader(scanner, apartmentReader);
        var buildingApp = new BuildingMenuApp(buildingReader, scanner);

        buildingApp.run();
    }
}
