package com.example.sayyanag.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeStatus(View view){
        TextView hungryStatus = (TextView) findViewById(R.id.status_text_view);
        hungryStatus.setText("I'm so full");
        ImageView imageView = (ImageView) findViewById(R.id.cookie);
        imageView.setImageResource(R.drawable.after_cookie);
    }
}
