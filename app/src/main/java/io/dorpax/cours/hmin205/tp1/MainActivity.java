package io.dorpax.cours.hmin205.tp1;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        ConstraintLayout layout = findViewById(R.id.main_layout);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            System.out.println(child);
            if(child instanceof EditText) {
                ((EditText) child).setText("");
            }
        }
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_validation_title)
                .setMessage(R.string.dialog_validation_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
