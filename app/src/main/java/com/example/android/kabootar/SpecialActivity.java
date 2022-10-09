package com.example.android.kabootar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpecialActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner branchNameSpinner;
    private Spinner batchSpinner;
    String branch;
    String name;
    EditText inputName;
    String letter;
    Button submit;
    String displaymessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        branchNameSpinner=findViewById(R.id.branch_spinner);
        branchNameSpinner.setOnItemSelectedListener(this);
        String []branchName = getResources().getStringArray(R.array.branch_name);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,branchName);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchNameSpinner.setAdapter(adapter);

        batchSpinner=findViewById(R.id.branch_spinner2);
        batchSpinner.setOnItemSelectedListener(this);
        String []batchNo = getResources().getStringArray(R.array.batch_no);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,batchNo);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        batchSpinner.setAdapter(adapter1);


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
        inputName = (EditText) findViewById(R.id.edit_text_person_name);
        name= inputName.getText().toString();

        letter = "To,\n"+
                "The Principal ,\n"+
                "SMT INDIRA GANDHI COLLEGE OF ENGINEERING,\n"+
                "Sector 8, Plot 1, Ghansoli, Navi Mumbai,\n"+
                "Maharashtra 400701\n"+
        "Date: __/__/____\n"+

        "\n\nSubject: Request for College leaving certificate.\n"+

                "\nRespected Sir / Madam,\n"+
                "               With due respect, I would like to state that, I am "+name +" and was a student of your college batch number ____________ (Batch). I was a student of   "+branch+". I cleared with good marks cleared all my semester examinations.\n"+
                "               As I’ve to get myself enrolled in another institute for further education I need to submit a college leaving certificate issued by you in my name. In order to prevent harm to my further studies, I need to deposit the certificate as soon as possible. Therefore, I request you to kindly issue a college leaving certificate at the earliest.\n"+

        "\n\n\nThanking you,\n"+
        "Yours Truly,\n"+
        name+",\n";

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