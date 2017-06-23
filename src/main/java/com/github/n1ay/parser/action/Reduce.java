package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class Reduce extends Action {
    @Override
    public void action(SLR1 slr1) throws ParsingErrorException {
        int productionLength = slr1.getGrammar().getProductions().get(arg-1).getRight().size();
        slr1.getProductionList().add(arg);

        for(int i=productionLength; i>0; i--) {
            slr1.getStateHistory().pop();
            slr1.getSymbolStack().pop();
        }

        slr1.getSymbolStack().push(slr1.getGrammar().getProductions().get(arg-1).getLeft());
        slr1.getParsingTable().get(slr1.getStateHistory().peek(), slr1.getSymbolStack().peek()).action(slr1);
    }
}
