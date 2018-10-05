package com.developerfriendlypizzalibrary.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.developerfriendlypizzalibrary.R;
import com.developerfriendlypizzalibrary.data.PizzaBean;
import com.developerfriendlypizzalibrary.ui.adapter.PizzaFlavorListAdapter;

import java.util.ArrayList;

/**
 * Created by divyanshunegi on 04/10/18.
 * Project : DeloperFriendlyPizza
 */
public class PizzaMenuFragment extends Fragment implements PizzaMenuContract.PizzaMenuView, PizzaFlavorListAdapter.PizzaSelectListner {

    private RecyclerView pizzaFlavorListView;
    private LinearLayoutManager linearLayoutManager;
    private PizzaFlavorListAdapter adapter;
    private ArrayList<PizzaBean> pizzaBeans;
    private PizzaMenuPresenter presenter;
    private ImageView cartSample1,cartSample2;
    private TextView pizzaTotalPrice;

    public static PizzaMenuFragment newInstance() {
        Bundle args = new Bundle();
        PizzaMenuFragment fragment = new PizzaMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pizza_menu, container, false);
        pizzaBeans = new ArrayList<>();
        pizzaTotalPrice = root.findViewById(R.id.totalPriceText);
        cartSample1 = root.findViewById(R.id.pizza1Image);
        cartSample2 = root.findViewById(R.id.pizza2Image);
        pizzaFlavorListView = root.findViewById(R.id.pizzaFlavorList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new PizzaFlavorListAdapter(pizzaBeans, this);
        pizzaFlavorListView.setLayoutManager(linearLayoutManager);
        pizzaFlavorListView.setAdapter(adapter);
        presenter = new PizzaMenuPresenter(this);
        return root;
    }

    @Override
    public void showPizzaFlavorList(ArrayList<PizzaBean> pizzaMenu) {
        pizzaBeans.clear();
        pizzaBeans.addAll(pizzaMenu);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void cartFullError(int errorMessage) {
        Toast.makeText(getActivity(), getResources().getString(errorMessage), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFirstHalf(PizzaBean pizza) {
        cartSample1.setImageResource(pizza.getPizzaImageResourceId());
    }

    @Override
    public void updateSecondHalf(PizzaBean pizza) {
        cartSample2.setImageResource(pizza.getPizzaImageResourceId());
    }

    @Override
    public void updatePrice(String totalPrice) {
        pizzaTotalPrice.setText(totalPrice);
    }

    @Override
    public void onPizzaSelected(PizzaBean pizza) {
        presenter.pizzaSelected(pizza);
    }
}
