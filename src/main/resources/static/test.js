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
    let element = document.getElementById(id);
    element.classList.add("transition-effect");
    element.addEventListener('transitionend', function() {
        element.classList.remove("transition-effect");
    });
}

function toggleCheckbox(id,event) {
    let element = document.getElementById(id);
    if (event.target !== element) {
        element.checked = !element.checked;
    }
    event.preventDefault();
    event.stopPropagation();
}

function toggleDropdown() {
    let dropdownContent = document.getElementById("dropdownContent");
    let dropdownIcon = document.getElementById("dropdownIcon");
    dropdownContent.classList.toggle("hidden");
    if (dropdownIcon.textContent === "▼") {
        dropdownIcon.textContent = "▲";
    } else {
        dropdownIcon.textContent = "▼";
    }
}