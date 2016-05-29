package com.learnvedictricks.shivakumar.learnvedictricks;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relative_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relative_layout = (RelativeLayout) findViewById(R.id.relative_layout);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view_main);
        scrollView.scrollTo(0, 0);

    }

    public void onClick(View v) {
        CardView cardViewRules = (CardView) findViewById(R.id.card_view_rules);
        CardView cardViewTryItYourself = (CardView) findViewById(R.id.card_view_tryityourself);
        int cardRulesId = cardViewRules.getId();
        int cardTryItYourselfId = cardViewTryItYourself.getId();
        if (v.getId() == cardRulesId) {
            Intent intent = new Intent(v.getContext(), RuleTypesActivity.class);
            v.getContext().startActivity(intent);
        } else if (v.getId() == cardTryItYourselfId) {
            Snackbar snackbar = Snackbar
                    .make(relative_layout, "Coming Soon!!", Snackbar.LENGTH_LONG);

            snackbar.show();
        }


    }
}
