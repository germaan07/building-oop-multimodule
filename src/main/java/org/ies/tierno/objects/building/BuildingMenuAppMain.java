package org.ies.tierno.objects.building;

import org.ies.tierno.objects.building.app.BuildingMenuApp;
import org.ies.tierno.objects.building.readers.ApartmentReader;
import org.ies.tierno.objects.building.readers.BuildingReader;
import org.ies.tierno.objects.building.readers.OwnerReader;

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
