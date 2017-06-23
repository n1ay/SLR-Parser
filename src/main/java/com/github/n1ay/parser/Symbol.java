package com.github.n1ay.parser;

public class Symbol {
    private String value;

    public Symbol(String value) {
        this.value = value;
    }

    public boolean equals(Object object) {
        try {
            if (object == null)
                return false;
            else if (value.equals(((Symbol) object).value))
                return true;
        } catch (ClassCastException classCastException) {}
        return false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
