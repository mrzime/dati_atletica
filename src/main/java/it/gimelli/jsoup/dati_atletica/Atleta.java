package it.gimelli.jsoup.dati_atletica;

import java.util.Collection;
import java.util.HashMap;

public class Atleta {

	String categoria;
	String nome;
	String cognome;
	int anno;
	String link;
	Societa societa;
	
	HashMap<String, Prestazione> best;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	
	
	public HashMap<String, Prestazione> getBest() {
		return best;
	}
	public void setBest(HashMap<String, Prestazione> best) {
		this.best = best;
	}
	@Override
	public String toString() {
		return "Atleta [categoria=" + categoria + ", nome=" + nome + ", cognome=" + cognome + ", anno=" + anno
				+ ", link=" + link + "]";
	}
	
	public void stampaPersonalBest(){
		Collection<Prestazione> pb = best.values();
		for (Prestazione prestazione : pb) {
			System.out.println(prestazione);
		}
	}
	
}
