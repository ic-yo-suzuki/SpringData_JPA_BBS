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
 * The persistent class for the departments database table.
 *
 */
@Data
@Entity
@Table(name="departments")
@NamedQuery(name="DepartmentEntity.findAll", query="SELECT d FROM DepartmentEntity d")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="department")
	private List<UserEntity> users;

	public DepartmentEntity() {
	}


	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setDepartment(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setDepartment(null);

		return user;
	}

}