package com.solovev.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Garden {
    private Plant[] plants;
    /**
     * Index shows how much not null elements there are in plants
     */
    private int fillIndex;

    /**
     * @param numberOfPlants number of plants in garden; can't be negative
     */
    public Garden(int numberOfPlants) {
        plants = new Plant[numberOfPlants];
    }

    /**
     * Adds plant to the garden
     *
     * @param plant plant to add
     * @return true if successfully added, false otherwise
     */
    public boolean addPlant(Plant plant) {
        if (fillIndex < plants.length) {
            plants[fillIndex++] = plant;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets plant by index
     *
     * @param index index to get plant from
     * @return Plant corresponding to index, or null if index is incorrect
     */
    public Plant get(int index) {
        return index < plants.length && index >= 0 ? plants[index] : null;
    }

    /**
     * @return number of non-null plants in  plants
     */
    public int count() {
        return fillIndex;
    }

    /**
     * Method to search for a Plant by name
     *
     * @param name - name of the plant to search
     * @return - Optional of a first found plant with this name, or empty optional, if there is none
     */
    public Optional<Plant> search(String name) {
        return Arrays
                .stream(plants)
                .filter(Objects::nonNull)
                .filter(plant -> plant.getName().equals(name))
                .findFirst();
    }

    /**
     * Method to search for a Plant by object
     *
     * @param plant - object to search
     * @return - index of a first found plant equals to it, or -1, if there is none
     */
    public int search(Plant plant) {
        return Arrays.asList(plants).indexOf(plant);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garden garden = (Garden) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(plants, garden.plants);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(plants);
    }

    @Override
    public String toString() {
        return "Garden{" +
                "plants=" + Arrays.toString(plants) +
                '}';
    }
}
