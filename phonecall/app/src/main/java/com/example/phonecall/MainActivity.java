package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnOne,btnTwo,btnThree,btnFour,btnFive;
    Button btnSix,btnSeven,btnEight,btnNine,btnZero;
    Button btnDel,btnStar,btnHash,btnCall,btnSave;
    EditText txtPhonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne=(Button)findViewById(R.id.btn_one);
        btnOne.setOnClickListener(this);
        btnTwo=(Button)findViewById(R.id.btn_two);
        btnTwo.setOnClickListener(this);
        btnThree=(Button)findViewById(R.id.btn_three);


        btnThree.setOnClickListener(this);
        btnFour=(Button)findViewById(R.id.btn_four);
        btnFour.setOnClickListener(this);
        btnFive=(Button)findViewById(R.id.btn_five);
        btnFive.setOnClickListener(this);
        btnSix=(Button)findViewById(R.id.btn_six);
        btnSix.setOnClickListener(this);
        btnSeven=(Button)findViewById(R.id.btn_seven);
        btnSeven.setOnClickListener(this);
        btnEight=(Button)findViewById(R.id.btn_eight);
        btnEight.setOnClickListener(this);
        btnNine=(Button)findViewById(R.id.btn_nine);
        btnNine.setOnClickListener(this);
        btnZero=(Button)findViewById(R.id.btn_zero);
        btnZero.setOnClickListener(this);
        btnStar=(Button)findViewById(R.id.btn_start);
        btnStar.setOnClickListener(this);
        btnHash=(Button)findViewById(R.id.btn_hash);
        btnHash.setOnClickListener(this);
        btnCall=(Button)findViewById(R.id.btn_call);
        btnCall.setOnClickListener(this);
        btnSave=(Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnDel=(Button)findViewById(R.id.btn_delete);
        btnDel.setOnClickListener(this);
        txtPhonenumber=(EditText)findViewById(R.id.txt_phonenumber);


    }
    public void onClick(View v)
    {
        if(v.equals(btnOne))
            txtPhonenumber.append("1");
        else if(v.equals(btnTwo))
            txtPhonenumber.append("2");
        else if(v.equals(btnThree))
            txtPhonenumber.append("3");
        else if(v.equals(btnFour))
            txtPhonenumber.append("4");
        else if(v.equals(btnFive))
            txtPhonenumber.append("5");
        else if(v.equals(btnSix))
            txtPhonenumber.append("6");
        else if(v.equals(btnSeven))
            txtPhonenumber.append("7");
        else if(v.equals(btnEight))
            txtPhonenumber.append("8");
        else if(v.equals(btnNine))
            txtPhonenumber.append("9");
        else if(v.equals(btnZero))
            txtPhonenumber.append("0");
        else if(v.equals(btnStar))
            txtPhonenumber.append("*");
        else if(v.equals(btnHash))
            txtPhonenumber.append("#");

else if(v.equals(btnSave))
    {
        Intent contactIntent= new Intent(ContactsContract.Intents.Insert.ACTION);
        contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
        contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,
                txtPhonenumber.getText().toString());
        startActivity(contactIntent);
    }

    else if(v.equals(btnDel))
    {
        String data=txtPhonenumber.getText().toString();
        if(data.length()>0)
        {
            txtPhonenumber.setText(data.substring(0,data.length()-1));
        }
        else
        {
            txtPhonenumber.setText("");
        }
    }
        btnCall.setOnClickListener(new View.OnClickListener()
                                   {


                                       @Override
                                       public void onClick(View v) {
                                           String data = txtPhonenumber.getText().toString();
                                           Intent intent=new Intent(Intent.ACTION_DIAL);
                                           intent.setData(Uri.parse("tel:"+ data));
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}