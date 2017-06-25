package com.github.n1ay.parser;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Symbol {
    private String value;

    public Symbol(String value) throws InstantiationError {
        if(value.length() > 10)
            throw new InstantiationError("Symbol max length is 10 characters");
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if(!(object instanceof Symbol))
            return false;
        return value.equals(((Symbol) object).value);
    }

    @Override
    public int hashCode() {
        int hashcode = 0;
        for(int i=0; i<value.length(); i++) {
            hashcode += value.charAt(i)*Math.pow(128, i);
        }
        return hashcode;
    }

    @Override
    public String toString() {
        return value;
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
