package com.example.jeffhsu.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class EditItemActivity extends ActionBarActivity {
    private EditText etfield;
    private Button btn2_save;
    private ArrayList<String> items;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etfield = (EditText) findViewById(R.id.etfield);
        btn2_save = (Button) findViewById(R.id.btn2_save);
        Intent intent = getIntent();
        index = intent.getIntExtra("index",-1);
        items = intent.getStringArrayListExtra("items");
        if(index<0){
            etfield.setText("");
        }else{
            etfield.setText(items.get(index));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onEditItem(View view) {
        Intent returnIntent = new Intent();

        if(index<0){
            setResult(RESULT_CANCELED,returnIntent);
            finish();
        }else{
            String newInput = etfield.getText().toString();
            returnIntent.putExtra("index",index);
            returnIntent.putExtra("newInput",newInput);
            setResult(RESULT_OK, returnIntent);

            finish();
        }
//        Toast.makeText(getApplicationContext(),"this is clicked", Toast.LENGTH_LONG).show();
    }
}
