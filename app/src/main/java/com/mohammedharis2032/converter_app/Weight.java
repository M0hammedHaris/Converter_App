package com.mohammedharis2032.converter_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Weight extends AppCompatActivity {

    EditText tempET,res;
    Button convertBtn,resetBtn;
    RadioButton c2f,f2c;
    TextView errorTV;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        tempET = (EditText) findViewById(R.id.kilogramValue);
        res = (EditText) findViewById(R.id.result);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        c2f = (RadioButton) findViewById(R.id.cTofRadio); //celsius to fahrenheit radio
        f2c = (RadioButton) findViewById(R.id.fTocRadio); //fahrenheit to celsius radio
        radioGroup  = (RadioGroup) findViewById(R.id.radioGroup) ;

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    errorTV.setText("Please select atleast one conversion method.");
                }
                else
                {
                    if(tempET.getText().toString().equals("") || tempET.getText().toString().equals(null) ){
                        errorTV.setText("Please enter a value in the text box.");
                    }else {
                        //celsius to fahrenheit radio button is clicked
                        if (c2f.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double kilogram = Double.parseDouble(value);

                            Double convertedValue = (kilogram*2.20462);

                            res.setText(String.valueOf(String.format("%.2f", convertedValue)));
                        }

                        //fahrenheit to celsius radio button is clicked
                        else if (f2c.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double pound = Double.parseDouble(value);

                            Double convertedValue = (pound/2.20462);

                            res.setText(String.valueOf(String.format("%.2f", convertedValue)));
                        }
                    }
                }


            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                errorTV.setText(null);
                tempET.setText(null);
                res.setText(null);
            }
        });
    }
}