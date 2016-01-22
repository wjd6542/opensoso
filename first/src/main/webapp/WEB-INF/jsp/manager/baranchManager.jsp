<%
/**
 * 
 * @author	강정권
 * @date	2015-10-20
 * @tip		권한관리 화면
 * <pre>
 * -------- 수정이력 ----------
 * 수정자	:	강정권
 * 수정일자	:	2015-10-20
 * 수정내용	:	페이지수정
 * ----------------------------
 * </pre>
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 상단 -->
<jsp:include page="/include/top.jsp"/>

<script type="text/javascript">
$(document).ready(function ()
{
	// 필수 항목 체크
	$.util.mustInput();
	
	// 이동경로
	var url = "/authorityManager.do";
	
	// select box 그리기
	$("#search").append("${search}");
	
	var list = "${baranchList}";
	var result = "";
	for(var i=0; i<list.length; i++)
	{
		var idx = list[i].dix;
		
	}
	
	var data = 
	[
		{
			label: 'node1',
			children: [
			{ label: 'child1' },
			{ label: 'child2' }
			]
		},
		{
			label: 'node2',
			children: [
			{ label: 'child3' }
			]
		}
	];
	// 트리 생성
	$("#tree").tree({
		data: data,
		autoOpen: true,
		closedIcon: '+'
	});
	
	$(".parent").on("click",function(){
		var idx = $(this).attr("dir");
		$("#idx").val(idx);
		$("#form").submit();
	});
	
	
	
	 jQuery(function() {
		    $('div.chosentree').chosentree({
		      width: 500,
		      deepLoad: true,
		      load: function(node, callback) {
		        /**
		         * This would typically call jQuery.ajax to load a new node
		         * on your server where you would return the tree structure
		         * for the provided node.
		         */
		      }
		    });
		  });
});
</script>

<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 서브메뉴 -->
			<jsp:include page="/include/sideMemu.jsp"/>
			<form method="post" id="form" action="/baranchManager.do">
			<input type="hidden" id="eventType" name="eventType">
			<input type="hidden" id="idx" name="idx" value="${idx}">
			
				<!-- content -->
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row placeholders">
						<div class="col-xs-12 col-sm-8 placeholder">
							<div id="sidetree">
								<div id="sidetreecontrol">
									<div class="input-group-btn">
										<a class="btn btn-default" href="?#">전체보기숨김</a> 
										<a class="btn btn-default" href="?#">전체보기</a>
									</div>
								</div>
								<ul id="tree">
								</ul>
								
								<div class="chosentree"></div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>