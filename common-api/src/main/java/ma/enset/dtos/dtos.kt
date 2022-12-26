package ma.enset.dtos

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
