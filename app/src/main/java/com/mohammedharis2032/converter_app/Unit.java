package com.mohammedharis2032.converter_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.*;
import android.text.TextUtils;
import android.widget.Toast;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
public class Unit extends AppCompatActivity {
    EditText input,result;
    Button convertBtn,resetBtn;
    TextView errorTV;
    Double num1,num2;
    String num,original,newU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

       final Spinner unit1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Units));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit1.setAdapter(adapter);
        final Spinner unit2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Units));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit2.setAdapter(adapter2);

        input = (EditText) findViewById(R.id.unit);
        result = (EditText) findViewById(R.id.result);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        num = input.getText().toString();
        num1 = Double.parseDouble(num);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfFieldIsEmpty(input);

                if (TextUtils.isEmpty(num)) {
                    input.setError("Please enter your weight");
                    input.requestFocus();
                    return;
                }
                original = unit1.getSelectedItem().toString().toLowerCase();
                newU = unit2.getSelectedItem().toString().toLowerCase();
                switch(original)
                {
                    case "inches":
                    {
                        switch(newU)
                        {
                            case "inches":

                                num2 = num1;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "feet":

                                num2 = num1 / 12.0d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "centimeters":

                                num2 = num1 * 2.54d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "meters":

                                num2 = num1 * 0.0254d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                        }
                        break;
                    }
                    case "feet":
                    {
                        switch(newU)
                        {
                            case "inches":

                                num2 = num1*12.0d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "feet":
                                num2 = num1;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "centimeters":

                                num2 = num1*30.48d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "meters":

                                num2 = num1*0.3048d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;

                        }
                        break;
                    }

                    case "centimeters":
                    {
                        switch(newU)
                        {
                            case "inches":
                                num2 = num1 / 2.54d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "feet":
                                num2 = num1 / 30.48d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "centimeters":
                                num2 = num1;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "meters":
                                num2 = num1/100;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                        }
                        break;
                    }
                    case "meters":
                    {
                        switch(newU) {
                            case "inches":
                                num2 = num1 * 39.3701d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "feet":
                                num2 = num1 * 3.28084d;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "centimeters":
                                num2 = num1*100;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                            case "meters":
                                num2 = num1;
                                result.setText(String.valueOf(String.format("%.2f", num2)));
                                break;
                        }
                        break;
                    }

                }

            }
            private void checkIfFieldIsEmpty(EditText checkContent){
                if(checkContent.getText().toString().equals("")){
                    Toast.makeText(Unit.this, "All the input field must be filled", Toast.LENGTH_LONG).show();
                }
            }

        });

        resetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                errorTV.setText(null);
                input.setText(null);
                result.setText(null);
            }
        });

    }
}
