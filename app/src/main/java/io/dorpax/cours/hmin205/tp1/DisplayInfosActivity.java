package io.dorpax.cours.hmin205.tp1;

import android.content.Intent;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayInfosActivity extends AppCompatActivity {

    private Infos infos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_infos);

        Intent intent = getIntent();
        EditText et = (EditText) findViewById(R.id.editTextTextMultiLine);
        infos = (Infos) intent.getSerializableExtra(MainActivity.EXTRA_INFOS);
        et.setText(infos.toString());
    }

    public void onClickBack(View v) {
        this.finish();
    }

    public void onClickOk(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(MainActivity2.EXTRA_PHONE, infos.getPhone());
        startActivity(intent);
    }
}
