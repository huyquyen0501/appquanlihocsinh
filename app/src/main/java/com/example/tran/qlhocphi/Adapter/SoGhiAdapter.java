package com.example.tran.qlhocphi.Adapter;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tran.qlhocphi.DTO.SoGhiDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class SoGhiAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<SoGhiDTO> arrper;
    private int mylayout;

    public SoGhiAdapter(Activity context, ArrayList<SoGhiDTO> arrper, int mylayout){
        this.context = context;
        this.arrper = arrper;
        this.mylayout = mylayout;
    }
    public void setArrylist(ArrayList<SoGhiDTO> hocPhi){
        arrper = hocPhi;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrper.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.soghicustom, parent, false);
            viewHolder.tvMaSoGhi = convertView.findViewById(R.id.tvSGAMaSoGhi);
            viewHolder.tvMaHS = convertView.findViewById(R.id.tvSGAMaHS);
            viewHolder.tvMaHP = convertView.findViewById(R.id.tvSGAMaHP);
            viewHolder.tvNgayLap = convertView.findViewById(R.id.tvSGANgayLap);
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SoGhiDTO soghi = arrper.get(position);
        viewHolder.tvMaSoGhi.setText("Mã: " +soghi.getiMaSoGhi());
        viewHolder.tvMaHS.setText("Mã học sinh: " +soghi.getiMaHS());
        viewHolder.tvMaHP.setText("Mã học phí: " +soghi.getiMaHP());
        viewHolder.tvNgayLap.setText("Ngày lập: " +soghi.getsNgayLap());
        return convertView;
    }
    public class ViewHolder{
        TextView tvMaSoGhi, tvMaHS, tvMaHP, tvNgayLap;
    }

    public SoGhiDTO get(int i){
        return arrper.get(i);
    }

}
