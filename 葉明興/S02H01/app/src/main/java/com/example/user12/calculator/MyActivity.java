package com.example.user12.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.BitSet;


public class MyActivity extends Activity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btn_f;               //小數點
    Button btn_add;             //加
    Button btn_tim;             //乘
    Button btn_min;            //減
    Button btn_div;            //除
    Button btn_end;
    Button btnc;
    TextView tv1;
    Double i=0.0;
    Double j=0.0;
    Double k=0.0;
    int a=0;
    int b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_div=(Button)findViewById(R.id.btn_div);
        btn_f=(Button)findViewById(R.id.btn_f);
        btn_min=(Button)findViewById(R.id.btn_min);
        btn_tim=(Button)findViewById(R.id.btn_tim);
        btn_end=(Button)findViewById(R.id.btn_end);
        btnc=(Button)findViewById(R.id.btnc);
        tv1=(TextView)findViewById(R.id.tv1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (a == 0) {
                      i = i * 10 + 1;
                      tv1.setText(i.toString());
                  } else {
                      j = j * 10 + 1;
                      tv1.setText(j.toString());
                  }
               };
    });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (a == 0) {
                        i = i * 10 + 2;
                        tv1.setText(i.toString());
                    } else {
                        j = j * 10 + 2;
                        tv1.setText(j.toString());
                    }
            };
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (a==0){
                    i=i*10+3;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+3;
                    tv1.setText(j.toString());
                }
            };
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+4;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+4;
                    tv1.setText(j.toString());
                }
            };
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+5;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+5;
                    tv1.setText(j.toString());
                }
            };
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+6;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+6;
                    tv1.setText(j.toString());
                }
            };
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+7;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+7;
                    tv1.setText(j.toString());
                }
            };
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+8;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+8;
                    tv1.setText(j.toString());
                }
            };
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+9;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+9;
                    tv1.setText(j.toString());
                }
            };
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a==0){
                    i=i*10+0;
                    tv1.setText(i.toString());
                }else {
                    j = j*10+0;
                    tv1.setText(j.toString());
                }
            };
        });
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=1;
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=1;
                b=0;
            }
        });
        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=2;
                b=0;
            }
        });
        btn_tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=3;
                b=0;
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=4;
                b=0;
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a) {
                    case 0:
                        k=i;
                        break;
                    case 1:
                        k=i+j+k;
                        break;
                    case  2:
                        k=(i+k)-j;
                        break;
                    case 3:
                        k=(i+k)*j;
                        break;
                    case 4:
                        if (j==0.0) {
                        }else {
                            k = (i + k) / j;
                        }
                        break;
                }
                tv1.setText(k.toString());
                i=0.0;
                j=0.0;

            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0.0;
                j=0.0;
                k=0.0;
                a=0;
                b=0;
                tv1.setText("0");
            }
        });

       }







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
