package com.riza.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivitySecound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);
        //get intent
        Intent intent = getIntent();
         //Bundle
        Bundle data = intent.getExtras();

        //give data to textView
        String nama = data.getString("nama");
        TextView nm = (TextView) findViewById(R.id.outputNama);
        nm.setText(nama);
        String email = data.getString("email");
        TextView eml = (TextView) findViewById(R.id.outputEmail);
        eml.setText(email);
        String alamat = data.getString("alamat");
        TextView alm = (TextView) findViewById(R.id.outputAlamat);
        alm.setText(alamat);
        String tanggal = data.getString("tgl");
        TextView tgl = (TextView) findViewById(R.id.outputTgl);
        tgl.setText(tanggal);
        String kelamin = data.getString("kel");
        TextView kel = (TextView) findViewById(R.id.outputKel);
        kel.setText(kelamin);
        String password = data.getString("pass");
        TextView pass = (TextView) findViewById(R.id.outputPass);
        pass.setText(password);

    }

}
