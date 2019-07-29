package com.vitcon.demoqrcodewithencodeaes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanQrCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScanerView;
    private TextView mResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr_code);
        mScanerView = findViewById(R.id.scannerView);
        mResult = findViewById(R.id.txt_data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScanerView.setResultHandler(this);
        mScanerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScanerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        if (rawResult== null){
            return;
        }
        String dataResult = Encryptor.decrypt(StringCommons.KEY_ENCODE, rawResult.getText());
        mResult.setText(dataResult);
        mScanerView.resumeCameraPreview(this);
    }

    public void Continue(View view) {
        onBackPressed();
    }
}
