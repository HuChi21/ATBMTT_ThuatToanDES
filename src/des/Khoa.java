/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des;

/**
 *
 * @author ADMIN
 */
public class Khoa {
    ChuoiNhiPhan KhoaChinhNhiPhan;
    public ChuoiNhiPhan[] DayKhoaPhu;
    public Khoa(String khoa) 
    {
        KhoaChinhNhiPhan = new ChuoiNhiPhan(0);
        for (int i=0; i<khoa.length();  i++)
        {
            KhoaChinhNhiPhan=KhoaChinhNhiPhan.Cong(ChuoiNhiPhan.ChuyenSoSangNhiPhan(ChuoiHexa.ChuyenHexaSangHe10(khoa.charAt(i)), 4));
        }
    }
    public boolean KiemTraKhoa()
    {
        return (KhoaChinhNhiPhan.DoDai() % 64==0);            
    }
    public void SinhKhoaCon()  
        {
            DayKhoaPhu = new ChuoiNhiPhan[16];
            ChuoiNhiPhan C0,D0, MotKhoaPhu;
            // b1: tính PC1
            ChuoiNhiPhan[] ChuoiSauPC1 = CacThongSo.TinhPC1(KhoaChinhNhiPhan);
            // sau khi qua PC1 sẽ có 56bit còn lại được chia thành 2 mảng C0 và D0
            C0 = ChuoiSauPC1[0];
            D0 = ChuoiSauPC1[1];
            // thực hiện 16 vòng để được 16 khóa
            for (int i = 0; i < 16; i++)
            {                
                // dịch trái hai chuỗi nhị phân với số bít bị dịch được quy định trước
                // vòng 1,2,9 là 1 bit
                // còn lại dịch 2 bit
                C0 = C0.DichTraiBit(CacThongSo.soBitDichTaiCacVong[i]);
                D0 = D0.DichTraiBit(CacThongSo.soBitDichTaiCacVong[i]);                
                // Khóa phụ thu được sau khi tính PC2 từ C và D
                MotKhoaPhu = CacThongSo.TinhPC2(C0, D0);       
                // thêm khóa phụ vào mảng khóa phụ
                DayKhoaPhu[i] = MotKhoaPhu;                         
            }// cứ thé 16 vòng ta thu được 16 khóa phụ

        }
    
}
