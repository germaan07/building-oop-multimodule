package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.exceptions.ApartmentNotFoundException;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class Building {
    private String address;
    private String city;
    private List<Apartment> apartments;



    public Apartment findApartment(int floor, String door) throws ApartmentNotFoundException {
        return apartments.stream()
                .filter(apartment -> apartment.getFloor() == floor && apartment.getDoor().equalsIgnoreCase(door))
                .findFirst()
                .orElseThrow(() -> new ApartmentNotFoundException(floor, door));
    }

    public Integer countApartmentOwners(int floor, String door) throws ApartmentNotFoundException {
        return findApartment(floor, door).getOwners().size();
    }

    public void showFloorApartments(int floor) {
        apartments.stream()
                .filter(apartment -> apartment.getFloor() == floor)
                .forEach(Apartment::showInfo);
    }

    public List<Owner> getApartmentOwners(int floor, String door) throws ApartmentNotFoundException {
        return findApartment(floor, door).getOwners();
    }

    public void showInfo() {
        System.out.println("Edificio " + address + ", " + city);
        apartments.forEach(Apartment::showInfo);
        System.out.println();
    }
}
