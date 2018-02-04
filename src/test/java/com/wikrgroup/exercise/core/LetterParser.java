package com.wikrgroup.exercise.core;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;

/**
 * Created by Vladislav Kulasov on 04.02.2018.
 */
public class LetterParser {
    private Logger logger = Logger.getLogger(this.getClass());

    public String getConfirmUrl(String htmlPage) {
        Document doc = Jsoup.parse(htmlPage, "UTF-8");
        Elements linkElements = doc.getElementsByTag("a");
        String url = linkElements
                .stream()
                .filter(e -> e.attributes().get("href")
                        .contains("confirm-email"))
                .collect(Collectors.toList())
                .get(0).attributes().get("href");
        logger.info("confirm url: " + url);
        return url;
    }
}
