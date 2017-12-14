package pbouda;

import pbouda.modulea.NameProducer;

public class Printer {

    public static void main(String[] args) {
        NameProducer producer = new NameProducer();

        System.out.println("This is my name: " + producer.getName());
    }

}
