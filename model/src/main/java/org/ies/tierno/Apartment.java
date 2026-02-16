package org.ies.tierno;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Apartment {
    private int floor;
    private String door;
    private Owner[] owners;



    public void showInfo() {
        System.out.print("Apartamento " + floor + door + ". Propietarios: ");
        for (var owner: owners) {
            owner.showInfo();
            System.out.print(", ");
        }
    }
}
