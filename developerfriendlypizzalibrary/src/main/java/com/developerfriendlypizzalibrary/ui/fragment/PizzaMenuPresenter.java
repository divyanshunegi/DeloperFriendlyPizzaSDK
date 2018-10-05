package com.developerfriendlypizzalibrary.ui.fragment;

import com.developerfriendlypizzalibrary.R;
import com.developerfriendlypizzalibrary.data.DataRepository;
import com.developerfriendlypizzalibrary.data.PizzaBean;
import com.developerfriendlypizzalibrary.data.PizzaCartBean;

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
                pizzaMenuView.updateFirstHalf(pizza);
            } else {
                pizzaMenuView.updateSecondHalf(pizza);
            }
            pizzaCart.orderedPizzas.add(pizza);
            pizzaMenuView.updatePrice(getTotalPrice());
        } else {
            pizzaMenuView.cartFullError(R.string.cart_full_error);
        }
    }

    private String getTotalPrice() {

        double price = 0;
        for (PizzaBean pizzaBean : pizzaCart.orderedPizzas) {
            price += pizzaBean.getPizzaCost();
        }

        return "Total : $ " + (price / 2);
    }
}
