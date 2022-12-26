package ma.enset.dtos

import ma.enset.enums.ProductState

data class CustomerCommandDTO (
        var name: String,
        var email: String,
        var phone: String
        );

data class CustomerQueryDTO (
        var id: String,
        var name: String,
        var email: String,
        var phone: String
);

data class ProductCommandDTO (
        var name: String,
        var price: Double,
        var quantity: Integer,
        var state: ProductState,
        var categoryId: String
        );


data class CategoryCommandDTO (
        var name: String,
        var description: String,
        );
