class BookApp {
    constructor() {
        this.titleInput = document.getElementById('title');
        this.showAlertButton = document.getElementById('showAlert');
        this.bookApi = new BookApi();
    }

    init() {
        this.titleInput.focus();

        this.showAlertButton.addEventListener('click', () => {
            alert(this.titleInput.value);
        });

        this.bookApi.getBooks();
    }
}


new BookApp().init();
