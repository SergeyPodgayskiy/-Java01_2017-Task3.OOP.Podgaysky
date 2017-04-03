package com.epam.task3.bean.candyclassification;

import com.epam.task3.bean.Candy;

/**
 * Created by serge on 31.03.2017.
 */
public abstract class Caramel extends Candy {
    private int water;
    private String flavoring;

    public Caramel() {
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public String getFlavoring() {
        return flavoring;
    }

    public void setFlavoring(String flavoring) {
        this.flavoring = flavoring;
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

        Caramel caramel = (Caramel) obj;
        if (!super.equals(caramel)) {
            return false;
        }
        if (water != caramel.water) {
            return false;
        }
        if (flavoring == null) {
            return false;
        } else {
            if (!flavoring.equals(caramel.flavoring)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getWater();
        result = 31 * result + (getFlavoring() != null ? getFlavoring().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                " water=" + water +
                ", flavoring=" + flavoring + " ";
    }

}
