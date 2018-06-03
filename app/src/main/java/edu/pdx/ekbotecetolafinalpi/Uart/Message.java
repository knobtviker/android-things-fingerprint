package edu.pdx.ekbotecetolafinalpi.Uart;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Message {
    private static final String TAG = "Message";
    public static final int MSG_SIZE = 12;
    public static final char START_CODE = 0xAA55;
    public static final char DEVICE_ID = 0x0001;

    private ByteBuffer data;

    public Message() {
        data = ByteBuffer.allocate(MSG_SIZE);
        this.data.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Message(int size) {
        data = ByteBuffer.allocate(size);
        this.data.order(ByteOrder.LITTLE_ENDIAN);
    }

    public void addBytes(byte[] d) {
        Log.d(TAG, "addBytes: " + UartUtils.bytesToHex(d, d.length));
        data.put(d);
    }

    public ByteBuffer getData() {
        return data;
    }

    public void setData(ByteBuffer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return UartUtils.bytesToHex(data.array(), data.array().length);
    }
}
