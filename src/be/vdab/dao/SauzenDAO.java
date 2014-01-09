package be.vdab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.sql.PreparedStatement;

import be.vdab.entities.Saus;

public class SauzenDAO extends AbstractDAO{

	
	private final static String READ_SAUS_ID_AANTAL_INGR = "select saus_id,count(*) as aantal_ingr from sauzen inner join"+
                                  "(sauzen_ingredienten inner join ingredienten on ingredient_nummer = ingredient_id)"+
                                  "on saus_nummer = saus_id group by saus_id";
	
	private final static String READ_SAUZEN_SQL = "select * from sauzen";
	
	private final static String READ_INGREDIENTEN_SQL = "select ingredienten.naam from ingredienten inner join"+
	                             "(sauzen_ingredienten as bridge inner join sauzen on bridge.saus_nummer = sauzen.saus_id)"+
			                     "on bridge.ingredient_nummer = ingredienten.ingredient_id and sauzen.saus_id = ?";	 
    private final static String DELETE_SQL = "delete from sauzen where saus_id = ?";
    
	private final Map <Integer,Integer> aantalIngredientenPerSaus = new ConcurrentHashMap<>();
	
  

  public Iterable<Saus> findAll(){
	  
	  List<Saus> sauzen = new ArrayList<>();
	  String[] ingredienten;
	  
		 try(Connection connection = getConnection();
			 Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery(READ_SAUZEN_SQL)){// eerst alle sauzen inlezen
			  while(resultSet.next()){ //per saus ingredienten opzoeken
				 Saus saus = null;
				 try(Connection connection2 = getConnection();
				     PreparedStatement prepStat = connection2.prepareStatement(READ_INGREDIENTEN_SQL)){
					 prepStat.setLong(1, resultSet.getLong(1));
				     try(ResultSet resultSet2 = prepStat.executeQuery()){
				      //om arraydimensie te kunnen bepalen
				      int aantalIngredienten = getAantalIngredientenPerSaus().get(resultSet.getInt(1));
					  ingredienten = new String[aantalIngredienten];
					 
				       int teller = 0;
				     //lees ieder ingredient voor deze saus en plaats in array
			           while(resultSet2.next()){
					     ingredienten[teller] = resultSet2.getString(1); 
					     teller++;
				       }
			         }
				     saus = new Saus(resultSet.getLong(1), resultSet.getString(2), ingredienten);
				     sauzen.add(saus);
				 }
			  }
		 }
		 catch(SQLException ex){
			 throw new DAOException("kan geen sauzen of ingredienten lezen uit database", ex);
		 }
		 
		 return sauzen;
 }
	
	
	
  public List<Saus> findSausByIngredient(String ingredient){
		
		List <Saus> sauzenByIngredient  = new ArrayList<>();
		
		 for(Saus saus : findAll()){
			 for(String ingr : saus.getIngredienten()){
				 if(ingr.equals(ingredient)){
					 sauzenByIngredient.add(saus);
				 }
			 }
			 
		 }
		return sauzenByIngredient;
	}
	
	
 public void deleteSaus(long nummer){
		
		try (Connection connection = getConnection();
		     PreparedStatement prepStat = connection.prepareStatement(DELETE_SQL)
		     ){
			prepStat.setLong(1,nummer);
			prepStat.executeUpdate();
		}
		catch(SQLException ex){
			throw new DAOException("Kan record met sausNr: "+nummer+" niet wissen uit databank",ex.getCause());
		}
  }
  
  private Map<Integer, Integer>getAantalIngredientenPerSaus() {
		try(Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(READ_SAUS_ID_AANTAL_INGR)){
			
			while(resultSet.next()){
				
				aantalIngredientenPerSaus.put(resultSet.getInt(1), resultSet.getInt(2));
			}
		}
	    catch(SQLException ex){
	    	throw new DAOException("Kan sauzen en het aantal ingredienten niet lezen uit database", ex);
	    }
		
	  return aantalIngredientenPerSaus;
  }
  

 
	

}
