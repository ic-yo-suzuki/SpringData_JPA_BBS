package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service;

import static jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.utils.EntityManagerUtil.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity.PostEntity;

@Service
public class MessageService {
	@SuppressWarnings("unchecked")
	public List<PostEntity> getMessageById(int id) {
		EntityManager em = getEntityManager();
		List<PostEntity> messageList = null;

		try {
			em.getTransaction().begin();
			messageList = em.createNamedQuery("PostEntity.findPostByUserId")
							.setParameter("id", id)
							.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}

		return messageList;
	}
}
