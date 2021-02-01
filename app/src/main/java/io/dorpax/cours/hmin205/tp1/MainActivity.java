package io.dorpax.cours.hmin205.tp1;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_INFOS = "io.dorpax.cours.hmin205.tp1.EXTRA_INFOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getEditTextString(int id) {
        return ((EditText) findViewById(id)).getText().toString();
    }

    public void openInfosIntent() {
        Intent intent = new Intent(this, DisplayInfosActivity.class);
        Infos infos = new Infos(getEditTextString(R.id.prenom_editext),
                getEditTextString(R.id.nom_editext), getEditTextString(R.id.domaine_editext),
                getEditTextString(R.id.age_editext), getEditTextString(R.id.phone_editext));
        intent.putExtra(EXTRA_INFOS, infos);
        startActivity(intent);
    }

    public void onClick(View view) {
        final ConstraintLayout layout = findViewById(R.id.main_layout);
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_validation_title)
                .setMessage(R.string.dialog_validation_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        openInfosIntent();
                        for (int i = 0; i < layout.getChildCount(); i++) {
                            View child = layout.getChildAt(i);
                            System.out.println(child);
                            if (child instanceof EditText) {
                                EditText et = (EditText) child;
                                et.setBackground(new EditText(getBaseContext()).getBackground());
                                et.setText("");
                            }
                        }
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < layout.getChildCount(); i++) {
                            View child = layout.getChildAt(i);
                            System.out.println(child);
                            if (child instanceof EditText) {
                                ((EditText) child).setBackgroundColor(R.color.colorAccent);
                            }
                        }
                    }
                }).show();
    }
}
