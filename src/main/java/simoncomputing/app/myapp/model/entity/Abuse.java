package simoncomputing.app.myapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@Table(name = "ABUSE", uniqueConstraints = @UniqueConstraint(columnNames={"KUDO_ID", "ENTRY_USER"}))
public class Abuse extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long abuseId;
	private Kudo kudo;
	private String comment;
	private User entryUser;

	@Id
	@SequenceGenerator(name = "abuseSequence", sequenceName = "ABUSE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "abuseSequence", strategy = GenerationType.SEQUENCE)
	@Column(name = "ABUSE_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getAbuseId() {
		return abuseId;
	}

	public void setAbuseId(Long abuseId) {
		this.abuseId = abuseId;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KUDO_ID", nullable = false)
	public Kudo getKudo() {
		return kudo;
	}

	public void setKudo(Kudo kudo) {
		this.kudo = kudo;
	}

	@Column(name = "CMNT", length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ENTRY_USER")
	public User getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(User entryUser) {
		this.entryUser = entryUser;
	}

}
