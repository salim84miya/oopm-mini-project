package com.example.android.kabootar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view1 =(View)findViewById(R.id.standard);
        View view2 =(View)findViewById(R.id.special);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                standard();
            }
        });

        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                special();
            }
        });

    }
   public void standard(){
        Intent intent = new Intent(this,StandardActivity.class);
        startActivity(intent);
   }
    public void special(){
        Intent intent = new Intent(this,SpecialActivity.class);
        startActivity(intent);
    }

}