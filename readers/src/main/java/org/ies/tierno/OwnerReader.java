package org.ies.tierno;


import java.util.Scanner;

public class OwnerReader {
    private final Scanner scanner;

    public OwnerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Owner read() {
        System.out.println("Introduce los datos del propietario");
        System.out.println("NIF:");
        String nif = scanner.nextLine();

        System.out.println("Nombre:");
        String name = scanner.nextLine();

        System.out.println("Apellidos:");
        String surname = scanner.nextLine();

        return new Owner(
                nif,
                name,
                surname
        );
    }
}
