package com.github.n1ay.parser.action;

import com.github.n1ay.parser.SLR1;

public class Accept extends Action {
    @Override
    public void action(SLR1 slr1) {
        slr1.setOk(true);
    }
}
