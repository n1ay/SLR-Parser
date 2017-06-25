package com.github.n1ay.parser;

import java.util.HashSet;
import java.util.Set;

public class SituationSet {
    private Set<Situation> situations;

    public SituationSet() {
        situations = new HashSet<>();
    }

    public Set<Situation> getSituations() {
        return situations;
    }

    public void setSituations(Set<Situation> situations) {
        this.situations = situations;
    }

    public void addSituation(Situation situation, Grammar grammar) {
        situations.add(situation);
        Symbol symbol = situation.getProduction().getRight().get(situation.getPosition());
        for (Production p: grammar.getProductions())
            if(p.getLeft() == symbol) {
                addSituation(new Situation(p, 0), grammar);
            }
    }

    public void move(Symbol symbol, Grammar grammar, StateSet stateSet) {
        SituationSet situationSet = new SituationSet();
        for(Situation s: situations) {
            if(s.getPosition() == s.getProduction().getRight().size())
                continue;
            if (s.getProduction().getRight().get(s.getPosition()) == symbol)
                situationSet.addSituation(new Situation(s.getProduction(), s.getPosition()+1), grammar);
        }
        stateSet.getStates().add(situationSet);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SituationSet))
            return false;
        Set<Situation> set = ((SituationSet) o).getSituations();
        for (Situation s: situations)
            if(!set.contains(s))
                return false;

        for (Situation s: set)
            if(!situations.contains(s))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hashcode = 0;
        for(Situation s:situations)
            hashcode += s.hashCode();
        return hashcode;
    }
}
