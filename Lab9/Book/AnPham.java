package Ex.Manager_Book;

public abstract class AnPham {
    /**
     * tiêu đề ấn phẩm
     */
    private String tieuDe;
    /**
     * số trang ấn phẩm
     */
    private int soTrang;
    /**
     * năm xuất bản
     */
    private int namXuatBan;
    /**
     * tác giả
     */
    private String tacGia;
    /**
     * giá tiền
     */
    private double giaTien;

    protected AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien) {
        this.tieuDe = tieuDe;
        this.soTrang = soTrang;
        this.namXuatBan = namXuatBan;
        this.tacGia = tacGia;
        this.giaTien = giaTien;
    }

    /**
     * Trả về loại ấn phẩm
     * 
     * @return loại ấn phẩm
     */
    public abstract String type();

    /**
     * Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây
     * (2021) 10 năm hay không
     * 
     * @return true nếu là tạp chí và có thời gian xuất bản cách đây (2021) 10 năm
     */
    public abstract boolean isTapChiTenAgo();

    /**
     * Phương thức kiểm tra hai ấn phẩm có cùng loại và cùng tác giả hay không
     * 
     * @return true nếu hai ấn phẩm có cùng loại và cùng tác giả
     */
    public boolean isSameTypeAndAuthor(AnPham anPham) {
        return this.type().equals(anPham.type()) && this.tacGia.equals(anPham.tacGia);
    }

    /**
     * Phương thức so sánh số trang của hai ấn phẩm
     * 
     * @param anPham ấn phẩm dùng để so sánh
     * @return trả về true nếu lớn hơn
     */
    public boolean compareBookPageCount(AnPham anPham) {
        return this.soTrang > anPham.soTrang;
    }

    /**
     * Phương tìm kiểm tra xem chuỗi truyền vào có phải là tiêu đề của ấn phẩm không
     * 
     * @return trả về true nếu chuỗi vào là tiêu đề của ấn phẩm
     */
    public boolean sameTitle(String tieuDe) {
        return this.tieuDe.equals(tieuDe);
    }
    /**
     * Phương thức kiểm tra ấn phẩm có được xuất bản trong năm cho trước hay không
     * @param year năm cho trước
     * @return trả về true nếu cùng năm
     */
    public boolean isPublishedInYear(int year) {
        return this.namXuatBan == year;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    @Override
    public String toString() {
        return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan +  "]\n";
    }
    

}
