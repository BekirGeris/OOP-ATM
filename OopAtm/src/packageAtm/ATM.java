package packageAtm;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		Account[] hesap = new Account[10];
		for (int i = 0; i < 10; i++) {
			hesap[i] = new Account(i, 100, 4.5);
		}

		Scanner input = new Scanner(System.in);

		int key = -1;
		int id = -1;
		while (id < Integer.MAX_VALUE) {
			switch (key) {
			case -1:
				System.out.println("Bir ID giriniz...");

				do {
					id = input.nextInt();
				} while (idKontrol(hesap, id) == false);
				
				key = 0;
				break;

			case 0:
				System.out.println("Main menu");
				System.out.println("1: Check balance");
				System.out.println("2: withdraw");
				System.out.println("3: deposite");
				System.out.println("4:exit");
				System.out.print("Enter a choice: ");
				key = input.nextInt();
				break;

			case 1:
				System.out.println("The balance is " + hesap[id].getBalance());
				key = 5;
				break;

			case 2:
				System.out.println("Enter a amount to withdraw: ");
				hesap[id].paraCekme(input.nextDouble());
				System.out.println("Hesap Bakiyesi: " + hesap[id].getBalance());
				key = 5;
				break;

			case 3:
				System.out.println("Enter a amount to deposite: ");
				hesap[id].paraYatir(input.nextDouble());
				System.out.println("Hesap Bakiyesi: " + hesap[id].getBalance());
				key = 5;
				break;

			case 4:
				key = -1;
				break;

			case 5:
				System.out.println("Geri gitmek için 0 giriniz..");
				if (input.nextDouble() == 0) {
					key = 0;
				}
				break;

			default:
				System.out.println("Hata 1-4 arasinda bir deger giriniz");
				key = 0;
				break;
			}
		}
		
		input.close();
	}

	private static boolean idKontrol(Account[] hesap, int id) {
		
		boolean temp = false;
		for (int i = 0; i < 10; i++) {
			if (id == hesap[i].getId()) {
				temp = true;
			}
		}
		
		if (temp == false) {
			System.out.println("Yanlis ID girdiniz...\nTekrar ID giriniz...");
		} 
		
		return temp;
	}
}
