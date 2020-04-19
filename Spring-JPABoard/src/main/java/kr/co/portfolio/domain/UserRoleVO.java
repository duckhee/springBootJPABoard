package kr.co.portfolio.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of="idx")
@Table(name = "cloud_uesr_role_table")
public class UserRoleVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column(name="role", nullable = false)
	private String role;
	@Column(name="createdAt", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@Column(name="updatedAt", nullable = false)
	@UpdateTimestamp
	private Timestamp updatedAt;
}
