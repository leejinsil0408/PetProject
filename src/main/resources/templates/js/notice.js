'use strict';

let replyIndex = {
    init: function () {
        $("#btn-reply-save").on("click", () => {
            this.insertReply();
        });
    },

    insertReply: function () {
        let seq = $("#seq").val();
        let data = {
            content: $("#reply-content").val()
        };

        $.ajax({
            type: "POST",
            url: `/js/detail.jsp`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/Notice/${seq}`;
        }).fail(function (error) {
            alert(JSON.stringify(err));
        });
    }
}
replyIndex.init();

