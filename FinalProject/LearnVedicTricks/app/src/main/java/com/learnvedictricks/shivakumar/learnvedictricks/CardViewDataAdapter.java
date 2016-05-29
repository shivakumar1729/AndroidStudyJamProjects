package com.learnvedictricks.shivakumar.learnvedictricks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sayyanag on 5/23/2016.
 */

public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> {
    private static ArrayList<RuleList> dataSet;
    private String value;

    public CardViewDataAdapter(ArrayList<RuleList> ruleLists, String value) {

        dataSet = ruleLists;
        this.value = value;
    }

    @Override
    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new View
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView, value);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewDataAdapter.ViewHolder holder, int position) {
        RuleList ruleList = dataSet.get(position);
        holder.ruleName.setText(ruleList.getRuleName());
        holder.ruleDescription.setText(ruleList.getRuleDescription());
        holder.ruleList = ruleList;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ruleName;
        public TextView ruleDescription;
        public RuleList ruleList;

        public ViewHolder(View itemLayoutView, String value) {

            super(itemLayoutView);
            ruleName = (TextView) itemLayoutView.findViewById(R.id.rule_name);
            ruleDescription = (TextView) itemLayoutView.findViewById(R.id.rule_description);
            final String val = value;
            itemLayoutView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (val.contentEquals("squares")) {
                        //Toast.makeText(v.getContext(),"Illustrate Square Rule"+ruleList.getRuleName(),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(v.getContext(), RuleIllustrationActivity.class);
                        String sutraName = ruleList.getRuleName();
                        String ruleType = val;
                        intent.putExtra("sutraName", sutraName);
                        intent.putExtra("ruleType", ruleType);
                        v.getContext().startActivity(intent);

                    } else if (val.contentEquals("cubes")) {
                        //Toast.makeText(v.getContext(),"Illustrate Cubes Rule"+ruleList.getRuleName(),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(v.getContext(), RuleIllustrationActivity.class);
                        String sutraName = ruleList.getRuleName();
                        String ruleType = val;
                        intent.putExtra("sutraName", sutraName);
                        intent.putExtra("ruleType", ruleType);
                        v.getContext().startActivity(intent);
                    }

                }
            });
        }
    }
}
