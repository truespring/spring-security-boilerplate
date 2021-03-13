let main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        let data = {
            title : $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            if(data === 1){
                alert('등록되었습니다');
                location.reload();
            }else{
                alert('등록이 실패하였습니다.');
            }
        }).fail(function (error) {
            console.log(error)
            alert("error");
        });
    }
};

main.init();