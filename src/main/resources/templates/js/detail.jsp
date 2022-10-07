<div class="card">
    <form>
        <input type="hidden" id="seq" value="${notice.seq}"/>
        <div class="card-body">
            <textarea id="reply-content" class="form-control" rows="1"></textarea>
        </div>
        <div class="card-footer">
            <button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
        </div>
    </form>
</div>
<%--    <div class="card-body">--%>
<%--        <textarea class="form-control" rows="1"></textarea>--%>
<%--    </div>--%>
<%--    <div class="card-footer">--%>
<%--        <button class="btn btn-primary">등록</button>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<br>--%>
<%--<div class="card">--%>
<%--    <div class="card-header">댓글 목록</div>--%>
<%--    <ul id="reply-box" class="list--group">--%>
<%--        <c:forEach let="reply" items="${notice.replys}">--%>
<%--        <li id="reply--1" class="list-group-item d-flex justify-content-between">--%>
<%--            <div>${reply.content}</div>--%>
<%--            <div class="d-flex">--%>
<%--                <div class="font-italic">작성자:${reply.user.username}&nbsp;</div>--%>
<%--                <button class="badge">삭제</button>--%>
<%--            </div>--%>
<%--        </li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
<%--</div>--%>