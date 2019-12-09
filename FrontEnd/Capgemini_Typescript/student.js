var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Student = /** @class */ (function () {
    function Student(name, age, marks, degree) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.degree = degree;
    }
    return Student;
}());
var student1 = new Student('Amit', 21, 89);
console.log(student1);
//student1.printDetail();
var student2 = {
    name: 'Kaleen Bhaiya',
    age: 45,
    marks: 99,
    degree: 'B.E.'
};
console.log(student2);
var students = [
    new Student('Dimpi', 23, 87),
    {
        name: 'Munna Bhaiya',
        age: 28,
        marks: 39,
        degree: '10th'
    },
    student2,
    student1
];
for (var _i = 0, students_1 = students; _i < students_1.length; _i++) {
    var student = students_1[_i];
    console.log(student, 'object printed');
}
var Gradute = /** @class */ (function (_super) {
    __extends(Gradute, _super);
    function Gradute(name, age, marks, degree) {
        return _super.call(this, name, age, marks) || this;
    }
    return Gradute;
}(Student));
