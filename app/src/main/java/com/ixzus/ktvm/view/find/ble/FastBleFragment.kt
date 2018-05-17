package com.ixzus.ktvm.view.find.ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.BluetoothLeScanner
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixzus.ktvm.view.base.BaseFragment
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx


/**
 * Created by Administrator on 2018/3/28.
 */
class FastBleFragment : BaseFragment() {

    lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = BleUI().createView(AnkoContext.Companion.create(ctx, this))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var bluetoothManager: BluetoothManager = activity?.getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
//        bluetoothAdapter = bluetoothManager.adapter

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        bluetoothAdapter.startDiscovery()

        var bluetoothLeScanner: BluetoothLeScanner = bluetoothAdapter.bluetoothLeScanner
        bluetoothLeScanner.startScan(scanCallback)

    }

    private val scanCallback = object : ScanCallback() {
        override
        fun onScanResult(callbackType: Int, result: ScanResult) {
            super.onScanResult(callbackType, result)
            val device = result.getDevice()
//            mLeDeviceList.addDevice(device)
            Log.d(TAG, "Device name: " + device.getName())
            Log.d(TAG, "Device address: " + device.getAddress())
            Log.d(TAG, "Device service UUIDs: " + device.getUuids())
            val record = result.getScanRecord()
            Log.d(TAG, "Record advertise flags: 0x" + Integer.toHexString(record.getAdvertiseFlags()))
            Log.d(TAG, "Record Tx power level: " + record.getTxPowerLevel())
            Log.d(TAG, "Record device name: " + record.getDeviceName()!!)
            Log.d(TAG, "Record service UUIDs: " + record.getServiceUuids())
            Log.d(TAG, "Record service data: " + record.getServiceData())
//            runOnUiThread(Runnable { })
        }

        override
        fun onBatchScanResults(results: List<ScanResult>) {
            super.onBatchScanResults(results)
        }

        override
        fun onScanFailed(errorCode: Int) {
            super.onScanFailed(errorCode)
        }
    }
}