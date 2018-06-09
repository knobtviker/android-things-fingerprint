package edu.pdx.ekbotecetolafinalpi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

import edu.pdx.ekbotecetolafinalpi.account.DeviceInfo;
import edu.pdx.ekbotecetolafinalpi.managers.EnrollmentManager;
import edu.pdx.ekbotecetolafinalpi.managers.EnrollmentManagerImpl;
import edu.pdx.ekbotecetolafinalpi.managers.FirestoreManager;
import edu.pdx.ekbotecetolafinalpi.managers.FirestoreManagerImpl;
import edu.pdx.ekbotecetolafinalpi.managers.IdentificationManager;
import edu.pdx.ekbotecetolafinalpi.managers.IdentificationManagerImpl;
import edu.pdx.ekbotecetolafinalpi.managers.UartManager;
import edu.pdx.ekbotecetolafinalpi.managers.UartManagerImpl;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    UartManager uartManager;
    EnrollmentManager enrollmentManager;
    IdentificationManager identManager;
    DeviceInfo info;
    FirestoreManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new FirestoreManagerImpl();
        uartManager = new UartManagerImpl(dbManager);
        uartManager.setDeviceInfoReadyListener(new UartManager.DeviceInfoReadyListener() {
            @Override
            public void onDeviceInfoReady(DeviceInfo info) {
                setDeviceInfo(info);
            }
        });
        openUart();
        uartManager.getDeviceInfo();
    }

    private void setDeviceInfo(DeviceInfo info) {
        this.info = info;
        //enrollmentManager = new EnrollmentManagerImpl(uartManager, dbManager);
        //enrollmentManager.checkEnroll(2, 0, "foo");
        identManager = new IdentificationManagerImpl(uartManager, dbManager);
        identManager.identifyFinger();
        //DANGER ZONE
        //enrollmentManager.deleteAll();
    }

    private void openUart() {
        List<String> devices = uartManager.getDeviceList();
        String myDevice = "";
        for(String device : devices) {
            Log.d(TAG, "openUart: Found USB UART: " + device);
            //TODO: meh.
            if(device.contains("USB1")) {
                myDevice = device;
            }
        }
        uartManager.openUsbUart(myDevice);
    }
}