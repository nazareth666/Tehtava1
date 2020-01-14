package com.example.tehtava1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Button btn_add;
private Button btn_done;
private EditText text;
private TextView textView;
public ArrayList<String> lista = new ArrayList<String>();
public String content = "";
public Toast toast;
public int duration = Toast.LENGTH_SHORT;
public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.btn_add = findViewById(R.id.btn_add);
        this.btn_done = findViewById(R.id.btn_done);
        this.text = findViewById(R.id.plain_text_input);
        this.textView = findViewById(R.id.text_view_id);

        this.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content = text.getText().toString();
                context = getApplicationContext();

               if (content.length() >= 3 && content.length() <= 15){
                    toast = Toast.makeText(context, "Lisäys onnistui", duration);
                    lista.add(content);
                }
                else {
                    toast = Toast.makeText(context, "Lisäys epäonnistui :( (min 3 max 15)", duration);
                }
                toast.show();
                textView.setText(content);

            }
        });

        this.btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putSerializable("objects", lista);

                Intent intent = new Intent(getBaseContext(), ShowList.class);
                intent.putExtra("extra",extra);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
