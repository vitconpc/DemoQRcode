package com.vitcon.demoqrcodewithencodeaes;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Hashtable;

public class GenerateCodeActivity extends AppCompatActivity {

    private EditText mEditData;
    private ImageView mImageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_code);
        initView();
    }

    private void initView() {
        mEditData = findViewById(R.id.edt_data);
        mImageCode = findViewById(R.id.image_view);
    }

    public void generateCode(View view) {
        String data = mEditData.getText().toString().trim();
        if (data.isEmpty()) {
            return;
        }
        try {
            String encode = Encryptor.encrypt(StringCommons.KEY_ENCODE, data);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            Bitmap bitmap = encoder.encodeBitmap(encode, BarcodeFormat.QR_CODE, 500, 500);
            mImageCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
