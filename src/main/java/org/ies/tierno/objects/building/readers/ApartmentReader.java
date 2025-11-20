package org.ies.tierno.objects.building.readers;

import org.ies.tierno.objects.building.model.Apartment;
import org.ies.tierno.objects.building.model.Owner;

import java.util.Scanner;

public class ApartmentReader {
    private final Scanner scanner;
    private final OwnerReader ownerReader;

    public ApartmentReader(Scanner scanner, OwnerReader ownerReader) {
        this.scanner = scanner;
        this.ownerReader = ownerReader;
    }

    public Apartment read() {
        System.out.println("Introduce los datos del apartamento");

        System.out.println("Piso:");
        int floor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Puerta:");
        String door = scanner.nextLine();

        System.out.println("¿Cuántos propietarios tiene?");
        int numOwners = scanner.nextInt();
        scanner.nextLine();

        Owner[] owners = new Owner[numOwners];

        for (int i = 0; i < owners.length; i++) {
            owners[i] = ownerReader.read();
        }

        return new Apartment(
                floor,
                door,
                owners
        );
    }
}
