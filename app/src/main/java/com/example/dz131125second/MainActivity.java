package com.example.dz131125second;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements Constants {

    private EditText txtName;
    private EditText txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
    }

    private void initView() {
        txtName = findViewById(R.id.textName);
        txtAge = findViewById(R.id.textAge);

        Button btnOpenCard = findViewById(R.id.btnOpenCard);
        btnOpenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCard = new Intent(MainActivity.this, BirthdayCardActivity.class);
                openCard.putExtra(YOUR_NAME, txtName.getText().toString());
                openCard.putExtra(YOUR_AGE, txtAge.getText().toString());
                startActivity(openCard);
            }
        });
    }
}