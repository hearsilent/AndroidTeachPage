package com.example.user12.activitytext;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class anotherActivity extends Activity {


    AlertDialog.Builder dilog;
    TextView  end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        end=(TextView)findViewById(R.id.textView);
        Bundle bundle=getIntent().getExtras();
        end.setText(bundle.getCharSequence("0123"));
         dilog=new AlertDialog.Builder(this);
        dilog.setTitle("結果");
        dilog.setMessage("一共點擊了"+end.getText().toString()+"次");
        dilog.setPositiveButton("確定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(anotherActivity.this,MyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dilog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.another, menu);
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
