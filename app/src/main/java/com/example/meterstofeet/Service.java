package com.example.meterstofeet;

import android.view.View;
import android.widget.EditText;

public class Service {

    private final double ratioMtoF = 3.2808399;
    private final double ratioInchToFoot = 0.0254;
    private final double ratioFItoM = 0.3048;

  public String getDimInFoot() {
      return "test";
}
//    public double getDimInFoot() {
//
//        int foot = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
//        double footFloor = Math.floor((meters + (centimeters / 100)) * ratioMtoF);
//        if (foot == 12) {
//            return footFloor + 1;
//        } else {
//            return footFloor;
//        }
//    }
//
//    public double getLeftDimInInch(View view) {
//        int inches = (int) Math.ceil((((meters + (centimeters / 100)) * ratioMtoF) % 1) * 12);
//        if (inches == 12) {
//            return 0;
//        } else {
//            return inches;
//        }
//    }
//
//    public String getDimInMeters() {
//        double meters = foot * ratioFItoM + inch * ratioInchToFoot;
//        String StringMeters2f = String.format("%.2f", meters);
//        return StringMeters2f;
//    }
}
