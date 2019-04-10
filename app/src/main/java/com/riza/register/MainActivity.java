package com.riza.register;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup jk ;
    private RadioButton btnJk;
    private DatePicker datePicker;
    private Calendar calendar;
    private EditText textView,nm,eml,almt,tgl,pass;
    private String nama,alamat,email,tanggal,kelamin,password;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (EditText) findViewById(R.id.inputTgl);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        textView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void send(View v){
        //create object intents
        nm = (EditText) findViewById(R.id.inputNama);
        nama = nm.getText().toString();
        eml = (EditText) findViewById(R.id.inputEmail);
        email = eml.getText().toString();
        almt = (EditText) findViewById(R.id.inputAlamat);
        alamat = almt.getText().toString();
        tgl = (EditText) findViewById(R.id.inputTgl);
        tanggal = tgl.getText().toString();
        RadioGroup rgjk = (RadioGroup) findViewById(R.id.kelaminGroup);
        RadioButton rbjk = (RadioButton) findViewById(rgjk.getCheckedRadioButtonId());
        kelamin = rbjk.getText().toString();
        pass = (EditText) findViewById(R.id.inputPass);
        password = pass.getText().toString();

        //class intant
        Intent intent = new Intent(this, ActivitySecound.class);
        //put data Bundle
        Bundle data = new Bundle();

        data.putString("nama",nama);
        data.putString("email",email);
        data.putString("alamat",alamat);
        data.putString("tgl",tanggal);
        data.putString("kel",kelamin);
        data.putString("pass",password);

        intent.putExtras(data);

        startActivity(intent);
    }

}
