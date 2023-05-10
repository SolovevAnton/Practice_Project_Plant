package com.solovev.model;

/**
 * Class to describe size of a plant
 */
public class Size implements Cloneable {
    /**
     * in cm, cannot be negative
     */
    private int height;
    /**
     * in cm, cannot be negative
     */
    private int length;
    /**
     * in cm
     */
    private int perimeter;

    public Size() {
    }

    /**
     * @param height height of the plant pod, can't be negative
     * @param length length of the plant pod, can't be negative
     * @throws IllegalArgumentException if height or length is negative
     */
    public Size(int height, int length) {
        this.height = height;
        this.length = length;
        setPerimeter();
    }

    /**
     * CopyConstructor
     * @param other Size to be copied
     */
    public Size(Size other){
        this.height = other.height;
        this.length = other.length;
        this.perimeter = other.perimeter;
    }
    @Override
    public Size clone(){
        try {
            return (Size) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setHeight(int height) {
        this.height = height;
        setPerimeter();
    }

    public void setLength(int length) {
        this.length = length;
        setPerimeter();
    }

    private void setPerimeter() {
        this.perimeter = (height + length) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (height != size.height) return false;
        if (length != size.length) return false;
        return perimeter == size.perimeter;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + length;
        result = 31 * result + perimeter;
        return result;
    }

    @Override
    public String toString() {
        return "Size{" +
                "height=" + height +
                ", length=" + length +
                ", perimeter=" + perimeter +
                '}';
    }
}
