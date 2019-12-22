package nju.se.rfid.common.CN9X;

import com.module.interaction.RXTXListener;
import com.module.interaction.ReaderHelper;
import com.rfid.RFIDReaderHelper;
import com.rfid.ReaderConnector;
import com.rfid.rxobserver.RXObserver;
import com.rfid.rxobserver.bean.RXInventoryTag;
import com.util.StringTool;
import org.springframework.data.relational.core.sql.In;

import java.util.Map;
import java.util.Observer;

public class RfidDeviceUtil {
    private static ReaderConnector mConnector;
    private static ReaderHelper mReaderHelper;
    private static byte insertLocation = 0x02;

    static Observer mObserver = new RXObserver() {
        @Override
        protected void onInventoryTag(RXInventoryTag tag) {
            System.out.println("EPC data:" + tag.strEPC);
        }

        @Override
        protected void onInventoryTagEnd(RXInventoryTag.RXInventoryTagEnd endTag) {
            System.out.println("inventory end:" + endTag.mTotalRead);
            ((RFIDReaderHelper) mReaderHelper).realTimeInventory((byte) 0xff,(byte)0x01);
        }

        @Override
        protected void onExeCMDStatus(byte cmd,byte status) {
            System.out.format("CDM:%s  Execute status:%S",
                    String.format("%02X",cmd),String.format("%02x", status));
        }

    };

    static Observer mObserver1 = new RXObserver() {
        @Override
        protected void onInventoryTag(RXInventoryTag tag) {
            System.out.println("EPC data:" + tag.strEPC);
        }

        @Override
        protected void onInventoryTagEnd(RXInventoryTag.RXInventoryTagEnd endTag) {
            System.out.println("inventory end:" + endTag.mTotalRead);
            ((RFIDReaderHelper) mReaderHelper).realTimeInventory((byte) 0xff,(byte)0x01);
        }

        @Override
        protected void onExeCMDStatus(byte cmd,byte status) {
            System.out.format("CDM:%s  Execute status:%S",
                    String.format("%02X",cmd),String.format("%0sendData2x", status));
        }
    };

    static RXTXListener mListener = new RXTXListener() {
        @Override
        public void reciveData(byte[] btAryReceiveData) {
            // TODO Auto-generated method stub
            System.out.println("reciveData" + StringTool.byteArrayToString(btAryReceiveData, 0, btAryReceiveData.length));
        }

        @Override
        public void sendData(byte[] btArySendData) {
            // TODO Auto-generated method stub
            System.out.println("sendData" + StringTool.byteArrayToString(btArySendData, 0, btArySendData.length));
        }

        @Override
        public void onLostConnect() {
            // TODO Auto-generated method stub
        }

    };

    public static void setConnector(String port, int buad){
        if (mConnector == null){
            mConnector = new ReaderConnector();
            mReaderHelper = mConnector.connectCom(port, buad);
        }
    }

    public static String read(String port, int buad){
        if (mReaderHelper == null){
            setConnector(port, buad);
        }
        String data = "";
        if(mReaderHelper != null) {
            System.out.println("Connect success!");
            try {
                RXTXListenerImpl rxtxListener = new RXTXListenerImpl();
                mReaderHelper.setRXTXListener(rxtxListener);

                // read tag
                System.out.println("isReadSuccess:"+((RFIDReaderHelper) mReaderHelper).readTag((byte)0xff,(byte)0x01,(byte)0x00,(byte)0x02,null));
                Thread.currentThread().sleep(2000);
                data = RXTXListenerImpl.str;

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("Connect faild!");
            mConnector.disConnect();
        }
        return data;
    }

    public static void write(Map<String,String> map, String type, int size){
//        if (mReaderHelper == null){
//            setConnector(port, buad);
//        }
        if(mReaderHelper != null) {
            System.out.println("Connect success!");
            try {
                byte[] psw = {(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
                byte[] data = new byte[size];

                if (type.equals("01")) {
                    String[] cas_id = map.get("cas_id").split("-");
                    if (cas_id[0].length() == 1) {
                        cas_id[0] = "000" + cas_id[0];
                    } else if (cas_id[0].length() == 2) {
                        cas_id[0] = "00" + cas_id[0];
                    } else if (cas_id[0].length() == 3) {
                        cas_id[0] = "0" + cas_id[0];
                    }

                    data[0] = int2ByteArray(Integer.parseInt(cas_id[0].substring(0, 2)));
                    data[1] = int2ByteArray(Integer.parseInt(cas_id[0].substring(2)));
                    data[2] = int2ByteArray(Integer.parseInt(cas_id[1]));
                    String lastCaseId = cas_id[2];
                    String batchId = map.get("batch_id");

                    data[3] = int2ByteArray(Integer.parseInt(lastCaseId + batchId));

                    String companyId = map.get("company_id");
                    String weight = map.get("weight");
                    data[4] = int2ByteArray(Integer.parseInt(companyId));
                    data[5] = int2ByteArray(Integer.parseInt(weight));
                }

//				byte[] data = {(byte)0x0C,(byte)0x0B,(byte)0x0A,(byte)0x09,(byte)0x08,(byte)0x07,(byte)0x06,(byte)0x05,(byte)0x04,(byte)0x03,(byte)0x02,(byte)0x01};
				System.out.println("isWriteSuccess:"+((RFIDReaderHelper) mReaderHelper).writeTag((byte)0xff,psw,(byte)0x01,insertLocation,int2ByteArray(size/2),data));

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println("Connect faild!");
            mConnector.disConnect();
        }
        return ;
    }

    public static byte int2ByteArray(int i){
        byte[] result=new byte[4];
        result[0]=(byte)((i >> 24)& 0xFF);
        result[1]=(byte)((i >> 16)& 0xFF);
        result[2]=(byte)((i >> 8)& 0xFF);
        result[3]=(byte)(i & 0xFF);
        return result[3];
    }
}
