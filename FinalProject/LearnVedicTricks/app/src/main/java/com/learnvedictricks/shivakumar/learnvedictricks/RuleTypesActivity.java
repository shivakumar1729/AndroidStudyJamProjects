package com.learnvedictricks.shivakumar.learnvedictricks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by sayyanag on 5/22/2016.
 */
public class RuleTypesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rule_types_layout);

    }

    public void onClick(View v) {
        CardView cardViewSquares = (CardView) findViewById(R.id.card_view_squares);
        CardView cardViewCubes = (CardView) findViewById(R.id.card_view_cubes);
        int cardSquaresId = cardViewSquares.getId();
        int cardCubesId = cardViewCubes.getId();
        String cardData = null;
        if (v.getId() == cardSquaresId) {
            Intent intent = new Intent(v.getContext(), RecyclerViewActivity.class);
            cardData = "squares";
            intent.putExtra("cardData", cardData);
            v.getContext().startActivity(intent);
        } else if (v.getId() == cardCubesId) {
            Intent intent = new Intent(v.getContext(), RecyclerViewActivity.class);
            cardData = "cubes";
            intent.putExtra("cardData", cardData);
            v.getContext().startActivity(intent);
        }
    }
}
