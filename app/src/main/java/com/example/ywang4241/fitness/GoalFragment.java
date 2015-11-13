package com.example.ywang4241.fitness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ywang4241 on 11/13/2015.
 */
public class GoalFragment extends Fragment {

    private Goal mGoal;


    private EditText mGoalEditText;
    private Button mConfirm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGoal = new Goal();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_goal, container, false);



        mGoalEditText = (EditText)v.findViewById(R.id.goalEditText);
        mGoalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGoal.setGoal(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






        return v;



    }
}
