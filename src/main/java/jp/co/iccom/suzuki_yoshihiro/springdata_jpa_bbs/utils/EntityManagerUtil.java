package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	public static EntityManager getEntityManager(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SpringData_JPA_BBS");
		return emf.createEntityManager();
	}
}
