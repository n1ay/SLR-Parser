package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;
import com.github.n1ay.parser.Symbol;

public class Shift extends Action {
    @Override
    public void action(SLR1 slr1) {
        Symbol symbol = slr1.getInput().get(0);
        slr1.getInput().remove(0);
        slr1.getSymbolStack().push(symbol);
        slr1.getStateHistory().push(arg);
    }
}
