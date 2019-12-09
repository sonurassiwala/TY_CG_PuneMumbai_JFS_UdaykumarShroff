var a = 100;
var b =200;
console.log(a+b);
console.log(a*b);


//Anonymous
var x = function(){
    console.log('Hello from Anonymous function');
}

x();

//Naming Function
function add(a, b){
    console.log(a+b);
}

add(102,123);

//immediately invoke function expression
(function(x, y){
    console.log('Result is : ',x*y)
})(12,20);

//Understanding return keyword
function division(a, b){
    return a/b;
}

console.log(division(20,5));