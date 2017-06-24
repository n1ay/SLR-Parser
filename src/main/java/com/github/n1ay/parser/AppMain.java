package com.github.n1ay.parser;


import com.github.n1ay.parser.action.ParsingErrorException;

import java.util.LinkedList;

public class AppMain {
    public static void main(String[] args) {
        SLR1 slr = SLRExampleClass.getSLR();
        slr.setInput(Symbol.createList("a", "(", "a", "(", "a", "*", "*", ")", ")", "*", "*", "*", "$"));
        try {
            LinkedList<Integer> productions = slr.parse();
            for(Integer i:productions)
                System.out.print(i+" ");
        } catch (ParsingErrorException ex) {
            System.out.println("Input does not belong to this grammar");
            ex.printStackTrace();
        }
    }
}
