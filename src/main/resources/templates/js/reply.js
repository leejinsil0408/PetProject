'use strict';

let replyIndex = {
    init: function () {
        $("#reply-btn-save").on("click", () => {
            this.insertReply();
        });
    },

    insertReply: function () {
        let data = {
            content: $("#reply-content").val(),
        }
        let noticeId = $("#noticeId").val();
        console.log(data)
        console.log(noticeId)
        $.ajax({
            type: "POST",
            url: `/Notice/getNotice.html`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text"
        }).done(function (res) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/Notice/${noticeId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

}
replyIndex.init();

