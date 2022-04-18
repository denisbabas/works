package stepDefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIConstants;
import utils.CommonMethods;
import utils.ExcelUtility;

public class API extends CommonMethods{
	int statusCode;
	@Given("Using an application, implement a call that returns is a {int}")
	public void using_an_application_implement_a_call_that_returns_is_a(int statusCode1) {
		Response response = RestAssured.get(APIConstants.GetStatusCode404);
		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, statusCode1 );
		}
	
	double num;
	Response response;
	@When("Using an application, read all the data from the .csv file and get parameters and have a return code {int}")
	public void using_an_application_read_all_the_data_from_the_csv_file_and_get_parameters_and_have_a_return_code(int code) {
	    
		ExcelUtility.openExcel("/Users/denysbabasiuk/eclipse-workspace/ShipWorks/src/test/resources/testData/Test.xlsx");
		ExcelUtility.getSheet("Test");	
		
		for (int i = 1; i < ExcelUtility.getRowsCount(); i++) {
			num = ExcelUtility.getCellDataDouble(i, 0);
			int value = (int)num;
			response = RestAssured.get(APIConstants.AllUsers + "?id=" + value);
			System.out.println(response.asString());
		}
	statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, code );
	
	}
	
	@Then("check if there are any users that have email starting with {string} then get their company name and write it to a file and assert response code {int}")
	public void check_if_there_are_any_users_that_have_email_starting_with_then_get_their_company_name_and_write_it_to_a_file_and_assert_response_code(String word, int code) throws IOException {
	    
		
		ExcelUtility.openExcel("/Users/denysbabasiuk/eclipse-workspace/ShipWorks/src/test/resources/testData/Test.xlsx");
		ExcelUtility.getSheet("Test");	
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Company Name");
		XSSFRow row;
		for (int i = 1; i < ExcelUtility.getRowsCount(); i++) {
			num = ExcelUtility.getCellDataDouble(i, 0);
			int value = (int)num;
			response = RestAssured.get(APIConstants.AllUsers + "?id=" + value);
			
		List<Map<String, String>> Emails = response.body().jsonPath().get("email");
		
		if(response.body().jsonPath().get("email").toString().startsWith("[" + word)){
		
			Map<String, String> companyName = response.jsonPath().getMap("company[0]");
			System.out.println(companyName.get("name"));
			
		
			Map<String, Object[]> companyNames= new TreeMap<String, Object[]>();
			
			companyNames.put(
	                 "Company: ",
	                 new Object[] {companyName.get("name")});
			
		
			Set<String> keyid = companyNames.keySet();
			 for (String key : keyid) {
				
		            row = spreadsheet.createRow(i);
		          
		            Object[] objectArr =companyNames.get(key);
		            int cellid = 0;
		           
		            for (Object obj : objectArr) {
		                Cell cell = row.createCell(cellid++);
		                cell.setCellValue((String)obj);
		                }
		              }
				}}    
		      FileOutputStream out = new FileOutputStream(
				            new File("/Users/denysbabasiuk/eclipse-workspace/ShipWorks/src/test/resources/testData/CompanyName.xlsx"));
				  
				        workbook.write(out);
				        out.close();
				        statusCode = response.getStatusCode();
				      Assert.assertEquals(statusCode, code );
		}
		
	}
	
		
		
		
		



		
	