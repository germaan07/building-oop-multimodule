package org.ies.tierno;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Owner {
    private String nif;
    private String name;
    private String surname;

    public void showInfo() {
        System.out.print(surname + ", " + name + " (" + nif + ")");
    }
}
