package com.example.meterstofeet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    public void getMetersToFeet(View view) {

//METERS
        EditText etM = (EditText) findViewById(R.id.meters);
        etM.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "99")});

        String metersString = etM.getText().toString();
        int metersInt = Integer.parseInt(metersString);

        //CENTIMETERS
        EditText etCms = (EditText) findViewById(R.id.cms);
        etCms.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "99")});
        String cmsString = etCms.getText().toString();
        int cmsInt = Integer.parseInt(cmsString);

        Log.i("meters: ", String.valueOf(metersInt));
        Log.i("centimeters: ", String.valueOf(cmsInt));
        Log.i("feet: ",getDimInFootString(metersInt, cmsInt));
       Log.i("inch: ",getLeftDimInInchString(metersInt,cmsInt));

        Toast.makeText(this,"feet: "+getDimInFootString(metersInt, cmsInt), Toast.LENGTH_LONG).show();
        Toast.makeText(this,"inch: "+getLeftDimInInchString(metersInt, cmsInt), Toast.LENGTH_LONG).show();
    }



    private final double ratioMtoF = 3.2808399;
    private final double ratioInchToFoot = 0.0254;
    private final double ratioFItoM = 0.3048;


    public int getDimInFoot(int meters, int centimeters) {
        int foot = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
        double footFloor = Math.floor((meters + (centimeters / 100)) * ratioMtoF);
        if (foot == 12) {
            return (int) (footFloor + 1);
        } else {
          return (int) footFloor;
        }
    }

    public String getDimInFootString(int meters, int centimeters) {
        return String.valueOf(getDimInFoot(meters, centimeters));
    }

    public int getLeftDimInInch(int meters, int centimeters) {
        int inches = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
        if (inches == 12) {
            return 0;
        } else {
            return inches;
        }
    }
    private String getLeftDimInInchString(int meters, int centimeters) {
        return String.valueOf(getLeftDimInInch(meters, centimeters));
    }

//    public String getDimInMeters() {
//        double meters = foot * ratioFItoM + inch * ratioInchToFoot;
//        String StringMeters2f = String.format("%.2f", meters);
//        return StringMeters2f;
//    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}