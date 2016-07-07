package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.service;

import static jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.utils.EntityManagerUtil.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity.PostEntity;
import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.form.MessageForm;

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

	public int postMessage(MessageForm form){
		EntityManager em = getEntityManager();
		int result = -1;
		try{
			em.getTransaction().begin();
			PostEntity newMessage = new PostEntity();
			newMessage.getUser().setId(form.getUserId());
			newMessage.setText(form.getText());
			newMessage.setTitle(form.getTitle());
			newMessage.setCategory(form.getCategory());

			em.persist(newMessage);
			em.getTransaction().commit();
			result = 0;
		}catch(Exception e){
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
		}finally{
			em.clear();
			em.close();
		}
		return result;
	}

}
