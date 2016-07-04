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
		}

		return userList;
	}

}
