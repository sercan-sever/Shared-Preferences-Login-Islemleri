package com.info.deneme;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KayitActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private EditText kulAdi,sifre;
    private Toolbar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        kulAdi = findViewById(R.id.kulAdi);
        sifre = findViewById(R.id.sifre);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Kayıt Ekranı");
        setSupportActionBar(toolbar);




        sp = getSharedPreferences("com.info.deneme",MODE_PRIVATE);
        editor = sp.edit();



    }


    public void kayitOl(View view){

      kayitOlma();

    }

    public void kayitOlma(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        if (kulAdi.getText().toString().matches("") && sifre.getText().toString().matches("")){

            alert.setIcon(R.drawable.dikkat_resim);
            alert.setTitle("DİKKAT !!!");
            alert.setMessage("Şifre ve Kullanıcı Adınızı Doldurunuz !!!");

            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(KayitActivity.this,KayitActivity.class));
                    finish();
                }
            });
            alert.show();
        }



        if (kulAdi.getText().toString().matches("") && !sifre.getText().toString().matches("")){

            alert.setIcon(R.drawable.dikkat_resim);
            alert.setTitle("DİKKAT !!!");
            alert.setMessage("Kullanıcı Adınızı Doldurunuz !!!");

            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(KayitActivity.this,KayitActivity.class));
                    finish();
                }
            });
            alert.show();
        }


        if (!kulAdi.getText().toString().matches("") && sifre.getText().toString().matches("")){

            alert.setIcon(R.drawable.dikkat_resim);
            alert.setTitle("DİKKAT !!!");
            alert.setMessage("Şifre Kısmını Doldurunuz !!!");

            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(KayitActivity.this,KayitActivity.class));
                    finish();
                }
            });
            alert.show();
        }

        sp = getSharedPreferences("com.info.deneme",MODE_PRIVATE);

        String kullaniciAdi = sp.getString("kulAdi","Kullanıcı Adı Verisinde Sorun Var");

        if (!kulAdi.getText().toString().matches("") && !sifre.getText().toString().matches("") && !kulAdi.getText().toString().matches(kullaniciAdi)){

            editor.putString("kulAdi",kulAdi.getText().toString());
            editor.putString("sifre",sifre.getText().toString());
            editor.commit();

            alert.setIcon(R.drawable.basarili_resim);
            alert.setTitle("Kayıt Olundu");
            alert.setMessage("Başarılı Bir Şekilde Kayıt Yapıldı...");

            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(KayitActivity.this,MainActivity.class));
                    finish();
                }
            });
            alert.show();
        }


        if (kulAdi.getText().toString().matches(kullaniciAdi)){

            alert.setIcon(R.drawable.dikkat_resim);
            alert.setTitle("Kullanıcı Adı");
            alert.setMessage("Bu Kullanıcı Adında Bir Kayıt Var");

            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    startActivity(new Intent(KayitActivity.this,KayitActivity.class));
                    finish();
                }
            });
            alert.show();
        }

    }

}