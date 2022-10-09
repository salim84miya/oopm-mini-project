package com.example.android.kabootar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SpecialRequestPage extends AppCompatActivity {


    String subject;
    String message;
    Button submit;
    EditText inputName;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_request);

    }


    public void submit(View view) {
        inputName = (EditText) findViewById(R.id.subject);
        subject= inputName.getText().toString();

        description = (EditText) findViewById(R.id.body_of_message);
        message= description.getText().toString();

        String email = "salimsaudagar84@gmail.com";
        String[] addresses = email.split(",");
        submit = findViewById(R.id.submit_button1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);

                intent1.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent1.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent1.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent1.putExtra(Intent.EXTRA_TEXT, message);
                intent1.setType("message/rfc822");
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                } else {
                    Toast.makeText(SpecialRequestPage.this, "There is no application that support this action",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    }