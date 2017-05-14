package org.vs.fitnesse;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiplyFixture {

    private static AutowireCapableBeanFactory context;
    private Multiplier multiplier;

    static {
        System.out.println("inside MultiplyFixture static block");
        context = new ClassPathXmlApplicationContext("/applicationContext-test.xml").getAutowireCapableBeanFactory();
    }

    public MultiplyFixture() {
        System.out.println("inside MultiplyFixture constructor");
        multiplier = context.getBean(Multiplier.class);
    }

    public static void main(String[] args) {
        MultiplyFixture fixture = new MultiplyFixture();
        fixture.a = 3;
        fixture.b = 4;
        fixture.execute();
        System.out.println(fixture.c());
    }

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
        this.c = multiplier.multiply(a, b);
    }

    public int c() {
        return this.c;
    }

}
