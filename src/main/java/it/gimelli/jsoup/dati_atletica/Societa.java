package it.gimelli.jsoup.dati_atletica;

import java.util.Collection;
import java.util.HashMap;

public class Societa {
	String codice;
	String nome;
	String link;
	HashMap<String, Atleta> atleti;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public HashMap<String, Atleta> getAtleti() {
		return atleti;
	}
	public void setAtleti(HashMap<String, Atleta> atleti) {
		this.atleti = atleti;
	}
	@Override
	public String toString() {
		return "Societa [codice=" + codice + ", nome=" + nome + ", link=" + link + "]";
	}
	
	public void stampaAtleti(){
		Collection<Atleta> atletiSet = atleti.values();
		for (Atleta atleta : atletiSet) {
			System.out.println(atleta);
			atleta.stampaPersonalBest();
		}
	}
	
}
