package com.example.intentdataandgetreturn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class User_Data extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_data);
        textView = findViewById(R.id.textView);

        Bundle extra = getIntent().getExtras();

        String name = extra.getString("name");
        int age = extra.getInt("age");
        String gender = extra.getString("gender");

        textView.setText("Name : "+name+"\nAge : "+age+"\nGender : "+gender);

        textView.setOnClickListener(view -> {
            Intent intent = new Intent(User_Data.this, MainActivity.class);
            intent.putExtra("message_back","This is from Second Activity");
            setResult(RESULT_OK,intent);
            finish();

        });
    }
}