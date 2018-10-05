package com.developerfriendlypizzalibrary.ui.fragment;

import com.developerfriendlypizzalibrary.R;
import com.developerfriendlypizzalibrary.data.DataRepository;
import com.developerfriendlypizzalibrary.data.PizzaBean;
import com.developerfriendlypizzalibrary.data.PizzaCartBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by divyanshunegi on 05/10/18.
 * Project : DeloperFriendlyPizza
 */
public class PizzaMenuPresenter implements DataRepository.DataListner, PizzaMenuContract.PizzaPresenter {

    private PizzaCartBean pizzaCart;
    private PizzaMenuContract.PizzaMenuView pizzaMenuView;
    private DataRepository dataRepository;

    public PizzaMenuPresenter(PizzaMenuContract.PizzaMenuView pizzaMenuView) {
        this.pizzaMenuView = pizzaMenuView;
        this.dataRepository = new DataRepository(this);
        start();
    }


    private void start() {
        //get the list of pizza from database or API and fill and pass to view as soon the view is rendered
        dataRepository.getPizzaFlavors();
    }

    @Override
    public void pizzaFlavors(ArrayList<PizzaBean> pizzaBeans) {
        pizzaMenuView.showPizzaFlavorList(pizzaBeans);
    }

    @Override
    public void pizzaSelected(PizzaBean pizza) {

        if (pizzaCart == null) {
            this.pizzaCart = new PizzaCartBean();
            this.pizzaCart.orderId = UUID.randomUUID().toString();
        }

        if (pizzaCart.orderedPizzas.size() < 2) {
            if (pizzaCart.orderedPizzas.size() == 0) {
                pizzaMenuView.updateFirstHalf(pizza.getPizzaImageResourceId());
            } else {
                pizzaMenuView.updateSecondHalf(pizza.getPizzaImageResourceId());
            }
            pizzaCart.orderedPizzas.add(pizza);
            pizzaMenuView.updatePrice(getTotalPrice());
        } else {
            pizzaMenuView.cartError(R.string.cart_full_error);
        }
    }

    @Override
    public void refreshCart() {
        pizzaCart = null;
        pizzaMenuView.updateFirstHalf(R.drawable.pizza_placeholder);
        pizzaMenuView.updateSecondHalf(R.drawable.pizza_placeholder);
        pizzaMenuView.updatePrice("Total : $ 0.00");
        pizzaMenuView.cartRefreshed();
    }

    @Override
    public void showOrder() {
        if (pizzaCart == null) {
            pizzaMenuView.cartError(R.string.cart_empty_error);
        } else if (pizzaCart.orderedPizzas.size() <= 0) {
            pizzaMenuView.cartError(R.string.cart_empty_error);
        } else {
            String orderDetail = "You have :\n";
            for (PizzaBean pizzaBean : pizzaCart.orderedPizzas) {
                orderDetail += "1/2 x " + pizzaBean.getPizzaName() + "\n";
                orderDetail += "\n";
            }
            orderDetail += "Order Id : "+pizzaCart.orderId +"\n\n";
            pizzaMenuView.showCartDialog(orderDetail, getTotalPrice());
        }
    }

    @Override
    public void orderNow() {
        if (pizzaCart == null) {
            pizzaMenuView.cartError(R.string.cart_empty_error);
        } else if (pizzaCart.orderedPizzas.size() < 2) {
            pizzaMenuView.cartError(R.string.cart_not_full_error);
        } else {
            //dataRepository.sendOrderRequest();
            pizzaMenuView.pizzaOrdered();
        }
    }

    private String getTotalPrice() {

        double price = 0;
        for (PizzaBean pizzaBean : pizzaCart.orderedPizzas) {
            price += pizzaBean.getPizzaCost();
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        return "Total : $ " + (df.format(price / 2));
    }
}
