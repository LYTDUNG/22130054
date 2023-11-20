package Ex.Manager_Book;

public class SachThamKhao extends AnPham {
    /**
     * Lĩnh vực((ví dụ: y học, thể thao, giáo dục, …)
     */
    private String linhVuc;

    public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String linhVuc) {
        super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
        this.linhVuc = linhVuc;
    }
    @Override
    public String type() {
        return "Sach Tham Khao";
    }
    @Override
    public boolean isTapChiTenAgo() {
        return false;
    }
    
}
