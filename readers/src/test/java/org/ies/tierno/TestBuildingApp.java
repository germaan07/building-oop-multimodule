package org.ies.tierno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBuildingApp {
    @Test
    public void Test1(){
        var n = 1;
        var n2 = 2;
        var sum = n + n2;

        Assertions.assertEquals(3, sum);
    }
}
