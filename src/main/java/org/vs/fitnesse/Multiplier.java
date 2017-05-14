package org.vs.fitnesse;

import org.springframework.stereotype.Component;

@Component
public class Multiplier {

    public int multiply(int a, int b) {
        return a * b;
    }
}
