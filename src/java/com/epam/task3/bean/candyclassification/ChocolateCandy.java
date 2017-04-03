package com.epam.task3.bean.candyclassification;

import com.epam.task3.bean.Candy;

/**
 * Created by serge on 31.03.2017.
 */
public abstract class ChocolateCandy extends Candy {
    private double cacao;
    private double milkPowder;

    public ChocolateCandy() {
    }

    public double getCacao() {
        return cacao;
    }

    public void setCacao(double cacao) {
        this.cacao = cacao;
    }

    public double getMilkPowder() {
        return milkPowder;
    }

    public void setMilkPowder(double milkPowder) {
        this.milkPowder = milkPowder;
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

        ChocolateCandy chocolateCandy = (ChocolateCandy) obj;
        if (!super.equals(chocolateCandy)) {
            return false;
        }
        if (cacao != chocolateCandy.cacao) {
            return false;
        }
        if (milkPowder != chocolateCandy.milkPowder) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getCacao());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMilkPowder());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "cacao=" + cacao +
                ", milkPowder=" + milkPowder + " ";
    }
}
