package com.example.meterstofeet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    public void show(View view) {
        textView.setVisibility(View.VISIBLE);
    }

    public void hide(View view) {
        textView.setVisibility(View.INVISIBLE);
    }

    public void getMetersToFeet(View view) {
        try {


//METERS
            EditText etM = (EditText) findViewById(R.id.meters);
            etM.setFilters(new InputFilter[]{new InputFilterMinMax("0", "99")});

            String metersString = etM.getText().toString();
            int metersInt = Integer.parseInt(metersString);

            //CENTIMETERS
            EditText etCms = (EditText) findViewById(R.id.cms);
            etCms.setFilters(new InputFilter[]{new InputFilterMinMax("0", "99")});
            // String cmsString = etCms.getText().toString();
            int cmsInt = Integer.parseInt(etCms.getText().toString());


            Log.i("meters: ", String.valueOf(metersInt));
            Log.i("centimeters: ", String.valueOf(cmsInt));

            Log.i("feet: ", getDimInFootString(metersInt, cmsInt));
            Log.i("inch: ", getLeftDimInInchString(metersInt, cmsInt));


            Toast.makeText(this, getDimInFootString(metersInt, cmsInt) + "' " + getLeftDimInInchString(metersInt, cmsInt) + "\"", Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"inch: "+getLeftDimInInchString(metersInt, cmsInt), Toast.LENGTH_LONG).show();
            TextView signTextView = findViewById(R.id.textViewInSign);
            signTextView.setText(getDimInFootString(metersInt, cmsInt) + "'-" + getLeftDimInInchString(metersInt, cmsInt) + "\"");

//        ImageView imageView = (ImageView) findViewById(R.id.imageHeight);
//        imageView.setImageResource(R.drawable.signrestictionreightempty);
            if (getDimInFoot(metersInt, cmsInt) > 16) {
                Log.i("Too height! ", getDimInFootString(metersInt, cmsInt));
                Toast.makeText(this, "No UK legal height limit but wherever possible a maximum of 4.95 metres should be adhered to in order to make maximum use of the motorway and trunk road network.", Toast.LENGTH_LONG).show();

                //textView = findViewById(R.id.textView);
                show(textView);
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }

//if(getDimInFoot(metersInt, cmsInt) < 16){
//    hide(textView);
//}


    }


    private final double ratioMtoF = 3.2808399;
    private final double ratioInchToFoot = 0.0254;
    private final double ratioFItoM = 0.3048;


    public double getDimInFoot(double meters, double centimeters) {

        try {
            int foot = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
            double footFloor = Math.floor((meters + (centimeters / 100)) * ratioMtoF);
            if (foot == 12) {
                return (int) (footFloor + 1);
            } else {
                return (int) footFloor;
            }
        } catch (Exception ignored) {

        }
        return 0.0;
    }

    public String getDimInFootString(double meters, double centimeters) {
        try {


            int feetInt = (int) getDimInFoot(meters, centimeters);
            return String.valueOf(feetInt);
        } catch (Exception ignored) {

        }
        return "Input value";
    }

    public double getLeftDimInInch(double meters, double centimeters) {
        try {

            int inches = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
            if (inches == 12) {
                return 0;
            } else {
                return inches;
            }
        } catch (Exception ignored) {

        }
        return 0.0;
    }


    private String getLeftDimInInchString(double meters, double centimeters) {
        //int inchInt = Integer.parseInt(null);
        try {
            int inchInt = (int) getLeftDimInInch(meters, centimeters);
            return String.valueOf(inchInt);
        } catch (Exception ignored) {

        }
        return "Input value";
    }


//    public String getDimInMeters() {
//        double meters = foot * ratioFItoM + inch * ratioInchToFoot;
//        String StringMeters2f = String.format("%.2f", meters);
//        return StringMeters2f;
//    }
//ImageView imageView = (ImageView) findViewById(R.id.catImageView);
//    Image.setImageResource(R.drowable.cat2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}