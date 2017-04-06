package com.epam.task3.bean.entity;

import com.epam.task3.bean.Caramel;

/**
 * Created by serge on 31.03.2017.
 */
public class Lollipop extends Caramel {
    private String colorant;

    public Lollipop() {
    }

    public String getColorant() {
        return colorant;
    }

    public void setColorant(String colorant) {
        this.colorant = colorant;
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

        Lollipop lollipop = (Lollipop) obj;
        if (!super.equals(lollipop)) {
            return false;
        }
        if (colorant == null) {
            return false;
        } else {
            if (!colorant.equals(lollipop.colorant)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getColorant() != null ? getColorant().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "colorant=" + colorant;
    }
}
