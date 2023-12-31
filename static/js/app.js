//console.log('js executed');
console.log('hello from js');

const form = document.getElementById('form');
// -----------------------------------------------------------------------------------------------------------
// 'submit' - это событие отправки формы
// =>  это лямда
// приходит событие evt, и это событие приходит нужного нам типа.
// Соответственно если мы подписываемся на событие типа 'submit', то нам приходит событие evt - типа 'submit'
// Что бы наше приложение работало корректно, это можно сделать с помощью вызова у события метода evt.preventDefault();
// evt.preventDefault(); - отменяем стандартное действие,(В стандарте это отправка) У нас действия не будет
// -----------------------------------------------------------------------------------------------------------
form.addEventListener('submit', (evt) => {
  evt.preventDefault();
  console.log("submit event raised");

  // {
  //   // GET с Query URL
  //   const data = new URLSearchParams();
  //   Array.from(form.elements)
  //     .filter((el) => el.name !== '') // только с атрибутом name
  //     .forEach((el) => data.append(el.name, el.value));
  //
  //   const xhr = new XMLHttpRequest();
  //   xhr.open('GET', `/api?${data}`);
  //   xhr.send();
  //   form.reset(); // очистка формы
  // }

  // {
  //   // POST
  //   const data = new URLSearchParams();
  //   Array.from(form.elements)
  //     .filter((el) => el.name !== '') // только с атрибутом name
  //     .forEach((el) => data.append(el.name, el.value));
  //
  //   const xhr = new XMLHttpRequest();
  //   xhr.open('POST', `/api`);
  //   xhr.send(data);
  //   form.reset();
  // }

  // {
  //   // Multipart
  //   const data = new FormData(form);
  //   const xhr = new XMLHttpRequest();
  //   xhr.open('POST', `/api`);
  //   xhr.send(data);
  //   form.reset();
  // }

  // {
  //   const data = new Blob(["some data"]);
  //   const xhr = new XMLHttpRequest();
  //   xhr.open('POST', `/api`);
  //   xhr.send(data);
  // }

  // {
  //   const data = JSON.stringify({key: 'value'});
  //   const xhr = new XMLHttpRequest();
  //   xhr.open('POST', `/api`);
  //   xhr.setRequestHeader('Content-Type', 'application/json');
  //   xhr.send(data);
  // }

  {
    // SOP Demo
    const data = JSON.stringify({key: 'value'});
    const xhr = new XMLHttpRequest();
    xhr.open('POST', `http://localhost:9999/api`);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
  }
});

