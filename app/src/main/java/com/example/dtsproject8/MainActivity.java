package com.example.dtsproject8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button create;
    Button update;
    Button read;
    Button delete;
    TextView hasil;

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        create = (Button) findViewById(R.id.btnCreate);
        read = (Button) findViewById(R.id.btnRead);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btnDelete);

        hasil = (TextView) findViewById(R.id.tvHasil);
        create.setOnClickListener(this);
        update.setOnClickListener(this);
        read.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreate:
                createFile();
                break;
            case R.id.btnRead:
                bacaFie();
                break;
            case R.id.btnUpdate:
                break;
            case R.id.btnDelete:
                hapusFile();
                break;
            default:
        }
    }

    private void createFile(){
        File file = new File(getFilesDir(), "coba.txt");
        Log.d(TAG, "createFile: "+getFilesDir().getAbsolutePath());
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write("Coba isi data file text".getBytes());
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void bacaFie(){
        File file = new File(getFilesDir(), "coba.txt");
        if (file.exists()){
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null){
                    builder.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            hasil.setText(builder.toString());
        } else {
            Log.d(TAG, "bacaFie: "+file.exists());
            hasil.setText("");
        }
    }

    private void updateFie(){
        File file = new File(getFilesDir(), "coba.txt");
        if (file.exists()){
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null){
                    builder.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            hasil.setText(builder.toString());
        }
    }

    private void hapusFile(){
        File file = new File(getFilesDir(), "coba.txt");
        if (file.exists())
            Log.d(TAG, "hapusFile: "+file.delete()); ;
    }
}