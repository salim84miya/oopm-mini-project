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

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                standardList();
            }
        });
    }
    public void standardList(){
        Intent intent = new Intent(this, StandardRequestActivity.class);
        startActivity(intent);
    }

}