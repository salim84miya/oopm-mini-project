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

public class SpecialActivity extends AppCompatActivity {

    String name;
    EditText inputName;
    String letter;
    Button submit;
    String displaymessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
    }
    public void display(){
        TextView view =(TextView) findViewById(R.id.description);
        displaymessage=Letterformat();
        view.setText(displaymessage);

    }
    public void submit(View view){
        String email = "salimsaudagar84@gmail.com";
        String []addresses=email.split(",");
        View view1 =(View)findViewById(R.id.submit_button);
        display();
        submit=findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Application for leaving certificate");
                intent.putExtra(Intent.EXTRA_TEXT, displaymessage);
                intent.setType("message/rfc822");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else {
                    Toast.makeText(SpecialActivity.this, "There is no application that support this action",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String Letterformat(){
        inputName = (EditText) findViewById(R.id.editTextTextPersonName);
        name= inputName.getText().toString();

        letter = "To,\n"+
                "The Principal ,\n"+
                "SMT INDIRA GANDHI COLLEGE OF ENGINEERING,\n"+
                "Sector 8, Plot 1, Ghansoli, Navi Mumbai,\n"+
                "Maharashtra 400701\n"+
        "Date: __/__/____\n"+

        "\n\nSubject: Request for College leaving certificate.\n"+

                "\nRespected Sir / Madam,\n"+
                "               With due respect, I would like to state that, I am "+name +" and was a student of your college batch number ____________ (Batch). I was a student of ____________ (Course / Department). I cleared with good marks cleared all my semester examinations.\n"+
                "               As I’ve to get myself enrolled in another institute for further education I need to submit a college leaving certificate issued by you in my name. In order to prevent harm to my further studies, I need to deposit the certificate as soon as possible. Therefore, I request you to kindly issue a college leaving certificate at the earliest.\n"+

        "\n\n\nThanking you,\n"+
        "Yours Truly,\n"+
        name+",\n";

        return letter;

    }
}