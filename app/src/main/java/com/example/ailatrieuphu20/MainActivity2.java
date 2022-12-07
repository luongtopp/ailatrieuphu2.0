package com.example.ailatrieuphu20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ailatrieuphu20.adapter.TienThuongAdapter;
import com.example.ailatrieuphu20.object.CauHoi;
import com.example.ailatrieuphu20.object.FaceData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ListView lsvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    CauHoi cauHoi;

    int viTriCauHoi = 0;
    View.OnClickListener listener;
    TextView txvCauHoi, txvCauTl1, txvCauTl2, txvCauTl3, txvCauTl4, txvThuaGame;
    ArrayList<TextView> arrTxvCauTraLoi;
    String cauTraoLoi;
    FaceData faceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        anhXa();
        setUp();
        setClick();
        try {
            this.getSupportActionBar().hide();
        }
        // catch block to handle NullPointerException
        catch (NullPointerException e) {
        }
    }
    public void  init(){
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("1000000");
        arrTienThuong.add("500000");
        arrTienThuong.add("250000");
        arrTienThuong.add("125000");
        arrTienThuong.add("64000");
        arrTienThuong.add("32000");
        arrTienThuong.add("16000");
        arrTienThuong.add("8000");
        arrTienThuong.add("4000");
        arrTienThuong.add("2000");
        arrTienThuong.add("1000");
        arrTienThuong.add("500");
        arrTienThuong.add("300");
        arrTienThuong.add("200");
        arrTienThuong.add("100");
        tienThuongAdapter = new TienThuongAdapter(this,0,arrTienThuong); // thực thể

        cauHoi = new CauHoi();

        arrTxvCauTraLoi = new ArrayList<>();

        faceData = new FaceData(this);

    }
    public void  anhXa(){
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTl1 = findViewById(R.id.txvCauTL1);
        txvCauTl2 = findViewById(R.id.txvCauTL2);
        txvCauTl3 = findViewById(R.id.txvCauTL3);
        txvCauTl4 = findViewById(R.id.txvCauTL4);
        txvThuaGame = findViewById(R.id.txvThuaGame);

        arrTxvCauTraLoi.add(txvCauTl1);
        arrTxvCauTraLoi.add(txvCauTl2);
        arrTxvCauTraLoi.add(txvCauTl3);
        arrTxvCauTraLoi.add(txvCauTl4);



    }
    public void  setUp(){
        txvThuaGame.setVisibility(View.GONE);
        lsvTienThuong.setAdapter(tienThuongAdapter);
        hienCauHoi();
    }
    public void  setClick(){
        listener = (view) -> {
          checkCauTraLoi(((TextView) view));
        };
       for(TextView t : arrTxvCauTraLoi){
           t.setOnClickListener(listener);
       }
    }
    public void checkCauTraLoi(final TextView txv){
        cauTraoLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);

    new CountDownTimer(2000,100){

            @Override
            public void onTick(long l) {

            }

            public void onFinish(){
                for (TextView t : arrTxvCauTraLoi){
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())){
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(2000,100){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        if (cauTraoLoi.equals(cauHoi.getDapAnDung())){
                            viTriCauHoi++;
                            if (viTriCauHoi>=arrTienThuong.size()){
                                viTriCauHoi = arrTienThuong.size();
                                txvThuaGame.setVisibility(View.VISIBLE);
                                txvThuaGame.setText("Chúc mừng bạn đã chiến thắng giành \n"+arrTienThuong.get(0)+"000 VNĐ");
                                return;
                            }
                            hienCauHoi();
                        }
                        else{
                            txvThuaGame.setVisibility(View.VISIBLE);
                            // 8 5 + 3
                            if(viTriCauHoi == 0) {
                                txvThuaGame.setText("Chúc mừng bạn may mắn lần sau!");
                                return;

                            }
                            int vitriTienThuong = arrTienThuong.size()-viTriCauHoi;
                            txvThuaGame.setText("Bạn sẽ ra về với tiền thưởng là \n"+arrTienThuong.get(vitriTienThuong)+"000 VNĐ");
                          //  Toast.makeText(MainActivity2.this,"Ban Da Thua",Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
        }.start();

    }

    public void setCauHoi(){
        cauHoi = faceData.taoCauHoi(viTriCauHoi);
    }
    public  void hienCauHoi(){
        setCauHoi();
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());

        Random r = new Random();
        for(int i=0;i<5;i++){
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            //  int vt3 = r.nextInt(arrCauTraLoi.size());
            //  int vt4 = r.nextInt(arrCauTraLoi.size());

           String a = arrCauTraLoi.get(vt1);// 0 1 2 3
            arrCauTraLoi.set(vt1,arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2,a);
        }

        for(int i=0;i<arrTxvCauTraLoi.size();i++){
            arrTxvCauTraLoi.get(i).setOnClickListener(listener);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }


        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);

    }

    boolean troGiup5050 = true;
    public void trogiup5050(View view) {
        if(troGiup5050 == false){
            return;
        }
        Random r = new Random();
        int sodanAnAndi = 2;
        do {
            int vitriDanAnAn = r.nextInt(4);
            TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);
            if (t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung())==false){
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAndi--;
            }
        }while (sodanAnAndi>0);
        troGiup5050 = false;
    }

    boolean troGiupKhanGia = true;
    public void troGiupKhanGia(View view) {
        if(troGiupKhanGia == false){
            return;
        }
        for (int i = 0;i<arrTxvCauTraLoi.size();i++){
            TextView t = arrTxvCauTraLoi.get(i);
            if(t.getText().toString().equals(cauHoi.getDapAnDung())){
                new DialogKhanGiaTraLoi(this, i+1).show();
                break;
            }
        }
        troGiupKhanGia = false;
    }

    boolean troGiupDoiCauHoi = true;
    public void trogiupDoiCauHoi(View view) {
        if(troGiupDoiCauHoi == false){
            return;
        }
        faceData.taoCauHoi(viTriCauHoi+1);
        viTriCauHoi++;
        hienCauHoi();
        troGiupDoiCauHoi = false;
    }
}