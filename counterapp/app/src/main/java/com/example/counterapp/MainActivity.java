package com.example.counterapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblCounter;
    Button btnStart,btnStop;
    int counter=0;
    boolean running = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblCounter=(TextView)findViewById(R.id.lbl_text);
        btnStart=(Button)findViewById(R.id.btn_start);
        btnStop=(Button)findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }



    public void onClick(View v)
    {
        if(v.equals(btnStart))
        {
            counter = 0;
            running = true;
            new MyCounter().start();
        }
        else if(v.equals(btnStop))
        {
            running = false;
        }
    }
    class MyCounter extends Thread
    {
        public void run()
        {
            while(running)
            {
                counter++;
                try {



                    lblCounter.setText(String.valueOf(counter));
                    Thread.sleep(1000);
                }
                catch(Exception e) { }
            }
        }
    }
}