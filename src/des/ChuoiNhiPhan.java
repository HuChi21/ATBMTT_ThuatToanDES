/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package des;

/**
 *
 * @author ADMIN
 */
public class ChuoiNhiPhan {
     public int[] MangNhiPhan;
     private double _doDai;
     String _text = "";
     public  int DoDai(){
         return MangNhiPhan.length;
     }
     
     public ChuoiNhiPhan(int doDai){
         this.MangNhiPhan= new int[doDai];
        
     }
     
     public  ChuoiNhiPhan(int[] mangNhiPhan){
         this.MangNhiPhan=mangNhiPhan;
     }
     public ChuoiNhiPhan(char kyTu){
         MangNhiPhan= new int[16];
         int MaUniCode =(int)kyTu;
         int i=15;
         while (MaUniCode > 0) {
             MangNhiPhan[i]=MaUniCode%2;
             MaUniCode=MaUniCode/2;
             i--;
         }
     }
     public String GetTex(){
         String str="";
         for(int i=0; i<MangNhiPhan.length; i++){
             str+= String.valueOf(MangNhiPhan[i]);
         }
         return str;
     }
     
     
     
     public ChuoiNhiPhan Cat(int viTriBatDau, int SoLuong){
        int[] mangNhiPhanDuocCat = new int[SoLuong];
        for (int i = viTriBatDau; i < viTriBatDau + SoLuong;i++ ){
            mangNhiPhanDuocCat[i-viTriBatDau]=MangNhiPhan[i];
        }
        return (new ChuoiNhiPhan(mangNhiPhanDuocCat));
     }
     public ChuoiNhiPhan Cong(ChuoiNhiPhan chuoi2){
         ChuoiNhiPhan ChuoiKQ = new ChuoiNhiPhan(chuoi2.DoDai() + this.DoDai());
         for (int i = 0; i < DoDai(); i++){
             ChuoiKQ.MangNhiPhan[i] = MangNhiPhan[i];
         }
         for (int i = 0; i < chuoi2.DoDai(); i++){
             ChuoiKQ.MangNhiPhan[DoDai() + i] = chuoi2.MangNhiPhan[i];
         }
         return ChuoiKQ;
     }
     public static ChuoiNhiPhan ChuyenSoSangNhiPhan(int SoInput, int doDai){
         ChuoiNhiPhan ChuoiKQ = new ChuoiNhiPhan(doDai);
         int i = doDai - 1;
         while (SoInput > 0){
               ChuoiKQ.MangNhiPhan[i] = SoInput % 2;
               SoInput = SoInput / 2;
               i--;
         }
         return ChuoiKQ;
     }
     public static int[] ChuyenSoSangMangNhiPhan(int SoInput, int doDai){
          int[] MangNhiPhan = new int[doDai];
          int i = doDai - 1;
          while (SoInput > 0)
          {
              MangNhiPhan[i] = SoInput % 2;
              SoInput = SoInput / 2;
              i--;
          }
          return MangNhiPhan;
     }
     public ChuoiNhiPhan ChinhDoDai64(){
        int Mod = DoDai() % 64;
        int thieu = 64 - Mod;
        ChuoiNhiPhan chuoiBuThieu = new ChuoiNhiPhan(thieu);
        ChuoiNhiPhan KQ = new ChuoiNhiPhan(MangNhiPhan);
        KQ = KQ.Cong(chuoiBuThieu);
        ChuoiNhiPhan ChuoiChieuDai = ChuoiNhiPhan.ChuyenSoSangNhiPhan((int)DoDai(), 64);
        KQ = KQ.Cong(ChuoiChieuDai);
        return KQ;
     }
     public static int ChuyenNhiPhanSangSo(ChuoiNhiPhan ChuoiVao){
         int KQ = 0;
         for (int i = ChuoiVao.DoDai() - 1; i >= 0; i--)
         {
            KQ += ChuoiVao.MangNhiPhan[i]* (int)Math.pow(2, ChuoiVao.DoDai()- i-1);
         }
         return KQ;
     }
     public ChuoiNhiPhan CatDuLieu64(){
         ChuoiNhiPhan ChuoiChieuDai=this.Cat(DoDai()-64,64);// lấy 64 bit cuối
         int d = ChuoiNhiPhan.ChuyenNhiPhanSangSo(ChuoiChieuDai);
         ChuoiNhiPhan KQ = this.Cat(0, DoDai() - 64); // chỉ lấy số bit tương ứng vs chiefu dài
         if (d < 0 || d > KQ.DoDai())
            return null;
         KQ = KQ.Cat(0, d);
         return KQ;
     }
     
     public ChuoiNhiPhan XOR(ChuoiNhiPhan Chuoi2){
          if(DoDai()!=Chuoi2.DoDai())
                return null;
          ChuoiNhiPhan ChuoiKQ = new ChuoiNhiPhan(DoDai());
          int x = 0,y=0;
          for (int i = 0; i < ChuoiKQ.DoDai(); i++){
              x = MangNhiPhan[i];
              y = Chuoi2.MangNhiPhan[i];
              if (x !=y){
                  ChuoiKQ.MangNhiPhan[i] = 1;
              }
              else{
                  ChuoiKQ.MangNhiPhan[i] = 0;
              }
          }
          return ChuoiKQ;
     }
     
     public ChuoiNhiPhan DichTraiBit(int SoBitDich){
         ChuoiNhiPhan KQ = new ChuoiNhiPhan(MangNhiPhan);
         int tam = 0;
         for (int i = 0; i < SoBitDich; i++){
             tam = MangNhiPhan[0];
             for (int j = 0; j < MangNhiPhan.length - 1; j++){
                 KQ.MangNhiPhan[j] = MangNhiPhan[j + 1];
             }
             KQ.MangNhiPhan[MangNhiPhan.length - 1] = tam;
         } 
         return (KQ);
     }
     public ChuoiNhiPhan[] ChiaDoi( ){
         ChuoiNhiPhan ChuoiTrai = new ChuoiNhiPhan(this.DoDai()/2);
         ChuoiNhiPhan ChuoiPhai = new ChuoiNhiPhan(DoDai()- ChuoiTrai.DoDai());
          for (int i = 0; i < ChuoiTrai.DoDai(); i++){
              ChuoiTrai.MangNhiPhan[i] = MangNhiPhan[i];
          }
          for (int i = 0; i < ChuoiPhai.DoDai(); i++){
              ChuoiPhai.MangNhiPhan[i] = MangNhiPhan[i+ChuoiTrai.DoDai()];
          }
          return (new ChuoiNhiPhan[]{ChuoiTrai,ChuoiPhai});
     }
     public ChuoiNhiPhan[] Chia(int SoLuong){
         ChuoiNhiPhan[] KQ = new ChuoiNhiPhan[SoLuong];
         ChuoiNhiPhan chuoi;
         int SoBit= DoDai()/SoLuong; 
         int[]  NhiPhan = new int[SoBit] ;
         int leng= SoBit;
         for (int i = 0; i < SoLuong ; i++){
             if (i * SoBit + SoBit > DoDai()){
                 SoBit = DoDai() - i * SoBit;
             }
             NhiPhan = new int[SoBit];
             for (int j = i * SoBit; j < i * SoBit + SoBit; j++){
                 NhiPhan[j - i * SoBit] = MangNhiPhan[j];
             }
             chuoi = new ChuoiNhiPhan(NhiPhan);
             KQ[i] = chuoi;
         }
         return (KQ);
     }
     public static String ChuyenSoSangStringNhiPhan(int SoInput, int doDai){
         return ChuyenSoSangNhiPhan(SoInput,doDai).GetTex();
     }
     public static ChuoiNhiPhan ChuyenChuSangChuoiNhiPhan(String ChuoiVao){
          try{
              ChuoiVao = ChuoiVao.trim();
              int[] mangNhiPhan = new int[ChuoiVao.length()];
              for (int i = ChuoiVao.length() - 1; i >= 0; i--){
                  mangNhiPhan[i] = Character.getNumericValue(ChuoiVao.charAt(i));
              }
              return (new ChuoiNhiPhan(mangNhiPhan));
          }catch(Exception e){
              return null;
          }
      }
     public static int ChuyenMangSangByte(int[] mang, int batDau, int KetThuc){
          int KQ = 0;
          for (int i = KetThuc - 1; i >= batDau; i--){
                KQ += mang[i] * (int)Math.pow(2, KetThuc - i - 1);
          }
          return KQ;
     }
     public static int ChuyenNhiPhanSangSo(String ChuoiVao)
    {
        int KQ = 0;
        for (int i = ChuoiVao.length() - 1; i >= 0; i--){
            KQ +=Character.getNumericValue(ChuoiVao.charAt(i)) * (int)Math.pow(2, ChuoiVao.length() - i - 1);
        }
        return KQ;
    }
    public static String ChuyenNhiPhanSangChu(ChuoiNhiPhan ChuoiVao)
    {
 
            int soChu = ChuoiVao.DoDai() / 16;
            ChuoiNhiPhan[] MangChuoi = ChuoiVao.Chia(soChu);
            String KQ = "";
            for (var ch : MangChuoi)
            {
                KQ += (char) ChuyenNhiPhanSangSo(ch);
            }
            return KQ;
 
    }  
    public static ChuoiNhiPhan ChuyenChuSangNhiPhan(String text)
     {
            ChuoiNhiPhan KQ = new ChuoiNhiPhan(0);
            ChuoiNhiPhan chuoi;
            for(int i=0 ; i<text.length();i++)
            {
                chuoi = new ChuoiNhiPhan(text.charAt(i));
                KQ = KQ.Cong(chuoi);
            }
            return KQ;
     }
    public static ChuoiNhiPhan ChuyenKhoaSangNhiPhan(String text)
        {
            ChuoiNhiPhan KQ = new ChuoiNhiPhan(0);
            ChuoiNhiPhan chuoi;
            for(int i=0 ; i<text.length();i++)
            {
                int x=Character.getNumericValue(text.charAt(i));
                chuoi = ChuoiNhiPhan.ChuyenSoSangNhiPhan(x,16);
                KQ = KQ.Cong(chuoi);
            }
            return KQ;

        }
   
}
