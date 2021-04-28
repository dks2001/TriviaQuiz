package com.example.triviaquiz.model;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.triviaquiz.R;
import com.example.triviaquiz.VolleySingleton;
import com.example.triviaquiz.controllers.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class quizManager {

    Context mContext;
    private RequestQueue requestQueue;
    private String url;

    public quizManager(Context context) {

        mContext = context;
        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=10&category=18&type=boolean";


    }

    public void getQuestion(Activity activity) {

        List<quizQuestion> Quizquestion = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray results = response.getJSONArray("results");

                    for(int i=0;i<results.length();i++)
                    {
                        JSONObject questionjsonObject = results.getJSONObject(i);
                        String questiontext = questionjsonObject.getString("question");
                        Boolean questionAnswer = questionjsonObject.getBoolean("correct_answer");
                        quizQuestion QuizQuestion = new quizQuestion(questiontext,questionAnswer);
                        Quizquestion.add(QuizQuestion);

                    }

                    CardStackView cardStackView = activity.findViewById(R.id.myCardView);
                    cardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                    cardStackView.setAdapter(new CardStackAdapter(mContext,Quizquestion));

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(jsonObjectRequest);


    }
}
