package com.developerfriendlypizzalibrary.data;

/**
 * Created by divyanshunegi on 05/10/18.
 * Project : DeloperFriendlyPizza
 */
public class PizzaBean {

    private String pizzaId;
    private int pizzaImageResourceId;
    private float pizzaCost;
    private String pizzaName;
    private String pizzaDescription;

    private PizzaBean(Builder builder) {
        pizzaId = builder.pizzaId;
        pizzaImageResourceId = builder.pizzaImageResourceId;
        pizzaCost = builder.pizzaCost;
        pizzaName = builder.pizzaName;
        pizzaDescription = builder.pizzaDescription;
    }

    public static final class Builder {
        private String pizzaId;
        private int pizzaImageResourceId;
        private float pizzaCost;
        private String pizzaName;
        private String pizzaDescription;

        public Builder() {
        }

        public Builder pizzaId(String val) {
            pizzaId = val;
            return this;
        }

        public Builder pizzaImageResourceId(int val) {
            pizzaImageResourceId = val;
            return this;
        }

        public Builder pizzaCost(float val) {
            pizzaCost = val;
            return this;
        }

        public Builder pizzaName(String val) {
            pizzaName = val;
            return this;
        }

        public Builder pizzaDescription(String val) {
            pizzaDescription = val;
            return this;
        }

        public PizzaBean build() {
            return new PizzaBean(this);
        }
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getPizzaImageResourceId() {
        return pizzaImageResourceId;
    }

    public void setPizzaImageResourceId(int pizzaImageResourceId) {
        this.pizzaImageResourceId = pizzaImageResourceId;
    }

    public double getPizzaCost() {
        return Math.round(pizzaCost * 100.0) / 100.0;
    }

    public void setPizzaCost(float pizzaCost) {
        this.pizzaCost = pizzaCost;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaDescription() {
        return pizzaDescription;
    }

    public void setPizzaDescription(String pizzaDescription) {
        this.pizzaDescription = pizzaDescription;
    }
}
