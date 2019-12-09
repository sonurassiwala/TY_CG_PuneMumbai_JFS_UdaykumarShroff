// var x = [12345, 'zxcv', true, {name : 'Ranveer Singh'}];

// for(var i=0; i < x.length; i++){
//     console.log(x[i]);
// }

 var color = ['yellow', 'orange', 'green', 'white', 'red'];
// console.log(color);
// color.pop();
// console.log(color);
// color.push('violet', 'blue');
// console.log(color);
// color.shift();
// console.log(color);
// color.unshift('black');
// console.log(color);
// color.splice(2, 2);
// console.log(color);
// color.splice(2,1,'Bhagva','Pink');
// console.log(color);

// color.forEach(function(value, index, array){
//     console.log(value, index, array);
// })

// console.log(color.indexOf('blue'));

//var myArray = [1,2,3,4,5,6,7,8,9,0];
// var newArray = myArray.filter(function(value, index, array){
//     return value>3;
// })
// console.log(newArray);

//filter method for unique values
// var filteredArray = myArray.filter(function(value, index, array){
//     return array.indexOf(value) === index; 
// });
// console.log(filteredArray);

// if(123 === '123'){
//     console.log(true)
// }
// else{
//     console.log(false)
// }

// for(var x of myArray){
//     console.log(x);
// }

//for In loop
// for(var x in myArray){
//     console.log("Value is : " + myArray[x] + " and Index is : " + x);
// }

var movie = {
    name : 'Gangs of Wasseypur',
    actor : 'Nawajuddin Siddique',
    actress : 'Huma Qureshi',
    director : 'Anurag Kashyap'
};
console.log(movie.name);
for(var key in movie){
    console.log(key + " : "+movie[key]);
}

// setTimeout(function(){
//     console.log('5 seconds done')
// }, 5000);

// var i=1;
// setInterval(function(){
//     console.log(i);
//     i++;
// }, 1000);

// //callback function
// function test(cb){
//     console.log('test function started');
//     cb();
//     console.log('test function ended');
// }

// test(function(){
//     console.log('Callback function is being executed')
// });

