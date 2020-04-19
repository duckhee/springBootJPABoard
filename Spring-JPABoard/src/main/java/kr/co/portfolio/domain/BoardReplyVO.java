package kr.co.portfolio.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString(exclude = "board")
@EqualsAndHashCode(of = "idx")
@Table(name = "cloud_board_reply_table")
public class BoardReplyVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column(name="retitle")
	private String retitle;
	@Column(name="recontent")
	private String recontent;
	@Column(name="replyer", nullable = false)
	private String replyer;
	@Column(name="createdAt", nullable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@Column(name="updatedAt", nullable = false)
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	
	/** Board */
	@ManyToOne
	private BoardVO board;
}
