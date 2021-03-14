let main = {
    init : function () {
        let _this = this;
        // Paging 호출
        $.ajax({
            type: 'GET',
            url: '/totalPage',
            contentType: 'application/json; charset=utf-8',
        }).done(function (data) {
            $('#divBoard').append(`
                <ul class="text-center" id="pageGroup" style="list-style-type: none; margin: 20px auto; font-size: 1.2em; font-weight: bold;"></ul>
            `)
            let lastPage = 5;
            // 총 페이지가 출력페이지보다 적다면, 총 페이지가 출력 페이지
            if(data < lastPage) lastPage = data;
            
            for (let page = 1; page <= lastPage; page++) {
                $('#pageGroup').append(`
                    <li style="display: inline-block; cursor:pointer;">${page}</li>
                `)
            }
        }).fail(function (error) {
            console.log(error)
        })

        // 글 등록 버튼 클릭 시
        $('#btn-save').on('click', function () {
            _this.save();
        });
        // 수정 버튼 클릭 시
        $('.modifyBoard').on('click', function () {
            let thisTr = $(this).parent().parent();
            let thisId = $(thisTr).find('.id')[0].innerText;
            let thisTitle = $(thisTr).find('.title')[0].innerText;
            let thisContent = $(thisTr).find('.content')[0].innerText;
            let thisAuthor = $(thisTr).find('.author')[0].innerText;
            // let thisCreatedDate = $(thisTr).find('.createdDate')[0].innerText;
            // let thisModifiedDate = $(thisTr).find('.modifiedDate')[0].innerText;
            $('#updatePostsModal').on('show.bs.modal',function() {
                $('.modal-body #updateId').val(thisId);
                $('.modal-body #updateTitle').val(thisTitle);
                $('.modal-body #updateAuthor').val(thisAuthor);
                $('.modal-body #updateContent').val(thisContent);
            })
        });

    },
    // 모달창 -> 등록 시
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
function delThisList(thisBtn) {
    let thisTr = $(thisBtn).parent().parent();
    let thisId = $(thisTr).find('.id')[0].innerText;
    let chk = confirm('삭제하시겠습니까?')
    if(chk){
        let data = {
            id : thisId
        }
        $.ajax({
            type: 'DELETE',
            url: '/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (data) {
            if(data === 1){
                alert('삭제되었습니다.')
                location.reload()
            }else{
                alert('실패하였습니다.')
            }
        })
    }
}

function modify() {
    let data = {
        id : $('#updateId').val(),
        title : $('#updateTitle').val(),
        author: $('#updateAuthor').val(),
        content: $('#updateContent').val()
    };
    $.ajax({
        type: 'PATCH',
        url: '/posts',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function (data) {
        if(data === 1){
            alert('수정되었습니다.');
            location.reload();
        }else{
            alert('실패하였습니다.');
        }
    })
}

main.init();