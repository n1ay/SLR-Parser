package com.github.n1ay.parser;

import com.github.n1ay.parser.action.Action;
import com.github.n1ay.parser.action.ParsingErrorException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class SLR1 {
    private ArrayList<Symbol> input;
    private Hashmatrix<Integer, Symbol, Action> parsingTable;
    private Stack<Integer> stateHistory;
    private Stack<Symbol> symbolStack;
    private LinkedList<Integer> productionList;
    private Grammar grammar;
    private boolean ok = false;

    public SLR1() {
        stateHistory = new Stack<>();
        symbolStack = new Stack<>();
    }

    public LinkedList<Integer> parse() throws ParsingErrorException {
        while(input.size() > 1 && !ok) {
            parsingTable.get(stateHistory.peek(), input.get(0)).action(this);
        }

        return  productionList;
    }

    public ArrayList<Symbol> getInput() {
        return input;
    }

    public void setInput(ArrayList<Symbol> input) {
        this.input = input;
    }

    public Hashmatrix<Integer, Symbol, Action> getParsingTable() {
        return parsingTable;
    }

    public void setParsingTable(Hashmatrix<Integer, Symbol, Action> parsingTable) {
        this.parsingTable = parsingTable;
    }

    public Stack<Integer> getStateHistory() {
        return stateHistory;
    }

    public void setStateHistory(Stack<Integer> stateHistory) {
        this.stateHistory = stateHistory;
    }

    public Stack<Symbol> getSymbolStack() {
        return symbolStack;
    }

    public void setSymbolStack(Stack<Symbol> symbolStack) {
        this.symbolStack = symbolStack;
    }

    public LinkedList<Integer> getProductionList() {
        return productionList;
    }

    public void setProductionList(LinkedList<Integer> productionList) {
        this.productionList = productionList;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
