package com.example.staycationappandroid;

import java.text.DecimalFormat;

public class Utilities {

    protected String formatDate (String pDate){

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


    protected String formatDate2 (String pDate){

        String lMonth = pDate.substring(0,3);
        String lDay = pDate.substring(4,6);

        switch(lMonth) {
            case "Jan":
                pDate = "2022-01-" + lDay;
                break;
            case "Feb":
                pDate = "2022-02-" + lDay;
                break;
            case "Mar":
                pDate = "2022-03-" + lDay;
                break;
            case "Apr":
                pDate = "2022-04-" + lDay;
                break;
            case "May":
                pDate = "2022-05-" + lDay;
                break;
            case "Jun":
                pDate = "2022-06-" + lDay;
                break;
            case "Jul":
                pDate = "2022-07-" + lDay;
                break;
            case "Aug":
                pDate = "2022-08-" + lDay;
                break;
            case "Sep":
                pDate = "2022-09-" + lDay;
                break;
            case "Oct":
                pDate = "2022-10-" + lDay;
                break;
            case "Nov":
                pDate = "2022-11-" + lDay;
                break;
            case "Dec":
                pDate = "2022-12-" + lDay;
                break;
        }
        return pDate;
    }

}
