// https://www.javascripttutorial.net/es-next/javascript-promise-allsettled/
const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
      console.log('The first promise has resolved');
      resolve(10);
  }, 1 * 1000);

});

const p2 = new Promise((resolve, reject) => {
  setTimeout(() => {
      console.log('The second promise has rejected');
      reject(20);
  }, 2 * 1000);
});

Promise.allSettled([p1, p2])
  .then((result) => {
      console.log(result);
  });

// 결과값: fulfilled와 rejected 모두 반환
// The first promise has resolved
// The second promise has rejected
// [
//   { status: 'fulfilled', value: 10 },
//   { status: 'rejected', reason: 20 }
// ]
