package com.github.n1ay.parser;

import java.util.Collections;
import java.util.LinkedList;

public class Production {
    private Symbol left;
    private LinkedList<Symbol> right;

    public Production(Symbol left, LinkedList<Symbol> right) {
        this.left = left;
        this.right = right;
    }

    public Production(Symbol left, Symbol... rightSymbols) {
        this.left = left;
        right = new LinkedList<>();
        Collections.addAll(right, rightSymbols);
    }

    public void setLeft(Symbol left) {
        this.left = left;
    }

    public void setRight(LinkedList<Symbol> right) {
        this.right = right;
    }

    public void setRight(Symbol... rightSymbols) {
        right = new LinkedList<>();
        Collections.addAll(right, rightSymbols);
    }

    public Symbol getLeft() {
        return left;
    }

    public LinkedList<Symbol> getRight() {
        return right;
    }
}
