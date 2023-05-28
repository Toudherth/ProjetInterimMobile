package com.example.myapplication.frontend.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.models.Vacancies;

public class Emp_Popup_apply_form extends AppCompatActivity {

    TextView tvpop;
    Button btn;
    Vacancies model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_apply_form);


        tvpop = findViewById(R.id.tvPopupEmail);
        btn = findViewById(R.id.btnPopup);

        Intent i = getIntent();
        //String email = i.getStringExtra("gmail");

        //tvpop.setText(email);

        model = (Vacancies) i.getSerializableExtra("vacancy"); // Récupérer l'objet Vacancies depuis l'intent

        if (model != null) {
            String email = model.getEmail();
            tvpop.setText(email);
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);

        int width = dm.widthPixels;
        int hight = dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(hight*.6));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + model.getEmail()));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Candidature pour le poste");
                intent.putExtra(Intent.EXTRA_TEXT, "Bonjour,\n\nJe souhaite postuler pour le poste. Veuillez trouver ci-joint mon CV.\n\nCordialement,");

                try {
                    v.getContext().startActivity(Intent.createChooser(intent, "Envoyer l'e-mail"));
                } catch (Exception e) {
                    Toast.makeText(v.getContext(), "Impossible d'envoyer l'e-mail.", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

    }
}