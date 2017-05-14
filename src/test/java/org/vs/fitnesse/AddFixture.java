package org.vs.fitnesse;

import org.vs.Adder;

public class AddFixture {

    private int a;
    private int b;
    private int c;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void execute() { // executed after each table row
        this.c = new Adder().add(a, b);
    }

    public int c() {
        return this.c;
    }
}
