package com.github.n1ay.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;

public class Grammar {

    private ArrayList<Production> productions;
    private Hashtable<String, Symbol> symbols;

    public Grammar(Production... productions) {
        this.productions = new ArrayList<>(productions.length);
        Collections.addAll(this.productions, productions);
        symbols = new Hashtable<>();
        symbols.put("$", new Symbol("$"));
    }

    public Grammar(ArrayList<Production> productions) {
        symbols = new Hashtable<>();
        this.productions = productions;
        symbols.put("$", new Symbol("$"));
    }

    public Grammar() {
        productions = new ArrayList<>();
        symbols = new Hashtable<>();
        symbols.put("$", new Symbol("$"));
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

    public Symbol getSymbol(String string) {
        return symbols.get(string);
    }

    public Grammar putSymbol(String string, Symbol symbol) {
        symbols.put(string, symbol);
        return this;
    }

    public Grammar addProduction(Production production) {
        productions.add(production);
        return this;
    }

    public Grammar addProduction(String left, String... right) {
        LinkedList<Symbol> symbolsRight = new LinkedList<>();
        for (String string : right)
            symbolsRight.add(getSymbol(string));

         addProduction(new Production(getSymbol(left), symbolsRight));
         return this;
    }
}
