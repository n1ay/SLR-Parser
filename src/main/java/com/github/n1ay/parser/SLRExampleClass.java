package com.github.n1ay.parser;

import com.github.n1ay.parser.*;
import com.github.n1ay.parser.action.*;

public class SLRExampleClass {
    public static SLR1 getSLR() {
        SLR1 slr = new SLR1();
        slr.setGrammar(getGrammar());
        slr.setParsingTable(getHashmatrix(getGrammar()));

        return slr;
    }
    public static Grammar getGrammar() {
        Grammar grammar = new Grammar();
        grammar.putSymbol("S", new Symbol("S"))
                .putSymbol("a", new Symbol("a"))
                .putSymbol("(", new Symbol("("))
                .putSymbol(")", new Symbol(")"))
                .putSymbol("*", new Symbol("*"));
        grammar.addProduction("S\'", "S")
                .addProduction("S", "S", "*")
                .addProduction("S", "a", "(", "S", ")")
                .addProduction("S", "a");
        return grammar;
    }

    public static Hashmatrix<Integer, Symbol, Action> getHashmatrix(Grammar grammar) {
        Hashmatrix<Integer, Symbol, Action> hashmatrix = new Hashmatrix<>(7,6);
        hashmatrix.add(0, grammar.getSymbol("a"), new Shift(2))
                .add(0, grammar.getSymbol("S"), new StateChangeReduce(1))
                .add(1, grammar.getSymbol("*"), new Shift(3))
                .add(1, grammar.getSymbol("$"), new Accept())
                .add(2, grammar.getSymbol("*"), new Reduce(3))
                .add(2, grammar.getSymbol("("), new Shift(4))
                .add(2, grammar.getSymbol(")"), new Reduce(3))
                .add(2, grammar.getSymbol("$"), new Reduce(3))
                .add(3, grammar.getSymbol("*"), new Reduce(1))
                .add(3, grammar.getSymbol(")"), new Reduce(1))
                .add(3, grammar.getSymbol("$"), new Reduce(1))
                .add(4, grammar.getSymbol("a"), new Shift(2))
                .add(4, grammar.getSymbol("S"), new StateChangeReduce(5))
                .add(5, grammar.getSymbol("*"), new Shift(3))
                .add(5, grammar.getSymbol(")"), new Shift(6))
                .add(6, grammar.getSymbol("*"), new Reduce(2))
                .add(6, grammar.getSymbol(")"), new Reduce(2))
                .add(6, grammar.getSymbol("$"), new Reduce(2));
        return hashmatrix;
    }
}
