package com.example.myapplication.frontend;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.myapplication.R;

public class SlideShowDialog extends AppCompatDialogFragment {

    private int[] imageResources = {R.drawable.diapositive1, R.drawable.diapositive2, R.drawable.diapositive3, R.drawable.diapositive4};
    private int currentPosition = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_slide_show, null);

        ImageView imageView = view.findViewById(R.id.imageView);
        Button closeButton = view.findViewById(R.id.closeButton);

        imageView.setImageResource(imageResources[currentPosition]);

        imageView.setOnClickListener(v -> {
            currentPosition = (currentPosition + 1) % imageResources.length;
            imageView.setImageResource(imageResources[currentPosition]);
        });

        closeButton.setOnClickListener(v -> dismiss());

        builder.setView(view);
        return builder.create();
    }
}
