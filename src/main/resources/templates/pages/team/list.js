
function createSelectOptions(data) {
    // 检查 data 是否有 list 属性，并且它是一个数组
    if (!data.list || !Array.isArray(data.list)) {
        return '';
    }

    // 开始构建 HTML 字符串
    var optionsHtml = '';

    // 遍历 list 数组
    data.list.forEach(function(course) {
        // 对于每个课程，添加一个 <option> 标签
        optionsHtml += '<option value="' + course.course_ID + '">' + course.course_name + '</option>';
    });

    return optionsHtml;
}

// main.js
document.addEventListener('DOMContentLoaded', function () {
    // var data = {/* ... 数据 ... */};
    var selectHtml = createSelectOptions(data);
    document.getElementById('layerContent').innerHTML = selectHtml;
});