package org.ies.tierno.objects.building.model;

import java.util.Arrays;
import java.util.Objects;

public class Building {
    private String address;
    private String city;
    private Apartment[] apartments;

    public Building(String address, String city, Apartment[] apartments) {
        this.address = address;
        this.city = city;
        this.apartments = apartments;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(address, building.address) && Objects.equals(city, building.city) && Objects.deepEquals(apartments, building.apartments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, Arrays.hashCode(apartments));
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", apartments=" + Arrays.toString(apartments) +
                '}';
    }
}
