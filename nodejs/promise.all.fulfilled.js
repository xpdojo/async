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
      reject(new Error("Boom!"));
  }, 2 * 1000);
});

Promise.all([p1, p2])
  .then((result) => {
      console.log(result);
  })
  .catch((e) => {
    console.log(e);
  });

// 결과값: 모두 fulfilled여야 반환
// node:internal/process/promises:288
