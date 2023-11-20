package Ex.Manager_Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NhaSach {
    private List<AnPham> anPhams;
    public NhaSach(List<AnPham> anPhams) {
        this.anPhams = anPhams;
    }

    /**
     * Phương thức để kiểm tra loại của ấn phẩm truyền vào
     * 
     * @param anPham ấn phầm cần kiểm tra loại
     * @return loại của ấn phẩm
     */
    public String type(AnPham anPham) {
        return anPham.type();
    }

    /**
     * Phương thức kiểm tra ấn phẩm là tạp chí và có thời gian xuất bản cách đây
     * (2021) 10 năm hay không
     * 
     * @param anPham ấn phầm cần kiểm tra
     * @return true nếu là tạp chí và có thời gian xuất bản cách đây (2021) 10 năm
     */
    public boolean isMagazineTenAgo(AnPham anPham) {
        return anPham.isTapChiTenAgo();
    }

    /**
     * Phương thức kiểm tra hai ấn phẩm có cùng loại và tác gỉả không
     * 
     * @param anPham1 ấn phẩm thứ nhất
     * @param anPham2 ấn phẩm thứ hai
     * @return trả về true nếu có cùng loại và tác giả
     */
    public boolean isSameTypeAndAuthor(AnPham anPham1, AnPham anPham2) {
        return anPham1.isSameTypeAndAuthor(anPham2);
    }

    /**
     * Phương thức tính tổng giá tiền của các ấn phẩm
     * 
     * @return tổng giá tiền của các ấn phẩm
     */
    public double sumPrice() {
        double sum = 0;
        for (AnPham anPham : anPhams) {
            sum += anPham.getGiaTien();
        }
        return sum;
    }

    /**
     * Phương thức tìm sách tham khảo có số trang lớn nhất
     * 
     * @return trả về ấn phẩm có số trang lớn nhất
     */
    public AnPham findMaxChapterBook() {
        AnPham sachThamKhao = null;
        for (AnPham anPham : anPhams) {
            if (anPham instanceof SachThamKhao) {
                if (sachThamKhao == null)
                    sachThamKhao = anPham;
                else if (anPham.compareBookPageCount(sachThamKhao)) {
                    sachThamKhao = anPham;
                }
            }
        }
        return sachThamKhao;
    }

    /**
     * Kiểm tra xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước
     * 
     * @param name tên cho trước
     * @return trả về true nếu có
     */
    public boolean hasMagazine(String name) {
        for (AnPham anPham : anPhams) {
            if (anPham.sameTitle(name))
                return true;
        }
        return false;
    }

    public List<AnPham> getMagazinesByYear(int year) {
        List<AnPham> list = new ArrayList<>();
        for (AnPham anPham : anPhams) {
            if (anPham.isPublishedInYear(year)) {
                list.add(anPham);
            }
        }
        return list;
    }

    /**
     * Phương thức sắp xếp các ấn phẩm theo năm xuất bản
     * 
     * @param isIncrease true nếu tăng dần, false nếu giảm dần
     */
    public void sortByYear(boolean isIncrease) {
        anPhams.sort(new Comparator<AnPham>() {
            @Override
            public int compare(AnPham o1, AnPham o2) {
                if (isIncrease)
                    return o1.getNamXuatBan() - o2.getNamXuatBan();
                else
                    return o2.getNamXuatBan() - o1.getNamXuatBan();
            }
        });
    }
    /**
     * Thông kê số lượng các ấn phẩm theo năm xuất bản
     * @return thống kê số lượn án phẩm
     */
    public Map<Integer, Integer> statsByYear() {
        Map<Integer, Integer> result = new TreeMap<>();
        for (AnPham anPham : anPhams) {
            int year= anPham.getNamXuatBan();
            if (result.containsKey(year)) {
                result.put(year, result.get(anPham.getNamXuatBan()) + 1);
            } else {
                result.put(year, 1);
            }
        }
        return result;
    }
    

    @Override
    public String toString() {
        return "NhaSach [anPhams=" + anPhams + "]";
    }

    public static void main(String[] args) {
        List<AnPham> phams = new ArrayList<>();
        phams.add(new SachThamKhao("Sach 1", 100, 2021, "Tac gia 1", 100, "Linh vuc 1"));
        phams.add(new SachThamKhao("Sach 2", 200, 2021, "Tac gia 2", 2050, "Linh vuc 2"));
        phams.add(new SachThamKhao("Sach 3", 300, 2021, "Tac gia 3", 3040, "Linh vuc 3"));
        phams.add(new SachThamKhao("Sach 4", 400, 2021, "Tac gia 1", 4090, "Linh vuc 4"));
        phams.add(new TapChi("Tap chi 1", 100, 2011, "Tac gia 1", 1900, "Ten tap chi 1"));
        phams.add(new TapChi("Tap chi 2", 200, 2012, "Tac gia 2", 2090, "Ten tap chi 2"));    
        phams.add(new TapChi("Tap chi 3", 300, 2013, "Tac gia 3", 3010, "Ten tap chi 3"));
        NhaSach nhaSach = new NhaSach(phams);
        System.out.println(nhaSach.type(phams.get(4)));
        System.out.println(nhaSach.isMagazineTenAgo(phams.get(3)));
        System.out.println(nhaSach.isSameTypeAndAuthor(phams.get(0), phams.get(3)));
        System.out.println(nhaSach.sumPrice());
        System.out.println(nhaSach.findMaxChapterBook());
        System.out.println(nhaSach.hasMagazine("Sach 1"));
        // System.out.println(nhaSach.getMagazinesByYear(2021));
        nhaSach.sortByYear(false);
        // System.out.println(nhaSach);
        System.out.println(nhaSach.statsByYear());
    }
    

}
