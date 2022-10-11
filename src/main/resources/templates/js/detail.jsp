<form>
    <script th:src="@{/templates/js/notice.js}"></script>
    <br>
    <div class="card">
        <input type="hidden" id="seq" value="{seq}"/>
        <div class="card-body">
            <textarea class="form-control" rows="1"></textarea>
        </div>
        <form th:action="@{|/Reply/${reply.size()}|}" method="post">
            <div class="card-footer">
                <button type="button" id="insertReply" class="btn btn-primary">댓글 등록</button>
            </div>
    </div>
    <br>
    <div class="card">
        <div class="card-header">댓글 목록</div>
        <ui id="reply-box" class="list-group">
            <li id="reply-${reply.r_seq}" class="list-group-item d-flex justify-content-between">
                <div>${reply.content}</div>
                <div class="d-flex">
                    <button onclick="${reply.r_seq}" class="badge">삭제</button>
                </div>
            </li>
        </ui>
    </div>
</form>