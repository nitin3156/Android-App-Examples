package com.live.qrscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandleClick();
    }

    public void HandleClick() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");

                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                      startActivityForResult(intent, 0); //Barcode Scanner to scan for us
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {

                Toast.makeText(getApplicationContext(),(intent.getStringExtra("SCAN_RESULT")),Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(getApplicationContext(),"Scan cancelled.",Toast.LENGTH_LONG).show();
            }
        }
    }
}