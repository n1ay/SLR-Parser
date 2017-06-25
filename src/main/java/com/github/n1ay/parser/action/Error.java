package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class Error extends Action {
    @Override
    public void action(SLR1 slr1) throws ParsingErrorException {
        throw new ParsingErrorException("Parsing error at:\nSymbol stack: "+slr1.getSymbolStack().peek() + "\nState stack: " + slr1.getStateStack().peek() + "\nInput stack: " + slr1.getInput().get(0));
    }
}
