package com.brodosTest.fileoperation.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.brodosTest.fileoperation.entity.Product;
import com.opencsv.CSVReader;

public class CSVHelper {

	final static String SEPARATER = ";";
	final static String SOURCE_DIRECTORY = "D:\\Temp\\inputFiles\\Product.csv";

	public static List<Product> csvToProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		try {
			System.out.println("CHecking directory");
			CSVReader reader = new CSVReader(new FileReader(SOURCE_DIRECTORY));

			String[] data = null;
			int count = 0;
			List<String[]> list = new ArrayList<String[]>();
			while ((data = reader.readNext()) != null) {
				if (count != 0) {
					list.add(data);
				}
				count++;
			}

			for (String[] strings : list) {
				for (String s : strings) {
					String sarr[] = s.split(SEPARATER);
					String articleNumber = sarr[0];
					String name = sarr[1];
					double price = Double.valueOf(sarr[2]);
					int stock = Integer.valueOf(sarr[3]);
					String description = sarr[4];

					Product p = Product.build(0, articleNumber, name, price, stock, description);
					products.add(p);

				}
			}
			reader.close();

			archiveFile();
		} catch (FileNotFoundException e) {
			return null;
		}

		return products;
	}

	static boolean archiveFile() {

		Long datetime = System.currentTimeMillis();

		String dest = "D:\\Temp\\inputFiles\\archive\\Product" + datetime + ".csv";

		File fileToMove = new File(SOURCE_DIRECTORY);

		return fileToMove.renameTo(new File(dest));
	}

}
