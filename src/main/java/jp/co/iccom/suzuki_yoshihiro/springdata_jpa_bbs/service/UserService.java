package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service;

import static jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.utils.EntityManagerUtil.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity.UserEntity;

@Service
public class UserService {
	@SuppressWarnings("unchecked")
	public List<UserEntity> getUserList(){
		EntityManager em = getEntityManager();
		List<UserEntity> userList = null;

		try{
			em.getTransaction().begin();
			userList = em.createNamedQuery("UserEntity.findAll").getResultList();
			em.getTransaction().commit();

		}catch(Exception e){
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		}finally{
			em.clear();
			em.close();
		}

		return userList;
	}

	public UserEntity getUser(int id) {
		EntityManager em = getEntityManager();
		UserEntity user = null;
		try{
			em.getTransaction().begin();
			user = (UserEntity) em.createNamedQuery("UserEntity.findById")
					.setParameter("id", id)
					.getSingleResult();
			em.getTransaction().commit();
		}catch(Exception e){
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		}finally{
			em.clear();
		}

		return user;
	}

}
