package com.example.uts;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Button submit = findViewById(R.id.tombolsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();

                Log.d("RegisterActivity",
                        "Tombol register diklik. Informasi pengguna: " + usernameText + " " + passwordText);
                String message = "Username: " + usernameText + "\nPassword: " + passwordText;
                Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem items) {

        if (items.getItemId() == android.R.id.home) {

            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(items);
    }
}