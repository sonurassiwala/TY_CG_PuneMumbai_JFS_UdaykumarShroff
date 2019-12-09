//literal way of Object creation
var student = {
    name : 'Shoeb Kala',
    age : 23,
    degree : '10th',
    PhoneNumber : 986543210
};

//printing the data
console.log(student.name);
console.log(student);

//changing info
student.PhoneNumber = 89745663210;
console.log(student);

//adding data
student.selectedCompany = 'Safi Rassi';
console.log(student);

//using Object Constructor
var laptop = new Object();
laptop.brand = 'MSI';
laptop.ram = '16GB';
laptop.processor = 'i7u5';
laptop.price = 68500;

console.log(laptop);
console.log(Object.keys(laptop));
console.log(Object.keys(laptop).length);