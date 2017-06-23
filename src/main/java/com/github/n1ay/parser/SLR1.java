package com.github.n1ay.parser;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

public class SLR1 {
    private Hashmatrix<Integer, Token, Action> parsingTable;
    private Stack<Integer> stateHistory;
    private Stack<Token> tokenStack;
    private LinkedList<Integer> productionList;
    private Grammar grammar;
}
