package it.gimelli.jsoup.dati_atletica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AtletaParser extends Parser{

	public HashMap<String, Prestazione> getPersonalBest(){
		HashMap<String, Prestazione> pres=new HashMap<String, Prestazione>();
	
		Elements titlet=doc.select("#tab2 .tab-holder .title-table");
		
	
		for (Element tt : titlet) {
			Prestazione p= new Prestazione();
			
			String discip= tt.text();
			p.setTipo(discip);
			
			Element table=tt.nextElementSibling();
			Element riga=table.selectFirst("table tbody tr td form");
			
			String tempo=riga.select("[name='titleTime']").attr("value").trim();
			p.setTimeFromString(tempo);
			
			String datas=riga.select("[name='titleDate']").attr("value").trim();
			LocalDate data=LocalDate.parse(datas, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			p.setData(data);
			
			String luogo=riga.select("[name='titleLuogo']").attr("value").trim();
			p.setLuogo(luogo);
			
			pres.put(discip, p);
		}
		return pres;
	}
}
