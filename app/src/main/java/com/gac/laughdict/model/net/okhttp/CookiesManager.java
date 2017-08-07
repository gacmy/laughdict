package com.gac.laughdict.model.net.okhttp;

import android.content.Context;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import static okhttp3.internal.Util.UTC;

public class CookiesManager implements CookieJar {

        private final PersistentCookieStore cookieStore;
        private Context context;

        public CookiesManager(Context context){
            cookieStore = new PersistentCookieStore(context);
            this.context = context;
        }
        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//            if(url.toString().contains("login")){
                   StringBuilder sb = new StringBuilder();


                    if(cookies != null && cookies.size() == 1){
                        sb.append(cookies.get(0).name()+","+cookies.get(0).value());
                       // SPUtils.setJseesionId(sb.toString(),context);
                       // L.d("httputils","cookie0:"+toString(cookies.get(0)));
                    }
                    if(cookies != null && cookies.size() == 2){
                        String cookie = cookies.get(0).name()+","+cookies.get(0).value();
                        String cookie1 = cookies.get(1).name()+","+cookies.get(1).value();
                        if(cookies.get(0).name().equals("remember-me")){
                          //  SPUtils.setRememberMe(cookie,context);
                           // SPUtils.setJseesionId(cookie1,context);
                        }else{
                          //  SPUtils.setJseesionId(cookie,context);
                          //  SPUtils.setRememberMe(cookie1,context);
                        }
                        sb.append(cookies.get(0).name()+","+cookies.get(0).value()+",");
                        sb.append(cookies.get(1).name()+","+cookies.get(1).value());
                     //   L.d("httputils","receive cookie0:"+toString(cookies.get(0)));

//                        L.d("httputils","receive cookie1:"+toString(cookies.get(1)));
//                        SPUtils.setCookie(sb.toString(),context);
                    }
                  //  L.d("httputils","receive cookie:"+sb.toString());
                    for (Cookie item : cookies) {

                        //sb.append(item.toString()+",");

                       // cookieStore.add(url, item);
                    }

//                    System.out.println("cookies:"+sb.toString());
//
//                    SPUtils.setCookie(sb.toString(),context);
                }



    public String toString(Cookie cookie) {
        StringBuilder result = new StringBuilder();
        result.append(cookie.name());
        result.append('=');
        result.append(cookie.value());

        if (cookie.persistent()) {
            if (cookie.expiresAt() == Long.MIN_VALUE) {
                result.append("; max-age=0");
            } else {
                DateFormat rfc1123 = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
                rfc1123.setLenient(false);
                rfc1123.setTimeZone(UTC);

                result.append("; Expires=").append(rfc1123.format(cookie.expiresAt()));
            }
        }

        if (!cookie.hostOnly()) {
            result.append("; domain=").append(cookie.domain());
        }

        result.append("; Path=").append(cookie.path());

        if (cookie.secure()) {
            result.append("; secure");
        }

        if (cookie.hostOnly()) {
            result.append("; HttpOnly");
        }

        return result.toString();
    }
      List<Cookie> cookies  = new ArrayList<>();
        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {
//            cookies.clear();
//            String nowdate = DateUtils.getDateStr(new Date());
//            Calendar dd = Calendar.getInstance();//定义日期实例
//            dd.setTime(new Date());//设置日期起始时间
//            dd.add(Calendar.YEAR,3);
//            Date date = DateUtils.calendar2Date(dd);
//            String[] remember = SPUtils.getRememberMe(context).split(",");
//            Cookie.Builder builder = new Cookie.Builder();
//
//            if(remember != null && remember.length ==2){
//                builder.name(remember[0]).value(remember[1]).domain(url.host());
//                builder.expiresAt(date.getTime());
//
//            }else{
//                builder.name("remember-me").value("ffdadafddaff").domain(url.host());
//                builder.expiresAt(date.getTime());
//            }
//            Cookie.Builder builder1 = new Cookie.Builder();
//            String[] seesionId = SPUtils.getSessionId(context).split(",");
//            if(seesionId != null && seesionId.length ==2){
//                builder1.name(seesionId[0]).value(seesionId[1]);
//                builder1.domain(url.host());
//                builder1.expiresAt(date.getTime());
//            }else{
//                builder1.name("JSESSIONID").value("ffdadafddaff");
//                builder1.domain(url.host());
//                builder1.expiresAt(date.getTime());
//               // builder1.name().value().domain(url.host());
//            }
//             cookies.add(builder.build());
//             cookies.add(builder1.build());
//
//            L.d("httputils","send cookies cookie0:"+toString(cookies.get(0))+" cookie1:"+cookies.get(1));
            return cookies;
        }
    }