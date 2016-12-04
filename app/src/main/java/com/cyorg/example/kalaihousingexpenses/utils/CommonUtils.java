package com.cyorg.example.kalaihousingexpenses.utils;

import android.util.Log;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yoganand on 12/4/2016.
 */
public class CommonUtils {

    private static final String LOG_TAG = CommonUtils.class.getSimpleName();

    private static SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");

    public static String getDateFromMilli(long milliDate)      {
        return simpleDateFormat.format(new Date(milliDate));
    }

    public static String formatAmountAsCurrency(double amount)  {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        //decimalFormatSymbols.setCurrencySymbol("\u20B9");

        DecimalFormat decimalFormat = new DecimalFormat("\u20B9 ##,##,##,###.##",decimalFormatSymbols);

        String formattedValue;
        try {
            formattedValue = decimalFormat.format(amount);
        }   catch(Exception e)  {
            Log.e(LOG_TAG,"Exception Occurred while formatting Currency "+e.getMessage());
            formattedValue = "";
        }

        Log.i(LOG_TAG,"Formatted Currency Value : "+formattedValue);

        return formattedValue;
    }
}
