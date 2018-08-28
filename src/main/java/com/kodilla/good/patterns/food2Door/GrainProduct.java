package com.kodilla.good.patterns.food2Door;

import java.util.Objects;

public class GrainProduct extends Product {
    private boolean isBio;

    public GrainProduct(String productName, boolean isBio){
        super(productName);
        this.isBio = isBio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GrainProduct that = (GrainProduct) o;
        return isBio == that.isBio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isBio);
    }
}
