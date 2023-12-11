// Obtener la referencia a la tabla
    const tabla = document.getElementById('tablaAuto').getElementsByTagName('tbody')[0];

    // Realizar una petición a la API
    fetch('http://localhost:8081/carro')
      .then(response => response.json())
      .then(data => {
        // Iterar a través de los datos y agregar filas a la tabla
        data.forEach(carro => {
          const fila = tabla.insertRow();

          // Crear celdas para cada dato del carro
          const celdaPlaca = fila.insertCell(0);
          const celdaColor = fila.insertCell(1);
          const celdaMarca = fila.insertCell(2);
          const celdaModelo = fila.insertCell(3);
          const celdaCilindraje = fila.insertCell(4);
          
          // Llenar las celdas con los datos del carro
          celdaPlaca.textContent = carro.placa;
          celdaColor.textContent = carro.color;
          celdaMarca.textContent = carro.marca;
          celdaModelo.textContent = carro.modelo;
          celdaCilindraje.textContent = carro.cilindraje;
          // Agrega más celdas si la API proporciona más datos
        });
      })
      .catch(error => {
        console.error('Ha ocurrido un error al obtener los datos:', error);
      });