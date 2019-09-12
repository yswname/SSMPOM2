<html>
<head>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function toSend() {
            var _oJson = {"name": "zhangsan", "age": 12, "userName": "zzzzz"};
            var _data = JSON.stringify(_oJson);
            alert(typeof (_data));
            $.ajax({
                type: 'post',
                url: 'request/req7',
                data: _data,
                contentType: 'application/json',
                success: function (msg) {
                    // alert(msg)
                }
            });
        }

        function toSend2() {
            var _oJson = {"name": "zhangsan", "age": 12, "userName": "zzzzz"};
            var _data = JSON.stringify(_oJson);
            //alert(typeof (_data));
            $.ajax({
                type: 'post',
                url: 'res/test8',
                data: _data,
                contentType: 'application/json',
                dataType: "json",
                success: function (msg) {
                    //alert(msg)
                    alert(msg.name + "," + msg.age + "," + msg.userName);
                }
            });
        }
    </script>
</head>
<body>
<input type="button" onclick="toSend()" value="Test ToSend"/><br/>
<input type="button" onclick="toSend2()" value="Test ToSend2"/>
<h2>Hello World!</h2>
<form action="mapping/test3" method="post">
    <input type="submit" value="submit"/>
</form>
</body>
</html>
