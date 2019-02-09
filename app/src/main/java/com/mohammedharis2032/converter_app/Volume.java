package com.mohammedharis2032.converter_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Volume extends AppCompatActivity {

    EditText tempET,res;
    Button convertBtn,resetBtn;
    RadioButton c2f,f2c;
    TextView errorTV;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        tempET = (EditText) findViewById(R.id.volumeValue);
        res = (EditText) findViewById(R.id.result);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        errorTV = (TextView) findViewById(R.id.errorTextView);
        c2f = (RadioButton) findViewById(R.id.cTofRadio);
        f2c = (RadioButton) findViewById(R.id.fTocRadio);
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
                        if (c2f.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double litre = Double.parseDouble(value);

                            Double convertedValue = (litre/3.785);

                            res.setText(String.valueOf(String.format("%.2f", convertedValue)));
                        }

                        else if (f2c.isChecked()) {
                            errorTV.setText(null);
                            String value = tempET.getText().toString();
                            Double gallon = Double.parseDouble(value);

                            Double convertedValue = (gallon*3.785);

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