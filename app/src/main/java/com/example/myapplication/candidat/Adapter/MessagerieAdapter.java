package com.example.myapplication.candidat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myapplication.candidat.model.Message;

import java.util.List;

public class MessagerieAdapter extends BaseAdapter {

    private static final int TYPE_SENT = 0;
    private static final int TYPE_RECEIVED = 1;

    private Context context;
    private List<Message> message;
    private LayoutInflater inflater;

    public MessagerieAdapter(Context context, List<Message> message) {
        this.context = context;
        this.message = message;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return message.size();
    }

    @Override
    public Message getItem(int position) {
        return message.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
     /*   RecyclerView.ViewHolder holder;
        int messageType = getItemViewType(position);

        // Vérifier si la vue est nulle
        if (view == null) {
            // Créer une nouvelle vue en fonction du type d'élément
            if (messageType == TYPE_SENT) {
                view = inflater.inflate(R.layout.item_messagerie, parent, false);
                holder = new ViewHolder() {
                };
                holder.messageTextView = view.findViewById(R.id.sentMessageTextView);
            } else if (messageType == TYPE_RECEIVED) {
                view = inflater.inflate(R.layout.item_received_message, parent, false);
                holder = new ViewHolder();
                holder.messageTextView = view.findViewById(R.id.receivedMessageTextView);
            }

            // Définir le porte-vues comme tag de la vue
            view.setTag(holder);
        } else {
            // Réutiliser le porte-vues existant
            holder = (ViewHolder) view.getTag();
        }

        // Récupérer le message à afficher
        Message currentMessage = getItem(position);
        String messageText = currentMessage.getMessage();

        // Définir le texte du message dans le porte-vues
        holder.messageTextView.setText(messageText);
*/
        return view;
    }
}


