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
                <div class="page-wrapper text-center">
                    <span class="material-icons" style="position: relative; font-size: 2em; top: 8px; cursor: pointer;" onclick="paging(this)">chevron_left</span>
                    <ul class="text-center" id="pageGroup" style="list-style-type: none; margin: 20px auto; font-size: 1.2em; font-weight: bold; display: inline-block; padding: 0;"></ul>
                    <span class="material-icons" style="position: relative; font-size: 2em; top: 8px; cursor: pointer;" onclick="paging(this)">chevron_right</span>
                </div>
            `)

            // 총 페이지가 출력페이지보다 적다면, 총 페이지가 출력 페이지
            if(data < printEndPage) printEndPage = data;
            if(data > 1){
                endPage = parseInt(data)
                startPage = data - (data - 1);
                printStartPage = data - (data - 1);
            }else if(data === 1){
                startPage = parseInt(data);
                endPage = parseInt(data);
            }

            for (let page = 1; page <= printEndPage; page++) {
                if(page === 1){
                    $('#pageGroup').append(`
                        <li class = "paging active" style="display: inline-block; cursor:pointer;" onclick="paging(this)">${page}</li>
                    `)
                    currentPageObj = $('.paging.active');
                }else{
                    $('#pageGroup').append(`
                        <li class = "paging" style="display: inline-block; cursor:pointer;" onclick="paging(this)">${page}</li>
                    `)
                }
            }
        }).fail(function (error) {
            console.log(error)
        })

        // 글 등록 버튼 클릭 시
        $('#btn-save').on('click', function () {
            _this.save();
        });
        // 수정 버튼 클릭 시 모달창 출력
        showModifyModal();
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
let currentPageObj = ''
let startPage = ''; // 전체 페이지의 첫 번째 = 1
let endPage = ''; // 전체 페이지의 마지막
let printPageSize = 5; // 출력되는 페이지 갯수
let printStartPage = ''; // 출력되는 페이지의 첫 번째
let printEndPage = printPageSize; // 출력되는 페이지의 마지막
let printListSize = 10;
let requirePage = ''; // 요청 페이지
// 페이징
function paging(thisPage) {
    // 색깔 지우기
    if(thisPage.innerText === 'chevron_left'){
        console.log(currentPageObj[0].innerText)
        console.log(startPage)
        if(parseInt(currentPageObj[0].innerText) === startPage){
            alert('처음입니다.')
            return;
        }else{
            if(parseInt(currentPageObj[0].innerText) === printStartPage){
                $('#pageGroup').html('');
                printStartPage = printStartPage - printPageSize;
                printEndPage = printEndPage - printPageSize;
                for (let page = printStartPage; page <= printEndPage; page++) {
                    $('#pageGroup').append(`
                        <li class = "paging" style="display: inline-block; cursor:pointer;" onclick="paging(this)">${page}</li>
                    `)
                    if(page === printEndPage){
                        currentPageObj.removeClass('active');
                        currentPageObj = $('#pageGroup').children().last();
                        currentPageObj.addClass('active');
                        requirePage = currentPageObj[0].innerText
                    }
                }
            }else {
                currentPageObj.removeClass('active');
                currentPageObj = currentPageObj.prev();
                currentPageObj.addClass('active');
                requirePage = currentPageObj[0].innerText
            }
        }
    }else if(thisPage.innerText === 'chevron_right'){
        if(parseInt(currentPageObj[0].innerText) === endPage){
            alert('마지막입니다.')
            return;
        }else{
            if(parseInt(currentPageObj[0].innerText) === printEndPage){
                $('#pageGroup').html('');
                printStartPage = printStartPage + printPageSize;
                if(endPage - printEndPage > 5){
                    printEndPage = printEndPage + printPageSize;
                }else{
                    printEndPage = endPage;
                }
                for (let page = printStartPage; page <= printEndPage; page++) {
                    console.log(page)
                    $('#pageGroup').append(`
                        <li class = "paging" style="display: inline-block; cursor:pointer;" onclick="paging(this)">${page}</li>
                    `)
                    if(page === printStartPage){
                        currentPageObj.removeClass('active');
                        currentPageObj = $('#pageGroup').children().last();
                        currentPageObj.addClass('active');
                        requirePage = currentPageObj[0].innerText
                    }
                }
            }else{
                currentPageObj.removeClass('active');
                currentPageObj = currentPageObj.next();
                currentPageObj.addClass('active');
                requirePage = currentPageObj[0].innerText
            }
        }
    }else{
        currentPageObj.removeClass('active');
        currentPageObj = $(thisPage)
        currentPageObj.addClass('active')
        requirePage = thisPage.innerText;
    }
    console.log(`리턴 탈출?`)
    $.ajax({
        type: 'GET',
        url: '/paging',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: {
            requirePage : requirePage - 1,
            printListSize : printListSize
        }
    }).done(function (data) {
        console.log(data)
        $('#tbody').html('');
        // HTML 생성 후 APPEND
        makeList(data)
    })
}
function makeList(arr){
    for (let i = 0; i < arr.length; i++) {
        $('#tbody').append(`
            <tr>
                <td class="text-center id">${arr[i].id}</td>
                <td class="text-center title">${arr[i].title}</td>
                <td class="text-center author">${arr[i].author}</td>
                <td class="content" style="display: none;">${arr[i].content}</td>
                <td class="text-center createdDate">${arr[i].createdDate}</td>
                <td class="text-center modifiedDate">${arr[i].modifiedDate}</td>
                <td class="text-center">
                    <button class="btn btn-secondary btn-xs modifyBoard" data-toggle="modal" data-target="#updatePostsModal">수정</button>
                    <button class="btn btn-danger btn-xs" onclick="delThisList(this)">삭제</button>
                </td>
            </tr>
        `)
    }
    showModifyModal();
}
// 수정 모달창 출력
function showModifyModal() {
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
}
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