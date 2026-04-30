package org.ies.tierno;

import org.ies.tierno.exceptions.ApartmentNotFoundException;
import org.ies.tierno.model.Building;
import org.ies.tierno.model.Owner;

import java.util.Scanner; //

public class BuildingMenuApp {
    private final BuildingReader buildingReader;
    private final Scanner scanner;

    public BuildingMenuApp(BuildingReader buildingReader, Scanner scanner) {
        this.buildingReader = buildingReader;
        this.scanner = scanner;
    }

    public void run() throws ApartmentNotFoundException {
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

    private void showApartmentOwners(Building building) throws ApartmentNotFoundException {
        building.getApartmentOwners(askFloor(), askDoor()).forEach(Owner::showInfo);
    }

    private void showApartmentInfo(Building building) throws ApartmentNotFoundException {
        building.findApartment(askFloor(), askDoor()).showInfo();
    }

    private String askDoor() {
        System.out.println("Puerta:");
        return scanner.nextLine();
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
