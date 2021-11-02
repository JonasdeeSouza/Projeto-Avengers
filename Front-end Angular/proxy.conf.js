const BASE_API_TARGET = 'http://localhost:8080';

const APIS = [
  '/Herois',
  '/Filmes',
  '/HeroisEFilmes'
];

const proxy = [
  {
    context: APIS,
    target: BASE_API_TARGET,
    changeOringin: true
  }
];

module.exports = proxy;
