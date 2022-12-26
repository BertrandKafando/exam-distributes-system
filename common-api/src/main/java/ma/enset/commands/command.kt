package ma.enset.commands

import ma.enset.enums.ProductState
import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id : T
)

data class CreateCustomerCommand (
        override val id:String,
        val name: String,
        val email: String,
        val phone: String

):BaseCommand<String>(id)

data class UpdateCustomerCommand (
        override val id:String,
        val name: String,
        val email: String,
        val phone: String

):BaseCommand<String>(id)

//ineventory


data class CreateProductCommand (
        override val id:String,
        val name: String,
        val price: Double,
        val quantity: Integer,
        val state: ProductState,
        val categoryId: String


):BaseCommand<String>(id)

data class CreateCategoryCommand (
        override val id:String,
        val name: String,
        val description: String,

):BaseCommand<String>(id)

