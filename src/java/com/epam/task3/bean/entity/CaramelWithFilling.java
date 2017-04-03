package com.epam.task3.bean.entity;

import com.epam.task3.bean.candyclassification.Caramel;

import java.io.Serializable;

/**
 * Created by serge on 31.03.2017.
 */
public class CaramelWithFilling extends Caramel implements Serializable {
    private String filling;

    public CaramelWithFilling() {
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
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

        CaramelWithFilling caramelWithFilling = (CaramelWithFilling) obj;
        if (!super.equals(caramelWithFilling)) {
            return false;
        }
        if (filling == null) {
            return false;
        } else {
            if (!filling.equals(caramelWithFilling.filling)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFilling() != null ? getFilling().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "filling=" + filling;
    }
}
