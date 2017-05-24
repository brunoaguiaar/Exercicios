// 1
function daisyGame(a){
  if (a % 2 == 0){
  return "Love me not"}
  else {return "Love me"}
  // outras formas de fazer:
  //return a % 2 !== 0 ? 'love me' : 'love me not'
  //return `love me${ a % 2 !== 0 ? '' : 'not' }` tem que ser com crase
  //return `love me${ impar ? '' : 'not' }` versao 2015
}

//2
function maiorTexto(texto){
  var maior = texto.length > 0 ? texto[0] : ""
    for(let i=1; i<texto.length; i++){
      if (texto[0].length < texto[i].length)
      maior = texto[i]
    }
  return maior;
  //let é para matar o "i" depois do for;

}

//3
function imprime(textos, funcaoParaExecutar){
  if (typeof funcaoParaExecutar == 'function'){
    textos.forEach(funcaoParaExecutar)
  }
}
imprime(
  // primeiro parâmetro: array
  [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ],
  // segundo parâmetro: função
  function(instrutor) {
   console.log('olá querido instrutor:', instrutor)
  }
)

//4
function adicionar (a){
  return function(b) {
    return a+b;
  }
}

console.log(adicionar(3)(4)); // 7
console.log(adicionar(5642)(8749)); // 14391

//5
// 1+1+2+3+5+8+13
function fibonacci(n){
    if(n === 1 || n ===2){
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}
function fiboSum(n){
  if(n === 1){
    return 1;
  }
  return fibonacci(n) + fiboSum(n - 1);
}

//6

function queroCafe(mascada, precos){
  var precosNoOrcamento = [];
  precos.forEach(p =>{
    if(p <= mascada){
      precosNoOrcamento.push(p);
    }
  });
  precosNoOrcamento.sort( (a,b) => a-b )
  return precosNoOrcamento.toString();
}

queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]);
