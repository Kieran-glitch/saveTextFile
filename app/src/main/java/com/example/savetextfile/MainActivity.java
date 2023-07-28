package com.example.savetextfile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String fileName="example.txt";
    EditText et;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editTextText);
    }
    public void save(View v){
        String text=et.getText().toString();
        FileOutputStream f=null;
        try{
            f=openFileOutput(fileName,MODE_PRIVATE);
            f.write(text.getBytes());
            et.getText().clear();
            Toast.makeText(MainActivity.this,"Saved to:"+getFilesDir()+"/"+fileName,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(f!=null){
                try{
                    f.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}