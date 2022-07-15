<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Họ tên :</td>
        <td>${medical.name}</td>
    </tr>
    <tr>
        <td>Năm sinh :</td>
        <td>${medical.age}</td>
    </tr>
    <tr>
        <td>Giới tính :</td>
        <td>${medical.gender}</td>
    </tr>
    <tr>
        <td>Quốc tịch :</td>
        <td>${medical.languages}</td>
    </tr>
    <tr>
        <td>CMND :</td>
        <td>${medical.idCard}</td>
    </tr>
    <tr>
        <td>Thông tin đi lại :</td>
        <td>${medical.travel}</td>
    </tr>
    <tr>
        <td>Số hiệu phương tiện :</td>
        <td>${medical.vehicleNumber}</td>
    </tr>
    <tr>
        <td>Số ghế :</td>
        <td>${medical.callNumber}</td>
    </tr>
    <tr>
        <td>ngày khởi hành :</td>
        <td>${medical.startDay}</td>
    </tr>
    <tr>
        <td>Ngày kết thúc :</td>
        <td>${medical.endDate}</td>
    </tr>
    <tr>
        <td>Trong vòng 14 ngày có đi đâu không :</td>
        <td>${medical.status}</td>
    </tr>

</table>
</body>
</html>
