package com.sumo.traffic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class radiusplace extends AppCompatActivity {
    static EditText radius;
    static double inputtedradius = 10000;
    static Circle circle;
    static int exist = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiusplace);


        radius = (EditText) findViewById(R.id.editText3);


    }


    public void adjust(View view) {
        String heightString = radius.getText().toString();
        inputtedradius = Double.parseDouble(heightString);
        if (radiusplace.exist == 1)
        {
            radiusplace.circle.remove();


        }
        circle = traffic.mMap.addCircle(new CircleOptions()
                .center(new LatLng(traffic.latLng.latitude, traffic.latLng.longitude))
                .radius(inputtedradius)

                .strokeColor(Color.GREEN)
        );
     //  circle.setRadius(inputtedradius);

        exist = 1;


        Toast.makeText(radiusplace.this, "Radius has been updated to:" + inputtedradius, Toast.LENGTH_LONG).show();
        finish();
    }

}
