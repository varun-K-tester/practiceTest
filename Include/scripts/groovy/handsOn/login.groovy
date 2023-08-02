package handsOn
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class login {
	@Given("User is on login page")
	def loginPage() {
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/Login/Sign in'))
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/Sign in'))
		WebUI.waitForPageLoad(10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/Sign in Header'),5)
	}
	@When("User enters username(.*)")
	def username(String usernames) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/Email'), 5)
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/Email'))
		WebUI.sendKeys(findTestObject('Object Repository/HandsOn/Login/Email'),usernames )
	}
	@And("User enters password(.*)")
	def password(String passwords) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/HandsOn/Login/password'),5)
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/password'))
		WebUI.setEncryptedText(findTestObject('Object Repository/HandsOn/Login/password'), passwords)
	}
	@Then("User is succesfully logged in")
	def loggedIn(){
		WebUI.verifyElementClickable(findTestObject('Object Repository/HandsOn/Login/sign_in_btn'))
		WebUI.click(findTestObject('Object Repository/HandsOn/Login/sign_in_btn'))
	}
}