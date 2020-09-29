package unlp.info.mapaw.comedor.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import unlp.info.mapaw.comedor.enums.RoleEnum;
import unlp.info.mapaw.comedor.enums.UserConditionEnum;

@Entity
@Table(name ="USER")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_USER", allocationSize = 1)
public class User extends AbstractEntity {

	@Column
	private String fullname;

	@Column
	private String password;

	@Column
	private String dni;

	@Enumerated(EnumType.STRING)
	@Column
	private RoleEnum role;

	@ManyToMany
	@JoinTable(name = "CLIENT_FACULTY", joinColumns = @JoinColumn(name = "id_client"), inverseJoinColumns = @JoinColumn(name = "id_faculty"))
	private Set<Faculty> faculties;

	@ManyToOne
	@JoinColumn(name = "id_kitchen_site")
	private KitchenSite kitchenSite;

	@Column
	private String email;

	@Enumerated(EnumType.STRING)
	@Column
	private UserConditionEnum condition;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public KitchenSite getKitchenSite() {
		return kitchenSite;
	}

	public void setKitchenSite(KitchenSite kitchenSite) {
		this.kitchenSite = kitchenSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserConditionEnum getCondition() {
		return condition;
	}

	public void setCondition(UserConditionEnum condition) {
		this.condition = condition;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}
}
