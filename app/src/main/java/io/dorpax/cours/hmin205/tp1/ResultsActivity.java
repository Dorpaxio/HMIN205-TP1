package io.dorpax.cours.hmin205.tp1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {

    public static final String EXTRA_DEPARTURE = "io.dorpax.cours.hmin205.tp1.EXTRA_DEPARTURE";
    public static final String EXTRA_ARRIVAL = "io.dorpax.cours.hmin205.tp1.EXTRA_ARRIVAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        String departure = intent.getStringExtra(EXTRA_DEPARTURE);
        String arrival = intent.getStringExtra(EXTRA_ARRIVAL);


    }
}
