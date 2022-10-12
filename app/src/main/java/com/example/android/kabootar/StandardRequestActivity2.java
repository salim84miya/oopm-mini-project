package com.example.android.kabootar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class StandardRequestActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner branchNameSpinner;
    String branch;
    String name;
    String rollno;
    String date;
    EditText inputName;
    EditText inputRollNo;
    String letter;
    Button submit;
    String displaymessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_page);

        View view = findViewById(R.id.branch_spinner2);
        view.setVisibility(View.GONE);

        Calendar calendar = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
        date=CurrentDate;
        branchNameSpinner=findViewById(R.id.branch_spinner);
        branchNameSpinner.setOnItemSelectedListener(this);
        String []branchName = getResources().getStringArray(R.array.branch_name);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,branchName);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchNameSpinner.setAdapter(adapter);

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
                    Toast.makeText(StandardRequestActivity2.this, "There is no application that support this action",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String Letterformat(){
        inputName = (EditText) findViewById(R.id.edit_text_person_name);
        name= inputName.getText().toString();

        inputRollNo = (EditText) findViewById(R.id.edit_text_roll_no);
        rollno= inputRollNo.getText().toString();

        letter = "To,\n"+
                "The Principal ,\n"+
                "SMT INDIRA GANDHI COLLEGE OF ENGINEERING,\n"+
                "Sector 8, Plot 1, Ghansoli, Navi Mumbai,\n"+
                "Maharashtra 400701\n"+
                "Date:"+date+"\n"+

                "\n\nSubject: Identity card lost application.\n"+

                "\nRespected Sir / Madam,\n"+
                "               Most respectfully, I would like to state that my name is "+name +" and I am a student of "+branch+" department of your reputed college having roll number " +rollno+"."+
                "I am most apologetically writing this letter to inform you that my college ID (Identity) card has been lost and is missing for last couple of days. I have tried searching all places but failed to find it.\n"+
                "               Therefore, I request you to kindly issue me with a duplicate Identity card at the earliest. I shall be highly obliged for your kind support. I am ready to pay all applicable charges (if any).\n"+

                "\nThanking you,\n"+
                "Yours Truly,\n"+
                name+".\n";

        return letter;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.branch_spinner ){
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
            branch= valueFromSpinner;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    }
