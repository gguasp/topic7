package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Date currentTime = Calendar.getInstance().getTime();
                String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
                dateButton.setBackgroundColor(Color.GREEN);
                dateButton.setText(dateString);
            }
        });

        final ImageButton copyButton = findViewById(R.id.copyButton);
        copyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                copyButton.playSoundEffect(SoundEffectConstants.CLICK);
                EditText et1 = findViewById(R.id.EditText1);
                EditText et2 = findViewById(R.id.EditText2);
                et2.setText(et1.getText());
            }
        });

        final CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    if(checkBox.isChecked()){
                        checkBox.setText("This Checkbox is: Checked");
                    }else{
                        checkBox.setText("This Checkbox is: Unchecked");
                    }
                }
            });

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

    }

    public void comprobarColor(View view) {
        TextView colorView = findViewById(R.id.coloredTextView);
        if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton) {
            colorView.setBackgroundColor(Color.BLUE);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton2){
            colorView.setBackgroundColor(Color.RED);
        }else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton3){
            colorView.setBackgroundColor(Color.GREEN);
        }
    }


}