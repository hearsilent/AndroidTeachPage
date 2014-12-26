package com.example.user12.activitytext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.util.concurrent.Delayed;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;


public class MyActivity extends Activity {

    Button click;
    TextView ck;
    int a=0;
    Handler handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        click=(Button)findViewById(R.id.button);
        ck=(TextView)findViewById(R.id.textView);
        click.setText("開始");
        click.setOnClickListener(start);
    }


    private View.OnClickListener start=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            click.setText("點擊");
            click.setOnClickListener(cl);
            handler.postDelayed(re,10000);

        }
    };

    private Runnable re=new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(MyActivity.this,anotherActivity.class);
            intent.putExtra("0123",String.valueOf(a));
            startActivity(intent);
            finish();
        }
    } ;


    private View.OnClickListener cl=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            a++;
            ck.setText(String.valueOf(a));
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
