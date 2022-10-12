package com.example.android.kabootar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StandardActivityList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standard_request_list);

        View view1 =(View)findViewById(R.id.list_item_1);
        View view2 =(View)findViewById(R.id.lost_id_view);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LeavingCertificate();
            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LostId();
            }
        });
    }
    public void LeavingCertificate(){
        Intent intent = new Intent(this, StandardRequestActivity.class);
        startActivity(intent);
    }
    public void LostId(){
        Intent intent = new Intent(this, StandardRequestActivity2.class);
        startActivity(intent);
    }



}