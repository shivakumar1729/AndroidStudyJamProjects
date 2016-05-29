package com.learnvedictricks.shivakumar.learnvedictricks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RuleIllustrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_illustration);
        TextView sutraNameTextView = (TextView) findViewById(R.id.sutra_name);
        TextView sutraDescriptionTextView = (TextView) findViewById(R.id.sutra_description);
        TextView sutraExamplesTextView = (TextView) findViewById(R.id.sutra_examples);
        String sutraName;
        String ruleType;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sutraName = extras.getString("sutraName");
            ruleType = extras.getString("ruleType");
            String description;
            String example;
            if (ruleType.contentEquals("squares")) {
                if (sutraName.contentEquals("Ekadhikena Purvena")) {
                    sutraNameTextView.setText("Ekadhikena Purvena");
                    description = getString(R.string.sq_ekadhikena_desc);
                    example = getString(R.string.sq_ekadhikena_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                } else if (sutraName.contentEquals("Dwandva")) {
                    sutraNameTextView.setText("Dwandva");
                    description = getString(R.string.sq_dwandva_desc);
                    example = getString(R.string.sq_dwandva_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                } else if (sutraName.contentEquals("Yawadhunam Tavaduni")) {
                    sutraNameTextView.setText("Yawadhunam Tavaduni Kritya Varjancha Yojayet");
                    description = getString(R.string.sq_yavadunam_desc);
                    example = getString(R.string.sq_yavadunam_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                }

            } else if (ruleType.contentEquals("cubes")) {
                if (sutraName.contentEquals("Ekadhikena Purvena")) {
                    sutraNameTextView.setText("Ekadhikena Purvena");
                    description = getString(R.string.cu_ekadhikena_desc);
                    example = getString(R.string.cu_ekadhikena_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                } else if (sutraName.contentEquals("Anurupyena")) {
                    sutraNameTextView.setText("Anurupyena");
                    description = getString(R.string.cu_anurupyena_desc);
                    example = getString(R.string.cu_anurupyena_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                } else if (sutraName.contentEquals("Yawadhunam Tavaduni")) {
                    sutraNameTextView.setText("Yawadhunam Tavaduni");
                    description = getString(R.string.cu_yavadunam_desc);
                    example = getString(R.string.cu_yavadunam_examples);
                    sutraDescriptionTextView.setText(description);
                    sutraExamplesTextView.setText(example);
                }
            }
        }

    }
}
