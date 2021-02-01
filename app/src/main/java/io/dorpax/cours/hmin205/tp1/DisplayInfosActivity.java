package io.dorpax.cours.hmin205.tp1;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayInfosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_infos);

        Intent intent = getIntent();
        EditText et = (EditText) findViewById(R.id.editTextTextMultiLine);
        et.setText(intent.getSerializableExtra(MainActivity.EXTRA_INFOS).toString());
    }

    public void onClickBack(View v) {
        this.finish();
    }

    public void onClickOk(View v) {
        startActivity(new Intent(this, MainActivity2.class));
    }
}
