package com.example.tran.qlhocphi.DTO;



import java.io.Serializable;

public class SoGhiDTO implements Serializable {
    private int iMaSoGhi,iMaHS,iMaHP;
    private String sNgayLap;

    public SoGhiDTO() {
    }

    public int getiMaSoGhi() {
        return iMaSoGhi;
    }

    public void setiMaSoGhi(int iMaSoGhi) {
        this.iMaSoGhi = iMaSoGhi;
    }

    public int getiMaHS() {
        return iMaHS;
    }

    public void setiMaHS(int iMaHS) {
        this.iMaHS = iMaHS;
    }

    public int getiMaHP() {
        return iMaHP;
    }

    public void setiMaHP(int iMaHP) {
        this.iMaHP = iMaHP;
    }

    public String getsNgayLap() {
        return sNgayLap;
    }

    public void setsNgayLap(String sNgayLap) {
        this.sNgayLap = sNgayLap;
    }
}
