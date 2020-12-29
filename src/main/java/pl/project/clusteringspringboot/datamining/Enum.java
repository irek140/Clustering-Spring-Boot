package pl.project.clusteringspringboot.datamining;

import java.io.Serializable;

public abstract class Enum implements Serializable, Comparable {

    private String value;
    private int ID;

    protected Enum(String value) {
        if (value != null) {
            this.value = new String(value);
        }

    }

    protected Enum() {
    }

    protected int getID() {
        return this.ID;
    }

    protected void setID(int id) {
        this.ID = id;
    }

    public String name() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (0 != this.getClass().getName().compareTo(obj.getClass().getName())) {
            return false;
        } else {
            Enum obj2 = (Enum)obj;
            if (0 != this.value.compareTo(obj2.name())) {
                return false;
            } else {
                return this.ID == obj2.getID();
            }
        }
    }

    public int compareTo(Object obj) throws ClassCastException {
        if (obj == null) {
            throw new ClassCastException("Null cannot be compared to.");
        } else if (0 != this.getClass().getName().compareTo(obj.getClass().getName())) {
            throw new ClassCastException("Incompatible object type: " + obj.getClass().getName());
        } else {
            return this.getID() - ((Enum)obj).getID();
        }
    }
}
