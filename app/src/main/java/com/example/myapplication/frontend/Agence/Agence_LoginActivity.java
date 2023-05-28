package com.example.myapplication.frontend.Agence;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Employee.Emp_RegisterActivity;
import com.example.myapplication.models.AppUser;
import com.example.myapplication.models.Vacancies;
import com.example.myapplication.services.it20133290.VacancyServicesImp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class Agence_LoginActivity extends AppCompatActivity {

    EditText email,pass;
    Button submit,sign,forgotPassword;
    Vacancies vacancies;
    AppUser appUser;
    private FirebaseAuth auth;
    VacancyServicesImp vacSer = new VacancyServicesImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_agence);
        getSupportActionBar().hide();

        email = findViewById(R.id.etUserLoginEmail);
        pass = findViewById(R.id.etUserLoginPassword);
        submit = findViewById(R.id.btnLogin);
        sign = findViewById(R.id.btnSignIn);
        forgotPassword = findViewById(R.id.forget);

        // Vérifier si c'est la première utilisation de l'application
        if (isFirstTimeUser()) {
            // Afficher la boîte de dialogue de demande d'autorisation de localisation
            showLocationPermissionDialog();
        }



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vacSer.validateAgency(Agence_LoginActivity.this,email,pass);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(Agence_LoginActivity.this, Agence_RegisterActivity.class);
                startActivity(i);
            }
        });

        auth = FirebaseAuth.getInstance();
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Agence_LoginActivity.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                EditText emailBox = dialogView.findViewById(R.id.emailBox);
                builder.setView(dialogView);
                AlertDialog dialog = builder.create();
                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String userEmail = emailBox.getText().toString();
                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                            Toast.makeText(Agence_LoginActivity.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Agence_LoginActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(Agence_LoginActivity.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                if (dialog.getWindow() != null){
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                dialog.show();
            }
        });


    }

    // Méthode pour vérifier si c'est la première utilisation de l'application
    private boolean isFirstTimeUser() {
        SharedPreferences preferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE);
        return preferences.getBoolean("firstTimeUser", true);
    }

    private void showLocationPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Autorisation de localisation");
        builder.setMessage("L'application souhaite accéder à votre localisation pour afficher des annonces pertinentes.");
        builder.setPositiveButton("Accepter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Enregistrer l'autorisation dans les préférences
                saveLocationPermission(true);
                // Enregistrer la localisation dans les préférences
                saveLocationToPreferences();
            }
        });

        builder.setCancelable(false);
        builder.show();
    }

    private void saveLocationPermission(boolean isPermissionGranted) {
        SharedPreferences preferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLocationPermissionGranted", isPermissionGranted);
        editor.apply();
    }


    private void saveLocationToPreferences() {
        // Obtenir une instance du FusedLocationProviderClient
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Demander la dernière position connue
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            // Récupérer la latitude et la longitude de la position
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();

                            // Convertir la latitude et la longitude en une chaîne de localisation
                            String locationString = latitude + "," + longitude;

                            // Enregistrer la localisation dans les préférences de l'utilisateur
                            SharedPreferences preferences = getSharedPreferences("MyAppPreferences", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("location", locationString);
                            editor.apply();
                        }
                    }
                });
    }


}