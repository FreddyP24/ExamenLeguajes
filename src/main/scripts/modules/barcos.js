const API_BARCOS_URL = 'http://localhost:8080/barcos';

function cargarBarcos() {
    fetch(API_BARCOS_URL)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la respuesta del servidor');
            }
            return response.json();
        })
        .then(data => {
            const tbody = document.getElementById('barcos');
            tbody.innerHTML = '';

            data.forEach(barco => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${barco.idBarco}</td>
                    <td>${barco.nombre}</td>
                    <td>${barco.origen}</td>
                    <td>${barco.destino}</td>
                    <td>${barco.capacidad}</td>
                    <td>
                    <button class="btn btn-sm btn-primary me-2" onclick="window.location.href='formularioBarcos.html'">Agregar</button>
                    <button class="btn btn-sm btn-warning me-2" onclick="editarBarco(${barco.idBarco})">Editar</button>
                    <button class="btn btn-sm btn-danger" onclick="eliminarBarco(${barco.idBarco})">Eliminar</button>
                    </td>
                `;
                tbody.appendChild(row);
            });
        })
        .catch(error => console.error('Error al cargar barcos:', error));
}



window.addEventListener('DOMContentLoaded', cargarBarcos);