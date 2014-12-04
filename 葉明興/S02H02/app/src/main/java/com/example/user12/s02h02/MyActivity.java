package com.example.user12.s02h02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;





public class MyActivity extends Activity {
    Button enter;
    EditText name;
    EditText password;
    int a=0;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        time=(TextView)findViewById(R.id.time);
        name = (EditText) findViewById(R.id.ed1);
        password = (EditText) findViewById(R.id.ed2);
        enter = (Button) findViewById(R.id.btn1);
        readData();
        enter.setOnClickListener(save);
        SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdate = nowdate.format(new java.util.Date());
        time.setText(sdate);

    }
    private View.OnClickListener save=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sdate = nowdate.format(new java.util.Date());
            time.setText(sdate);
            if(enter.getText().toString().equals("登入")){
               enter.setText("登出");
            }else {
                enter.setText("登入");
            }
           if (name.getText().toString().equals("")||password.getText().toString().equals("")){
              Toast.makeText(getApplicationContext(),
               "未輸入資料",Toast.LENGTH_SHORT).show();
           }else {
               saveData();
               if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                   Toast.makeText(getApplicationContext(),
                   "外部空間有誤，請檢查",Toast.LENGTH_SHORT).show();
               }else {
                   String path = Environment
                           .getExternalStorageDirectory()
                           .getAbsolutePath()
                           + "/others/";
                   Toast.makeText(getApplicationContext(), path,
                           Toast.LENGTH_SHORT).show();

                   File sdcardPath = new File(path);
                   if (!sdcardPath.exists()) {
                       sdcardPath.mkdir();
                       Toast.makeText(getApplicationContext(),
                               "建立" + path, Toast.LENGTH_SHORT).show();
                   }
                   File file = new File(path, "data" + ".txt");
                   try {
                       FileWriter fw = new FileWriter(file, true);
                       BufferedWriter bw= new BufferedWriter(fw);
                       bw.append("["+time.getText().toString()+"]"+enter.getText().toString()+
                               name.getText().toString()+"\n");
                       bw.flush();
                       bw.close();
                       fw.close();
                       Toast.makeText(getApplicationContext()
                       ,"數據儲存成功",Toast.LENGTH_SHORT).show();
                   }catch (Exception e){
                       Toast.makeText(getApplicationContext()
                       ,"數據儲存失敗",Toast.LENGTH_SHORT).show();
                       e.printStackTrace();

                   }
               }
           }
        }
    };


    private SharedPreferences settings;
    private static final String data = "DATA";
    private static final String ed2= "NAME";
    private static final String ed1 = "PASSWORD";
    private static final String btn1 = "登入";


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


    public void readData(){
        SharedPreferences settings=getSharedPreferences(data,0);
        name.setText(settings.getString(ed1,""));
        password.setText(settings.getString(ed2,""));


    }
    public void saveData(){
        SharedPreferences settings=getSharedPreferences(data,0);
        settings.edit()
                .putString(ed1,name.getText().toString())
                .putString(ed2,password.getText().toString())
                .commit();
    }


}


