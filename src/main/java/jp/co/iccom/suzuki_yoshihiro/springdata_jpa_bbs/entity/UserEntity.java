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


/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name="users")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
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

	public UserEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public BranchEntity getBranch() {
		return this.branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public DepartmentEntity getDepartment() {
		return this.department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}