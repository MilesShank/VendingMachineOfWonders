import {
  fetchMachineDisplay,
  getCoinReturn,
  acceptCoin,
  fetchProducts,
  dispenseProduct,
  returnCoins,
  emptyCoinReturn,
} from "./apiHelper.js";

const machineDisplay = document.querySelector(".machine-display");
const quarterButton = document.querySelector(".quarter");
const dimeButton = document.querySelector(".dime");
const nickelButton = document.querySelector(".nickel");
const productsList = document.querySelector(".products");
const coinReturn = document.querySelector(".coins");
const coinReturnButton = document.querySelector(".return-coins-button");
const emptyCoinReturnButton = document.querySelector(".empty-coin-return");

const updateDisplay = () => {
  fetchMachineDisplay().then((response) => {
    machineDisplay.innerHTML = response;
  });
};
updateDisplay();

quarterButton.addEventListener("click", () => {
  acceptCoin("Quarter").then(() => {
    updateDisplay();
  });
});

dimeButton.addEventListener("click", () => {
  acceptCoin("Dime").then(() => {
    updateDisplay();
  });
});

nickelButton.addEventListener("click", () => {
  acceptCoin("Nickel").then(() => {
    updateDisplay();
  });
});

fetchProducts().then((products) => {
  products.forEach((product) => {
    const productButton = document.createElement("button");
    productButton.innerText = `${product.name} $${product.price}`;
    productButton.addEventListener("click", () => {
      dispenseProduct(product.name).then(() => {
        updateDisplay();
        updateCoinReturn();
      });
    });
    productsList.appendChild(productButton);
  });
});
const updateCoinReturn = () => {
  getCoinReturn().then((coins) => {
    coinReturn.innerHTML = coins;
  });
};
updateCoinReturn();

coinReturnButton.addEventListener("click", () => {
  returnCoins().then(() => {
    updateDisplay();
    updateCoinReturn();
  });
});

emptyCoinReturnButton.addEventListener("click", () => {
  emptyCoinReturn().then(() => {
    updateDisplay();
    updateCoinReturn();
  });
});
