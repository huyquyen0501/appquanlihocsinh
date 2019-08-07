package com.example.tran.qlhocphi.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tran.qlhocphi.DTO.HocPhiDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class HocPhiAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<HocPhiDTO> arrper;
    private int mylayout;

    public HocPhiAdapter(Activity context, ArrayList<HocPhiDTO> arrper, int mylayout){
        this.context = context;
        this.arrper = arrper;
        this.mylayout = mylayout;
    }
    public void setArrylist(ArrayList<HocPhiDTO> hocPhi){
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
            convertView = LayoutInflater.from(context).inflate(R.layout.hocphicustom, parent, false);
            viewHolder.tvMaHP = convertView.findViewById(R.id.tvHPAMaHP);
            viewHolder.tvTenHP = convertView.findViewById(R.id.tvHPATenHP);
            viewHolder.tvSoTien = convertView.findViewById(R.id.tvHPASoTien);
            viewHolder.tvHocKy = convertView.findViewById(R.id.tvHPAHocKy);
            viewHolder.tvNamHoc = convertView.findViewById(R.id.tvHPANamHoc);
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HocPhiDTO person = arrper.get(position);
        viewHolder.tvMaHP.setText("Mã học phí: " +person.getiMaHP());
        viewHolder.tvTenHP.setText("Tên HP: " +person.getsTenHP());
        viewHolder.tvSoTien.setText("Số tiền: " +person.getiSoTien());
        viewHolder.tvHocKy.setText("Học kỳ: " +person.getiHocKy());
        viewHolder.tvNamHoc.setText("Năm học: " +person.getiNamHoc());
        return convertView;
    }
    public class ViewHolder{
        TextView tvMaHP, tvTenHP, tvSoTien, tvHocKy, tvNamHoc;
    }
    public HocPhiDTO get(int pos){
        return arrper.get(pos);
    }
}
