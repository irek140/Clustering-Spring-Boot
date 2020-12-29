package pl.project.clusteringspringboot.datamining.rule;

import pl.project.clusteringspringboot.datamining.CDMException;
import pl.project.clusteringspringboot.datamining.Enum;

import java.util.Collection;
import java.util.Hashtable;

public class RuleTranslationFormat extends Enum {

    private static int nID;
    private static Hashtable enumList = new Hashtable();
    private static final String[] names = new String[]{"systemDefault"};
    private static final RuleTranslationFormat[] values;
    public static final RuleTranslationFormat systemDefault;

    private RuleTranslationFormat(String val) {
        super(val);
        this.setID(nID++);
        enumList.put(val, this);
    }

    public static RuleTranslationFormat[] values() {
        if (enumList.size() == values.length) {
            return values;
        } else {
            Collection enums = enumList.values();
            Object[] objects = enums.toArray();
            RuleTranslationFormat[] values2 = new RuleTranslationFormat[enumList.size()];
            System.arraycopy(objects, 0, values2, 0, enumList.size());
            return values2;
        }
    }

    public static RuleTranslationFormat valueOf(String name) throws CDMException {
        RuleTranslationFormat _enum = (RuleTranslationFormat)enumList.get(name);
        return _enum;
    }

    public static void addExtension(String name) throws CDMException {
        RuleTranslationFormat _enum = new RuleTranslationFormat(name);
        enumList.put(name, _enum);
    }

    static {
        values = new RuleTranslationFormat[]{new RuleTranslationFormat(names[0])};
        systemDefault = values[0];
    }
}
