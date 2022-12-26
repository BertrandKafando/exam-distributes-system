package ma.enset.events

import ma.enset.enums.ProductState

abstract class BaseEvent<T>(
        open val id : T
)

data class CustomerCreatedEvent (
        override val id:String,
        val name: String,
        val email: String,
        val phone: String

): BaseEvent<String>(id)

data class CustomerUpdatedEvent (
        override val id:String,
        val name: String,
        val email: String,
        val phone: String

): BaseEvent<String>(id)


//ineventory

data class ProductCreatedEvent (
        override val id:String,
        val name: String,
        val price: Double,
        val quantity: Integer,
        val state: ProductState,
        val categoryId: String


):BaseEvent<String>(id)

data class CategoryCreatedEvent (
        override val id:String,
        val name: String,
        val description: String,

        ):BaseEvent<String>(id)
