
function createSelectOptions(data) {
    // 创建一个 select 元素
    var select = document.createElement('select');
    select.setAttribute('id', 'courseSelect');  // 设置 ID 或其他属性
    select.setAttribute('name', 'course_ID');      // 设置 name

    // 检查 data 是否有 list 属性，并且它是一个数组
    if (data && Array.isArray(data.list)) {
        data.list.forEach(function(course) {
            // 对于每个课程，创建一个 <option> 元素
            var option = document.createElement('option');
            option.value = course.course_ID;
            option.textContent = course.course_name;

            // 将 <option> 元素添加到 <select> 元素中
            select.appendChild(option);
        });
    } else {
        console.log('data.list is not an array or is empty.');
    }
    return select;
}

// main.js
document.addEventListener('DOMContentLoaded', function () {
    // var data = {/* ... 数据 ... */};
    var selectHtml = createSelectOptions(data);
    document.getElementById('layerContent').innerHTML = selectHtml;
});

// document.getElementById('submitBtn').addEventListener('click', function() {
//     alert(111)
//     var course_ID = document.getElementById('course_ID').value;
//     sumbitCourse(data.teacher_id,course_ID);
// });

function sumbitCourse(teacher_id,course_ID){
    console.log("提交的教师ID是: " + teacher_id + ", 课程ID是: " + course_ID);

    // 创建 XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();

    var token = localStorage.getItem('token');
    // 设置请求的类型和 URL
    xhr.open('POST', '/teacher/addCourse', true);

    // 设置发送数据的格式
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    // 如果有 token，则在请求头中添加
    xhr.setRequestHeader("Authorization", "Bearer " + token);

    // 定义当请求完成且响应已就绪时要运行的函数
    xhr.onreadystatechange = function() {
        // 检查请求的状态是否为 '完成' 且 '成功'
        if (xhr.readyState == 4 && xhr.status == 200) {
            // 这里处理服务器的响应
            console.log(xhr.responseText);
        }
    };

    // 准备要发送的数据
    var data = 'teacher_id=' + encodeURIComponent(teacher_id) + '&course_ID=' + encodeURIComponent(course_ID);

    // 发送请求，带上 teacher_id 和 course_ID
    xhr.send(data);

    window.location.reload();
}