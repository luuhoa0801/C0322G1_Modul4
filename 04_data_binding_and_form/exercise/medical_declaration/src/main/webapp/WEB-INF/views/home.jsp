<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="addMedical" modelAttribute="medical">
    <div style="display: flex;flex-direction: column; justify-items: center;align-items: center;margin-bottom: 2rem">
        <h1 style="margin: 0;margin-bottom: 1rem "> Tờ khai y tế </h1>
        <h3 style="margin: 0;margin-bottom: 1rem "> Đây là tài liệu quan trọng, thông tin của anh/chị sẽ giúp cơ quan y
            tế liên hệ khi cần
            thiết để
            phòng chống dịch bệnh truyền nhiễm
        </h3>
        <h3 style="margin: 0;margin-bottom: 1rem;color: red "> Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật
            Việt Nam và có thể xử lý hình
            sự</h3>
    </div>
    <div style="display: flex;flex-direction: column;margin-bottom: 2rem">
        <label> Họ tên </label>
        <form:input path="name" cssStyle="width: 60%"></form:input>
    </div>
    <div style="display: flex;margin-bottom: 2rem;gap: 2rem">
        <div>
            <label>Năm sinh </label>
            <form:select path="age">
                <form:options items="${listYear}"></form:options>
            </form:select>
        </div>
        <div>
            <label> Giới tính </label>
            <form:select path="gender">
                <form:options items="${listGender}"></form:options>
            </form:select>
        </div>
        <div>
            <label> Quốc tịch </label>
            <form:select path="languages">
                <form:options items="${listLanguages}"></form:options>
            </form:select>
        </div>
    </div>
    <div style="margin-bottom: 2rem;display: flex;flex-direction: column ">
        <label> Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác </label>
        <form:input path="idCard" cssStyle="width: 60%"></form:input>
    </div>
    <div style="margin-bottom: 2rem">
        <label> Thông tin đi lại: </label>
        <form:radiobutton path="travel" value="Tàu bay"></form:radiobutton> Tàu bay
        <form:radiobutton path="travel" value="Tàu thuyền"></form:radiobutton> Tàu thuyền
        <form:radiobutton path="travel" value="Ô tô"></form:radiobutton> Ô tô
        <form:radiobutton path="travel" value="Khác"></form:radiobutton> Khác (Ghi rõ)
    </div>
    <div style="margin-bottom: 2rem">
        <div>
            <label> Số hiệu phương tiện </label>
            <form:input path="vehicleNumber"></form:input>
        </div>
        <div>
            <label> Số ghế</label>
            <form:input path="callNumber"></form:input>
        </div>
    </div>
    <div style="margin-bottom: 2rem">
        <div>
            <label> Ngày khởi hành</label>
            <form:input path="startDay" type="date"></form:input>
        </div>
        <div>
            <label> Ngày kêt thúc</label>
            <form:input path="endDate" type="date"></form:input>
        </div>
    </div>
    <div style="margin-bottom: 2rem">
        <label> Trong 14 ngày anh/chị có đi đến tỉnh/thành phố nào không?</label>
        <form:input path="status"></form:input>
    </div>
    <button value="submit">Gửi</button>
</form:form>
</body>
</html>
