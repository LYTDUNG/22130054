package Ex.Manager_Book;

public class TapChi extends AnPham {
    /**
     * Tên tạp chí
     */
    private String tenTapChi;

    public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, double giaTien, String tenTapChi) {
        super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
        this.tenTapChi = tenTapChi;
    }

    @Override
    public String type() {
        return "Tap Chi";
    }

    @Override
    public boolean isTapChiTenAgo() {
        return 2021 - super.getNamXuatBan() >= 10;
    }

}
