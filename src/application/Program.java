package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numProducts = sc.nextInt();
		
		
		for (int i = 0; i < numProducts; i++) {
			System.out.println();
			System.out.println("Product #" + (i+1) + " data: ");
			
			System.out.print("Common, used or importaded (c|u|i)? ");
			sc.nextLine();
			char option = sc.nextLine().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			Product product = new Product();
			
			if(option == 'c') {
				product = new Product(name, price);
			}
			else if(option == 'u') {
				System.out.print("Manufactured date (DD/MM/YYYY): ");
				Date manufacturedDate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufacturedDate);
			}
			else {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsFee);
			}
			
			productList.add(product);
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product obj : productList) {
			System.out.println(obj.priceTag());
		}
		
		sc.close();
	}
}
