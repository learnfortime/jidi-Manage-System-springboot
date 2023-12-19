function updateCourse(){

    event.preventDefault();
    // 获取表单数据
    var courseData = {
        course_ID: $('input[name="course_ID"]').val(),
        course_name: $('input[name="course_name"]').val(),
        course_description: $('input[name="course_description"]').val(),
        course_content: $('textarea[name="course_content"]').val()
    };

    // AJAX 请求
    $.ajax({
        url: '/course/update', // 服务器端更新数据的 URL
        type: 'POST', // 请求类型，根据后端要求可能是 'POST' 或 'PUT'
        contentType: 'application/json', // 发送数据的格式
        data: JSON.stringify(courseData), // 将数据转换为 JSON 字符串

        beforeSend: function(xhr) {
            // 在发送请求之前设置 Authorization 头部
            var token = window.localStorage.getItem("token"); // 假设令牌存储在浏览器的本地存储中
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        },
        success: function(response) {
            // 处理成功响应
            console.log('更新成功', response);
            alert("course update successfully!")
            layer.closeAll(); // 关闭所有弹出层
            // 可能还需要重新加载表格数据等
            window.location.reload()
        },
        error: function(xhr, status, error) {
            // 处理错误响应
            console.error('更新失败', error);
        }
    });
}

function addCourse() {
    // 阻止表单默认提交行为
    event.preventDefault();
    let course_ID = $('input[name="course_ID"]').val()
    // 序列化表单数据
    var formData = $('#addForm').serialize();

    // AJAX 请求
    $.ajax({
        url: '/course/insert/', // 服务器端添加数据的 URL
        type: 'POST', // 请求类型
        data: formData, // 序列化的表单数据
        beforeSend: function(xhr) {
            // 在发送请求之前设置 Authorization 头部
            var token = window.localStorage.getItem("token"); // 假设令牌存储在浏览器的本地存储中
            xhr.setRequestHeader("Authorization", "Bearer " + token);
        },
        success: function(response) {
            // 处理成功响应
            console.log('添加成功', response);
            alert("course add successfully!")
            layer.closeAll(); // 关闭弹出层
            // 可能还需要刷新表格或执行其他更新
            window.location.reload()
        },
        error: function(xhr, status, error) {
            // 处理错误响应
            console.error('添加失败', error);
            alert("添加失败，添加的课程"+course_ID+"  ID 已存在")
        }
    });
}