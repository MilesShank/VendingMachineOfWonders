import {
  fetchMachineDisplay,
  getCoinReturn,
  acceptCoin,
  fetchProducts,
  dispenseProduct,
  returnCoins,
  emptyCoinReturn,
  getProductDisplay,
} from "./apiHelper.js";

const machineDisplay = document.querySelector(".machine-display");
const quarterButton = document.querySelector(".quarter");
const dimeButton = document.querySelector(".dime");
const nickelButton = document.querySelector(".nickel");
const productsList = document.querySelector(".products");
const coinReturn = document.querySelector(".coins");
const coinReturnButton = document.querySelector(".return-coins-button");
const emptyCoinReturnButton = document.querySelector(".empty-coin-return");
const productDisplay = document.querySelector(".product-display-section");
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
    productButton.classList.add("product-button");
    productButton.innerText = `${product.name} $${product.price}`;
    productButton.addEventListener("click", () => {
      dispenseProduct(product.name).then(() => {
        updateProductDisplay();
        updateDisplay();
        updateCoinReturn();
      });
    });
    productsList.appendChild(productButton);
  });
});

const updateProductDisplay = () => {
  productDisplay.innerHTML = "";
  getProductDisplay().then((products) => {
    products.forEach((product) => {
      const productImg = new Image(100);
      productImg.classList.add("product-image");
      switch (product.name) {
        case "Sense of Purpose":
          productImg.src = "images/Asset4.png";
          break;
        case "Antiviral Cola":
          productImg.src = "images/Asset5.png";
          productImg.width = 50;
          break;
        case "Monster Chips":
          productImg.src = "images/Asset6.png";
          break;
        case "Unusually Cold Candy":
          productImg.src = "images/Asset7.png";
          break;
      }
      productDisplay.appendChild(productImg);
    });
  });
};
const updateCoinReturn = () => {
  coinReturn.innerHTML = "";
  getCoinReturn().then((coins) => {
    coins.forEach((coin) => {
      const coinImg = new Image(50, 50);
      coinImg.classList.add("coinImage");
      if (coin === "Quarter") {
        coinImg.src = "images/Asset1.png";
      } else if (coin === "Dime") {
        coinImg.src = "images/Asset2.png";
      } else if (coin === "Nickel") {
        coinImg.src = "images/Asset3.png";
      }
      coinReturn.append(coinImg);
    });
    updateDisplay();
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
    coinReturn.innerHTML = "";
    productDisplay.innerHTML = "";
  });
});
