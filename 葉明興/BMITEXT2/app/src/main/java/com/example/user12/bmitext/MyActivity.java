package com.example.user12.bmitext;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {
    Button btn;
    double a;
    double b;
    double c;
    TextView i;
    TextView j;
    EditText ed1;
    EditText ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btn =(Button)findViewById(R.id.btn);
        i=(TextView)findViewById(R.id.textView4);
        j=(TextView)findViewById(R.id.tv5);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        btn.setOnClickListener(calBMI);




    }
    private View.OnClickListener calBMI=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            a=Double.parseDouble(ed1.getText().toString());    //體重
            b=Double.parseDouble(ed2.getText().toString());    //身高
            c=a/(b*b)*10000;
            i.setText(String.valueOf(c));

           j.setText(c>24?"過重":(c<18?"過輕":"標準"));


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
        return super.onOptionsItemSelected(item);
    }
}
