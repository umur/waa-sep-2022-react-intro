package henry.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto implements Serializable {
    private int id;
    private String name;
    @JsonManagedReference
    private List<ProductDto> products;
}