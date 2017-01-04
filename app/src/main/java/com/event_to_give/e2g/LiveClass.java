package com.event_to_give.e2g;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Created by Louis on 17/11/2016.
 * <p>
 * e2g
 */

class LiveClass
{
    void showPlanning(TextView textV, LinearLayout lvOff)
    {
        Calendar c = Calendar.getInstance();

        int heure = c.get(Calendar.HOUR_OF_DAY);
        int day = c.get(Calendar.DAY_OF_WEEK);

        switch (day)
        {
            case Calendar.MONDAY:
                if(heure >= 8)
                {
                    if(heure == 8 || heure == 9 || heure == 13 || heure == 14 || heure == 15 || heure == 16 || heure == 17)
                    {
                        //STREAM OFF
                        streamOff(lvOff);
                    }
                    else
                    {
                        lvOff.setVisibility(View.VISIBLE);
                    }

                    if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 10H-13H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM D4NTE
                        textV.setText("WebTV : 18H-20H\nD4NTE\nsur Titan Fall");
                    }
                    else if (heure == 20 || heure == 21)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 20H-22H\nXANXS\nsur STYX");
                    }
                    else if (heure == 22 || heure == 23)
                    {
                        //STREAM XANXS
                        textV.setText("WebTV : 22H-00H\nXANXS\nsur STYX");
                    }
                }
                else
                {
                    streamOff(lvOff);
                }
                break;

            case Calendar.TUESDAY:
                if(heure >= 8)
                {
                    if(heure == 13 || heure == 14 || heure == 15 || heure == 16 || heure == 17 || heure == 23)
                    {
                        //STREAM OFF
                        streamOff(lvOff);
                    }
                    else
                    {
                        //STREAM ON
                        lvOff.setVisibility(View.VISIBLE);
                    }

                    //STREAM ON
                    if(heure == 8 || heure == 9)
                    {
                        //STREAM DE ALKA
                        textV.setText("WebTV : 8H-10H\nALKA\nsur The Elder Scrolls");
                    }
                    else if (heure == 10 || heure == 11 || heure == 12)
                    {
                        //STREAM JAWAN
                        textV.setText("WebTV : 10H-13H\nJAWAN\nsur HOTS");
                    }
                    else if (heure == 15 || heure == 16)
                    {
                        //STREAM CROWNED
                        textV.setText("WebTV : 15H-17H\nCROWNED\nsur Overwatch");
                    }
                    else if (heure == 18 || heure == 19)
                    {
                        //STREAM ROXY
                        textV.setText("WebTV : 18H-20H\nROXY\nsur CSGO/Battlerite");
                    }
                    else if(heure == 20 || heure == 21 || heure == 22)
                    {
                        //STREAM D4NTE
                        textV.setText("WebTV : 20H-23H\nD4NTE\nsur Titan Fall 2");
                    }
                }
                else
                {
                    streamOff(lvOff);
                }
                break;

            case Calendar.WEDNESDAY:
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
                    streamOff(lvOff);
                }
                break;

            case Calendar.THURSDAY:
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
                    streamOff(lvOff);
                }
                break;

            case Calendar.FRIDAY:
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
                    streamOff(lvOff);
                }
                break;

            case Calendar.SATURDAY:
                if(heure >= 8)
                {
                    if (heure == 11 || heure == 12)
                    {
                        //STREAM OFF
                        streamOff(lvOff);
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
                    streamOff(lvOff);
                }
                break;

            case Calendar.SUNDAY:
                if(heure >= 8)
                {
                    if (heure == 11 || heure == 12 || heure == 17 || heure == 22 || heure == 23)
                    {
                        //STREAM OFF
                        streamOff(lvOff);
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
                    streamOff(lvOff);
                }
                break;
        }
    }

    private void streamOff(LinearLayout lvOff)
    {
        lvOff.setVisibility(View.GONE);
    }
}