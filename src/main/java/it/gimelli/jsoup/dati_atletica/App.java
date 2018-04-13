package it.gimelli.jsoup.dati_atletica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	 System.out.println("START");
        

      
//        due();
//        uno();
    	 tre();
        
        
        System.out.println("Stop");
    }
    
    
    public static void uno(){
    	
         HashMap<String, Societa> socs = getDatiRegione();
         
         Collection<Societa> societas = socs.values();
         for (Societa societa : societas) {
			Collection<Atleta> atleti = societa.getAtleti().values();
			for (Atleta atleta : atleti) {
				getDatiAtleta(atleta);
			}
			
		}
         
         System.out.println("PARSING COMPLETATO");
         
         // stampa degli atleti dell'atletica ravenna
         Societa ra095=socs.get("RA095");
         if(ra095!=null){
         	ra095.stampaAtleti();
         }
    }
    
    
    public static void due(){
    	Societa s= new Societa();
    	s.setCodice("RA095");
    	s.setNome("Atletica Ravenna");
    	s.setLink("http://www.fidal.it/societa/ATLETICA-RAVENNA/RA095");
    	Societa ra095=getDatiSocieta(s);
    	ra095.stampaAtleti();
    	Atleta a=ra095.getAtleti().get("Gimelli Filippo");
    	a=getDatiAtleta(a);
    	a.stampaPersonalBest();
    	
    	
    }
    
    public static void tre(){
    	
    	Societa s1= new Societa();
    	s1.setCodice("RA095");
    	s1.setNome("Atletica Ravenna");
    	s1.setLink("http://www.fidal.it/societa/ATLETICA-RAVENNA/RA095");
    	
    	Societa s2= new Societa();
    	s2.setCodice("BO014");
    	s2.setNome("Atletica Sacmi");
    	s2.setLink("http://www.fidal.it/societa/ATL--IMOLA-SACMI-AVIS/BO014");
    	
    	Societa s3= new Societa();
    	s3.setCodice("RA094");
    	s3.setNome("Atletica 85 Faenza");
    	s3.setLink("http://www.fidal.it/societa/ATLETICA-85-FAENZA/RA094");
    	
    	Societa s4= new Societa();
    	s4.setCodice("RA093");
    	s4.setNome("Atletica Lugo");
    	s4.setLink("http://www.fidal.it/societa/ATL--LUGO/RA093");
    	
    	Societa[] ss={s1,s2,s3,s4};
    	
    	for (Societa s : ss) {
    		
        	s=getDatiSocieta(s);
        	Collection<Atleta> atl = s.getAtleti().values();
        	for (Atleta atleta : atl) {
				atleta=getDatiAtleta(atleta);
				if(atleta.getBest().containsKey("3000 metri")){
					System.out.println(atleta);
					atleta.stampaPersonalBest();
				}
			}
        	
		}
    	
    	
    	
    }
    
    public static Atleta getDatiAtleta(Atleta a){
        AtletaParser psr= new AtletaParser();
        psr.loadPage(a.getLink());
        
        HashMap<String, Prestazione> best = psr.getPersonalBest();
       
		a.setBest(best);
			
        
        return a;
    }
    
    
    public static Societa getDatiSocieta(Societa s){
        RegioneParser psr= new RegioneParser();
       
		SocietaParse sp= new SocietaParse();
		sp.loadPage(s.link);
		// recupero di tutti gli atleti
		HashMap<String, Atleta> atleti = sp.getAtleti(s);
		s.setAtleti(atleti);
			
        
        return s;
    }
    
    
    public static HashMap<String, Societa> getDatiRegione(){
        RegioneParser psr= new RegioneParser();
        psr.loadPage("http://www.fidal.it/mappa.php?regione=Emilia-Romagna");
        
        // recupero di tutte le societa
        HashMap<String, Societa> socs = psr.getSocieta();
        
        //iterazione su tutte le società per recuperare gli atleti
        Collection<Societa> societas = socs.values();
        for (Societa societa : societas) {
//			System.out.println(societa);
			SocietaParse sp= new SocietaParse();
			sp.loadPage(societa.link);
			// recupero di tutti gli atleti
			HashMap<String, Atleta> atleti = sp.getAtleti(societa);
			societa.setAtleti(atleti);
			
		}
        

        return socs;
    }
}
