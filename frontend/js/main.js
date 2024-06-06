const table = document.getElementById('table')
const template = document.getElementById('car')

if (searchParam != null && searchParam != '') {
    fetch('http://localhost:8000/car/' + searchParam)
        .then(rsp => {
            if (rsp.status == 200)
                return rsp.json()
            alert('Automobil nije pronadjen')
            window.location.href = "./ispit.html"
        })
        .then(data => {
            createCarTableRow(data)
        })

}
else {

    fetch('http://localhost:8000/car')
        .then(rsp => rsp.json())
        .then(data => {
            data.forEach(car => {
                createCarTableRow(car)
            });
        })
}
function createCarTableRow(car) {
    const copy = template.content.cloneNode(true)
    copy.querySelector('.id').innerText = car.id
    copy.querySelector('.manufacturer').innerText = car.car_manufacturer
    copy.querySelector('.model').innerText = car.car_model
    copy.querySelector('.part').innerText = car.part.name
    copy.querySelector('.release_year').innerText = car.car_release_year
    copy.querySelector('.updated').innerText = formatDate(car.updatedAt)
    copy.querySelector('.edit').href = `./edit.html?id=${car.id}`
    copy.querySelector('.remove').addEventListener('click', ()=>{
        if(confirm(`Da li zelita da obrisete automobil ${car.car_manufacturer} ${car.car_model} ${car.car_release_year}`)){
            fetch(`http://localhost:8000/car/${car.id}`, {
                method: 'DELETE',

            })
                .then(rsp => {
                    if (rsp.status == 204) {
                        window.location.href = './ispit.html'
                        return
                    }
                    else
                    alert(`Brisanje automobila nije uspelo(HTTP ${rsp.status})`)
                })
        }
    })
    table.appendChild(copy)
}
function formatDate(iso) {
    if (iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS')
}
