package pl.coderslab.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "purchases")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "brak nazwy")
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	@CreationTimestamp
	private Date created;
	@Column(scale = 2)
	@NotNull
	private BigDecimal price;
	@Column(columnDefinition = "TEXT")
	private String description;

	@Override
	public String toString() {
		return String.format("Purchase [id=%s, dateTime=%s, created=%s, price=%s, name=%s, description=%s]", id,
				dateTime, created, price, name, description);
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

}
