package com.developerfriendlypizzalibrary.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developerfriendlypizzalibrary.R;
import com.developerfriendlypizzalibrary.data.PizzaBean;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzaFlavorListAdapter extends RecyclerView.Adapter<PizzaFlavorListAdapter.PizzaViewHolder> {

    private ArrayList<PizzaBean> pizzaList;
    private PizzaSelectListner listner;

    public PizzaFlavorListAdapter(ArrayList<PizzaBean> pizzaList,PizzaSelectListner listner) {
        this.pizzaList = pizzaList;
        this.listner = listner;
    }

    @Override
    public PizzaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_pizza, parent, false);

        return new PizzaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PizzaViewHolder holder, int position) {
        final PizzaBean pizza = pizzaList.get(position);
        holder.pizzaImage.setImageResource(pizza.getPizzaImageResourceId());

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        holder.pizzaCost.setText("$ " + df.format(pizza.getPizzaCost()));
        holder.pizzaTitle.setText(pizza.getPizzaName());
        holder.pizzaDescription.setText(pizza.getPizzaDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listner!=null){
                    listner.onPizzaSelected(pizza);
                }else{
                    throw new RuntimeException("DUH! you forgot something, Pass PizzaSelectListner to PizzaFlavorListAdaptor");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }


    public class PizzaViewHolder extends RecyclerView.ViewHolder {

        public ImageView pizzaImage;
        public TextView pizzaTitle,pizzaDescription,pizzaCost;

        public PizzaViewHolder(View view) {
            super(view);
            pizzaImage = view.findViewById(R.id.pizzaImage);
            pizzaTitle = view.findViewById(R.id.pizzaTitle);
            pizzaDescription = view.findViewById(R.id.pizzaDescription);
            pizzaCost = view.findViewById(R.id.pizzaPrice);
        }
    }

    public interface PizzaSelectListner{
        void onPizzaSelected(PizzaBean pizza);
    }
}