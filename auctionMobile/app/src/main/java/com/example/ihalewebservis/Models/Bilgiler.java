package com.example.ihalewebservis.Models;

public class Bilgiler{
	private float baslangicFiyati;
	private String ihaleAdi;
	private String urunAdi;
	private boolean aktifMi;


	public void setBaslangicFiyati(float baslangicFiyati){
		this.baslangicFiyati = baslangicFiyati;
	}

	public float getBaslangicFiyati(){
		return baslangicFiyati;
	}

	public void setIhaleAdi(String ihaleAdi){
		this.ihaleAdi = ihaleAdi;
	}

	public String getIhaleAdi(){
		return ihaleAdi;
	}

	public void setUrunAdi(String urunAdi){
		this.urunAdi = urunAdi;
	}

	public String getUrunAdi(){
		return urunAdi;
	}

	public void setAktifMi(boolean aktifMi){
		this.aktifMi = aktifMi;
	}

	public boolean isAktifMi(){
		return aktifMi;
	}


	@Override
 	public String toString(){
		return 
			"Bilgiler{" + 
			"baslangicFiyati = '" + baslangicFiyati + '\'' + 
			",ihaleAdi = '" + ihaleAdi + '\'' +
			",urunAdi = '" + urunAdi + '\'' + 
			",aktifMi = '" + aktifMi + '\'' +
			"}";
		}
}
