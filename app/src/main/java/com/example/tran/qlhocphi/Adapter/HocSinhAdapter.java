package com.example.tran.qlhocphi.Adapter;



import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class HocSinhAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<HocSinhDTO> arrper;
    private int mylayout;
    private final String TAG = getClass().getSimpleName();

    public HocSinhAdapter() {
    }

    public HocSinhAdapter(Activity context, ArrayList<HocSinhDTO> arrper, int mylayout){
        this.context = context;
        this.arrper = arrper;
        this.mylayout = mylayout;
    }
    public void setArrylist(ArrayList<HocSinhDTO> hocSinh){
        arrper = hocSinh;
        this.notifyDataSetChanged();
    }
    public HocSinhDTO get(int i){
        return arrper.get(i);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.hocsinhcustom, parent, false);
            viewHolder.tvMaHS = convertView.findViewById(R.id.tvHSAMaHS);
            viewHolder.tvHoten = convertView.findViewById(R.id.tvHSAHoTen);
            viewHolder.tvNgaySinh = convertView.findViewById(R.id.tvHSANgaySinh);
            viewHolder.tvGioiTinh = convertView.findViewById(R.id.tvHSAGioiTinh);
            viewHolder.tvDiaChi = convertView.findViewById(R.id.tvHSADiaChi);
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HocSinhDTO person = arrper.get(position);
        viewHolder.tvMaHS.setText("Mã học sinh: " +person.getiMaHS());
        viewHolder.tvHoten.setText("Họ tên: " +person.getsHoTen());
        viewHolder.tvNgaySinh.setText("Ngày sinh: " +person.getsNgaySinh());
        viewHolder.tvGioiTinh.setText("Giới tính: " +person.getsGioiTinh());
        viewHolder.tvDiaChi.setText("Địa chỉ: " +person.getsDiaChi());
        return convertView;
    }
    public class ViewHolder{
        TextView tvMaHS, tvHoten, tvNgaySinh, tvGioiTinh, tvDiaChi;
    }
}

