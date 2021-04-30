package packageAtm;

import java.util.Date;

public class Account {

	private int id;
	private double balance;
	private double guncelFaizOrani;
	private Date hesabinOlusturulmaTarihi;

	public Account() {
		this(0, 0, 0);
	}

	public Account(int id, double balance, double guncelFaizOrani) {
		this.id = id;
		this.balance = balance;
		this.guncelFaizOrani = guncelFaizOrani;
		hesabinOlusturulmaTarihi = new Date();
	}

	public String toString() {
		return " ClassName: Account id: " + id + " balance: "
				+ balance + " Aylik Faiz Miktarý: "
				+ getAylikGuncelFaizMiktari() + " Hesap Olusturlma Tarihi: "
				+ getHesabinOlusturulmaTarihi();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getGuncelFaizOrani() {
		return guncelFaizOrani;
	}

	public void setGuncelFaizOrani(double guncelFaizOrani) {
		this.guncelFaizOrani = guncelFaizOrani;
	}

	public double getAylikGuncelFaizMiktari() {
		return balance * guncelFaizOrani / 1200;
	}

	public String getHesabinOlusturulmaTarihi() {
		return hesabinOlusturulmaTarihi.toString();
	}

	public void paraCekme(double cek) {
		if (cek <= balance) {
			balance -= cek;
		} else {
			System.out.println("Hesapta yeterli para yok");
		}
	}

	public void paraYatir(double yatir) {
		balance += yatir;
	}
}
