package com.solovev.model;

public class Garden {
    private Plant[] plants;

    /**
     *
     * @param numberOfPlants number of plants in garden; can't bew negative
     */
    public Garden(int numberOfPlants) {
        plants = new Plant[numberOfPlants];
    }
}
