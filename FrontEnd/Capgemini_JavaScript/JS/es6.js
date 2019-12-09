let person = {
    name: 'kajal',
    age: 28
};

let student = {
    ...person,
    id: 1234,
    percentage: 55.55
};
console.log(student);

let mumbaiCRS = ['Jagnish', 'Pooja'];
let noidaCRS = ['Kartik', 'Manali'];
let bangaloreCRS = ['Shahid', 'Nisha'];
let bhuCRS = ['Kaushik', 'Yasmin'];

let CRS = [
    ...noidaCRS,
    ...mumbaiCRS,
    ...bangaloreCRS,
    ...bhuCRS,
    'Suraj'
];
console.log(CRS);

let [name1, name2, name3, ...restValues] = CRS;
console.log(name1);
console.log(name2);
console.log(name3);
console.log(restValues);