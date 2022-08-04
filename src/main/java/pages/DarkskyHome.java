package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHome extends Base{

    By currentTempRaw = By.xpath("//span[@class='summary swap']");
    By timelineTempRaw = By.xpath("//span[@class='first']//span");
    By rawTimeList = By.xpath("//span[@class='hour']/span");

    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timeRawList = getElementTextList(rawTimeList);
        System.out.println(timeRawList);
        ArrayList<Integer> timeList = new ArrayList<>();

        for (int i=0;i<timeRawList.size();i++)
        {
          String timeRaw =   timeRawList.get(i); // 9pm / 11am
          String timeStr =   timeRaw.substring(0,timeRaw.length()-2); // 9 / 11
            int time = Integer.parseInt(timeStr);
            timeList.add(time);
        }

        System.out.println(timeList);
        return timeList;
    }


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
