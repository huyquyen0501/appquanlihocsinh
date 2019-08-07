package com.example.tran.qlhocphi.DTO;



public class UserDTO {
    private int id;
    private String sTaiKhoan,sMatKhau;

    public UserDTO() {
    }

    public UserDTO(String sTaiKhoan, String sMatKhau) {
        this.sTaiKhoan = sTaiKhoan;
        this.sMatKhau = sMatKhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsTaiKhoan() {
        return sTaiKhoan;
    }

    public void setsTaiKhoan(String sTaiKhoan) {
        this.sTaiKhoan = sTaiKhoan;
    }

    public String getsMatKhau() {
        return sMatKhau;
    }

    public void setsMatKhau(String sMatKhau) {
        this.sMatKhau = sMatKhau;
    }
}

