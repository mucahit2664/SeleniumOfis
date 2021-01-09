package com.ofis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase01 {
      /*
...Exercise1...
1-driver olusturalim
2-java class'imiza chromedriver.exe'yi tanitalim
3-driver'in tum ekrani kaplamasini saglayalim
4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
  söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
5-"sahibinden.com" adresine gidelim
6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
7-title ve url'nin "Kiralik" kelimesinin icerip icermedigini kontrol edelim
8-Ardindan "gittigidiyor.com" adresine gidelim
9-bu adresin basligini alalim ve "alisveris" kelismesini icerip icermedigini
  kontrol edelim
10-Bi onceki web sayfamiza geri donelim
11-sayfayi yenileyelim
12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
13-Enson adim olarak butun sayfalarimizi kapatmis olalim
 */

    public static void main(String[] args) {
       // 1-driver olusturalim
        System.setProperty("webdriver.chrome.driver","C:\\Users\\pc\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.sahibinden.com");
        String sahibindeBaslik = driver.getTitle();
        String sahibindenUrl = driver.getCurrentUrl();

       /* iverboolean isTrue = dr.getTitle().contains("Kiralık");
        if (isTrue){
            System.out.println("iceriyor");
        }
        else {
            System.out.println("icermioyr");
        }*/
        System.out.println(sahibindeBaslik);
        System.out.println(sahibindenUrl);
        if (sahibindeBaslik.contains("Kiralık") || sahibindenUrl.contains("Kiralık")){
            System.out.println("Kiralık yazısı vardır");
        }
        else {
            System.out.println("Kiralık yazısı yoktur");
        }
        driver.get("https://www.gittigidiyor.com");
        String gittiTitle = driver.getTitle();
        System.out.println(gittiTitle);
        String  gittiUrl = driver.getCurrentUrl();
        System.out.println(gittiUrl);
       /* if (gittiTitle.contains("alısveris")|| gittiUrl.contains("alisveris")){
            System.out.println("Alisveris icermektedir");
        }
        else {
            System.out.println("Alisveris icermemektedir");
        }
        */
        boolean isTrue = driver.getTitle().contains("alisveris");
        if (isTrue){
            System.out.println("Alisveris icermektedir");
        }
        else {
            System.out.println("Alisveris icermemektedir");
        }
        /*
        -Bi onceki web sayfamiza geri donelim
11-sayfayi yenileyelim
12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
13-Enson adim olarak butun sayfalarimizi kapatmis olalim
         */

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.close();
        driver.quit();

    }

}
