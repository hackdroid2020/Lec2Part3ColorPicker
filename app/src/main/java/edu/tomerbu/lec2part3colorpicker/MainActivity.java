package edu.tomerbu.lec2part3colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etRed;
    private EditText etGreen;
    private EditText etBlue;
    private SeekBar sbRed;
    private SeekBar sbGreen;
    private SeekBar sbBlue;

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRed = findViewById(R.id.edit_red);
        etGreen = findViewById(R.id.edit_green);
        etBlue = findViewById(R.id.edit_blue);
        sbRed = findViewById(R.id.seek_red);
        sbGreen = findViewById(R.id.seek_green);
        sbBlue = findViewById(R.id.seek_blue);

        tvResult = findViewById(R.id.text_result);
        //sbRed.setOn***Listener:

        //instead of creating a new Listener Per Seekbar:
        //init a variable outside:
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int red = sbRed.getProgress(); //128
                int green = sbGreen.getProgress(); //0
                int blue = sbBlue.getProgress(); //255

                etRed.setText(String.valueOf(red));
                etBlue.setText(String.valueOf(blue));
                etGreen.setText(String.valueOf(green));

                //given a value for rgb(255, 0, 144) -> we get a color
                int color = Color.rgb(red, green, blue);
                //TODO: add a #
                //to upper case
                String colorLiteral = "#"+ Integer.toHexString(color).toUpperCase();

                tvResult.setBackgroundColor(color);
                tvResult.setText(colorLiteral);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sbRed.setOnSeekBarChangeListener(listener);
        sbGreen.setOnSeekBarChangeListener(listener);
        sbBlue.setOnSeekBarChangeListener(listener);
    }
}
