package com.buiminhquy.demotestandroid;

public class SanPham {
    private String masp;

    private String tensp;

    private int gia;

    public SanPham(String masp, String tensp, int gia) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia = gia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + masp  + "\n Tên Sản phẩm: " + tensp + "\n Giá Sản Phẩm:  " + gia;
    }
}
