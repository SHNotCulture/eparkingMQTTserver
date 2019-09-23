package com.mqttserver.writeLock;

import com.mqttserver.entity.MQTTResult.CarFeeRsp;
import com.mqttserver.util.SessionUtil;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CarFeeRspLock {
    private final static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final static Lock r = rwl.readLock();
    private final static Lock w = rwl.writeLock();

    public static boolean containsKey(String key){
        r.lock();
        try { return SessionUtil.carFeeRspList.containsKey(key); }
        finally { r.unlock(); }
    }
    public static Collection<CarFeeRsp> allValues() {
        r.lock();
        try {
            return SessionUtil.carFeeRspList.values();}
        finally { r.unlock(); }
    }
    public static  CarFeeRsp get(String key) {
        r.lock();
        try { return SessionUtil.carFeeRspList.get(key); }
        finally { r.unlock(); }
    }
    public static CarFeeRsp put(String key,CarFeeRsp value) {
        w.lock();
        try { return SessionUtil.carFeeRspList.put(key, value); }
        finally { w.unlock(); }
    }

    public static void remove(String key){
        w.lock();
        try { SessionUtil.carFeeRspList.remove(key); }
        finally { w.unlock(); }
    }

    public static void clear() {
        w.lock();
        try { SessionUtil.carFeeRspList.clear(); }
        finally { w.unlock(); }
    }
}
