package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MessangerActivity extends AppCompatActivity {

    private ListView messageListView;
    private EditText messageEditText;
    private Button sendButton;

    private List<String> messages;
    private ArrayAdapter<String> messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messanger);
        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour



        // Initialisation des vues
        messageListView = findViewById(R.id.messageListView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        // Initialisation de la liste des messages
        messages = new ArrayList<>();
        messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
        messageListView.setAdapter(messageAdapter);

        // Ajout du listener pour le bouton d'envoi
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {
                    sendMessage(message);
                    messageEditText.setText("");
                }
            }
        });

        // Simulation de la réception d'un message
        receiveMessage("Hello!");
    }







    private void sendMessage(String message) {
        // Logique d'envoi du message ici
        // Par exemple, vous pouvez envoyer le message à un serveur ou à l'autre utilisateur

        // Ajout du message à la liste des messages affichée
        messages.add("Me: " + message);
        messageAdapter.notifyDataSetChanged();
    }

    private void receiveMessage(String message) {
        // Logique de réception du message ici

        // Ajout du message à la liste des messages affichée
        messages.add("Friend: " + message);
        messageAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Action à réaliser lorsque le bouton de retour est cliqué
            Intent intent = new Intent(this, OffreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}