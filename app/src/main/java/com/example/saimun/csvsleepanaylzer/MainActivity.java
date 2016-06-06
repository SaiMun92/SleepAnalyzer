package com.example.saimun.csvsleepanaylzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;



import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    public float count1_10 = 0;
    public float count11_20 = 0;
    public float count21_30 = 0;
    public float count31_40 = 0;
    public float count41_50 = 0;
    public float count51_60 = 0;
    public float count61_70 = 0;
    public float count71_80 = 0;
    public float count81_90 = 0;
    public float count91_100 = 0;
    public float count101_110 = 0;
    public float count111_120 = 0;
    public float count121_130 = 0;
    public float count131_140 = 0;
    public float count141_150 = 0;

    public int row = 0;
    public int UserCounter = 0;

    public ArrayList<ArrayList<Float>> UserData = new ArrayList<ArrayList<Float>>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textElement = (TextView) findViewById(R.id.text);
        textElement.setMovementMethod(new ScrollingMovementMethod());

        //Initialising ArrayList
        for(int i = 0; i < 20; i++)  {
            UserData.add(new ArrayList<Float>());
        }
        processSleepData();
        //textElement.append("Value of count1_10: " + count1_10);
        AvgSleepQualityfor20Users();
    }


    public void processSleepData() {

        try {
            TextView textElement = (TextView) findViewById(R.id.text);
            textElement.setMovementMethod(new ScrollingMovementMethod());
            InputStreamReader csvStreamReader = new InputStreamReader(
                    MainActivity.this.getAssets().open(
                            "ParsedData.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            String [] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                row++;
                String [] sleepData = nextLine[1].split(";");

                for (int i=0; i< sleepData.length;i++ ) {
                    int[] data = hexStringToInt(sleepData[i].substring(14));

                    //Store the data into a counter
                    for (int j=0; j<data.length;j++) {
                        if (data[j]>=0 && data[j]<=10) {
                            count1_10 +=1;
                        }
                        else if (data[j]>10 && data[j]<=20) {
                            count11_20 +=1;
                        }
                        else if (data[j]>20 && data[j]<=30) {
                            count21_30 +=1;
                        }
                        else if (data[j]>30 && data[j]<40) {
                            count31_40 +=1;
                        }
                        else if (data[j]>40 && data[j]<=50) {
                            count41_50 +=1;
                        }
                        else if (data[j]>50 && data[j]<60) {
                            count51_60 +=1;
                        }
                        else if (data[j]>60 && data[j]<70) {
                            count61_70 +=1;
                        }
                        else if (data[j]>70 && data[j]<80) {
                            count71_80 +=1;
                        }
                        else if (data[j]>80 && data[j]<90) {
                            count81_90 +=1;
                        }
                        else if (data[j]>90 && data[j]<100) {
                            count91_100 +=1;
                        }
                        else if (data[j]>100 && data[j]<=110) {
                            count101_110 +=1;
                        }
                        else if (data[j]>110 && data[j]<=120) {
                            count111_120 +=1;
                        }
                        else if (data[j]>120 && data[j]<=130) {
                            count121_130 +=1;
                        }
                        else if (data[j]>130 && data[j]<=140) {
                            count131_140 +=1;
                        }
                        else if (data[j]>140) {
                            count141_150 +=1;
                        }
                    }
                }

                if (row == 5) {
                    //Retreive the data and divide by 5 cos there are 5 sleeps per user.
                    //Reset all values to 0 and save all the data into an arrayList

                    UserData.get(UserCounter).add(Float.parseFloat(nextLine[0]));
                    UserData.get(UserCounter).add(count1_10/5);
                    UserData.get(UserCounter).add(count11_20/5);
                    UserData.get(UserCounter).add(count21_30/5);
                    UserData.get(UserCounter).add(count31_40/5);
                    UserData.get(UserCounter).add(count41_50/5);
                    UserData.get(UserCounter).add(count51_60/5);
                    UserData.get(UserCounter).add(count61_70/5);
                    UserData.get(UserCounter).add(count71_80/5);
                    UserData.get(UserCounter).add(count81_90/5);
                    UserData.get(UserCounter).add(count91_100/5);
                    UserData.get(UserCounter).add(count101_110/5);
                    UserData.get(UserCounter).add(count111_120/5);
                    UserData.get(UserCounter).add(count121_130/5);
                    UserData.get(UserCounter).add(count131_140/5);
                    UserData.get(UserCounter).add(count141_150/5);

//                    //Testing purposes only
//                    textElement.append("Storing Arraylist data: " + UserData.get(UserCounter).get(0) + "\n" +
//                            "first Data from the user: " + UserData.get(UserCounter).get(1) + "\n");

                    textElement.append(
                            "User_Id: " + nextLine[0] + "\n" +
                                    "Count1_10: " + count1_10/5 + "\n" +
                                    "Count11_20: " + count11_20/5 + "\n" +
                                    "Count21_30: " + count21_30/5 + "\n" +
                                    "Count31_40: " + count31_40/5 + "\n" +
                                    "Count41_50: " + count41_50/5 + "\n" +
                                    "Count51_60: " + count51_60/5 + "\n" +
                                    "Count61_70: " + count61_70/5 + "\n" +
                                    "Count71_80: " + count71_80/5 + "\n" +
                                    "Count81_90: " + count81_90/5 + "\n" +
                                    "Count91_100: " + count91_100/5 + "\n" +
                                    "Count101_110: " + count101_110/5 + "\n" +
                                    "Count111_120: " + count111_120/5 + "\n" +
                                    "Count121_130: " + count121_130/5 + "\n" +
                                    "Count131_140: " + count131_140/5 + "\n" +
                                    "Count141_150: " + count141_150/5 + "\n\n");



                    //UserCounter is the counter for which user
                    UserCounter +=1;

                    //Counter is for every 5 sleep data
                    //Reset all counters
                    row = 0;
                    count1_10 = 0;
                    count11_20 = 0;
                    count21_30 = 0;
                    count31_40 = 0;
                    count41_50 = 0;
                    count51_60 = 0;
                    count61_70 = 0;
                    count71_80 = 0;
                    count81_90 = 0;
                    count91_100 = 0;
                    count101_110 = 0;
                    count111_120 = 0;
                    count121_130 = 0;
                    count131_140 = 0;
                    count141_150 = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AvgSleepQualityfor20Users() {
        TextView textElement = (TextView) findViewById(R.id.text);
        textElement.setMovementMethod(new ScrollingMovementMethod());

        for (int i=0; i<20; i++) {
            count1_10 += UserData.get(i).get(1);
            count11_20 += UserData.get(i).get(2);
            count21_30 += UserData.get(i).get(3);
            count31_40 += UserData.get(i).get(4);
            count41_50 += UserData.get(i).get(5);
            count51_60 += UserData.get(i).get(6);;
            count61_70 += UserData.get(i).get(7);
            count71_80 += UserData.get(i).get(8);
            count81_90 += UserData.get(i).get(9);
            count91_100 += UserData.get(i).get(10);
            count101_110 += UserData.get(i).get(11);
            count111_120 += UserData.get(i).get(12);
            count121_130 += UserData.get(i).get(13);
            count131_140 += UserData.get(i).get(14);
            count141_150 += UserData.get(i).get(15);
        }

        textElement.append(
                "Avg of 20 Users " + "\n" +
                        "Count1_10: " + count1_10/20 + "\n" +
                        "Count11_20: " + count11_20/20 + "\n" +
                        "Count21_30: " + count21_30/20 + "\n" +
                        "Count31_40: " + count31_40/20 + "\n" +
                        "Count41_50: " + count41_50/20 + "\n" +
                        "Count51_60: " + count51_60/20 + "\n" +
                        "Count61_70: " + count61_70/20 + "\n" +
                        "Count71_80: " + count71_80/20 + "\n" +
                        "Count81_90: " + count81_90/20 + "\n" +
                        "Count91_100: " + count91_100/20 + "\n" +
                        "Count101_110: " + count101_110/20 + "\n" +
                        "Count111_120: " + count111_120/20 + "\n" +
                        "Count121_130: " + count121_130/20 + "\n" +
                        "Count131_140: " + count131_140/20 + "\n" +
                        "Count141_150: " + count141_150/20 + "\n\n");
    }



    public static int[] hexStringToInt(String s) {
        int len = s.length();
        int stringCounter = 0;

        int[] data = new int[len/2];
        for (int i=0; i < len; i +=2) {
            String HexStr = s.substring(stringCounter, stringCounter + 2);
            stringCounter += 2;
            data[i / 2] = Integer.parseInt(HexStr, 16);
        }
        return data;
    }
}
