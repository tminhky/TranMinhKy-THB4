package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class GiaoDich {
private String MaGD, NgayGD;
private double DonGia;
private float DienTich;
Scanner sc = new Scanner(System.in);
public GiaoDich(){
super();
}
public GiaoDich(String MaGD, String NgayGD,double DonGia, float DienTich){
super();
this.MaGD = MaGD;
this.NgayGD = NgayGD;
this.DonGia = DonGia;
this.DienTich = DienTich;
}
public String getMaGD() {
    return MaGD;
}
public void setMaGD(String maGD) {
    MaGD = maGD;
}
public String getNgayGD() {
    return NgayGD;
}
public void setNgayGD(String ngayGD) {
    NgayGD = ngayGD;
}
public double getDonGia() {
    return DonGia;
}
public void setDonGia(double donGia) {
    DonGia = donGia;
}
public float getDienTich() {
    return DienTich;
}
public void setDienTich(float dienTich) {
    DienTich = dienTich;
}

public void nhap(){
System.out.println("NHAP MA GIAO DICH: ");
MaGD = sc.nextLine();
System.out.println("NHAP NGAY GIAO DICH (ngay/thang/nam): ");
NgayGD = sc.nextLine();
System.out.println("NHAP DON GIA: ");
DonGia = sc.nextDouble();
System.out.println("NHAP DIEN TICH: ");
DienTich = sc.nextFloat();
}
@Override
    public String toString() {
        return "Ma giao dich: " + this.MaGD + ", ngay giao dich: " + this.NgayGD + 
            ", don gia: " + this.DonGia + ", dien tich: " + this.DienTich;
    }
}
class GiaoDichDat extends GiaoDich{
    private String LoaiDat;
    public GiaoDichDat(){
    super();
    }
    public GiaoDichDat(String LoaiDat){
    this.LoaiDat = LoaiDat;
    
    }
    public String getLoaiDat() {
        return LoaiDat;
    }
    public void setLoaiDat(String loaiDat) {
        LoaiDat = loaiDat;
    }
    public void nhap(){
    super.nhap();
    System.out.println("Nhap loai dat A/B/C: ");
    LoaiDat = sc.nextLine();
    }
    @Override
    public String toString() {
        return super.toString() + ", loai dat: " + this.LoaiDat;
    }
    }
class GiaoDichNha extends GiaoDich{
        private String loaiNha, diaChi;
        private int chon;
        public GiaoDichNha(){
        super();
        }
        public GiaoDichNha(String loaiNha, String diaChi){
        super();
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
        }
        public String getLoaiNha() {
            return loaiNha;
        }
        public void setLoaiNha(String loaiNha) {
            loaiNha = loaiNha;
        }
        public String getDiaChi() {
            return diaChi;
        }
        public void setDiaChi(String diaChi) {
            diaChi = diaChi;
        }
        
        public void nhap(){
        super.nhap();
        System.out.println("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.println("Nhap loai nha (0: cao cap, 1: thuong: )");
        chon = sc.nextInt();
        switch(chon){
        case 0:
        loaiNha = "cao cap";
        break;
        case 1:
        loaiNha = "thuong";
        break;
        default:
        System.out.println("Khong hop le");
        break;
        }
        }
        @Override
        public String toString() {
            return super.toString() + ", loai nha: " + this.loaiNha + ", dia chi: " + this.diaChi;
        }
        
        }
class Main {
 
            public static void main(String[] args) {
                ArrayList<GiaoDichNha> arrGiaoDichNha = new ArrayList<>();
                ArrayList<GiaoDichDat> arrGiaoDichDat = new ArrayList<>();
                int soGiaoDichDat = 0, soGiaoDichNha = 0;
                long tongTienGiaoDichDat = 0, trungBinhThanhTien = 0;
                Scanner scanner = new Scanner(System.in);
                 
                System.out.print("NHAP SO GIAO DICH DAT: ");
                soGiaoDichDat = scanner.nextInt();
                System.out.print("NHAP SO GIAO DICH NHA: ");
                soGiaoDichNha = scanner.nextInt();
                 
                System.out.println("NHAP THONG TIN GIAO DICH DAT:");
                for (int i = 0; i < soGiaoDichDat; i++) {
                    System.out.println("NHAP THONG TIN GIAO DICH DAT THU " + (i + 1) + ":");
                    GiaoDichDat giaoDichDat = new GiaoDichDat();
                    giaoDichDat.nhap();
                    arrGiaoDichDat.add(giaoDichDat);
                }
                 
                System.out.println("NHAP THONG TIN GIAO DICH NHA:");
                for (int i = 0; i < soGiaoDichNha; i++) {
                    System.out.println("NHAP THONG TIN GIAO DICH NHA THU " + (i + 1) + ":");
                    GiaoDichNha giaoDichNha = new GiaoDichNha();
                    giaoDichNha.nhap();
                    arrGiaoDichNha.add(giaoDichNha);
                }
                 
                System.out.println("---THONG TIN CAC GIAO DICH DAT---");
                for (int i = 0; i < arrGiaoDichNha.size(); i++) {
                    System.out.println(arrGiaoDichDat.get(i).toString());
                }
                 
                System.out.println("---THONG TIN CAC GIAO DICH NHA---");
                for (int i = 0; i < arrGiaoDichNha.size(); i++) {
                    System.out.println(arrGiaoDichNha.get(i).toString());
                }
                 
                for (int i = 0; i < arrGiaoDichDat.size(); i++) {
                    if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("A")) {
                        tongTienGiaoDichDat += arrGiaoDichDat.get(i).getDienTich() * 
                            arrGiaoDichDat.get(i).getDonGia() * 1.5;
                    } else if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("B") || 
                            arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("C")) {
                        tongTienGiaoDichDat += arrGiaoDichDat.get(i).getDienTich() * 
                            arrGiaoDichDat.get(i).getDonGia();
                    }
                }
                trungBinhThanhTien = tongTienGiaoDichDat / (arrGiaoDichDat.size());
                System.out.println("TRUNG BINH THANH TIEN CUA GIAO DICH DAT = " + trungBinhThanhTien);
                 
            
                System.out.println("CAC GIAO DICH DAT CUA THANG 9/2013: ");
                for (int i = 0; i < arrGiaoDichDat.size(); i++) {
                    String[] dateGiaoDichDat = arrGiaoDichDat.get(i).getNgayGD().split("/");
                    if (dateGiaoDichDat[1].equals("9") && dateGiaoDichDat[2].equals("2013")) {
                        System.out.println(arrGiaoDichDat.get(i).toString());
                    }
                }
                 
                System.out.println("CAC GIAO DICH NHA CUA THANG 9/2013: ");
                for (int i = 0; i < arrGiaoDichNha.size(); i++) {
                    String[] dateGiaoDichNha = arrGiaoDichNha.get(i).getNgayGD().split("/");
                    if (dateGiaoDichNha[1].equals("9") && dateGiaoDichNha[2].equals("2013")) {
                        System.out.println(arrGiaoDichNha.get(i).toString());
                    }
                }
            }
         
        }
