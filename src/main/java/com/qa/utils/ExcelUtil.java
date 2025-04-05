package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int FindNumberRows(String FilePath, String SheetName) {

		try {

			file = new File(FilePath);
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(SheetName);

		} catch (FileNotFoundException e) {

			System.out.println("File not found or problem with file load.");
			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("Problem with Reading data from excel file.");
			e.printStackTrace();

		}

		return sheet.getLastRowNum();

	}

	public static int FindNumberCols(String FilePath, String SheetName) {

		try {

			file = new File(FilePath);
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(SheetName);

		} catch (FileNotFoundException e) {

			System.out.println("File not found or problem with file load.");
			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("Problem with Reading data from excel file.");
			e.printStackTrace();

		}

		return sheet.getRow(0).getPhysicalNumberOfCells();

	}

	public static String[][] GetSheetData(String FilePath, String SheetName)
			throws InvalidFormatException, IOException {

		String[][] data = null;

		file = new File(FilePath);

		fis = new FileInputStream(file);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet(SheetName);

		int rows = ExcelUtil.FindNumberRows(FilePath, SheetName);

		int cols = ExcelUtil.FindNumberCols(FilePath, SheetName);

		data = new String[rows][cols];

		System.out.println("Number of rows = " + rows + ", number of cols = " + cols);

		for (int i = 1; i <= rows; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.getCell(j);

				switch (cell.getCellType()) {

				case NUMERIC:

					data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
					break;

				case STRING:
					data[i - 1][j] = cell.getStringCellValue();
					break;

				case BOOLEAN:

					data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
					break;

				default:
					System.out.println("Invalid string cell type.....");
					break;
				}

			}
		}

		return data;

	}
}
