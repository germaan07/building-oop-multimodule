package org.ies.tierno;

import org.ies.tierno.exceptions.ApartmentNotFoundException;
import org.ies.tierno.model.Building;

import java.util.Scanner;

public class BuildingApp1 {
    private final Scanner scanner;
    private final BuildingReader buildingReader;

    public BuildingApp1(Scanner scanner, BuildingReader buildingReader) {
        this.scanner = scanner;
        this.buildingReader = buildingReader;
    }

    public void run() throws ApartmentNotFoundException {
        Building building = buildingReader.read();

        System.out.println("Planta:");
        int floor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Puerta:");
        String door = scanner.nextLine();

        building.findApartment(floor, door).showInfo();

        building.showFloorApartments(2);
    }
}
