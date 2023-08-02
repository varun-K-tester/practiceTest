package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

		String subTotal1 = WebUI.getText(findTestObject('Object Repository/testts/Page_Caseys/span_126.30'))
		println subTotal1
		String subTotal2 = subTotal1.substring(0, subTotal1.lastIndexOf("."))
		//		for(int i = 1;i < subTotal1.size() ;i++) {
		//			if (subTotal1[i].equals('.')) {
		//				break;
		//			}
		//			else {
		//				int n=0
		//				subTotal2[n] = subTotal1[i]
		//				n++
		//			}
		//		}
		println subTotal2
		int subTotal= subTotal2.toInteger()
		if(subTotal >10) {
			WebUI.sendKeys(findTestObject('Object Repository/HandsOn/placeOrder/cvv'), '123')
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