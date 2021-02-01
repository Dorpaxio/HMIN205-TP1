package io.dorpax.cours.hmin205.tp1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_PHONE = "io.dorpax.cours.HMIN205.tp1.EXTRA_PHONE";
    public static final int PHONE_REQUEST_CODE = 100;

    private String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        phone = intent.getStringExtra(EXTRA_PHONE);
        ((TextView) findViewById(R.id.phone_textview)).setText(phone);
    }

    private void call() {
        Uri uri = Uri.parse("tel:"+phone);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

    public void onClickCall(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            call();
        } else {
            requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, PHONE_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PHONE_REQUEST_CODE) {
            call();
        }
    }
}
