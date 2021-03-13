package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    EditText etUpdateItem;
    Button btnSave;

    private static final String RESULT_CODE = "Result code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etUpdateItem = findViewById(R.id.etUpdateItem);
        btnSave = findViewById(R.id.btnSave);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit item");
        }

        etUpdateItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();

            intent.putExtra(MainActivity.KEY_ITEM_TEXT, etUpdateItem.getText().toString());
            intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

            setResult(RESULT_OK, intent);
            finish();
        });

    }
}