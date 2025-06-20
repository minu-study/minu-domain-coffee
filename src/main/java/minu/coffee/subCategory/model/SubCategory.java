package minu.coffee.subCategory.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.category.model.Category;
import minu.coffee.common.CommonField;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "sub_category", schema = "minu_shop", catalog="minu_shop")
public class SubCategory extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;

}