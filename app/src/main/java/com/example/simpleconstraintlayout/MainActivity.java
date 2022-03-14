package com.example.simpleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel untuk button
    Button btnLogin;

    //deklarasi variabel untuk EditText
    private EditText edemail, edpassword;

    //deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel edemail dengan component pada layout
        edemail = findViewById(R.id.edEmail);
        //menghubungkan variabel edpassword dengan component pada layout
        edpassword = findViewById(R.id.edPassword);
        //menghubungkan variabel btnLogin dengan component pada layout
        Button btnLogin = findViewById(R.id.btSignin);

        btnLogin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();
                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                String email="admin@mail.com";
                String pass="123";

                if(nama.isEmpty() || password.isEmpty()){
                    edemail.setError("username harus diisi");
                    edpassword.setError("password harus diisi");
                }else{
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "login berhasil", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a",nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), ActivityKedua.class);

                        i.putExtras(b);

                        startActivity(i);

                    } else if (nama.equals(email)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "username anda salah", Toast.LENGTH_LONG);
                        t.show();
                    } else if (password.equals("pass")) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "password anda salah", Toast.LENGTH_LONG);
                        t.show();
                    } else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "usernname dan password salah", Toast.LENGTH_LONG);
                        t.show();
                    }
                }


            }
        });
    }
}