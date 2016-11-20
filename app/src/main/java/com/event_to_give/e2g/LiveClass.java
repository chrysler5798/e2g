package com.event_to_give.e2g;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Louis on 17/11/2016.
 * <p>
 * e2g
 */

class LiveClass {

        private Calendar c = Calendar.getInstance();

        //    SimpleDateFormat Sdf = new SimpleDateFormat("u/H", Locale.FRANCE);
        //    String strDate = Sdf.format(c.getTime());
        //    String[] values = strDate.split("/",0);
        private int heure = c.get(Calendar.HOUR_OF_DAY);

        private SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        private Date d = new Date();
        private String dayOfTheWeek = sdf.format(d);

    void showPlanning(TextView textV, RelativeLayout rvOff, SwipeRefreshLayout swipeOff)
    {
        switch (dayOfTheWeek) {
            case "Monday":
                if(heure >= 8)
                {
                    if(heure == 17)
                    {
                        //STREAM OFF
                        streamOff(rvOff, swipeOff);
                    }

                    //STREAM ON
                    if(heure == 8 || heure == 9)
                    {
                        //STREAM DE EMERALD
                        textV.setText("WebTV : 8H-10H\nEMERALD\nsur CSGO");
                    }
                    else if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 10H-13H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 18 || heure == 19 || heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 18H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Tuesday":
                if(heure >= 8)
                {
                    if(heure == 13 || heure == 14 || heure == 17)
                    {
                        //STREAM OFF
                        streamOff(rvOff, swipeOff);
                    }

                    //STREAM ON
                    if(heure == 8 || heure == 9)
                    {
                        //STREAM DE EMERALD
                        textV.setText("WebTV : 8H-10H\nEMERALD\nsur CSGO");
                    }
                    else if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 13H-15H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur\nThe Elder Scrolls");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM ROXY
                        textV.setText("WebTV : 18H-20H\nROXY\nsur CSGO/Battlerite");
                    }
                    else if(heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Wednesday":
                if(heure >= 10)
                {
                    //STREAM ON
                    if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 10H-13H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 17)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 17H-18H\nNERODITH");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM ROXY
                        textV.setText("WebTV : 18H-20H\nROXY\nsur CSGO/Battlerite");
                    }
                    else if(heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Thursday":
                if(heure >= 8)
                {
                    if(heure == 8 || heure == 9)
                    {
                        //STREAM DE EMERALD
                        textV.setText("WebTV : 8H-10H\nEMERALD\nsur CSGO");
                    }
                    else if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 10H-13H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 17)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 17H-18H\nNERODITH");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM ROXY
                        textV.setText("WebTV : 18H-20H\nROXY\nsur CSGO/Battlerite");
                    }
                    else if(heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Friday":
                if(heure >= 10)
                {
                    if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 13H-15H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 17)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 17H-18H\nNERODITH");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM CODYY
                        textV.setText("WebTV : 18H-20H\nCODYY\nsur HearthStone");
                    }
                    else if (heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Saturday":
                if(heure >= 8)
                {
                    if (heure == 11 || heure == 12)
                    {
                        //STREAM OFF
                        streamOff(rvOff, swipeOff);
                    }

                    //STREAM ON
                    if(heure == 8 || heure == 9 || heure == 10)
                    {
                        //STREAM MILA
                        textV.setText("WebTV : 8H-11H\nMILA\nsur CSGO");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 17)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 17H-18H\nNERODITH");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM CODYY
                        textV.setText("WebTV : 18H-20H\nCODYY\nsur HS");
                    }
                    else if (heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM NERO
                        textV.setText("WebTV : 22H-00H\nNERODITH\nsur STYX");
                    }
                } else
                {
                    streamOff(rvOff, swipeOff);
                }
                break;

            case "Sunday":
                if(heure >= 8)
                {
                    if (heure == 11 || heure == 12 || heure == 17 || heure == 22 || heure == 23)
                    {
                        //STREAM OFF
                        streamOff(rvOff, swipeOff);
                    }

                    //STREAM ON
                    if(heure == 8 || heure == 9 || heure == 10)
                    {
                        //STREAM MILA
                        textV.setText("WebTV : 8H-11H\nMILA\nsur CSGO");
                    }
                    else if (heure == 13 || heure == 14)
                    {
                        //STREAM KHRYS
                        textV.setText("WebTV : 13H-15H\nKHRYS\nsur CSGO");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM ALKA
                        textV.setText("WebTV : 15H-17H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM ROXY
                        textV.setText("WebTV : 18H-20H\nROXY\nsur CSGO/Battlerite");
                    }
                    else if (heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur HOTS");
                    }
                } else
                {
                    streamOff(rvOff, swipeOff);
                }
                break;
        }
    }

    private void streamOff(RelativeLayout rvOff, SwipeRefreshLayout swipeOff){
        rvOff.setVisibility(View.GONE);
        swipeOff.setPadding(0,0,0,0);
    }
}
