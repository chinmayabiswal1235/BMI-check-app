package com.example.bmicheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }
    public void myButtonListenerMethod(){
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText height=(EditText)findViewById(R.id.height);
                String heightStr=height.getText().toString();
                double height1=Double.parseDouble(heightStr);
                final EditText weight=(EditText)findViewById(R.id.weight);
                String weightStr=weight.getText().toString();
                double weight1=Double.parseDouble(weightStr);
                double BMI=(weight1)/(height1*height1);
                DecimalFormat df=new DecimalFormat("#.#");
                double BMI_trimmed=Double.parseDouble(df.format(BMI));
                final EditText BMIResult=(EditText)findViewById(R.id.bmi);
                BMIResult.setText(Double.toString(BMI_trimmed));
                String BMI_Cat;
                if(BMI<16)
                    BMI_Cat="Very severely underweight";
                else if(BMI>16&&BMI<18.4)
                    BMI_Cat="Severely underweight";
               else if(BMI>18.5&&BMI<24.9)
                    BMI_Cat="Underweight";
                else if(BMI>25.0&&BMI<29.9)
                    BMI_Cat="Normal";
               else if(BMI>30.0&&BMI<34.9)
                    BMI_Cat="Overweight";
               else if(BMI>35.0&&BMI<39.9)
                   BMI_Cat="Obese Class-1-Moderately obese";
                else if(BMI>40)
                    BMI_Cat="Obese Class-2-Severely obese";
                else
                    BMI_Cat="Obese Class-3-Very severely obese";
                final TextView BMICategory=(TextView)findViewById(R.id.category);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}