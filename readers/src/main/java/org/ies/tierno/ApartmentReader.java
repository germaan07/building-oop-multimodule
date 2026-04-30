package org.ies.tierno;

import org.ies.tierno.model.Apartment;
import org.ies.tierno.model.Owner;

import java.util.ArrayList;
import java.util.List;
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

        List<Owner> owners = new ArrayList<>();

        for (int i = 0; i < numOwners; i++) {
            owners.add(ownerReader.read());
        }

        return new Apartment(
                floor,
                door,
                owners
        );
    }
}
