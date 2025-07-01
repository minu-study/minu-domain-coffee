package minu.coffee.product.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minu.coffee.product.ProductDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.querydsl.core.types.Projections.fields;
import static minu.coffee.category.model.QCategory.category;
import static minu.coffee.product.model.QProduct.product;
import static minu.coffee.productPrice.model.QProductPrice.productPrice;
import static minu.coffee.shopInfo.model.QShopInfo.shopInfo;
import static minu.coffee.subCategory.model.QSubCategory.subCategory;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<ProductDto.ProductSummaryView> getProductSummaryView(Long shopInfoId, LocalDateTime now, Long subCategoryId) {
        Expression<ProductDto.ProductSummaryView> expression = fields(ProductDto.ProductSummaryView.class,
                product.id,
                category.code.as("categoryCode"),
                category.codeName.as("categoryName"),
                subCategory.code.as("subCategoryCode"),
                subCategory.codeName.as("subCategoryName"),
                product.code.as("productCode"),
                product.codeName.as("productName"),
                productPrice.price,
                shopInfo.paymentMethod.as("paymentType")

        );

        return queryFactory
                .select(expression)
                .from(product)
                .innerJoin(shopInfo).on(shopInfo.eq(product.shopInfo))
                .innerJoin(productPrice).on(product.eq(productPrice.product))
                .innerJoin(subCategory).on(product.subCategory.eq(subCategory))
                .innerJoin(category).on(category.eq(subCategory.category))
                .where(
                        product.shopInfo.id.eq(shopInfoId)
                                .and(productPrice.enable.eq(true))
                                .and(productPrice.deleted.eq(false))
                                .and(productPrice.startDate.loe(now)
                                .and(productPrice.endDate.goe(now)))
                                .and(product.subCategory.id.eq(subCategoryId))
                )
                .fetch();
    }

}
