let sayi1 = 10
sayi1 = "engin demirog"
let student = { id: 1, name: "engin" }
//console.log(student)
function save(puan = 10, ogrenci) {
    console.log(ogrenci.name + ":" + puan);
}
//save(undefined,student);
let students = ["engin", "berkant"]

//console.log(students);
let students2 = [student, { id: 1, name: "berkant" }, "ankara", { city: "istanbul" }]
//console.log(students2);


//rest
let showProducts = function (id, ...products) {
    console.log(id);
    console.log(products[0]);
}
//console.log(typeof showProducts);
//showProducts(1, "abc", "abc")

//spread 
let points=[1,2,3,4,14,12,11]
console.log(...points);
console.log(Math.max(... points));
console.log(..."ABC","D",..."EFG","H");

//Destructuring
let populations=[10000,20000,30000,[40000,50000]]
let [small,medium,high,[veryHigh,maximum]]=populations
console.log(small,medium,high,veryHigh,maximum);

function someFunction([small1],number) {
    console.log(small1);
    
}
someFunction(populations)

let category={id:1,name:"içecek"}
console.log(category.id);
console.log(category["name"]);

let{id,name}=category
console.log(id);
console.log(name);
