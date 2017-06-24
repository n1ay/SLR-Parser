package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class StateChangeReduce extends Action {

    public StateChangeReduce(int nextState) {
        this.arg = nextState;
    }

    @Override
    public void action(SLR1 slr1) throws ParsingErrorException {
        slr1.getStateStack().push(arg);
    }
}
