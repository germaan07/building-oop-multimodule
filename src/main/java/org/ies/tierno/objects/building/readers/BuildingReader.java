package org.ies.tierno.objects.building.readers;

import org.ies.tierno.objects.building.model.Apartment;
import org.ies.tierno.objects.building.model.Building;

import java.util.Scanner;

public class BuildingReader {
    private final Scanner scanner;
    private final ApartmentReader apartmentReader;

    public BuildingReader(Scanner scanner, ApartmentReader apartmentReader) {
        this.scanner = scanner;
        this.apartmentReader = apartmentReader;
    }

    public Building read() {
        System.out.println("Introduce los datos del edificio");

        System.out.println("Dirección:");
        String address = scanner.nextLine();

        System.out.println("Ciudad:");
        String city = scanner.nextLine();

        System.out.println("¿Cuántos apartamentos tiene?");
        int numApartments = scanner.nextInt();
        scanner.nextLine();

        Apartment[] apartments = new Apartment[numApartments];

        for (int i = 0; i < apartments.length; i++) {
            apartments[i] = apartmentReader.read();
        }

        return new Building(
                address,
                city,
                apartments
        );
    }
}
