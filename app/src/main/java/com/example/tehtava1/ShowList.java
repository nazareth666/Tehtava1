package com.example.tehtava1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {


    private View back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        this.back_button = findViewById(R.id.back_button);
        TextView textView = findViewById(R.id.textView);

        Bundle extra = getIntent().getBundleExtra("extra");
        ArrayList<String> lista = (ArrayList<String>) extra.getSerializable("objects");
        textView.setText(lista.toString());

        this.back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
    }

}
