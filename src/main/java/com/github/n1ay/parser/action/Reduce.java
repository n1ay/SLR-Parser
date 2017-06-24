package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class Reduce extends Action {

    public Reduce(int productionNumber) {
        this.arg = productionNumber;
    }

    @Override
    public void action(SLR1 slr1) throws ParsingErrorException {
        int productionLength = slr1.getGrammar().getProductions().get(arg).getRight().size();
        slr1.getProductionList().add(arg);

        for(int i=productionLength; i>0; i--) {
            slr1.getStateStack().pop();
            slr1.getSymbolStack().pop();
        }

        slr1.getSymbolStack().push(slr1.getGrammar().getProductions().get(arg).getLeft());
        slr1.getParsingTable().get(slr1.getStateStack().peek(), slr1.getSymbolStack().peek()).action(slr1);
    }
}
