package com.epam.task3.bean.entity;

import com.epam.task3.bean.candyclassification.ChocolateCandy;

import java.io.Serializable;

/**
 * Created by serge on 31.03.2017.
 */
public class ChocoNutsCandy extends ChocolateCandy implements Serializable {
    private String additive;

    public ChocoNutsCandy() {
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        ChocoNutsCandy chocoNutsCandy = (ChocoNutsCandy) obj;
        if (!super.equals(chocoNutsCandy)) {
            return false;
        }
        if (additive == null) {
            return false;
        } else {
            if (!additive.equals(chocoNutsCandy.additive)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAdditive() != null ? getAdditive().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "additive=" + additive;
    }
}
