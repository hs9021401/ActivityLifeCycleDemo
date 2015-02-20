package com.alex.alex.activitylifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    static final String LOG_TAG = "##DEMO##";
    Button btnShowDialog, btnGoSecAct;
    EditText edtName, edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponent();
        Log.d(LOG_TAG,"MainActivity: onCreate()");
    }

    private void setupComponent()
    {
        edtName = (EditText)findViewById(R.id.name);
        edtAge = (EditText)findViewById(R.id.age);
        btnGoSecAct = (Button)findViewById(R.id.GoSecAct);

        btnGoSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.valueOf(edtAge.getText().toString());

                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                it.putExtra("name" , name);
                it.putExtra("age", age);
                startActivity(it);
            }
        });

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onPause() {
        Log.d(LOG_TAG,"MainActivity: onPause()");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"MainActivity: onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"MainActivity: onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"MainActivity: onRestart()");
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
