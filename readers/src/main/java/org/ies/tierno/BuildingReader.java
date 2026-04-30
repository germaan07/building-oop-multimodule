package org.ies.tierno;



import org.ies.tierno.model.Apartment;
import org.ies.tierno.model.Building;

import java.util.ArrayList;
import java.util.List;
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

        List<Apartment> apartments = new ArrayList<>();
        for (int i = 0; i < numApartments; i++) {
            apartments.add(apartmentReader.read());
        }

        return new Building(
                address,
                city,
                apartments
        );
    }
}
