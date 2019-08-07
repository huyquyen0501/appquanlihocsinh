package com.example.tran.qlhocphi.DTO;



import java.io.Serializable;

public class HocPhiDTO implements Serializable {
    private String sTenHP;
    private int iMaHP,iSoTien,iHocKy,iNamHoc;
    public HocPhiDTO() {
    }

    public HocPhiDTO(String sTenHP, int iSoTien, int iHocKy, int iNamHoc) {
        this.sTenHP = sTenHP;
        this.iSoTien = iSoTien;
        this.iHocKy = iHocKy;
        this.iNamHoc = iNamHoc;
    }

    public int getiMaHP() {
        return iMaHP;
    }

    public void setiMaHP(int iMaHP) {
        this.iMaHP = iMaHP;
    }

    public String getsTenHP() {
        return sTenHP;
    }

    public void setsTenHP(String sTenHP) {
        this.sTenHP = sTenHP;
    }

    public int getiSoTien() {
        return iSoTien;
    }

    public void setiSoTien(int iSoTien) {
        this.iSoTien = iSoTien;
    }

    public int getiHocKy() {
        return iHocKy;
    }

    public void setiHocKy(int iHocKy) {
        this.iHocKy = iHocKy;
    }

    public int getiNamHoc() {
        return iNamHoc;
    }

    public void setiNamHoc(int iNamHoc) {
        this.iNamHoc = iNamHoc;
    }
}
