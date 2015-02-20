package com.alex.alex.activitylifecycledemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class SecondActivity extends Activity {
    static final String LOG_TAG = "##DEMO##";
    EditText edtName, edtAge;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupComponent();
        Log.d(LOG_TAG, "SecondActivity: onCreate()");
    }
    
    void setupComponent()
    {
        edtName = (EditText)findViewById(R.id.name2);
        edtAge = (EditText)findViewById(R.id.age2);

        edtName.setText(getIntent().getStringExtra("name"));
        edtAge.setText(String.valueOf(getIntent().getIntExtra("age", 0)));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "SecondActivity: onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"SecondActivity: onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"SecondActivity: onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"SecondActivity: onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"SecondActivity: onRestart()");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
