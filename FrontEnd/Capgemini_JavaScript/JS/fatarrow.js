//fat arrow function
let add = (a,b) => {
    console.log('Sum is : ', a+b)
}
add(12,13);

//fat arrow function with one argument
let printAge = age =>{
    console.log("Age is :", age);
}
printAge(21);

//fat arrow function with only return statement
let product = (a, b) => a*b;
console.log("Product is : ", product(12, 13));