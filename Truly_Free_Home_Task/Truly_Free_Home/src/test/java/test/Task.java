package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import page_Actions.sign_In_Actions;
import utility_File.Base_Class;

public class Task extends Base_Class {


	@Test(priority = 1)
	private void Log_in_As_ExistingUser_To_Checkout() throws AWTException {
		sign_In_Actions.TC_02();
	}
	
}
