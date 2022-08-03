$(document).ready(function () {
    debugger
    $("#createCustomer").on("click", function (event) {
        let id = $('#id').val();
        let name = $('#nameCustomer').val();
        let birthday = $('#birthday').val();
        let gender = $('#gender').val();
        let id_card = $('#id_card').val();
        let phone = $('#phone').val();
        let email = $('#email').val();
        let address = $('#address').val();
        let idCustomerType = $('#customerType').val();
        let newCustomer = {
            id: id,
            name: name,
            birthday: birthday,
            gender: +gender,
            id_card: id_card,
            phone: phone,
            email: email,
            address: address,
            status: 0,
            customerType: {
                id: +idCustomerType
            }
        };
        $.ajax({
            headers: {
                "Content-Type": "application/json",
                "accept": "application/json"
            },
            type: "POST",
            url: `/customerRest/add`,
            data: JSON.stringify(newCustomer),
            success:successHandler ,

            error: function (){
                alert(" them that bai")
            }
        });
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
})

function successHandler() {
    console.log()
    debugger
    $.ajax({
        type: "GET",
        url: "/customerRest/list",
        success: function (data) {
            // hien thi danh sach o day
            let content = ' <thead>\n' +
                '    <tr>\n' +
                '        <th>ID</th>\n' +
                '        <th>Name</th>\n' +
                '        <th>BirthDay</th>\n' +
                '        <th>Gender</th>\n' +
                '        <th>IdCard</th>\n' +
                '        <th>Phone</th>\n' +
                '        <th>Email</th>\n' +
                '        <th>Address</th>\n' +
                '        <th>status</th>\n' +
                '        <th>CustomerType</th>\n' +
                '        <th>Chỉnh sửa</th>\n' +
                '    </tr>\n' +
                '    </thead>\n' +
                '    <tbody>';
            for (let i = 0; i < data.content.length; i++) {
                content += getCustomer(data.content[i]);
            }
            content += `</tbody>`;
            document.getElementById('tableCustomer').innerHTML = content;
        }
    });
}

function getCustomer(customer) {
    return `
        <tr>
        <td> ${customer.id}</td>
        <td> ${customer.name}</td>
        <td> ${customer.birthday }</td>
        <td> ${customer.gender }</td>
        <td> ${customer.id_card }</td>
        <td> ${customer.phone }</td>
        <td> ${customer.email }</td>
        <td> ${customer.address }</td>
        <td> ${customer.status }</td>
        <td> ${customer.customerType.name }</td>
</tr>
    `;
}
$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    $("#buttonSearch").on("click",".search", function (event) {
        debugger
        let name = $('#nameSearch').val();
        $.ajax({
            type: "GET",
            url: `/customerRest/search/${name}`,
            success: function (data) {
                console.log(data)
                // hien thi danh sach o day
                let content = ``;
                for (let i = 0; i < data.length; i++) {
                    content += getCustomer(data[i]);
                }
                console.log(content)
                document.getElementById('tableCustomer').innerHTML = content;
            },
            error: function () {
                alert('Khong tim thay doi tuong')
            }
        });
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
});


