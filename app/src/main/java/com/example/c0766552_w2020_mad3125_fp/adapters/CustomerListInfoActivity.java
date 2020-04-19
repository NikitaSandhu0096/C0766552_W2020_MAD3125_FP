package com.example.c0766552_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;
import com.example.c0766552_w2020_mad3125_fp.ui.ShowBillDetailsActivity;

import java.util.ArrayList;

public class CustomerListInfoActivity extends RecyclerView.Adapter<CustomerListInfoActivity.CustomerViewHolder> {
    private ArrayList<Customer> customersArrayList;

    public CustomerListInfoActivity(ArrayList<Customer> customersArrayList) {
        this.customersArrayList = customersArrayList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_summary, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomerListInfoActivity.CustomerViewHolder holder, final int position) {
        final Customer mCustomer = this.customersArrayList.get(position);
        holder.txtCustomerName.setText(mCustomer.getFullName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sint = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);

                ShowBillDetailsActivity.selectItem = position;          //https://stackoverflow.com/questions/54507274/recyclerview-get-the-selected-position-and-pass-the-position-to-another-activi
                sint.putExtra("customerSelected", position);
                holder.itemView.getContext().startActivity(sint);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.customersArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder{
        TextView txtCustomerName;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCustomerName = itemView.findViewById(R.id.txtCustomerName);
        }
    }
}
