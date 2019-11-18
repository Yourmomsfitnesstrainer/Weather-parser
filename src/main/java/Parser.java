import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    public static Document getPage() throws IOException {
        String url ="https://yandex.ru/pogoda/yoshkar-ola";
                Document page = Jsoup.parse(new URL(url), 5000);
                return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        String timeNowElement = page.select(".time").first().text();
        String environmentalCondition = page.select("body > div > div.content.content_compressed.i-bem > div.content__top > div > div.content__row >" +
                " div.fact.card.card_size_big > div.fact__temp-wrap > a > div.link__feelings.fact__feelings > div").text();
        String DaylighTime = page.select("body > div > div.content.content_compressed.i-bem > div.content__bottom > div > div > div.sun-card.sun-card_theme_light.card.content__elem.content__elem_pos_1 > div.sun-card__info > div.sun-card__sunrise-sunset > div.sun-card__sunrise-sunset-info-wrapper > " +
                "div.sun-card__sunrise-sunset-info.sun-card__sunrise-sunset-info_value_rise-time").text();
        String DaylighMeaningEndTime = page.select("body > div > div.content.content_compressed.i-bem > div.content__bottom > div > div > div.sun-card.sun-card_theme_light.card.content__elem.content__elem_pos_1 > div.sun-card__info > div.sun-card__sunrise-sunset > div.sun-card__sunrise-sunset-info-wrapper > " +
                "div.sun-card__sunrise-sunset-info.sun-card__sunrise-sunset-info_value_set-time").text();
        System.out.println("  Время:" + timeNowElement + "     На улочке:" + environmentalCondition +
                "     Световой день c:" + DaylighTime + "    По:" + DaylighMeaningEndTime + ".");

    }

}
