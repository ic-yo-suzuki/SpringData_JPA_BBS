package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_bbs.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the branches database table.
 *
 */
@Data
@Entity
@Table(name="branches")
@NamedQuery(name="BranchEntity.findAll", query="SELECT b FROM BranchEntity b")
public class BranchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to UserEntity
	@OneToMany(mappedBy="branch")
	private List<UserEntity> users;

	public BranchEntity() {
	}


	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setBranch(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setBranch(null);

		return user;
	}

}