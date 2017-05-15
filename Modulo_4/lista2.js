// exercicio 1
function seriesInvalidas(series){
  invalidas = new Array;
  var date = new Date();
  for (let i=0; i<series.length; i++){
    if(series[i].anoEstreia > date.getFullYear() ||
    Object.values(series[i]) === "undefined" ||
    Object.values(series[i]) === "null"){
      invalidas.push(series[i].titulo);
    }
  }
  return invalidas.toString();
}


//exercicio 2
function filtrarSeriesPorAno(series, ano){
  var seriesRetornadas = new Array;
  for (let i=0; i<series.length; i++){
    if(series[i].anoEstreia >= ano){
      seriesRetornadas.push(series[i].titulo);
    }
  }
  return seriesRetornadas;
}


// exercicio 3
function mediaDeEpisodios(series){
  var media = 0;
  for (let i=0; i<series.length; i++){
    media = media + series[i].numeroEpisodios;
  }
  media = media/series.length;
  return media;
}


// exercicio 4
function procurarPorNome(series, nome){
  var nomeRetornado = false;
  for (let i=0; i<series.length; i++){
    for (let j=0; j<series[i].elenco.length; j++){
      if(series[i].elenco[j].match(nome)){
        nomeRetornado = true;
      }
    }
  }
  return nomeRetornado
}


// exercicio 5
function mascadaEmSerie(series){
  var diretor = 100000 * series.diretor.length;
  var elenco = 40000 * series.elenco.length;
  var total = diretor + elenco;
  return total;
}


// exercicio 6
function queroGenero(genero){
  seriesGenero = new Array;
  for (let i=0; i<series.length; i++){
    for (let j=0; j<series[i].genero.length; j++){
      if(series[i].genero[j].match(genero)){
        seriesGenero.push(series[i].titulo)
      }
    }
  }
  return seriesGenero;
}

function queroTitulo(titulo){
  seriesTitulo = new Array;
  for (let i=0; i<series.length; i++){
    if(series[i].titulo.match(titulo)){
      seriesTitulo.push(series[i].titulo)
    }
  }
  return seriesTitulo;
}













//
