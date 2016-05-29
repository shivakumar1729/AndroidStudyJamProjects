package com.learnvedictricks.shivakumar.learnvedictricks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by sayyanag on 5/23/2016.
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardView cardView;
    private ArrayList<RuleList> genericRuleList = new ArrayList<RuleList>();
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        process();
    }

    private void process() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("cardData");
            if (value.contentEquals("squares")) {
                final String[] ruleNames = {"Ekadhikena Purvena", "Dwandva", "Yawadhunam Tavaduni"};
                final String[] ruleDescriptions = {"Numbers ending with digit 5", "Duplex Combination Process", "Numbers closer to Powers of 10"};

                genericRuleList = new ArrayList<RuleList>();
                for (int i = 0; i < ruleNames.length; i++) {
                    RuleList ruleList = new RuleList();
                    ruleList.setRuleName(ruleNames[i]);
                    ruleList.setRuleDescription(ruleDescriptions[i]);
                    genericRuleList.add(ruleList);
                }
                recyclerView.setHasFixedSize(true);
                // ListView
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // create an Object for Adapter
                mAdapter = new CardViewDataAdapter(genericRuleList, value);
                // set the adapter object to the Recyclerview
                recyclerView.setAdapter(mAdapter);

            } else if (value.contentEquals("cubes")) {
                final String[] ruleNames = {"Ekadhikena Purvena", "Anurupyena", "Yawadhunam Tavaduni"};
                final String[] ruleDescriptions = {"Numbers ending with digit 5", "General Process", "Numbers closer to Powers of 10"};

                genericRuleList = new ArrayList<RuleList>();
                for (int i = 0; i < ruleNames.length; i++) {
                    RuleList ruleList = new RuleList();
                    ruleList.setRuleName(ruleNames[i]);
                    ruleList.setRuleDescription(ruleDescriptions[i]);
                    genericRuleList.add(ruleList);
                }
                recyclerView.setHasFixedSize(true);
                // ListView
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                // create an Object for Adapter
                mAdapter = new CardViewDataAdapter(genericRuleList, value);
                // set the adapter object to the Recyclerview
                recyclerView.setAdapter(mAdapter);

            }


        }


    }
}
