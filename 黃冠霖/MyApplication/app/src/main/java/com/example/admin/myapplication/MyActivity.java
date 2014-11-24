package com.example.admin.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {
    Button cal;
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    EditText e;
    EditText f;
    Double g = 0.0;
    Double h = 0.0;
    Double j = 0.0;
    TextView k;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        cal = (Button) findViewById(R.id.button);
        cal.setOnClickListener(calBMI);


        a = (TextView) findViewById(R.id.textView);
        b = (TextView) findViewById(R.id.textView2);
        c = (TextView) findViewById(R.id.textView3);
        d = (TextView) findViewById(R.id.textView4);
        e = (EditText) findViewById(R.id.editText);
        f = (EditText) findViewById(R.id.editText2);
        k = (TextView) findViewById(R.id.textView5);

    }

    private View.OnClickListener calBMI = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            g = Double.parseDouble(e.getText().toString());
            h = Double.parseDouble(f.getText().toString());
            j=h/(g*g)*10000;
            //if (g==0.0||h==0.0){

           // }
            d.setText(j.toString());
            if (j > 24) {
                k.setText("過重");
            }
            if (j < 24 && j > 18) {
                k.setText("正常");
            }
            if (j < 18) {
                k.setText("過輕");
            }
        }
    };









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.action_settings){
        }
        return super.onOptionsItemSelected(item);
    }
}
