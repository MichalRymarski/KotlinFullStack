function fetchData(event) {
    console.log(event)
}

/*for (let i = 1; i <= 50; i++) {
    if (characterDiv) {

        let characterDiv = document.getElementById(`characterDiv${i}`);
        characterDiv.addEventListener('htmx:afterOnLoad', function (event) {
            try {
                var data = JSON.parse(event.detail.xhr.responseText);
                var characterImage = document.getElementById(`characterImage${i}`);
                if (characterImage) {
                    characterImage.src = data.image;
                }
            } catch (error) {
                console.error('Error parsing JSON:', error);
            }
        });
    } else {
        console.error(`characterDiv${i} not found`);
    }
}*/

function setupCharacterListener(index) {
    let characterDiv = document.getElementById(`characterDiv${index}`);
    if (characterDiv) {
        characterDiv.addEventListener('htmx:afterOnLoad', function (event) {
            try {
                var data = JSON.parse(event.detail.xhr.responseText);
                var characterImage = document.getElementById(`characterImage${index}`);
                if (characterImage) {
                    characterImage.src = data.image;
                }
            } catch (error) {
                console.error('Error parsing JSON:', error);
            }
        });
    } else {
        console.error(`characterDiv${index} not found`);
    }
}
