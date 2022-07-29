$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    $("#buttonSearch").on("click", function (event) {
        //lay du lieu
        let title = $('#title').val();
        $.ajax({
            type: "GET",
            //tên API
            url: `/blog/search/${title}`,
            //xử lý khi thành công
            success: function (data) {
                console.log(data);
                debugger
                // hien thi danh sach o day
                let content = `<thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>CreateDay</th>
                        <th>StatusDelete</th>
                        <th>Category</th>
                        <th>Edit</th>
                        <th>Delete</th>
                        <th>View</th>
                    </tr>
                    </thead>
                    <tbody>`;
                for (let i = 0; i <data.length ; i++) {
                    content += getSearchBlog(data[i]);
                }

                content += `</tbody>`;
                document.getElementById('blogs').innerHTML = content;
            },

            error : function () {
                alert('Khong tim thay doi tuong')
            }
        });

        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
})

function getSearchBlog(blog){
 return ` 
    <tr>
    <td> ${blog.id}</td>
    <td> ${blog.title}</td>
    <td> ${blog.createDay}</td>
    <td> ${blog.statusDelete}</td>
    <td> ${blog.category.content}</td>
</tr>`
}