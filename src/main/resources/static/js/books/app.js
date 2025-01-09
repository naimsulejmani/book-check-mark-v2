class BookApp {
    constructor() {
        // this.titleInput = document.getElementById('title');
        // this.showAlertButton = document.getElementById('showAlert');
        this.bookTableTBody = document.getElementById("bookTable");
        this.loaderDiv = document.getElementById("loader");
        this.mainTable = document.getElementById("mainTable");
        this.body = document.querySelector("body");
        this.btnRefresh = document.getElementById("btnRefresh");
        this.bookApi = new BookApi();
    }

    async init() {
        // this.titleInput.focus();

        // this.showAlertButton.addEventListener('click', () => {
        //     alert(this.titleInput.value);
        // });

        this.btnRefresh.addEventListener('click', () => {
            this.loadBooks();
        })

        await this.loadBooks();

        this.bookTableTBody.addEventListener('click', async (event) => {
            console.log(event);
            console.log(event.target);
            if (event.target.textContent === "DELETE") {
                if (!confirm(`Are you sure you want to delete book with id ${event.target.dataset.id}?`)) {
                    return;
                }
                // const bookId = event.target.parentElement.parentElement.firstElementChild.textContent;
                console.log(event.target.dataset)
                await this.bookApi.deleteBookById(event.target.dataset.id);
                await this.loadBooks();
                //toast message
            }
        });
    }

    async loadBooks() {
        this.mainTable.style = "display:none";
        this.loaderDiv.style = "display:block";

        const books = await this.bookApi.getBooks();

        this.bookTableTBody.innerHTML = "";
        for (let book of books) {
            this.bookTableTBody.innerHTML += `
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.publishedYear}</td>
                    <td>${book.pages}</td>    
                    <td>
                        <button class="btn btn-danger" type="button" data-id="${book.id}"
                        data-title="${book.title}">DELETE</button>
                    </td>
                </tr>`;
        }
        this.loaderDiv.style = "display:none";
        this.mainTable.style = "display:block";

    }
}


new BookApp().init();
