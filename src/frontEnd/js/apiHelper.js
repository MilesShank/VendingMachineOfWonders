export {
  fetchMachineDisplay,
  fetchProducts,
  acceptCoin,
  dispenseProduct,
  returnCoins,
  getCoinReturn,
  emptyCoinReturn,
};

const fetchMachineDisplay = async () => {
  return fetch(
    "http://localhost:8080/api/vend/machinedisplay"
  ).then((response) => response.text());
};

const fetchProducts = async () => {
  return fetch("http://localhost:8080/api/vend/products").then((response) =>
    response.json()
  );
};

const acceptCoin = async (coin) => {
  return fetch(`http://localhost:8080/api/vend/acceptcoin/${coin}`);
};

const dispenseProduct = async (productName) => {
  return fetch(`http://localhost:8080/api/vend/dispenseproduct/${productName}`);
};

const returnCoins = async () => {
  return fetch(`http://localhost:8080/api/vend/returncoins`);
};

const getCoinReturn = async () => {
  return fetch(
    `http://localhost:8080/api/vend/getcoinreturn`
  ).then((response) => response.json());
};

const emptyCoinReturn = async () => {
  return fetch(`http://localhost:8080/api/vend/emptycoinreturn`);
};
