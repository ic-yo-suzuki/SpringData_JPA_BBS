package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the comments database table.
 *
 */
@Data
@Entity
@Table(name="comments")
@NamedQuery(name="CommentEntity.findAll", query="SELECT c FROM CommentEntity c")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private String text;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	//bi-directional many-to-one association to PostEntity
	@ManyToOne
	@JoinColumn(name="post_id")
	private PostEntity post;

	public CommentEntity() {
	}


}