package com.info.deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DigerActivity extends AppCompatActivity {

    private TextView textView1, textView2;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diger);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        sp = getSharedPreferences("com.info.deneme",MODE_PRIVATE);
        editor = sp.edit();


        String kullaniciAdi = sp.getString("kulAdi","Kullanıcı Adı Verisinde Sorun Var");
        String sifree = sp.getString("sifre","Şifre Verisinde Sorun Var");

        textView1.setText("Kulanıcı Adınız : " + kullaniciAdi);
        textView2.setText("Şifreniz : " + sifree);


    }


    public void cikisYap(View view){

        startActivity(new Intent(DigerActivity.this,MainActivity.class));
        editor.remove("kulAdi");
        editor.remove("sifre");
        editor.commit();
        finish();
    }
}