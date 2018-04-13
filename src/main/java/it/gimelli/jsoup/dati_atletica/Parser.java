package it.gimelli.jsoup.dati_atletica;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Parser {

	Document doc=null;

	public Document loadPage(String path) {
		try {
			doc = Jsoup.connect(path).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

}
