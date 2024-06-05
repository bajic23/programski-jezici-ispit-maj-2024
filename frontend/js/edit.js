const id = params.get('id')

if (id == null || id == '')
    window.location.href = "./ispit.html"

const breadcrumb = document.getElementById('breadcrumb')
const cid = document.getElementById('id')
const manufacturer = document.getElementById('manufacturer')
const model = document.getElementById('model')
const release_year = document.getElementById('release_year')
const part = document.getElementById('part')

fetch('http://localhost:8000/part')
.then(rsp => rsp.json())
.then(data => {
    data.foreach(part => {
        const option = document.createElement('option')
        option.value=part.id
        option.text = part.name
        part.appendChild(option)
    })
})

fetch('http://localhost:8000/car/' + id)
    .then(rsp => {
        if (rsp.status == 200)
            return rsp.json()
        alert('Automobil nije pronadjen')
        window.location.href = "./ispit.html"
    })
    .then(data => {
        cid.value = data.id
        manufacturer.value = data.car_manufacturer
        model.value = data.car_model
        release_year.value = data.car_release_year
        breadcrumb.innerText = `${data.car_manufacturer} ${data.car_model} ${data.car_release_year}`
        document.getElementById('save').addEventListener('click', () => {
            fetch(`http://localhost:8000/car/${data.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    manufacturer: manufacturer.value,
                    model: model.value,
                    release_year: release_year.value
                }),
            })
                .then(rsp => {
                    if (rsp.ok) {
                        window.location.href = './ispit.html'
                        return
                    }
                    else
                    alert(`Izmena automobila nije uspela(HTTP ${rsp.status})`)
                })
        })

    })