class Customer{
    constructor(id,customerNumber) {
        this.id=id
        this.customerNumber=customerNumber
    }
}
let customer= new Customer(1,"12345");
//prototyping
console.log(customer.customerNumber);
Customer.bisey="bişey"
console.log(Customer.bisey);

class IndividualCustomer extends Customer{
    constructor(firstName,id,customerNumber){
        super(id,customerNumber)
        this.firstName=firstName
    }
}
class CorporateCustomer extends Customer{
        constructor(companyName,id,customerNumber){
            super(id,customerNumber)
            this.companyName=companyName
    }
}
