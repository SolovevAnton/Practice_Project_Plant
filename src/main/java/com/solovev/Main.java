package com.solovev;

import com.solovev.model.Garden;
import com.solovev.model.Plant;
import com.solovev.model.Size;

import java.math.BigDecimal;
import java.time.Period;
import java.util.List;
import java.util.Optional;

// Questions:
// In garden
public class Main {

    /**
     * Method to test code
     * Prints if test have passed or failed
     * if match test prints match, if not prints fails and show both results
     * @param name name of the test
     * @param expected expected result
     * @param result   real outcome
     */
    static <T> void test(String name, T expected, T result) {
        if (expected == null && result == null || expected.equals(result)) {
            System.out.println("Test: " + name + " success");
        } else {
            System.err.printf("Test: %s failed; Expected:%s Got: %s\n", name, expected, result);
        }
    }
    public static void main(String[] args) {
        Plant fullPlant = new Plant(
                "ToCopy",
                "Green",
                3,
                Period.ofDays(9),
                BigDecimal.TEN);

        Size sizeEmpty = new Size();
        Size size = new Size(2,3);
        fullPlant.setSize(size);

        List<Plant> plants = List.of(
                new Plant(),
                new Plant("10 eu", BigDecimal.TEN),
                fullPlant,
                new Plant(fullPlant),
                fullPlant.clone()
                );
        //test for plants
        fullPlant.addPrice(BigDecimal.TWO);
        fullPlant.setSize(new Size(sizeEmpty));

        Garden gardenEmpty = new Garden(0);
        Garden garden = new Garden(plants.size());
        plants.forEach(garden :: addPlant);

        test("add1", false, garden.addPlant(fullPlant));
        test("add2", false, gardenEmpty.addPlant(fullPlant));

        test("delete1", new Plant(), garden.delete(new Plant().getName()).get());
        test("delete2", Optional.empty(), garden.delete(new Plant().getName()));
       // System.out.println(garden);
        test("Insert1",true, garden.insert(new Plant(),0));
        garden.delete(new Plant());

        test("Insert2",true, garden.insert(new Plant(), garden.count()-1));
        test("Insert2",false, garden.insert(new Plant(), garden.count()-1));
        System.out.println(garden);



    }
}