package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ShoppingCartPage extends BaseClass {

    // Elements
    private By proceedToCheckoutBtn() {
        return By.cssSelector(".js-cart-detailed-actions .btn-primary");
    }

    private By removeFromCartBtn() {
        return By.cssSelector(".remove-from-cart");
    }

    private By promoCodeLink() {
        return By.cssSelector(".promo-code-button .collapse-button");
    }

    private By promoCodeInput() {
        return By.cssSelector("input[name='discount_name']");
    }

    private By promoCodeLabel() {
        return By.cssSelector(".promo-name .label");
    }

    private By itemsInCartSpan() {
        return By.cssSelector(".js-subtotal");
    }

    private By cartItemTitles() {
        return By.cssSelector("[data-id_customization]");
    }

    /*
     *
     * Actions
     *
     * */
    public void addPromoCode(String promoCode) {
        waitUntilElementIsClickable(promoCodeLink());
        getDriver().findElement(promoCodeLink()).click();

        waitUntilElementIsVisible(promoCodeInput());
        WebElement promoCodeInput = getDriver().findElement(promoCodeInput());
        promoCodeInput.sendKeys(promoCode);
        pressEnter(promoCodeInput);
        waitForElementToHaveText(promoCodeLabel(), promoCode);
    }

    public void proceedToCheckout() {
        waitUntilElementIsClickable(proceedToCheckoutBtn());
        getDriver().findElement(proceedToCheckoutBtn()).click();
    }

    public int getCartItemCount() {
        waitUntilElementIsVisible(itemsInCartSpan());
        String itemText = getDriver().findElement(itemsInCartSpan()).getText();
        String numberOnly = itemText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }


    public void removeItemsFromCart(int numberOfItems) {
        for (int i = 0; i <= numberOfItems; i++) {
            waitUntilElementIsClickable(removeFromCartBtn());
            getDriver().findElement(removeFromCartBtn()).click();
        }
        waitForElementToHaveText(itemsInCartSpan(), String.valueOf((getCartItemCount() - numberOfItems)));
    }

    public int getItemListSize() {
        return getDriver().findElements(cartItemTitles()).size();
    }

}
