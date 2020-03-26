package com.karthick.smsbroadcastreceiver;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class IncomingSMSListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //CHECK IF THE INTENT CONTAINS SMS_RECEIVED
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            for (SmsMessage sms : msgs) {

                String number = sms.getOriginatingAddress();
                String message = sms.getMessageBody();
                Toast.makeText(context, "From : " + number + "\nMessage : " + message, Toast.LENGTH_LONG).show();
            }
        }
    }
}


