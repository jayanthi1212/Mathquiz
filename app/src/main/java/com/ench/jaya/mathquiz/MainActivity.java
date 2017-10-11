package com.ench.jaya.mathquiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.ench.jaya.mathquiz.R.id.textView;

public class MainActivity extends AppCompatActivity {
    int i1;
    TextView t1;
    TextView tx1;
    TextView t2, ed1,txtans,textans;
String mystring,mystring1;
    int correct,wrong,t3=1;
    EditText editText;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1 = (TextView) findViewById(textView);
        tx1 = (TextView) findViewById(R.id.textView7);
        txtans = (TextView) findViewById(R.id.textView6);
        editText = (EditText) findViewById(R.id.editText5);
        textans=(TextView)  findViewById(R.id.textansw);
        button=(Button)findViewById(R.id.button);
        ed1 = (TextView) findViewById(R.id.editText2);
        cal();
    }


    public  void cal() {
        Random random = new Random();
        int number = random.nextInt(6) + 1;
        mystring = String.valueOf(number);
        t1.setText(mystring);
        int number1 = random.nextInt(6) + 1;
        mystring1 = String.valueOf(number1);
        tx1.setText(mystring1);



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                int t4=Integer.parseInt(mystring)*Integer.parseInt(mystring1);

                String t5=Integer.toString(t4);

                textans.setText(t5);

                //String s1 = Integer.toString(t3);
                String gg = editText.getText().toString();
                if (t5.equals(gg)) {
                    ++correct;
                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
                    cal();
                    editText.setText("");

                } else {
                    ++wrong;
//                cal();
                }

            }
        });


//
        // txtans.setText(t1);




        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                ed1.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                ed1.setText("done!");
            }
        }.start();

    }

    }

