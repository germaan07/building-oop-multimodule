package org.ies.tierno;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Building {
    private String address;
    private String city;
    private Apartment[] apartments;



    public Apartment findApartment(int floor, String door) {
        for (var apartment : apartments) {
            if (apartment.getFloor() == floor && apartment.getDoor().equals(door)) {
                return apartment;
            }
        }
        return null;
    }

    public Integer countApartmentOwners(int floor, String door) {
        var apartment = findApartment(floor, door);
        if (apartment != null) {
            return apartment.getOwners().length;
        } else {
            return null;
        }
    }

    public void showFloorApartments(int floor) {
        for (var apartment : apartments) {
            if (apartment.getFloor() == floor) {
                apartment.showInfo();
                System.out.println();
            }
        }
    }

    public Owner[] getApartmentOwners(int floor, String door) {
        var apartment = findApartment(floor, door);
        if (apartment != null) {
            return apartment.getOwners();
        } else {
            return null;
        }
    }

    public void showInfo() {
        System.out.println("Edificio " + address + ", " + city);
        for (var apartment : apartments) {
            apartment.showInfo();
            System.out.println();
        }
    }
}
