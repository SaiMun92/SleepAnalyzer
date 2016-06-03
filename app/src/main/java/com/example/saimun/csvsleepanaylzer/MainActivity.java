package com.example.saimun.csvsleepanaylzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    public int count1_10 = 0;
    public int count11_20 = 0;
    public int count21_30 = 0;
    public int count31_40 = 0;
    public int count41_50 = 0;
    public int count51_60 = 0;
    public int count61_70 = 0;
    public int count71_80 = 0;
    public int count81_90 = 0;
    public int count91_100 = 0;

    public boolean deepStart;
    public boolean countStop;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStreamReader csvStreamReader = new InputStreamReader(
                    MainActivity.this.getAssets().open(
                            "ParsedData.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            String [] nextLine;
            ArrayList<Character> HexStr = new ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                String [] sleepData = nextLine[1].split(";");

                for (int i=0; i< sleepData.length; i++ ) {
                    System.out.println("LocalId: " + nextLine[0] + " sleepData: " +  sleepData[i].substring(14));
//                    for (int j=0; j<16; j++) {
//                        HexStr.add(sleepData[i].substring(14).charAt(j));
//                    }
//                    System.out.println("HexStr: " + HexStr);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sleepFunction();
    }


//    public ArrayList<ArrayList<ArrayList<Integer>>> processSleepData() {
//        ArrayList<ArrayList<ArrayList<Integer>>> sleepHrsData = new ArrayList<>();
//        //SleepHrsData = 1 sleep data
//        //SleepMinData = store one 15 min sleep data
//        if (sleepPatternItem != null) {
//            ArrayList<ArrayList<Integer>> sleepMinData = new ArrayList<>();
//
//            String[] data = sleepPatternItem.getSleepData().split(";");
//            deepStart = false;
//            countStop = false;
//            boolean isFrontZeros = true;
//            int frontZerosMin = 0;
//            for (int i = 0; i < data.length; i++) {
//                //each time block (15min), calc sleep quality value (average from 2min)
//                //4 time block = 1hr block
//                byte[] databytes = StringUtils.hexStringToByteArray(data[i]);
//                if (databytes.length > 0) {
//                    String hextime = StringUtils.byteToHexString(databytes[5]);
//                    int timeblock = Integer.parseInt(hextime, 16) % 4;
//                    if (timeblock == 0 && sleepMinData.size() > 0) {
//                        //next hr ---> store previous hour
//                        if (sleepMinData.size() > 0)
//                            sleepHrsData.add(sleepMinData);
//                        sleepMinData = new ArrayList<>();
//                    }
//
//                    //calc sleep quality average: sum of 2min quality value / sum of 2min blocks
//                    int quality = 0;
//                    int num = 0;
//
//                    ArrayList<Integer> sleep2MinData = new ArrayList<>();
//                    for (int j = 7; j < databytes.length; j++) {
//                        String hexMin = StringUtils.byteToHexString(databytes[j]);
//                        int min = Integer.parseInt(hexMin, 16);
//
//                    }
//                }
//            }
//        }
//    }
}
