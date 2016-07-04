package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the posts database table.
 *
 */
@Data
@Entity
@Table(name="posts")
@NamedQueries({
	@NamedQuery(name="PostEntity.findAll", query="SELECT p FROM PostEntity p"),
	@NamedQuery(name = "PostEntity.findPostByUserId", query = "select p from PostEntity p where p.user.id = :id")
})

public class PostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private String text;

	private String title;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	//bi-directional many-to-one association to CommentEntity
	@OneToMany(mappedBy="post")
	private List<CommentEntity> comments;

	public PostEntity() {
	}


	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setPost(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setPost(null);

		return comment;
	}

}