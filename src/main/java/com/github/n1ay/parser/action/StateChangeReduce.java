package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class StateChangeReduce extends Action {
    @Override
    public void action(SLR1 slr1) throws ParsingErrorException {
        slr1.getStateHistory().push(arg);
    }
}
