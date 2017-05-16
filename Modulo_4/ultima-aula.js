Number.prototype.arredondar = function(casasDecimais = 2) {
  //casasDecimais = casasDecimais || 2;
  //return parseFloat(this.toFixed(2));
  let casas = Math.pow(10, casasDecimais);
  return Math.round(this * casas) / casas;
}


function Jedi() {
  this.nome = "Luke";
  this.ligarSabre = function() {
    //let self = this;
    //setInterval(function(){
    //console.log("Uóóóóóm", this.nome)
    //}.bind(this), 2000)
    setInterval(() =>{
      console.log("Uóóóóóm", this.nome);
    }, 2000)
  }
  console.log(this);
}
