package com.github.n1ay.parser;

import java.util.ArrayList;
import java.util.Collections;

public class Grammar {

    private ArrayList<Production> productions;

    public Grammar(Production... productions) {
        this.productions = new ArrayList<>(productions.length);
        Collections.addAll(this.productions, productions);
    }

    public Grammar(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public void setProductions(Production... productions) {
        this.productions = new ArrayList<>(productions.length);
        Collections.addAll(this.productions, productions);
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }




}
