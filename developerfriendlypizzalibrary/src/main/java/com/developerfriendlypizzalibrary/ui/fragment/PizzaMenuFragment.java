package com.developerfriendlypizzalibrary.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
    private ImageView cartSample1, cartSample2;
    private TextView pizzaTotalPrice;
    private ImageButton refreshButton;
    private Button orderButton;
    AlertDialog dialog;

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
        orderButton = root.findViewById(R.id.orderButton);
        cartSample1 = root.findViewById(R.id.pizza1Image);
        refreshButton = root.findViewById(R.id.refreshButton);
        cartSample2 = root.findViewById(R.id.pizza2Image);
        pizzaFlavorListView = root.findViewById(R.id.pizzaFlavorList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new PizzaFlavorListAdapter(pizzaBeans, this);
        pizzaFlavorListView.setLayoutManager(linearLayoutManager);
        pizzaFlavorListView.setAdapter(adapter);
        presenter = new PizzaMenuPresenter(this);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.refreshCart();
            }
        });
        cartSample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showOrder();
            }
        });
        cartSample2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showOrder();
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.orderNow();
            }
        });
        return root;
    }

    @Override
    public void showPizzaFlavorList(ArrayList<PizzaBean> pizzaMenu) {
        pizzaBeans.clear();
        pizzaBeans.addAll(pizzaMenu);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void cartError(int errorMessage) {
        Toast.makeText(getActivity(), getResources().getString(errorMessage), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFirstHalf(int pizzaresourceId) {
        cartSample1.setImageResource(pizzaresourceId);
    }

    @Override
    public void updateSecondHalf(int pizzaresourceId) {
        cartSample2.setImageResource(pizzaresourceId);
    }

    @Override
    public void updatePrice(String totalPrice) {
        refreshButton.setVisibility(View.VISIBLE);
        pizzaTotalPrice.setText(totalPrice);
    }

    @Override
    public void cartRefreshed() {
        refreshButton.setVisibility(View.INVISIBLE);
        Toast.makeText(getActivity(), "cart refreshed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCartDialog(String orderDetail, String totalPrice) {

        dialog = new AlertDialog.Builder(getActivity(), R.style.dialog_light)
                .setTitle(totalPrice)
                .setMessage(orderDetail)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something
                    }
                })
                .create();
        dialog.show();

    }

    @Override
    public void pizzaOrdered() {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.pizza_order_success, Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
    }

    @Override
    public void onPizzaSelected(PizzaBean pizza) {
        presenter.pizzaSelected(pizza);
    }
}
