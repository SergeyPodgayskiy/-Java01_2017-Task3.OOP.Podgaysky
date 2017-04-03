package com.epam.task3.bean;

/**
 * Created by serge on 31.03.2017.
 */
public abstract class Candy {
    private String name;
    private double weight;
    private double carbohydrates;
    private double proteins;
    private double fats;
    private short kilocalories;
    private double sugar;

    public Candy() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public short getKilocalories() {
        return kilocalories;
    }

    public void setKilocalories(short kilocalories) {
        this.kilocalories = kilocalories;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
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

        Candy candy = (Candy) obj;

        if (name == null) {
            return (name == candy.name);
        } else {
            if (!name.equals(candy.name)) {
                return false;
            }
        }
        if (weight != candy.weight) {
            return false;
        }
        if (carbohydrates != candy.carbohydrates) {
            return false;
        }
        if (proteins != candy.proteins) {
            return false;
        }
        if (fats != candy.fats) {
            return false;
        }
        if (kilocalories != candy.kilocalories) {
            return false;
        }
        if (sugar != candy.sugar) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;

        result = getName() != null ? getName().hashCode() : 0;
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCarbohydrates());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getProteins());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getFats());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) getKilocalories();
        temp = Double.doubleToLongBits(getSugar());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "name='" + name +
                ", weight=" + weight +
                ", carbohydrates=" + carbohydrates +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", kilocalories=" + kilocalories +
                ", sugar=" + sugar + "";
    }
}
