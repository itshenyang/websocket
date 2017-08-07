<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/1
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="js/jquery.js"></script>
<script>
    $('.image').change(function(e) {
        var target = $(e.target);
        var file;
        if(target[0].files && target[0].files[0] ) {
            file = target[0].files[0];
        }
        if(file) {
            var reader = new FileReader();
            reader.onload = function(evt){
                var imgstr = evt.target.result; //这就是base64字符串
                aler("base64:"+imgstr);
            };
            reader.readAsDataURL(file);
        }
    });
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="postForm" action= "uploadBack.jsp" method= "post">
    <ul>
        <li>
            <span>img:</span>
            <input id="img" name="img" type="file" accept=".jpg">
        </li>
        <li>
            <a href="javascript:void(0);">提交</a>
            <button type="submit">tijiao</button>
        </li>
    </ul>
</form>
</body>
</html>
