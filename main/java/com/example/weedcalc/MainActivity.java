package com.example.weedcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    private double flowers = 0;
    private double liquids = 0;
    private double edibles = 0;
    double total =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.txtResult);

        EditText flower = (EditText)findViewById(R.id.txtFlower);
        EditText liquid = (EditText)findViewById(R.id.txtLiquid);
        EditText edible = (EditText)findViewById(R.id.txtEdible);

        Button button = (Button)findViewById(R.id.btnCalculate);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                total = 0;
                if (flower.getText() != null && !flower.getText().toString().equals("")){
                    flowers = Double.parseDouble(flower.getText().toString());
                }
                else{
                    flowers = 0;
                }
                if (liquid.getText() != null && !liquid.getText().toString().equals("")) {
                    liquids = Double.parseDouble(liquid.getText().toString());// * 12;
                }
                else{
                    liquids = 0;
                }
                if (edible.getText() != null && !edible.getText().toString().equals("")) {
                    edibles = Double.parseDouble(edible.getText().toString());// * 32;
                }
                else{
                    edibles = 0;
                }

                total = flowers + liquids + edibles;

                if (total > 2.5) {
                    result.setTextColor(getResources().getColor(R.color.red));
                    result.setText("Total Weight = " + total);
                }
                else {
                    result.setTextColor(getResources().getColor(R.color.green));
                    result.setText("Total Weight = " + total);
                }
                if(total > 2.5){

                    Toast.makeText(getApplicationContext(),"Too Much Weight",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}