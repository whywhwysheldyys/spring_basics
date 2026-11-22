document.addEventListener('DOMContentLoaded', () => {
    const API_URL = '/l12/library';
    const form = document.querySelector('.libraryForm');
    const container = document.getElementById('books-container');

    async function loadBooks() {
        try {
            const response = await fetch(API_URL);
            if (!response.ok) throw new Error('Ошибка при загрузке данных');

            const books = await response.json();

            container.innerHTML = '';

            if (books.length === 0) {
                container.innerHTML = '<p style="color: #6b7280;">Пока нет добавленных книг. Создайте первую!</p>';
                return;
            }

            books.forEach(book => {
                const card = document.createElement('div');
                card.className = 'book-card';

                card.innerHTML = `
                    <h3>${book.title}</h3>
                    <p><b>Автор:</b> ${book.author}</p>
                    <p><b>Жанр:</b> ${book.genre}</p>
                    <p><b>Страниц:</b> ${book.pages}</p>
                    <p><b>Статус:</b> ${book.status ? '✅ Прочитано' : '⏳ В планах'}</p>  
                `;

                container.appendChild(card);
            });
        } catch (error) {
            console.error('Ошибка:', error);
        }
    }

    form.addEventListener('submit', async(e) => {
        e.preventDefault();

        const newBook = {
            title: document.getElementById('title').value,
            author: document.getElementById('author').value,
            genre: document.getElementById('genre').value,
            pages: parseInt(document.getElementById('pages').value) || 0,
            status: document.getElementById('status').checked
        };

        try {
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newBook)
            });

            if (response.ok) {
                form.reset();
                loadBooks();
            } else {
                alert('Не удалось сохранить книгу на сервере.');
            }
        } catch (error) {
            console.error('Ошибка отправки', error);
        }
    });

    loadBooks();

});