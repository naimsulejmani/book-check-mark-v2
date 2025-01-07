class BookApi {

    constructor() {
        this.apiUrl = "/api/v1/books"
    }

    async getBooks() {
        const res = await fetch(this.apiUrl);
        const data = await res.json();
        console.log(data);
        console.log("Loaded successfully");
        return data;
    }

    async getBookById(id) {
        const res = await fetch(`${this.apiUrl}/${id}`);
        const data = await res.json();
        console.log(data);
        console.log("Loaded successfully");
        return data;
    }

    async postBook(book) {
        const res = await fetch(this.apiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(book)
        });
        const data = await res.json();
        console.log(data);
        console.log("Loaded successfully");
        return data;
    }

    async modifyBook(id, book) {
        const res = await fetch(`${this.apiUrl}/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(book)
        });
        const data = await res.json();
        console.log(data);
        console.log("Loaded successfully");
        return data;
    }

    async deleteBookById(id) {
        const res = await fetch(`${this.apiUrl}/${id}`, {
            method: "DELETE"
        });
        const data = await res.text();
        console.log(data);
        console.log("Loaded successfully");
        return data;
    }




    // getBooks() {
    //
    //     fetch(this.apiUrl)
    //         .then((res) => res.json())
    //         .then((data) => {
    //             console.log(data)
    //             console.log("Loaded successfully");
    //         })
    //         .catch((err) => {
    //             alert(err.message);
    //         });

    //
    // }
}

