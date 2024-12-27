class BookApi {
    constructor() {
        this.apiUrl = "/api/v1/books"
    }

    getBooks() {

        fetch(this.apiUrl)
            .then((res) => res.json())
            .then((data) => {
                console.log(data)
            })
            .catch((err) => {
                alert(err.message);
            })
        //async..await
        //Promise
        //Callback
    }
}

