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
import android.widget.TextView;


public class MainActivity extends Activity {
    final String LOG_TAG = "##DEMO##";
    final int REQUEST_CODE = 0;

    Button btnGoSecAct;
    EditText edtName, edtAge;
    TextView txtReturnData;

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
        txtReturnData = (TextView)findViewById(R.id.returnData);

        btnGoSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int age = Integer.valueOf(edtAge.getText().toString());

                Intent it = new Intent(MainActivity.this, SecondActivity.class);
                it.putExtra("TAG_Name" , name);
                it.putExtra("TAG_Age", age);

                //Method 1: 單純跳轉畫面
                //startActivity(it);

                //Method 2:
                startActivityForResult(it,REQUEST_CODE);
            }
        });
    }

    //Method 2: 跳轉畫面後, 回來主畫面將會接收回傳的資料
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode != REQUEST_CODE)
            return;

        switch(resultCode){
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String strData = bundle.getString("DATA");
                txtReturnData.setText(strData);
                break;

            case RESULT_CANCELED:
                txtReturnData.setText("SecondActivity已按下取消");
                break;
        }
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
