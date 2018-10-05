package com.developerfriendlypizzalibrary.data;

import com.developerfriendlypizzalibrary.R;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by divyanshunegi on 05/10/18.
 * Project : DeloperFriendlyPizza
 */
public class DataRepository {

    private DataListner dataListner;

    public DataRepository(DataListner dataListner) {
        this.dataListner = dataListner;
    }

    public void getPizzaFlavors() {
        ArrayList<PizzaBean> pizzaBeans = new ArrayList<>();

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(4.99f)
                .pizzaDescription("This is a unique flavour of vegetarian pizza where the pizza where the spicy vegetarian delight is topped with extremely appealing golden corns")
                .pizzaImageResourceId(R.drawable.flavor1)
                .pizzaName("Gourmet Pizza")
                .build());


        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(7.99f)
                .pizzaDescription("This is a very popular veg. pizza which has a double thick layer of cheese")
                .pizzaImageResourceId(R.drawable.flavor2)
                .pizzaName("Double Cheese Pizza")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(3.99f)
                .pizzaDescription("This is another unique recipe of American pizza which mane is influenced by the Mexican Waves")
                .pizzaImageResourceId(R.drawable.flavor3)
                .pizzaName("Mexican Green Wave")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(9.99f)
                .pizzaDescription("Paneer is a fresh cheese common in South Asian Cuisine. It is an Indian Origin food item which is a delicious piece of cheese cube made of pure milk")
                .pizzaImageResourceId(R.drawable.flavor4)
                .pizzaName("Peppy Paneer")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(5.99f)
                .pizzaDescription("Pizza Margherita is a very common and a popular menu in the Asian countries. These pizzas are delicious and are made with single topping of Cheese")
                .pizzaImageResourceId(R.drawable.flavor5)
                .pizzaName("Margherita Pizza")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(12.99f)
                .pizzaDescription("This is a non- vegetarian dish and is exclusively meant for you, if you are a hard core Non Vegetarian")
                .pizzaImageResourceId(R.drawable.flavor6)
                .pizzaName("Meatzaa Pizza")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(8.99f)
                .pizzaDescription("The Cheese and Barbeque chicken Pizzas are the most popular among the pizza flavours. In countries like India where Ham and beef are not consumed largely")
                .pizzaImageResourceId(R.drawable.flavor7)
                .pizzaName("Cheese and Barbeque Chicken")
                .build());

        pizzaBeans.add(new PizzaBean.Builder()
                .pizzaId(UUID.randomUUID().toString())
                .pizzaCost(10.99f)
                .pizzaDescription("These pizzas are one of the most delicious spicy flavours of pizzas available. The Mexican Red Wave Pizza is a lip smacking flavour of Pizza which is made with hot and spicy chicken as the main topping")
                .pizzaImageResourceId(R.drawable.flavor8)
                .pizzaName("Chicken Mexican Red Wave")
                .build());

        dataListner.pizzaFlavors(pizzaBeans);
    }

    public interface DataListner{
        void pizzaFlavors(ArrayList<PizzaBean> pizzaBeans);
    }
}
