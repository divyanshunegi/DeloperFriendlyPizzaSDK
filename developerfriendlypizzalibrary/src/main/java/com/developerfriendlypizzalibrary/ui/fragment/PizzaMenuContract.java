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
        void cartFullError(int errorMessage);
        void updateFirstHalf(PizzaBean pizza);
        void updateSecondHalf(PizzaBean pizza);
        void updatePrice(String totalPrice);
    }

    public interface PizzaPresenter{
        void pizzaSelected(PizzaBean pizza);
    }
}
