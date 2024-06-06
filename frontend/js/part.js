const table = document.getElementById('partTable')
const template = document.getElementById('part')

fetch('http://localhost:8000/part')
    .then(rsp => rsp.json())
    .then(data => {
        data.forEach(part => {
            createPartTableRow(part)
        });
    })

function createPartTableRow(part) {
    const copy = template.content.cloneNode(true)
    copy.querySelector('.id').innerText = part.id
    copy.querySelector('.name').innerText = part.name
    copy.querySelector('.fuel_type').innerText = part.fuel_type
    copy.querySelector('.edit').href = `./edit-part.html?id=${part.id}`
    copy.querySelector('.remove').addEventListener('click', () => {
        if (confirm(`Da li zelita da obrisete deo ${part.name} ${part.fuel_type}`)) {
            fetch(`http://localhost:8000/part/${part.id}`, {
                method: 'DELETE'
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
        table.appendChild(copy)

    }

