const manufacturer = document.getElementById('manufacturer')
const model = document.getElementById('model')
const release_year = document.getElementById('release_year')
const parts = document.getElementById('part')

fetch('http://localhost:8000/part')
.then(rsp => rsp.json())
.then(partData => {
    partData.forEach(part => {
        const option = document.createElement('option')
        option.value = part.id
        option.text = part.name

        parts.appendChild(option)
    })
    document.getElementById('save').addEventListener('click', () => {
        if (manufacturer.value == null || manufacturer.value == '') {
            alert('Nijedno polje ne sme biti prazno')
            return
        }
        if (model.value == null || model.value == '') {
            alert('Nijedno polje ne sme biti prazno')
            return
        }
        if (release_year.value == null || release_year.value == '') {
            alert('Nijedno polje ne sme biti prazno')
            return
        }
    
        fetch('http://localhost:8000/car', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                manufacturer: manufacturer.value,
                model: model.value,
                release_year: release_year.value,
                partId: parts.value
            }),
        }).then(rsp => {
                    if (rsp.ok) {
                        window.location.href = './ispit.html'
                        return
                    }
                    else
                        alert(`Dodavanje automobila nije uspelo(HTTP ${rsp.status})`)
                })
        })
    
})


