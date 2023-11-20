// https://www.codecademy.com/learn/webdev-intermediate-javascript/modules/asynch-js/cheatsheet#heading-resolving-javascript-promises
let promise1 = Promise.resolve(5);
let promise2 = 44;
let promise3 = new Promise(function (resolve, reject) {
  setTimeout(resolve, 1_000, "foo");
});

Promise.all([promise1, promise2, promise3]).then(function (values) {
  console.log(values);
});
// expected output: Array [5, 44, "foo"]
