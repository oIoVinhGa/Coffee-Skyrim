package poly.edu.Entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Catagory implements Serializable {
	@Id
	@Column(name = "CategoryId")
	private String id;
	
	@Nationalized
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;
}
