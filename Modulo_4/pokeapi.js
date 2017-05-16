// let urls = [
//   "http://pokeapi.co/api/v2/pokemon/99/",
//   "http://pokeapi.co/api/v2/pokemon/6/",
//   "http://pokeapi.co/api/v2/pokemon/7/"
// ]
// urls.forEach(url => {
//   fetch(url)
//     .then(response => response.json())
//     .then(json => {
//       console.log(json);
//       console.log(json.sprites.front_default);
//       let div = document.getElementById('detalhesPokemon');
//       let img = document.createElement('img');
//       img.src = json.sprites.front_default;
//       div.append(img);
//     })
// })




document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    console.log("clicou...");
  }
})
