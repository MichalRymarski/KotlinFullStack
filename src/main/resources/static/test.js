function fetchData(event) {
    console.log(event)
}

for (let i = 1; i <= 50; i++) {
    let characterDiv = document.getElementById(`characterDiv${i}`);

    if (characterDiv) {
        characterDiv.addEventListener('htmx:afterOnLoad', function (event) {
            console.log(`htmx:afterOnLoad event fired for character ${i}`);
            console.log('Response:', event.detail.xhr.responseText);
            try {
                var data = JSON.parse(event.detail.xhr.responseText);
                console.log('Parsed data:', data);
                var characterImage = document.getElementById(`characterImage${i}`);
                console.log(`characterImage${i}:`, characterImage);
                if (characterImage) {
                    characterImage.src = data.image;
                } else {
                    console.error(`characterImage${i} element not found`);
                }
            } catch (error) {
                console.error('Error parsing JSON:', error);
            }
        });
    } else {
        console.error(`characterDiv${i} not found`);
    }
}
