package br.com.cast.weather.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.weather.entity.Weather;

@Repository
public class WeatherRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Weather weather) {
		weather.setId(UUID.randomUUID().toString());
		em.persist(weather);
	}
	
	@SuppressWarnings("unchecked")
	public List<Weather> getPorDataAtualCidade(String cidade) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT w ")
		   .append(" FROM ").append(Weather.class.getName()).append(" w ")
		   .append(" WHERE 1=1 ")
		   .append(" AND w.date >= :date ")
		   .append(" AND w.city = :city ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("date", new Date());
		query.setParameter("city", cidade);
		
		return query.getResultList();
		
	}

	public void excluirPorCidade(String cidade) {
		StringBuilder hql = new StringBuilder();
		hql.append("DELETE ")
		   .append(" FROM ").append(Weather.class.getName())
		   .append(" WHERE 1=1 ")
		   .append(" AND city = :city ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("city", cidade);
		
		query.executeUpdate();

	}
}
