function definirPage(event) {
    const page = event.target.value;
    const buttonsAction = document.querySelectorAll("a");
    buttonsAction.forEach(function(buttonAction) {
        let href = buttonAction.getAttribute("href");
        let url = href.split("?")[0];
        url += `?page=${page}`;
        buttonAction.setAttribute("href", url);
    });
}

const page = document.querySelector("#page");
page.addEventListener("change", definirPage);