package com.solovev.model;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Objects;

/**
 * Class describes Plant Object
 */
public class Plant implements Cloneable {
    private String name;
    private String color;
    /**
     * cannot be negative
     */
    private int numberOfBranches;
    /**
     * cannot be negative
     */
    private Period timeOfLife;
    /**
     * cannot be negative
     */
    private BigDecimal price;
    private Size size;
    public Plant() {
    }

    /**
     * @param name name of the plant
     * @param price price of a plant, Cannot be negative
     * @throws IllegalArgumentException if one of values above is negative
     */
    public Plant(String name, BigDecimal price) {
        this.name = name;
        setPrice(price);
    }

    /**
     * Constructor
     *
     * @param name             name of the plant
     * @param color            color of the plant
     * @param numberOfBranches number of branches Cannot be negative
     * @param timeOfLife       time of life of a plant Cannot be negative
     * @param price            price of a plant, Cannot be negative
     * @throws IllegalArgumentException if one of values above is negative
     */
    public Plant(String name, String color, int numberOfBranches, Period timeOfLife, BigDecimal price) {
        this.name = name;
        this.color = color;
        setNumberOfBranches(numberOfBranches);
        setTimeOfLife(timeOfLife);
        setPrice(price);
    }

    /**
     * Method to add price. Add negative value to decrease
     *
     * @param price price to add
     * @throws IllegalArgumentException if new price become negative
     */
    public void addPrice(BigDecimal price) {
        setPrice(this.price.add(price));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    /**
     * @throws IllegalArgumentException if value is negative
     */
    public void setNumberOfBranches(int numberOfBranches) {
        if (numberOfBranches < 0) {
            throw new IllegalArgumentException("Value Cannot be negative");
        }
        this.numberOfBranches = numberOfBranches;
    }

    public Period getTimeOfLife() {
        return timeOfLife;
    }

    /**
     * @throws IllegalArgumentException if value is negative
     */
    public void setTimeOfLife(Period timeOfLife) {
        if (timeOfLife.isNegative()) {
            throw new IllegalArgumentException("Value Cannot be negative");
        }
        this.timeOfLife = timeOfLife;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @throws IllegalArgumentException if value is negative
     */
    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Value Cannot be negative");
        }
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plant plant = (Plant) o;

        if (numberOfBranches != plant.numberOfBranches) return false;
        if (!Objects.equals(name, plant.name)) return false;
        if (!Objects.equals(color, plant.color)) return false;
        if (!Objects.equals(timeOfLife, plant.timeOfLife)) return false;
        if (!Objects.equals(price, plant.price)) return false;
        return Objects.equals(size, plant.size);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + numberOfBranches;
        result = 31 * result + (timeOfLife != null ? timeOfLife.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", numberOfBranches=" + numberOfBranches +
                ", timeOfLife=" + timeOfLife +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
