package io.dorpax.cours.hmin205.tp1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchClick(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra(ResultsActivity.EXTRA_DEPARTURE, ((EditText) findViewById(R.id.departure_textedit)).getText().toString());
        intent.putExtra(ResultsActivity.EXTRA_ARRIVAL, ((EditText) findViewById(R.id.arrival_textedit)).getText().toString());
        startActivity(intent);
    }
}
