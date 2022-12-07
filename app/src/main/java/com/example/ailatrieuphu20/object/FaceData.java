package com.example.ailatrieuphu20.object;

import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu20.sql.DBManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Logger;

public class FaceData {
    ArrayList<ArrayList<CauHoi>> arrCauHoi = new ArrayList<>();
    private int a[] = new int[15];
    public FaceData(Context ct) {
        layCauHoiSqlite(ct);
        //taoCauHoi1();
    }

    public void layCauHoiSqlite(Context ct) {
        DBManager d = new DBManager(ct);
        d.open();
        arrCauHoi = new ArrayList<>(d.getcauhoi());
        Collections.shuffle(arrCauHoi);
        d.close();

    }

    public CauHoi taoCauHoi(int viTri) {
        return arrCauHoi.get(viTri).get(0);
    }


//    public  void taoCauHoi1(){
//        ArrayList<CauHoi> arrCauSo1 = new ArrayList<>();
//        arrCauSo1.add(taoCauHoi("Điền từ nào thiếu vào câu ca dao: \"Gần mực thì đen, gần đèn thì ...\"gì?","Sáng","Chói&Lóa&Tối"));
//        arrCauSo1.add(taoCauHoi("Mưa ngây là vào khoảng tháng mấy trong năm?","7","1&4&9"));
//      //  arrCauSo1.add(taoCauHoi("","",""));
//      //  arrCauSo1.add(taoCauHoi("","",""));
//        arrCauHoi.add(arrCauSo1);
//
//        // cau so 2
//        ArrayList<CauHoi> arrCauSo2 = new ArrayList<>();
//        arrCauSo2.add(taoCauHoi("Từ nào sau đây khác nghĩa với 3 từ còn lại?","Sinh viên","Sinh nở&Sinh sôi &Sinh đẻ"));
//        arrCauSo2.add(taoCauHoi("Pha màu đỏ với màu xanh lam, ta được màu nào sau đây?","Tím","Vàng&Xanh&Nâu"));
//        arrCauHoi.add(arrCauSo2);
//
//    }

//    private  CauHoi taoCauHoi(String s1, String s2, String s3){
//        CauHoi c1 = new CauHoi();
//        c1.setNoiDung(s1);
//        c1.setDapAnDung(s2);
//        c1.setArrDapAnSai(s3);
//        return  c1;
//    }
}
