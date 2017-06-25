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

    @Override
    public boolean equals(Object object) {
        if(object == null)
            return false;
        if(!(object instanceof Production))
            return false;
        Production production = (Production)object;
        if(left != production.left || right.size() != production.right.size())
            return false;
        for(int i=0; i<right.size(); i++)
            if(right.get(i) != production.right.get(i))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hashcode = left.hashCode();
        for (int i = 0; i < right.size(); i++) {
            hashcode += right.get(i).hashCode()*Math.pow(11,i);
        }
        return hashcode;
    }
}
