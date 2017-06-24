package com.github.n1ay.parser;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Symbol {
    private String value;

    public Symbol(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        try {
            if (object == null)
                return false;
            else if (value.equals(((Symbol) object).value))
                return true;
        } catch (ClassCastException classCastException) {}
        return false;
    }

    @Override
    public int hashCode() {
        int hashcode = 0;
        for(int i=0; i<value.length(); i++) {
            hashcode += value.charAt(i)*(i+1)*(i+2)*(i+3);
        }
        return hashcode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static ArrayList<Symbol> createList(String... strings) {
        ArrayList<Symbol> symbols = new ArrayList<>(strings.length);
        for (String s:strings) {
            symbols.add(new Symbol(s));
        }
        return symbols;
    }
}
