const id = params.get('id')

if (id == null || id == '')
    window.location.href = "./part.html"

const breadcrumb = document.getElementById('breadcrumb')
const pid = document.getElementById('id')
const name = document.getElementById('name')
const fuel_type = document.getElementById('fuel_type')

fetch('http://localhost:8000/part/' + id)
    .then(rsp => {
        if (rsp.status == 200)
            return rsp.json()
        alert('Deo nije pronadjen')
        window.location.href = "./part.html"
    })
    .then(data => {
        pid.value = data.id
        name.value = data.name
        fuel_type.value = data.fuel_type
        breadcrumb.innerText = `${data.name} ${data.fuel_type}`
        document.getElementById('save').addEventListener('click', () => {
            fetch(`http://localhost:8000/part/${data.id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: name.value,
                    fuel_type: fuel_type.value
                }),
            })
                .then(rsp => {
                    if (rsp.ok) {
                        window.location.href = './part.html'
                        return
                    }
                    else
                    alert(`Izmena dela nije uspela(HTTP ${rsp.status})`)
                })
                copy.querySelector('.remove').addEventListener('click', ()=>{
                    if(confirm(`Da li zelita da obrisete deo ${part.name} ${part.fuel_type} `)){
                        fetch(`http://localhost:8000/part/${part.id}`, {
                            method: 'DELETE',
            
                        })
                            .then(rsp => {
                                if (rsp.status == 204) {
                                    window.location.href = './part.html'
                                    return
                                }
                                else
                                alert(`Brisanje dela nije uspelo(HTTP ${rsp.status})`)
                            })
                    }
                })
        })

    })