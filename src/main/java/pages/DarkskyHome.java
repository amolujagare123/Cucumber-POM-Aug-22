package pages;

import org.openqa.selenium.By;

public class DarkskyHome extends Base{

    By currentTempRaw = By.xpath("//span[@class='summary swap']");
    By timelineTempRaw = By.xpath("//span[@class='first']//span");

    public int getCurrentTemp()
    {
        String tempRaw = getTextFromElement(currentTempRaw);
        // 90˚ Humid and Overcast. --> {"90"," Humid and Overcast."}
        String tempStr = tempRaw.split("˚")[0]; // 90
        return Integer.parseInt(tempStr);
    }

    public int getTimelineTemp()
    {
        String tempRaw = getTextFromElement(timelineTempRaw);
        // 90°--> {"90"}
        String tempStr = tempRaw.split("°")[0]; // 90
        return Integer.parseInt(tempStr);
    }

}
