package com.example.user1.miniyuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user1.miniyuan.R;


public class MainActivity extends Activity {
    Button cal;
    TextView a;
    TextView b;
    EditText ed1;
    EditText ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        a = (TextView) findViewById(R.id.textView5);
        b = (TextView) findViewById(R.id.textView6);
        cal.setOnClickListener(calBMI);
    }

    private View.OnClickListener calBMI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            double high = Double.parseDouble(ed1.getText().toString()) / 100;
            double weigh = Double.parseDouble(ed2.getText().toString());
            double result = weigh / (high * high);
            a.setText(String.valueOf(result));


            if  (result < 18) {
                b.setText("你被虐待嗎");
            }
            else{
                if (result > 24){
                    b.setText("過重");
                }
                else {
                    b.setText(" 標準");
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
