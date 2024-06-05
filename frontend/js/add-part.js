const name = document.getElementById('name')
const fuel_type = document.getElementById('fuel_type')



document.getElementById('save').addEventListener('click', () => {
    if (name.value == null || name.value == '') {
        alert('Nijedno polje ne sme biti prazno')
        return
    }
    if (fuel_type.value == null || fuel_type.value == '') {
        alert('Nijedno polje ne sme biti prazno')
        return
    }
    fetch('http://localhost:8000/part', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: name.value,
            fuel_type: fuel_type.value
        }),
    }).then(rsp => {
        if (rsp.ok) {
            window.location.href = './part.html'
            return
        }
        else
            alert(`Dodavanje dela nije uspelo(HTTP ${rsp.status})`)
    })
})
