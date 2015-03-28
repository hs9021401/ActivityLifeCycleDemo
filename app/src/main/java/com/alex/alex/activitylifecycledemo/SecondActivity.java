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


public class SecondActivity extends Activity {
    static final String LOG_TAG = "##DEMO##";
    EditText edtName, edtAge;
    Button btnRet, btnCancel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupComponent();

        edtName.setText(getIntent().getStringExtra("TAG_Name"));
        edtAge.setText(String.valueOf(getIntent().getIntExtra("TAG_Age", 0)));

        Log.d(LOG_TAG, "SecondActivity: onCreate()");
    }
    
    void setupComponent()
    {
        edtName = (EditText)findViewById(R.id.name2);
        edtAge = (EditText)findViewById(R.id.age2);
        btnRet = (Button)findViewById(R.id.btnRet);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra("DATA", "Hi~ MainActivity, I got the message from you.");
                setResult(RESULT_OK, it);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
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
