package it.gimelli.jsoup.dati_atletica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RegioneParser extends Parser{
	
	public HashMap<String, Societa> getSocieta() {
		
		HashMap<String, Societa> socs= new HashMap<String, Societa>();
		
		Elements pngs = doc.select(".table_btm table tbody tr");
		for (Element element : pngs) {
			Societa s= new Societa();
			Element el = element.selectFirst("abbr");
			s.setCodice(el.text());
			Element el1=element.selectFirst("a");
			s.setNome(el1.text());
			s.setLink(el1.attr("href"));
			socs.put(s.getCodice(),s);
			

		}
		return socs;
	}
}
