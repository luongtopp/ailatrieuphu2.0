package com.example.ailatrieuphu20.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATA_NAME = "data.sqlite";
    public static final int DATA_VERSION = 1;

    String createTableCauHoi = "CREATE TABLE " + "Cauhoi"
            + "("
            + "id " + "INTEGER " + "PRIMARY KEY" + " autoincrement,"
            + "capdo " + " INTEGER,"
            + "noidung " + " TEXT,"
            + "dapan " + " TEXT,"
            + "dapasai " + " TEXT"
            + ")";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATA_NAME, null, DATA_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableCauHoi);
        fakedata(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void fakedata(SQLiteDatabase d) {
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,1,\"" + "Chất liệu gì hay dùng để cắt kim cương?" + "\",\"" + "Kim Cương" + "\",\"" + "Thép & Thủy tinh kim loại & Titanium" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,2,\"" + "“Vợ nhặt” là tác phẩm của tác giả nào?" + "\",\"" + "Kim Lân" + "\",\"" + "Ngô Tất Tố & Vũ Trọng Phụng & Nam Cao" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,3,\"" + "Thủ đô của Trung Quốc là?" + "\",\"" + "Bắc Kinh" + "\",\"" + "Đài Loan & Hồng Kông & Tô Châu" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,4,\"" + "One Piece là bộ Manga của tác giả nào?" + "\",\"" + "Eiichiro Oda" + "\",\"" + "Akira Toriyama & Kubo Tite & Hiro Mashima" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,5,\"" + "Kênh truyền hình từng chuyên dành cho thiếu nhi của VTC là?" + "\",\"" + "VTC 11" + "\",\"" + "VTC 14 & VTC 3 & VTC 2" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,6,\"" + "Đài Truyền hình quốc gia VTV ra đời vào năm nào?" + "\",\"" + "1970" + "\",\"" + "1969&1971&1972" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,7,\"" + "Ngô Quyền đại chiến với quân giặc nào trên sông Bạch Đằng năm 938?" + "\",\"" + "Nam Hán" + "\",\"" + "Ngô&Ân&Mông" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,8,\"" + "Đỉnh núi cao nhất Việt Nam – Fansipan thuộc dãy núi nào?" + "\",\"" + "Hoàng Liên Sơn" + "\",\"" + "Trường Sơn&Ngọc Linh&Ba Vì" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,9,\"" + "Những người sinh ngày 23/11 thuộc cung hoàng đạo nào?" + "\",\"" + "Nhân Mã" + "\",\"" + "Bạch Dương&Cự Giải&Ma Kết" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,10,\"" + "Cầu thủ Nguyễn Công Phượng bắt đầu sự nghiệp từ CLB nào?" + "\",\"" + "Hoàng Anh Gia Lai" + "\",\"" + "Đông Á Thanh Hóa&Hà Nội&Hồng Lĩnh Hà Tĩnh" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,11,\"" + "Chất nào có thể ăn mòn thủy tinh?" + "\",\"" + "Hidro Fluoride" + "\",\"" + "Axit Sulfuric&Methanol&Acid Hydrochloric" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,12,\"" + "Đơn vị đo độ ồn âm thanh là gì?" + "\",\"" + "Decibel" + "\",\"" + "Ampe&Byte&Celsius" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,13,\"" + "Trong lịch sử, nhà Nguyễn từng có bao nhiêu đời vua Nguyễn?" + "\",\"" + "13" + "\",\"" + "11&12&14" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,14,\"" + "Vị vua đầu tiên của nhà nước chính thức nước ta là ai?" + "\",\"" + "Lý Nam Đế" + "\",\"" + "Hùng Vương&Lê Hoàn&Hồ Quý Ly" + "\");");
        d.execSQL("INSERT INTO Cauhoi (id,capdo ,noidung,dapan,dapasai) VALUES (null,15,\"" + "Tỉnh nào là nơi chưa có tuyến cao tốc gắn trực tiếp tới thủ đô Hà Nội?" + "\",\"" + "Hà Giang" + "\",\"" + "Hưng Yên&Hải Phòng&Lào Cai" + "\");");

    }

}
