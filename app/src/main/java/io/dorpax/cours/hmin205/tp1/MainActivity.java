package io.dorpax.cours.hmin205.tp1;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));
        layout.setId(R.id.constraint_layout);

        EditText prenom = addEditTextToLayout(R.id.prenom_edit_text, R.id.prenom_label, R.string.edit_prenom,
                layout, InputType.TYPE_CLASS_TEXT, null);
        EditText nom = addEditTextToLayout(R.id.nom_edit_text, R.id.nom_label, R.string.edit_name,
                layout, InputType.TYPE_CLASS_TEXT, prenom);
        EditText age = addEditTextToLayout(R.id.age_edit_text, R.id.age_label, R.string.edit_age,
                layout, InputType.TYPE_CLASS_NUMBER, nom);
        EditText domaine = addEditTextToLayout(R.id.domaine_edit_text, R.id.domaine_label, R.string.edit_domaine,
                layout, InputType.TYPE_CLASS_TEXT, age);
        EditText phone = addEditTextToLayout(R.id.phone_edit_text, R.id.phone_label, R.string.edit_phone,
                layout, InputType.TYPE_CLASS_PHONE, domaine);

        Button button = new Button(this);
        button.setId(R.id.button_valider);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(300, 155);
        layoutParams.setMargins(0, 16, 16, 0);
        layoutParams.endToEnd = layout.getId();
        layoutParams.topToBottom = phone.getId();
        button.setText(R.string.button_valider);
        button.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.colorAccent));
        button.setLayoutParams(layoutParams);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.onClick(v);
            }
        });
        layout.addView(button);

        setContentView(layout);
    }

    private EditText addEditTextToLayout(int id, int labelId, int label, ConstraintLayout layout, int inputType, View parent) {
        TextView textView = new TextView(this);
        textView.setText(label);
        ConstraintLayout.LayoutParams textLayoutParams =
                new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT);
        textLayoutParams.setMargins(16, 16, 0, 0);
        textLayoutParams.startToStart = layout.getId();
        if (parent != null)
            textLayoutParams.topToBottom = parent.getId();
        else
            textLayoutParams.topToTop = layout.getId();
        textView.setLayoutParams(textLayoutParams);
        textView.setId(labelId);
        layout.addView(textView);

        EditText editText = new EditText(this);
        editText.setId(id);
        ConstraintLayout.LayoutParams layoutParams =
                new ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(16, 16, 16, 16);
        layoutParams.startToStart = layout.getId();
        layoutParams.endToEnd = layout.getId();
        layoutParams.topToBottom = textView.getId();

        editText.setLayoutParams(layoutParams);
        editText.setInputType(inputType);
        layout.addView(editText);
        return editText;
    }

    public void onClick(View view) {
        ConstraintLayout layout = findViewById(R.id.constraint_layout);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            System.out.println(child);
            if (child instanceof EditText) {
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
