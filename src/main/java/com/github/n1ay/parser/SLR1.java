package com.github.n1ay.parser;

import com.github.n1ay.parser.action.Action;
import com.github.n1ay.parser.action.Error;
import com.github.n1ay.parser.action.ParsingErrorException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class SLR1 {
    private ArrayList<Symbol> input;
    private Hashmatrix<Integer, Symbol, Action> parsingTable;
    private Stack<Integer> stateStack;
    private Stack<Symbol> symbolStack;
    private LinkedList<Integer> productionList;
    private Grammar grammar;
    private boolean ok = false;

    public SLR1() {
        stateStack = new Stack<>();
        symbolStack = new Stack<>();
        productionList = new LinkedList<>();
    }

    public LinkedList<Integer> parse() throws ParsingErrorException {
        productionList.clear();
        stateStack.clear();
        stateStack.push(0);
        symbolStack.clear();
        while(input.size() > 0 && !ok) {
            try {
                parsingTable.get(stateStack.peek(), input.get(0)).action(this);
            } catch (NullPointerException ex) {
                new Error().action(this);
            }
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

    public Stack<Integer> getStateStack() {
        return stateStack;
    }

    public void setStateStack(Stack<Integer> stateStack) {
        this.stateStack = stateStack;
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

    public void generateParsingTable() throws NullPointerException {
        if(grammar == null)
            throw new NullPointerException("Grammar is not defined.");

    }
}
