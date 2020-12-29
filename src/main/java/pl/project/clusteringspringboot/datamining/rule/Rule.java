package pl.project.clusteringspringboot.datamining.rule;

import pl.project.clusteringspringboot.datamining.CDMException;

public interface Rule {

    double getSupport();

    long getAbsoluteSupport();

    double getConfidence();

    Predicate getAntecedent();

    Predicate getConsequent();

    int getRuleIdentifier();

    String translate() throws CDMException;

    String translate(RuleTranslationFormat var1) throws CDMException;
}
