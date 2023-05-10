package com.solovev.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Garden implements Cloneable {
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
        if (count() < plants.length) {
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

    /**
     * Method to delete element from plants
     *
     * @param plant object to be deleted
     * @return true if object was found and deleted, false otherwise
     */
    public boolean delete(Plant plant) { // could be done with remove method from collections, but it's not efficient
        int index = search(plant);
        if (index != -1) {
            System.arraycopy(plants, index + 1,
                    plants, index, plants.length - index - 1);
            plants[fillIndex-- - 1] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Founds and deletes first found plant by name
     *
     * @param name name of a plant to delete
     * @return Optional plant if it was found and deleted, empty optional otherwise
     */
    public Optional<Plant> delete(String name) {
        Optional<Plant> foundPlant = search(name);
        foundPlant.ifPresent(this::delete);
        return foundPlant;
    }

    /**
     * Inserts plant on the given index
     *
     * @param plant plant to insert
     * @param index index where to insert plant, index can't be more than count()
     * @return true is plant was inserted, else otherwise (index incorrect, or plants is full)
     */
    public boolean insert(Plant plant, int index) {
        if (count() < plants.length &&
                index < count()) {
            System.arraycopy(plants, index,
                    plants, index + 1, plants.length - index - 1);
            plants[index] = plant;
            fillIndex++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Garden clone() {
        try {
            Garden cloned = (Garden) super.clone();
            cloned.plants = new Plant[plants.length];
            for (int i = 0; i < plants.length; i++) {
                cloned.plants[i] = this.plants[i].clone();
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
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
