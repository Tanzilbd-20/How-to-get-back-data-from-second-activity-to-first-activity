package com.example.intentdataandgetreturn;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user_edit_text;
    private Button button;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_edit_text = findViewById(R.id.user_edit_text);
        button = findViewById(R.id.button);



        button.setOnClickListener(view -> {
            String value = user_edit_text.getText().toString().trim();
            if (!value.isEmpty()){
                Intent intent = new Intent(MainActivity.this, User_Data.class);
            intent.putExtra("name", value);
            intent.putExtra("age", 23);
            intent.putExtra("gender", "Male");
            startActivityForResult(intent,REQUEST_CODE);
            /*startActivity(intent);*/
        }else {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){

                assert data != null;
                String message = data.getStringExtra("message_back");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}