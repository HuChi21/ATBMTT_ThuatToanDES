/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des;

/**
 *
 * @author ADMIN
 */
public class ChuoiHexa {
     public String Chuoi ;
     private int _doDai; 
     public ChuoiNhiPhan chuoiNhiPhan ;
     public static final String BoHexa = "0123456789ABCDEFabcdef";
     public int DoDai(){
          return Chuoi.length();
     }
      public Boolean KiemTra()
        {
            int k =-1;
            for (int i=0; i<Chuoi.length(); i++)
            {
               
                if (!ChuoiHexa.BoHexa.contains(String.valueOf(Chuoi.charAt(i)))) 
                {
                    k++;
                    
                }
            }
            if(k==-1){
                return true;
            }
            else
                return false;
        }
      public static int ChuyenHexaSangHe10(char K)
        {

            int KQ = 0;
            switch (K)
            {
                case '0':
                    KQ = 0;
                    break;
                case '1':
                    KQ = 1;
                    break;
                case '2':
                    KQ = 2;
                    break;
                case '3':
                    KQ = 3;
                    break;
                case '4':
                    KQ = 4;
                    break;
                case '5':
                    KQ = 5;
                    break;
                case '6':
                    KQ = 6;
                    break;
                case '7':
                    KQ = 7;
                    break;
                case '8':
                    KQ = 8;
                    break;
                case '9':
                    KQ = 9;
                    break;
                case 'A':
                    KQ = 10;
                    break;
                case 'B':
                    KQ = 11;
                    break;
                case 'C':
                    KQ = 12;
                    break;
                case 'D':
                    KQ = 13;
                    break;
                case 'E':
                    KQ = 14;
                    break;
                case 'F':
                    KQ = 15;
                    break;
            }
            return KQ;
        }
     public ChuoiHexa(String chuoi)
        {
            this.Chuoi = chuoi.toUpperCase(); // đưa về chữ hoa hết cho dễ đọc
            ChuoiNhiPhan chNP;//   
            if (KiemTra())// kiểm tra xem chuỗi này có hợp lệ k
            {
                chuoiNhiPhan = new ChuoiNhiPhan(0);
                for (int i=0; i<Chuoi.length(); i++)// chuyển sang cơ số 2
                {
                    
                    chNP= ChuoiNhiPhan.ChuyenSoSangNhiPhan(ChuoiHexa.ChuyenHexaSangHe10(Chuoi.charAt(i)),4); // chuyển từng ký tự 1 về dạng 4bit cơ số 2
                    chuoiNhiPhan = chuoiNhiPhan.Cong(chNP);
                }
            }
        }
}
