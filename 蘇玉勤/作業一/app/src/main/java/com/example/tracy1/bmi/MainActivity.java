package com.example.tracy1.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;


public class MainActivity extends Activity {

    Button btn;
    Button btn1;
    EditText ed1;
    EditText ed2;
    TextView g;
    TextView h;
    Double a;
    Double b;
    Double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       btn=(Button)findViewById(R.id.button);
       btn1=(Button)findViewById(R.id.button2);
       ed1=(EditText)findViewById(R.id.editText);
       ed2=(EditText)findViewById(R.id.editText2);
       g=(TextView)findViewById(R.id.textView);
       h=(TextView)findViewById(R.id.textView2);
       btn.setOnClickListener(BMI);
       btn1.setOnClickListener(ers);


        };
        private View.OnClickListener ers = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ed1.setText("");
                ed2.setText("");
                g.setText("");
                h.setText("");
            }
        };

        private View.OnClickListener BMI= new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                a = Double.parseDouble(ed1.getText().toString());   //tall
                b = Double.parseDouble(ed2.getText().toString());  //weight
                c = b / (a * a) *10000;

                g.setText(c.toString());
               // h.setText(c>24?"過重":(c<18?"過輕":"標準"));

                if( c>24)
                {
                   h.setText("過重");
                }
                else if(c<18)
               {
                    h.setText("過輕");
               }
               else
               {
                   h.setText("標準");
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
