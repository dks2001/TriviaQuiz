package com.example.triviaquiz.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaquiz.R;

public class filmViewHolder extends RecyclerView.ViewHolder {

    private TextView filmQuestion;
    private ImageButton trueButton;
    private ImageButton falseButton;


    public filmViewHolder(@NonNull View itemView) {
        super(itemView);

        filmQuestion = itemView.findViewById(R.id.filmquestion);
        trueButton = itemView.findViewById(R.id.trueButton);
        falseButton = itemView.findViewById(R.id.falseButton);
    }

    public TextView getFilmQuestion() {
        return filmQuestion;
    }

    public ImageButton getTrueButton() {
        return trueButton;
    }

    public ImageButton getFalseButton() {
        return falseButton;
    }
}
