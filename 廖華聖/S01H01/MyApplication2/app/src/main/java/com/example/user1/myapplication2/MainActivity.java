package com.example.user1.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    Button cal;
    EditText Kg;
    EditText M;
    EditText label1;
    EditText label2;
    TextView label3;
    TextView TEXT;
    TextView Hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal = (Button) findViewById(R.id.button);
        Kg = (EditText) findViewById(R.id.editText3);
        M = (EditText) findViewById(R.id.editText);
        label1 =(EditText)findViewById(R.id.editText2);
        label2 =(EditText)findViewById(R.id.editText4);
        label3 =(TextView)findViewById(R.id.textView2);
        TEXT = (TextView) findViewById(R.id.textView);
        Hint = (TextView)findViewById(R.id.textView3);
        cal.setOnClickListener(calBMI);
    }
    private View.OnClickListener calBMI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double a = Double.parseDouble(M.getText().toString())/100;
            double b =Double.parseDouble(Kg.getText().toString());
            double d = b/(a*a);
            TextView result =(TextView)findViewById(R.id.textView);
            result.setText(Double.toString(d));

            if (d< 19) {
                Hint.setText("你是厭食症??");
            }
            else {
              if (d>24){
                  Hint.setText("是不會減肥嗎??豬");
              }
             else {
                 Hint.setText("只是暫時別得意");

                  }
              }
            }

        };


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
