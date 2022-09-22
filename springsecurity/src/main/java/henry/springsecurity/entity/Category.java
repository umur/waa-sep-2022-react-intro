package henry.springsecurity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @JsonBackReference
    @JoinColumn(name = "category_id")
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Product> products;
}
