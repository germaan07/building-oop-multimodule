package org.ies.tierno;

import org.ies.tierno.model.Building;

import java.util.Scanner;

public class BuildingApp1 {
    private final Scanner scanner;
    private final BuildingReader buildingReader;

    public BuildingApp1(Scanner scanner, BuildingReader buildingReader) {
        this.scanner = scanner;
        this.buildingReader = buildingReader;
    }

    public void run() {
        Building building = buildingReader.read();

        System.out.println("Planta:");
        int floor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Puerta:");
        String door = scanner.nextLine();

        var apartment = building.findApartment(floor, door);
        if (apartment.isEmpty()) {
            System.out.println("No se ha encontrado el apartamento");
        } else {
            apartment.get().showInfo();
        }

        building.showFloorApartments(2);
    }
}
