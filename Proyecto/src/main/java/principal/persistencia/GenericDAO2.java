package principal.persistencia;

import java.util.ArrayList; 


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import principal.util.HibernateUtil;
import principal.util.JPAUtil;

public class GenericDAO2<T> {
	
	public Class<T> tipo;
	
	public GenericDAO2(Class<T> mitipo){
		tipo = mitipo;
	}
	
	//insertarJPA
	
	public void insertarRegistroJPA(T registro) {
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(registro);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		
		
		
	}
	
	public void insertarRegistroHibernate(T registro) {
		//Hibernate
				Transaction tr = null;
				Session sesion = null;
				
				try {
					sesion = HibernateUtil.getSessionFactory().openSession();
					tr = sesion.beginTransaction();
					sesion.persist(registro);
					tr.commit();
				
				} catch (PersistenceException e) {
				tr.rollback();
				}
				finally {
				sesion.close();	
				}
	}
	
	public void modificarRegistroJPA(T registro) {
		//JPA
				EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
				
				try {
					em.getTransaction().begin();
					em.merge(registro);
					em.getTransaction().commit();
				} catch (PersistenceException e) {
					em.getTransaction().rollback();
					System.out.println(e.getMessage());
				}
				finally {
					em.close();
				}
	}
	
	public void modificarRegistroHibernate(T registro) {
		//Hibernate
		Transaction tr = null;
		Session sesion = null;
		
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			tr = sesion.beginTransaction();
			sesion.merge(registro);
			tr.commit();
		
		} catch (PersistenceException e) {
		tr.rollback();
		}
		finally {
		sesion.close();	
		}
	}
	
	public void eliminarRegistroJPA(T registro) {
		//JPA
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(em.contains(registro)? registro:em.merge(registro) );
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void eliminarRegistroHibernate(T registro) {
		//Hibernate
				Transaction tr = null;
				Session sesion = null;
				
				try {
					sesion = HibernateUtil.getSessionFactory().openSession();
					tr = sesion.beginTransaction();
					sesion.remove(sesion.contains(registro)? registro:sesion.merge(registro) );
					tr.commit();
				
				} catch (PersistenceException e) {
				tr.rollback();
				}
				finally {
				sesion.close();	
				}
	}
	
	public ArrayList<T> listarRegistrosJPA(String tabla) {
		//JPA
				EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
				
				try {
					em.getTransaction().begin();
					ArrayList<T> misRegistros = (ArrayList<T>) em.createQuery("from "+tabla).getResultList();
					em.getTransaction().commit();
					return misRegistros;
				} catch (PersistenceException e) {
					em.getTransaction().rollback();
					System.out.println(e.getMessage());
				}
				finally {
					em.close();
				}
				return null;
		
		
	}
	
	public ArrayList<T> listarRegistrosHibernate(String tabla) {
		//Hibernate
		Transaction tr = null;
		Session sesion = null;
		
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			tr = sesion.beginTransaction();
			ArrayList<T> misRegistros = (ArrayList<T>) sesion.createQuery("from "+tabla).list();
			tr.commit();
			return misRegistros;
		
		} catch (PersistenceException e) {
		tr.rollback();
		}
		finally {
		sesion.close();	
		}
		return null;
		
	}
	
	public void imprimirRegistros(ArrayList<T> misRegistros) {
		System.out.println("Listado de Registros");
		for(T a:misRegistros) {
			System.out.println(a.toString());
		}
	}
	
	public void imprimirRegistrosGenerico(ArrayList<T> misRegistros) {
		System.out.println("Listado de Registros");
		for(T a:misRegistros) {
			System.out.println(a.toString());
		}
	}
	
	
	public T buscarPorIdJPA(int i) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			T registro = (T) em.find(tipo,i);
			System.out.println("El Registro buscado se llama " +registro);
			return registro;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
		finally {
			em.close();
		}
		return null;
		
	}
	
public T buscarPorIdHibernate(int id) {
		
	//Hibernate
	        T resultado = null;
			Transaction tr = null;
			Session sesion = null;
			
			try {
				sesion = HibernateUtil.getSessionFactory().openSession();
				tr = sesion.beginTransaction();
				resultado = (T) sesion.find(tipo, id);
				tr.commit();
				System.out.println("El Registro buscado es: " +resultado);
				return (T) resultado;
			
			} catch (PersistenceException e) {
			tr.rollback();
			}
			finally {
			sesion.close();	
			}
			return null;
		
	}
	
	
	
	
}


