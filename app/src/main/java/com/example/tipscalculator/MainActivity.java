package com.example.tipscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    private double progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.price = findViewById(R.id.textInputEditText);
        this.mViewHolder.seekBar = findViewById(R.id.seekBar);
        this.mViewHolder.total = findViewById(R.id.total);
        this.mViewHolder.valueTips = findViewById(R.id.valueTips);
        this.mViewHolder.textView = findViewById(R.id.textView3);
        mViewHolder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                mViewHolder.textView.setText(Math.round(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calculate();
            }
        });

    }
    @SuppressLint("SetTextI18n")
    public void calculate(){
        if(mViewHolder.price.getText().toString().equals("") || mViewHolder.price.getText().toString().isEmpty()){
            Toast.makeText(this, "Please add a value", Toast.LENGTH_SHORT).show();
        }else{
        Double price = Double.parseDouble(mViewHolder.price.getText().toString());
        Double valueTips = price*(progress/100);
        mViewHolder.valueTips.setText(valueTips.toString());
        double total = price+valueTips;
        mViewHolder.total.setText("$ "+String.format(String.valueOf(total)));
        }
    }


    public static class ViewHolder{
        TextView textView, valueTips, total;
        SeekBar seekBar;
        EditText price;
    }
}