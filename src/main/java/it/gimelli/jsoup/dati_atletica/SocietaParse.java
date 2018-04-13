package it.gimelli.jsoup.dati_atletica;

import java.util.HashMap;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SocietaParse extends Parser{

	public HashMap<String, Atleta> getAtleti(Societa soc){
		HashMap<String, Atleta> atleti=new HashMap<String, Atleta>();
		Elements atlem=doc.select("h3");
		for (Element element : atlem) {
			String categoria= element.text();
//			System.out.println(element);
			Element table=element.nextElementSibling();
			Elements righe=table.select("tbody tr");
			for(Element riga:righe){
				Atleta a= new Atleta();
				Element link=riga.selectFirst("a");
				a.setCognome(link.text());
				a.setLink(link.attr("href"));
				a.setNome(riga.selectFirst(".col2").text());
				a.setAnno(Integer.parseInt(riga.selectFirst(".col3").text()));
				a.setCategoria(categoria);
				a.setSocieta(soc);
				atleti.put(a.getCognome()+" "+a.getNome(),a);
			}
		}
		return atleti;
	}
}
