package com.example.tran.qlhocphi.DTO;



import java.io.Serializable;

public class HocSinhDTO implements Serializable {
    private String sHoTen,sNgaySinh,sGioiTinh,sDiaChi;
    int iMaHS;
    public HocSinhDTO() {
    }

    public HocSinhDTO(String sHoTen, String sNgaySinh, String sGioiTinh, String sDiaChi) {
        this.sHoTen = sHoTen;
        this.sNgaySinh = sNgaySinh;
        this.sGioiTinh = sGioiTinh;
        this.sDiaChi = sDiaChi;
    }

    public int getiMaHS() {
        return iMaHS;
    }

    public void setiMaHS(int iMaHS) {
        this.iMaHS = iMaHS;
    }

    public String getsHoTen() {
        return sHoTen;
    }

    public void setsHoTen(String sHoTen) {
        this.sHoTen = sHoTen;
    }

    public String getsNgaySinh() {
        return sNgaySinh;
    }

    public void setsNgaySinh(String sNgaySinh) {
        this.sNgaySinh = sNgaySinh;
    }

    public String getsGioiTinh() {
        return sGioiTinh;
    }

    public void setsGioiTinh(String sGioiTinh) {
        this.sGioiTinh = sGioiTinh;
    }

    public String getsDiaChi() {
        return sDiaChi;
    }

    public void setsDiaChi(String sDiaChi) {
        this.sDiaChi = sDiaChi;
    }
}

