package handsOn
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable



import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable


class placeOrder {

	@Given("User has selected the products")
	def verifyUserSelectedProducts() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'), 5)
	}

	@When("User navigates to cart page")
	def CartPage() {
		WebUI.waitForElementClickable(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'), 5)
		WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Review Checkout BTN'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Checkout BTN'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Your Order text cart page'), 5)
	}
	@And("User clicks on checkout")
	def checkoutpage() {
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/placeOrder/Checkout BTN'))
		WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Checkout BTN'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Select Payment text checkout page'), 5)
	}

	@Then("Users places order")
	def placeorder() {
		WebUI.waitForPageLoad(10)
		String subTotal1 = WebUI.getText(findTestOject('Object Repository/HandsOn/placeOrder/subtotal'))
		int subTotal = subTotal1.toInteger()
		println subTotal1
		println subTotal
		if(subTotal >10) {
			WebUI.sendKeys(findTestObject('Object Repository/HandsOn/placeOrder/cvv'), 123)
			WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Place pickup order BTN'))
		}
		else {
			WebUI.click(findTestObject('Object Repository/HandsOn/placeOrder/Place pickup order BTN'))
		}
	}
	@Then("Get order details")
	def getDetails() {
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Your Order Has been submitted Text'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/Order summary text page'), 5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/placeOrder/img'), 5)
		GlobalVariable.order_Number = WebUI.getText(findTestObject('Object Repository/HandsOn/placeOrder/orderNumber'))
		println(GlobalVariable.order_Number)
	}
}