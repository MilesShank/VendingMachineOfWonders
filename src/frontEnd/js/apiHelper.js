const fetchArtists = async () => {
  return fetch("http://localhost:8080/api/artists/").then((response) =>
    response.json()
  );
};

const fetchMachineDisplay = async () => {
  return fetch("http://localhost:8080/api/vend/machinedisplay").then(response);
};

const fetchProducts = async () => {
  return fetch("http://localhost:8080/api/vend/products").then((response) =>
    response.json()
  );
};
