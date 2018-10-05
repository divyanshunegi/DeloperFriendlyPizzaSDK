package com.developerfriendlypizzalibrary.ui.fragment;

import com.developerfriendlypizzalibrary.data.PizzaBean;

import java.util.ArrayList;

/**
 * Created by divyanshunegi on 05/10/18.
 * Project : DeloperFriendlyPizza
 */
public class PizzaMenuContract {

    public interface PizzaMenuView{
        void showPizzaFlavorList(ArrayList<PizzaBean> pizzaMenu);
        void cartError(int errorMessage);
        void updateFirstHalf(int pizzaResourceId);
        void updateSecondHalf(int pizzaResourceId);
        void updatePrice(String totalPrice);

        void cartRefreshed();

        void showCartDialog(String orderDetail, String totalPrice);

        void pizzaOrdered();
    }

    public interface PizzaPresenter{
        void pizzaSelected(PizzaBean pizza);

        void refreshCart();

        void showOrder();

        void orderNow();
    }
}
