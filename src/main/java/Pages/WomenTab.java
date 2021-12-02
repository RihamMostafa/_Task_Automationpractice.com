package Pages;

import properties.LoadProperties;

public class WomenTab extends HomePage {

    String reference;
    public WomenTab()
    {
        super();
        ValidLogin();
    }

    public void openBlousesTab() throws InterruptedException {
        Hover(LoadProperties.homepage.getProperty("Women_Btn"));
        Thread.sleep(2000);
        HoverThenClick(findByXPath(LoadProperties.WomenTab.getProperty("Blouses_Btn")));
    }

    public void SelectProduct() throws InterruptedException {
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("Item")));
        Hover(LoadProperties.WomenTab.getProperty("Item"));
        click(findByXPath(LoadProperties.WomenTab.getProperty("AddToCart_Btn")));
        Thread.sleep(2000);
        click(findByXPath(LoadProperties.WomenTab.getProperty("ProceedToCheckout_Btn")));
    }

    public boolean FollowCheckout()
    {
        if(!gettext(findByXPath(LoadProperties.WomenTab.getProperty("Description"))).equalsIgnoreCase("Blouse"))
            return false;
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("ProceedToCheckout2_Btn")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("ProceedToCheckout2_Btn")));
        //ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("ProceedToCheckout2_Btn")));
        //click(findByXPath(LoadProperties.WomenTab.getProperty("ProceedToCheckout2_Btn")));
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("processAddress_Btn")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("processAddress_Btn")));
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("Terms_CheckBox")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("Terms_CheckBox")));
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("processCarrier_Btn")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("processCarrier_Btn")));
        return true;
    }

    public boolean PaybyBankWire()
    {
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("PaybyBankWire_Btn")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("PaybyBankWire_Btn")));
        ScrollToElement(findByXPath(LoadProperties.WomenTab.getProperty("IConfirmMyOrder_Btn")));
        click(findByXPath(LoadProperties.WomenTab.getProperty("IConfirmMyOrder_Btn")));
        reference=gettext(findByXPath(LoadProperties.WomenTab.getProperty("referenceData")));
        return gettext(findByXPath(LoadProperties.WomenTab.getProperty("ConfirmationMsg_Txt")))
                .equalsIgnoreCase(LoadProperties.WomenTab.getProperty("ConfirmationMsg"));
    }

    public boolean OrderPlaced()
    {
        navigateTOURL("http://automationpractice.com/index.php?controller=history");
        reference=reference.substring(reference.indexOf("reference"));
        reference = reference.split(" ")[1];
        return findElementsByXPath(LoadProperties.WomenTab.getProperty("referenceCode_table").replace("reference",reference)).size()!=0;
    }
}
