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
 * The persistent class for the users database table.
 *
 */
@Data
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u"),
	@NamedQuery(name="UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = :id")
})

public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_date")
	private Date lastLoginDate;

	@Column(name="login_id")
	private String loginId;

	private String name;

	private String password;

	private byte status;

	//bi-directional many-to-one association to BranchEntity
	@ManyToOne
	@JoinColumn(name="branch_id")
	private BranchEntity branch;

	//bi-directional many-to-one association to DepartmentEntity
	@ManyToOne
	@JoinColumn(name="department_id")
	private DepartmentEntity department;

	//bi-directional many-to-one association to PostEntity
	@OneToMany(mappedBy="user")
	private List<PostEntity> posts;

	//bi-directional many-to-one association to CommentEntity
	@OneToMany(mappedBy="user")
	private List<CommentEntity> comments;

	public UserEntity() {
	}

	public PostEntity addPost(PostEntity post) {
		getPosts().add(post);
		post.setUser(this);

		return post;
	}

	public PostEntity removePost(PostEntity post) {
		getPosts().remove(post);
		post.setUser(null);

		return post;
	}

	public List<CommentEntity> getComments() {
		return this.comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

}