import java.util.Vector;
abstract class Sekil {
public abstract double alanHesapla();
}
class Nokta extends Sekil {
    public static double PI = 3.14;
    private int yaricap;

    public Nokta(){
        yaricap=0;
    }

    public int getYaricap() {
        return yaricap;
    }

    public void setYaricap(int yaricap) {
        this.yaricap = yaricap;
    }

    @Override
    public double alanHesapla() {
        return -1;
    }
}
class Yamuk extends Sekil{
    private int yukseklik;
    private int altTaban;
    private int ustTaban;

    public int getYukseklik() {
        return yukseklik;
    }

    public int getAltTaban() {
        return altTaban;
    }

    public int getUstTaban() {
        return ustTaban;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }

    public void setAltTaban(int altTaban) {
        this.altTaban = altTaban;
    }

    public void setUstTaban(int ustTaban) {
        this.ustTaban = ustTaban;
    }

    public Yamuk(){
        yukseklik =1;
        altTaban =2;
        ustTaban =1;
    }
    public Yamuk(int yukseklik,int altTaban, int ustTaban){
        this.ustTaban = ustTaban;
        this.yukseklik = yukseklik;
        this.altTaban =altTaban;
    }

    @Override
    public double alanHesapla() {
        return (getAltTaban()+getUstTaban())*getYukseklik()/2;
    }
}
class Cember extends Nokta{
    public Cember(){
        super();
    }
    public Cember(int yaricap){
        setYaricap(yaricap);
    }
    @Override
    public double alanHesapla() {
        return -1.00;
    }
}
class Daire extends Nokta{
    public Daire(){
        setYaricap(1);
    }
    public Daire(int yaricap){
        setYaricap(yaricap);
    }
    @Override
    public double alanHesapla() {
        return Nokta.PI*getYaricap()*getYaricap();
    }

}
class Dogru extends Nokta{
    @Override
    public double alanHesapla() {
        return -1.00;
    }
}
class Silindir extends Daire{
    private int yukseklik;

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }
    public Silindir(){
        super();
        yukseklik = 1;
    }
    public Silindir(int yukseklik,int yaricap){
        super(yaricap);
        this.yukseklik = yukseklik;
    }
    public double cevreHesapla(){
        return Nokta.PI*2*getYaricap();
    }

    @Override
    public double alanHesapla() {
        return super.alanHesapla()*2+cevreHesapla()*getYukseklik();
    }
}
class Kare extends Yamuk{
    public Kare(){
        setYukseklik(1);
        setAltTaban(1);
        setUstTaban(1);
    }
    public Kare(int uzunluk){
        setUstTaban(uzunluk);
        setAltTaban(uzunluk);
        setYukseklik(uzunluk);
    }
    public double cevreHesapla(){
        return getAltTaban()*4;
    }

    @Override
    public double alanHesapla() {
        return super.alanHesapla();
    }
}
class Kup extends Kare{
    public Kup(){
        super();
    }
    public Kup(int uzunluk){
        super(uzunluk);
    }
    @Override
    public double alanHesapla() {
        return super.alanHesapla()*6;
    }
}
class Piramit extends Kare{
    public Piramit(){
        super();
    }
    public Piramit(int yukseklik,int altUzunluk){
        super(altUzunluk);
        setYukseklik(yukseklik);
    }
    @Override
    public double alanHesapla() {
        return super.alanHesapla()+cevreHesapla()*getYukseklik()/2;
    }
}

public class Main {
    public static void main(String[] args) {
        //Vektore nesneleri giris sirasina gore string dizisi olusturdum.
        String [] sekilIsimleri = {"Çember","Daire","Nokta","Doğru","Kare","Yamuk","Piramit","Küp","Silindir"};
        Vector sekil = new Vector(9);

        Nokta nokta = new Nokta();
        Yamuk yamuk = new Yamuk(3,10,6);
        Kare kare = new Kare(5);
        Dogru dogru = new Dogru();
        Daire daire = new Daire(3);
        Cember cember = new Cember(2);
        Silindir silindir = new Silindir(2,2);
        Piramit piramit = new Piramit(2,2);
        Kup kup = new Kup(1);
        //sekil vektorune nesnelerin alan degerlerini attim. (Odevdeki siralama. Ama dogru yok)
        sekil.add(0,cember.alanHesapla());
        sekil.add(1,daire.alanHesapla());
        sekil.add(2,nokta.alanHesapla());
        sekil.add(3,dogru.alanHesapla());
        sekil.add(4,kare.alanHesapla());
        sekil.add(5,yamuk.alanHesapla());
        sekil.add(6,piramit.alanHesapla());
        sekil.add(7,kup.alanHesapla());
        sekil.add(8,silindir.alanHesapla());
        System.out.println("\nAlanlar Listesi : \n");
        //Dongu ile birlikte alan degerlerini ve hangi sekile ait oldugunu ekrana yazdırdım.
        for(int i=0; i < sekil.size(); i++) {
        if(sekil.get(i).equals(-1.00)){
            System.out.println(sekilIsimleri[i]+" Şeklinin Alanı Yoktur.");
        }
        else {
            System.out.print(sekilIsimleri[i]+" Alanı : ");
            System.out.printf("%.2f",sekil.get(i));
            System.out.println();
        }
        }
    }
}
