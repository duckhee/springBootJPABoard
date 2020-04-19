package kr.co.portfolio.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "roles")
@Entity
@EqualsAndHashCode(of = "idx")
@Table(name="cloud_uesr_table")
public class UserVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name="email", nullable = false, unique = true)
	private String email;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="createdAt", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@Column(name="updatedAt", nullable = false)
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	
	/** User Role */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user")
	private List<UserRoleVO> roles;
}
