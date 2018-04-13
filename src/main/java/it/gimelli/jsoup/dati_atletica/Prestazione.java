package it.gimelli.jsoup.dati_atletica;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Prestazione {
	
	static final String FORMATO_hh_mm_ss_SSS="hh:mm:ss.SSS";
	static final String FORMATO_mm_ss_SSS="mm:ss.SSS";
	static final String FORMATO_mm_ss="mm:ss";
	
	
	LocalDate data;
	String tipo;
	String luogo;
	String categoria;
	LocalTime tempo;
	BigDecimal misura;
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalTime getTempo() {
		return tempo;
	}
	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}
	public BigDecimal getMisura() {
		return misura;
	}
	public void setMisura(BigDecimal misura) {
		this.misura = misura;
	}
	
	public void setTimeFromString(String stime){
		
		if(stime.matches("[0-9]{2}:[0-9]{2}\\.[0-9]{1,3}") || stime.matches("[0-9]{2}:[0-9]{2}")){
			String modstime="00:"+stime;
			LocalTime t= LocalTime.parse(modstime,DateTimeFormatter.ISO_TIME);
			this.setTempo(t);
		}else if(stime.matches("[0-9]{1}:[0-9]{2}\\.[0-9]{1,3}") || stime.matches("[0-9]{1}:[0-9]{2}")){
			String modstime="00:0"+stime;
			LocalTime t= LocalTime.parse(modstime,DateTimeFormatter.ISO_TIME);
			this.setTempo(t);
		}else if(stime.matches("[0-9]{1}\\.[0-9]{1,3}")){
			String modstime="00:00:0"+stime;
			try{
				LocalTime t= LocalTime.parse(modstime,DateTimeFormatter.ISO_TIME);
				this.setTempo(t);
			}catch (Exception e) {
				// TODO: handle exception
			}
			this.setMisura(new BigDecimal(stime));
		}else if(stime.matches("[0-9]{2}\\.[0-9]{1,3}")){
			String modstime="00:00:"+stime;
			try{
				LocalTime t= LocalTime.parse(modstime,DateTimeFormatter.ISO_TIME);
				this.setTempo(t);
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			this.setMisura(new BigDecimal(stime));
		}else if(stime.matches("[0-9]{3}\\.[0-9]{1,3}")){
			
			this.setMisura(new BigDecimal(stime));
		}else{
			System.out.println(stime +" Formato non riconosciuto");
		}
		
		
	}
	@Override
	public String toString() {
		return "Prestazione [data=" + data + ", tipo=" + tipo + ", luogo=" + luogo + ", categoria=" + categoria
				+ ", tempo=" + tempo + ", misura=" + misura + "]";
	}
	
	
}
