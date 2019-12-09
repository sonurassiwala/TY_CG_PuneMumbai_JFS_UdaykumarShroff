class Student{
        constructor(
        public name: String, 
        public age: number,
        public marks: number,
        public degree ?: String){}
    // printDetail(){
    //     console.log(`Name is ${this.name} 
    //     Age is ${this.age} 
    //     and marks is ${this.marks}`);
    // }
}

let student1 = new Student('Amit', 21, 89);
console.log(student1);
//student1.printDetail();

let student2 : Student ={
    name: 'Kaleen Bhaiya',
    age: 45,
    marks: 99,
    degree: 'B.E.'
}
console.log(student2);

let students: Student[] = [
    new Student('Dimpi', 23, 87,),
    {
        name: 'Munna Bhaiya',
        age: 28,
        marks: 39,
        degree: '10th'
    },
    student2,
    student1
];
for(let student of students){
    console.log(student, 'object printed');
}

class Gradute extends Student{
    constructor(
        name: String, 
        age: number,
        marks: number,
        degree ?: String
    ){
    super(name, age, marks);
    }
}