function fetchData(event) {
    console.log(event)
}

function swapImageFromJson(url, imgId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const imgElement = document.getElementById(imgId);
            if (imgElement && data.image) {
                imgElement.src = data.image;
            }
        })
        .catch(error => console.error('Error:', error));
}

function navigateTo(link) {
    window.location.href = link;
}

function addTransitionEffect(id) {
    var element = document.getElementById(id);
    element.classList.add("transition-effect");
    element.addEventListener('transitionend', function() {
        element.classList.remove("transition-effect");
    });
}