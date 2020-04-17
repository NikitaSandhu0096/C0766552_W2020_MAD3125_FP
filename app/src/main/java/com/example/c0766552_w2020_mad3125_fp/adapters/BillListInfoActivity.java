package com.example.c0766552_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Bill;
import com.example.c0766552_w2020_mad3125_fp.ui.BillInfoActivity;

import java.util.ArrayList;

public class BillListInfoActivity extends RecyclerView.Adapter<BillListInfoActivity.BillViewHolder> {
    private ArrayList<Bill> billsArrayList;

    public BillListInfoActivity(ArrayList<Bill> billsArrayList) {
        this.billsArrayList = billsArrayList;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_summary, parent, false);
        BillViewHolder mBillViewHolder = new BillViewHolder(mView1);
        return mBillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BillListInfoActivity.BillViewHolder holder, final int position) {
        Bill mBill = this.billsArrayList.get(position);
        holder.txtBillType.setText("Bill Type : " + mBill.getBillType());
        holder.txtBillDate.setText("Bill Date : " + mBill.getBillDate());
        holder.txtBillAmount.setText("Bill Amount : " + mBill.getTotalBillAmount().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bill bill = billsArrayList.get(position);
                Intent sint1 = new Intent(holder.itemView.getContext(), BillInfoActivity.class);
                sint1.putExtra("bills", bill);
                holder.itemView.getContext().startActivity(sint1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.billsArrayList.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder{
        TextView txtBillType;
        TextView txtBillDate;
        TextView txtBillAmount;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);

            txtBillType = itemView.findViewById(R.id.txtBillType);
            txtBillDate = itemView.findViewById(R.id.txtBillDate);
            txtBillAmount = itemView.findViewById(R.id.txtBillAmount);
        }
    }
}
