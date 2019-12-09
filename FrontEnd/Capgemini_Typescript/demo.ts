let myName: String = 'Udaykumar';
//myName = 1234   Its gives Error b'coz we can't change the datatype

let company;    //implicitly it will consider as Any
company = 1234;
company = 'TY';
company = true;
company = "Uday";

let age: String | number;   //union( | )
age = 21;
age = 'twenty nine';
//age = true  it give error b'coz we doesn't declared boolean in declaration

//tuple []
let details: [String, number, number] = ['ASDF', 4152, 4785];

//Arrays
let mobiles: String[] = ['Samsung', 'Realme', 'Vivo','4785'];

//function
function add(a:number, b:number):number{
    return a+b;
}