package com.example.tehtava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        TextView textView = findViewById(R.id.textView);

        Bundle extra = getIntent().getBundleExtra("extra");
        ArrayList<String> lista = (ArrayList<String>) extra.getSerializable("objects");
        textView.setText(lista.toString());

    }
}
