	package handsOn
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class addToCart {

	@Given("User is on PDP")
	def verifyUserIsOnPDP() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/startOrder'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/order_quantity'), 5)
	}

	@When("User selects (.*) (.*)")
	def locationSelection(String location, date) {
		if((WebUI.verifyElementNotPresent(findTestObject('Object Repository/HandsOn/addtocart/selectedOccasion'),10, FailureHandling.OPTIONAL) == false && WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/addtocart/Pickup_occasion'),10, FailureHandling.OPTIONAL) == false)){
			WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/addtocart/Add to Order'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/Pickup_occasion'))
			//WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location)
			String location1 = findTestData('Data Files/StoreAddress').getValue(2,3)
			WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'),location1)
			
			WebUI.sendKeys(findTestObject('Object Repository/HandsOn/addtocart/Address_TextBar'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

			switch(date) {
				case('asap'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '0')

					break;
				case('later_today'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '1')
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/Time'), '2')

					break;
				case('tomorrow'):
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/date'), '2')
					WebUI.selectOptionByIndex(findTestObject('Object Repository/HandsOn/addtocart/Time'), '8')
					break;
			}
			WebUI.click(findTestObject('Object Repository/HandsOn/addtocart/button_Start Order'))
		}
	}

	@And("Add to cart button is enabled (.*)")
	def Addtocartbuttonisenabled(String quantity) {
		println("Add to cart button is enabled")
		WebUI.selectOptionByValue(findTestObject('Object Repository/HandsOn/addtocart/order_quantity'), quantity, true)
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/addtocart/Add to Order'))
	}

	@Then("User clicks on add to cart button")
	def Userclicksonaddtocartbutton() {
		println("User clicks on add to cart button")
		WebUI.doubleClick(findTestObject('Object Repository/HandsOn/addtocart/Add to Order'))
	}
}