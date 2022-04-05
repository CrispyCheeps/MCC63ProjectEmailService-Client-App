//Varable
var name = 'Wahyu';
let firstName = 'Wahyu';
const lastName = 'Kuncoro';

console.log(name);

//Object
const employee = {
    firstName: 'Wahyu',
    lastName: 'Kuncoro',
    address: {
        city: 'Sumatera Selatan',
        country: 'Indonesia'
    },
    hobbies: [
        'Coding',
        'Music'
    ]
};

console.log(employee.address.city);
console.log(employee.hobbies[0]);

//Array
const hobbies = ['Coding', 'Music'];
hobbies.push('Read Book');
// console.log(hobbies);
// hobbies.pop();
hobbies.shift();
console.log(hobbies);
hobbies.unshift("Coding Back Again");

//Thruty Falcy
console.log("Number =========");
console.log(new Boolean(0));//false
console.log(new Boolean(1));//true
console.log(new Boolean(2));//true

console.log("String =========");
console.log(new Boolean(''));//false
console.log(new Boolean('a'));//true


console.log("Other =========");
console.log(new Boolean(null));//false
console.log(new Boolean(NaN));//false
console.log(new Boolean(undefined));//false
console.log(new Boolean([]));//true
console.log(new Boolean({}));//true

const hello = 'hai';

if(hello) {
    console.log('Hello not empty');
}

let number = 100;
if(number) {
    console.log('Number is not 0 value or null');
}


//Array Manipulation
const movies = ["Spiderman", "Hulk", "Iron Man"];

const spiderman = movies.filter(movie => movie === "Spiderman");
const editMovies = movies.map(movie => movie + " Marvel");
console.log(movies);
console.log(spiderman);

console.log("1" == 1);
console.log("1" === 1);

//Javascript DOM
const navbar = document.getElementById('navbar');

const content = document.getElementsByClassName('container');

const querySelector = document.querySelector('nav#navbar');
const querySelectorContent = document.querySelector('div.container');

querySelectorContent.innerHTML = '<p>Add element from JS DOM</p>';


//function
function onSubmitDeleteForm() {
    console.log(this);
    console.log("On Click delete button")
}

