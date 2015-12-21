package com.example.ywang4241.fitness;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

// there was work done NOT on this file
/**
 * Created by aaernie7528 on 12/21/2015.
 */

//ISSUE: so this is an Activity and not connected at all to the GoalActivity or the GoalFragment.
public class PedometerSensor extends AppCompatActivity implements SensorEventListener {

    //sensorManager is for utilizing hardware such as a built in pedometer
    //Using a built in pedometer is for efficiency as the accelerometer is less percise and
    //consumes more battery life
    private SensorManager sensorManager;
    //textviews
    private TextView mSteps;
    private TextView mGoal;
    private TextView mCal;
    private TextView mDistance;
    //model
    Goal goal;
    //flag for if the activity is paused.
    boolean active;
    //variables for calculations
    double distance = 0;
    double calories = 0;
    //variables to allow for steps to fit in to
    String result;
    int steps = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSteps = (TextView) findViewById(R.id.steps);
        mGoal = (TextView) findViewById(R.id.goal);
        mCal = (TextView) findViewById(R.id.calories);
        mDistance = (TextView) findViewById(R.id.distance);
        updateUI();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        active = true;
        //Sets the sensor to a built in pedometer's step counting system.
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //check if there is a step_counter
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        active = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (active) {
            result = String.valueOf(event.values[0]);
            steps = Integer.parseInt(result);
            calcCalories();
            calcDistance();
            updateUI();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void updateUI() {
        mGoal.setText(goal.getGoal());
        mSteps.setText(Integer.toString(steps));
        mCal.setText(Double.toString(calories));
        mDistance.setText(Double.toString(distance));
    }

    //will calculate Distance based on steps
    private void calcDistance() {
        distance = steps * 2.5;
    }

    //will calculate calories based on steps
    private void calcCalories() {
        calories = steps * 0.045;
    }

}
