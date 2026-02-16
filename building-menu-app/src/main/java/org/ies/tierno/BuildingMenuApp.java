package org.ies.tierno;

import java.util.Scanner;

public class BuildingMenuApp {
    private final BuildingReader buildingReader;
    private final Scanner scanner;

    public BuildingMenuApp(BuildingReader buildingReader, Scanner scanner) {
        this.buildingReader = buildingReader;
        this.scanner = scanner;
    }

    public void run() {
        Building building = buildingReader.read();

        int opt;
        do {
            opt = chooseOption();
            if (opt == 1) {
                building.showInfo();
            } else if (opt == 2) {
                showFloorApartments(building);
            } else if (opt == 3) {
                showApartmentInfo(building);
            } else if (opt == 4) {
                showApartmentOwners(building);
            }

        } while (opt != 5);
    }

    private void showApartmentOwners(Building building) {
        int floor = askFloor();
        String door = askDoor();

        var owners = building.getApartmentOwners(floor, door);
        if (owners != null) {
            for (var owner : owners) {
                owner.showInfo();
                System.out.println();
            }
        } else {
            System.out.println("No existe el apartamento");
        }
    }

    private void showApartmentInfo(Building building) {
        int floor = askFloor();

        String door = askDoor();

        var apartment = building.findApartment(floor, door);
        if (apartment != null) {
            apartment.showInfo();
            System.out.println();
        } else {
            System.out.println("No existe el apartamento");
        }
    }

    private String askDoor() {
        System.out.println("Puerta:");
        String door = scanner.nextLine();
        return door;
    }

    private void showFloorApartments(Building building) {
        int floor = askFloor();
        building.showFloorApartments(floor);
    }

    private int askFloor() {
        System.out.println("Planta:");
        int floor = scanner.nextInt();
        scanner.nextLine();
        return floor;
    }

    private int chooseOption() {
        System.out.println("Elige una opción:");
        System.out.println("1. Muestra información del edificio");
        System.out.println("2. Muestra apartamentos de planta");
        System.out.println("3. Muestra datos de apartamento");
        System.out.println("4. Muestra propietarios de apartamento");
        System.out.println("5. Salir");
        int opt = scanner.nextInt();
        scanner.nextLine();
        return opt;
    }
}
