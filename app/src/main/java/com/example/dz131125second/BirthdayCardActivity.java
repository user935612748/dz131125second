package com.example.dz131125second;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BirthdayCardActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_birthday_card);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra(YOUR_NAME);
        String age = getIntent().getStringExtra(YOUR_AGE);

        ImageView imageView = findViewById(R.id.imageViewCard);
        TextView birthdayText = findViewById(R.id.textBirthday);
        TextView ageText = findViewById(R.id.textAge);
        Button btnReturn = findViewById(R.id.btnReturn);

        String birthdayMessage = getString(R.string.happy_birthday) + name + "!";
        birthdayText.setText(birthdayMessage);

        if (age != null && !age.isEmpty()) {
            String ageMessage = "Тебе " + age + " лет!";
            ageText.setText(ageMessage);
        } else {
            ageText.setText("С днем рождения!");
        }

        imageView.setImageResource(R.drawable.birthday_card);

        btnReturn.setOnClickListener(v -> finish());
    }
}