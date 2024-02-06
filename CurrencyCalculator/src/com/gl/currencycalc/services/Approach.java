package com.gl.currencycalc.services;

public class Approach {
    private Denomination denomination;
    private int count;
    
    public Approach(Denomination denomination, int count) {
        this.denomination = denomination;
        this.count = count;
    }
    
    public Denomination getDenomination() {
        return denomination;
    }
    
    public int getCount() {
        return count;
    }
}