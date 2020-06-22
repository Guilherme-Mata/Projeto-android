package com.example.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {
private TextView tvalor;
private SensorManager sensorManager;
private Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int position = getIntent().getIntExtra("position", 0);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList= sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensor= sensorList.get(position);
        tvalor = (TextView)findViewById(R.id.txtvalor);
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i < sensorEvent.values.length; i ++){
            sb.append(i).append(": ").append(sensorEvent.values[i]).append("\n");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
