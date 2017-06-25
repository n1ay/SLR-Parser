package com.github.n1ay.parser;

public class Situation {
    private Production production;
    private int position;

    public Situation(Production production, int position) {
        this.production = production;
        this.position = position;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null || !(object instanceof Situation))
            return false;
        Situation situation = (Situation)object;
        return (situation.position == position && situation.production == production);
    }

    @Override
    public int hashCode() {
        return production.hashCode()*(position+1);
    }

}
