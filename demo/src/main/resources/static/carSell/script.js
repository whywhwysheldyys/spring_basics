const API_URL = '/l10/cars';

async function loadCars() {
    try {
        const response = await fetch(API_URL);
        const cars = await response.json();

        const listDiv = document.getElementById('carList');
        listDiv.innerHTML = '';

        if (cars.length === 0) {
            listDiv.innerHTML = '<p>Список машин пуст.</p>';
            return;
        }

        cars.forEach(car => {
            listDiv.innerHTML += `
                <div class="car-card">
                    <div>
                        <strong>${car.brand} ${car.model}</strong><br>
                        Цена: ${car.price} $
                    </div>
                   <button class="delete-btn" onclick="deleteCar(${car.id})">Удалить</button>
                </div>
            `;
        });
    } catch (error) {
        console.error('Ошибка при загрузке машин: ', error);
    }
}

document.getElementById('carForm').addEventListener('submit', async(e) => {
    e.preventDefault();

    const carData = {
        brand: document.getElementById('brand').value,
        model: document.getElementById('model').value,
        price: parseFloat(document.getElementById('price').value)
    };

    await fetch(API_URL, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(carData)
    });

    document.getElementById('carForm').reset();
    loadCars();
});

async function deleteCar(id) {
    await fetch(`${API_URL}/${id}`, {
        method: `DELETE`
    });
    loadCars();
}

loadCars();