package com.example.yuan.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    Button cal;
    Button clear;
    TextView Re;
    TextView Co;
    EditText ed1;
    EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = (Button) findViewById(R.id.button);
        clear = (Button) findViewById(R.id.button2);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        Re = (TextView) findViewById(R.id.textView4);
        Co = (TextView) findViewById(R.id.textView5);
        cal.setOnClickListener(calBMI);
        clear.setOnClickListener(clearall);

            }



        private View.OnClickListener calBMI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(ed1.getText().toString()) / 100;
                double weigh = Double.parseDouble(ed2.getText().toString());
                double result = weigh / (height * height);
                Re.setText(String.valueOf(result));


                if (result > 24) {
                    Co.setText("體重過重");
                }
                if (result < 18) {
                    Co.setText("體重過輕");
                }
                if (result<24&&result>18) {
                    Co.setText("體重標準");
                }
            }
        };
        private View.OnClickListener clearall = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                Re.setText("");
                Co.setText("");
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

