package com.example.cocomocalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CostDriverAdapter
        extends RecyclerView.Adapter<CostDriverAdapter.ViewHolder> {

    private final List<CostDriver> drivers;

    public CostDriverAdapter(List<CostDriver> drivers) {
        this.drivers = drivers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cost_driver, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        CostDriver driver = drivers.get(position);

        holder.tvName.setText(driver.getName());

        List<String> labels = new ArrayList<>();
        for (CostDriverLevel level : driver.getLevels()) {
            labels.add(level.getLabel());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                holder.itemView.getContext(),
                android.R.layout.simple_spinner_item,
                labels
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        holder.spinner.setAdapter(adapter);
        holder.spinner.setSelection(driver.getSelectedLevelIndex());

        holder.spinner.setOnItemSelectedListener(
                new android.widget.AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            android.widget.AdapterView<?> parent,
                            View view,
                            int pos,
                            long id) {

                        driver.setSelectedLevelIndex(pos);
                    }

                    @Override
                    public void onNothingSelected(
                            android.widget.AdapterView<?> parent) {}
                }
        );
    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        Spinner spinner;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvDriverName);
            spinner = itemView.findViewById(R.id.spinnerLevel);
        }
    }
}
