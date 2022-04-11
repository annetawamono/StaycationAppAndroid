package com.example.staycationappandroid;

import java.text.DecimalFormat;

public class Utilities {

    public String formatDate (String pDate){

        String lMonth = pDate.substring(5,7);
        String lDay = pDate.substring(8,10);

        switch(lMonth) {
            case "01":
                pDate = "Jan, " + lDay;
                break;
            case "02":
                pDate = "Feb, " + lDay;
                break;
            case "03":
                pDate = "Mar, " + lDay;
                break;
            case "04":
                pDate = "Apr, " + lDay;
                break;
            case "05":
                pDate = "May, " + lDay;
                break;
            case "06":
                pDate = "Jun, " + lDay;
                break;
            case "07":
                pDate = "Jul, " + lDay;
                break;
            case "08":
                pDate = "Aug, " + lDay;
                break;
            case "09":
                pDate = "Sep, " + lDay;
                break;
            case "10":
                pDate = "Oct, " + lDay;
                break;
            case "11":
                pDate = "Nov, " + lDay;
                break;
            case "12":
                pDate = "Dec, " + lDay;
                break;
        }
        return pDate;
    }

    protected String formatNumber (Double pNumber){
        DecimalFormat vNumber = new DecimalFormat("0.00");
        return vNumber.format(pNumber);
    }

}
