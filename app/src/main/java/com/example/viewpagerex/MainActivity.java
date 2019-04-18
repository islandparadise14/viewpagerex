package com.example.viewpagerex;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    Document doc = null;
    int search;
    String discription = "";
    ArrayList<MyItem> myData;
    String arr[] = {"2370012300", "2370012400", "2370013901", "2370014001", "2370014002", "2370015300", "2370015400",
            "2370016500", "2370016600", "2510025900", "2510026000", "2510030501", "2510030502", "2510030601", "2510048700"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tap_layout);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final ViewpageAdapter adapter = new ViewpageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        myData = new ArrayList<>();
        for(search=0;search<8;search++) {
            GetXMLTask xmlTask = new GetXMLTask();
            xmlTask.execute("http://bd.kma.go.kr/openAPI/roadweather/getStdNodeLinkInfo?"
                    + "serviceKey=izTYBoebUTddSWSPjLWvBVYj1PQVSGexMW4EEwo2VBkq3PBIhbzTIyxgo03XwzhRazwHCVzRmr4H3wU5DusD2g%3D%3D"
                    + "stdLinkId=" + arr[search] + "&hhCode=00&type=xml");
        }
    }
    private class GetXMLTask extends AsyncTask<String, Void, Document> {

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
            }
            return doc;
        }

        protected void onPostExecute (Document doc){
            super.onPostExecute(doc);
            discription = "";
            NodeList nodeList = doc.getElementsByTagName("items");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;

                NodeList Date = fstElmnt.getElementsByTagName("baseDate");
                discription = discription + "날짜 " + Date.item(0).getChildNodes().item(0).getNodeValue() + " ";

                NodeList Time = fstElmnt.getElementsByTagName("baseTime");
                discription = discription + "시간 " + Time.item(0).getChildNodes().item(0).getNodeValue() + "\n";

                NodeList Name = fstElmnt.getElementsByTagName("cctvNm");
                discription = discription + "장소 " + Name.item(0).getChildNodes().item(0).getNodeValue() + " ";

                NodeList weather = fstElmnt.getElementsByTagName("weatherNm");
                discription = discription + "날씨 " + weather.item(0).getChildNodes().item(0).getNodeValue();

            }
            myData.add(new MyItem(R.drawable.ic_launcher_background, discription));
        }
    }
    public ArrayList<MyItem> getData(){
        return myData;
    }

}
