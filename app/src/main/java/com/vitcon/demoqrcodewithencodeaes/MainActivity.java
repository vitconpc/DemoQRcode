package com.vitcon.demoqrcodewithencodeaes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToGenerateCode(View view) {
        Intent intent = new Intent(this,GenerateCodeActivity.class);
        startActivity(intent);
    }

    public void goToScanQRCode(View view) {
        Intent intent = new Intent(this,ScanQrCodeActivity.class);
        startActivity(intent);
    }
}
