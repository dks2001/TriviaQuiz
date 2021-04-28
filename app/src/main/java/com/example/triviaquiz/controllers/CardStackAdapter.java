package com.example.triviaquiz.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaquiz.R;
import com.example.triviaquiz.model.quizQuestion;
import com.example.triviaquiz.view.filmViewHolder;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<filmViewHolder> {

    private Context context;
    private List<quizQuestion> mfilmQuestion;
    private LayoutInflater layoutInflater;

    public CardStackAdapter(Context mcontext,List<quizQuestion> mfilmNAmes) {

        context = mcontext;
        mfilmQuestion = mfilmNAmes;
        layoutInflater = LayoutInflater.from(mcontext);
    }



    @NonNull
    @Override
    public filmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.film_view,parent,false);
        return new filmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull filmViewHolder holder, int position) {
        holder.getFilmQuestion().setText(mfilmQuestion.get(position).getQuestiontext());

        holder.getTrueButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mfilmQuestion.get(position).isTrueAnswer()) {
                    Toast.makeText(context, "correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "wrong answer!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.getFalseButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mfilmQuestion.get(position).isTrueAnswer()) {
                    Toast.makeText(context, "wrong answer", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "correct answer", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mfilmQuestion.size();
    }
}
