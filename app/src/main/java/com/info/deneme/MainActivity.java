package com.info.deneme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private EditText kulAdi, sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kulAdi = findViewById(R.id.kulAdi);
        sifre = findViewById(R.id.sifre);

        sp = getSharedPreferences("com.info.deneme", MODE_PRIVATE);
        editor = sp.edit();

        String kullaniciAdi = sp.getString("kulAdi", "");
        String sifree = sp.getString("sifre", "");

       kulAdi.setText(kullaniciAdi);
       sifre.setText(sifree);
    }



    public void girisYap(View view) {

        String kullaniciAdi = sp.getString("kulAdi", "Kullanici Adi Verisinde Bir Sorun Var");
        String sifree = sp.getString("sifre", "Şifre Verisinde Bir Sorun Var");


        if (kulAdi.getText().toString().matches(kullaniciAdi) && sifre.getText().toString().matches(sifree)) {

            startActivity(new Intent(MainActivity.this, DigerActivity.class));
            finish();
        }


        if (!kulAdi.getText().toString().matches(kullaniciAdi) && !sifre.getText().toString().matches(sifree)) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setIcon(R.drawable.dikkat_resim);
            alert.setTitle("Dikkat!!!");
            alert.setMessage("Bu Kullanıcı Adına ve Şifreye Sahip Bir Kullanıcı Yok!!!");

            alert.setPositiveButton("Kayıt Ol", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(MainActivity.this, KayitActivity.class));
                    finish();
                }
            });

            alert.setNegativeButton("Tekrar Dene", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    finish();
                }
            });

            alert.show();

        }

    }
    public void kayitOl(View view) {

        startActivity(new Intent(MainActivity.this, KayitActivity.class));
        finish();

    }
}
