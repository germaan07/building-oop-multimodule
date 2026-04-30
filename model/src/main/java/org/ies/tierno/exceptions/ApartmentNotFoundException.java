package org.ies.tierno.exceptions;

import org.ies.tierno.model.Apartment;

public class ApartmentNotFoundException extends Exception {
    public final Integer floor;
    public final String door;

    public ApartmentNotFoundException(Integer floor, String door) {
        super("No se ha encontrado el apartamento " + floor + door);
        this.floor = floor;
        this.door = door;
    }
}
