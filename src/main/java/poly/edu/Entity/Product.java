package poly.edu.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Products")
public class Product implements Serializable{
	@Id
	@Column(name = "ProductID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Nationalized
	private String name;
	
	
	private String image;
	private Double price;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Createdate")
	private Date createDate;
	private Boolean avaiable;
	
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	Catagory category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OderDetail> orderDetails;
}
