package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;



@Data
@AllArgsConstructor
public class Apartment {
    private int floor;
    private String door;
    private List<Owner> owners;



    public void showInfo() {
        System.out.println("Apartamento " + floor + door + ".");
        System.out.println("Propietarios: ");
        owners.forEach(Owner::showInfo);

    }
}
