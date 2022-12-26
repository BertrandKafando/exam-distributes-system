package ma.enset.events

import ma.enset.commands.BaseCommand

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
