package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public abstract class Action {
    int arg;
    public abstract void action(SLR1 slr1) throws ParsingErrorException;
}
