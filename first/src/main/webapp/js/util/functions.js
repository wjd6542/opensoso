 /* 제이쿼리 전역함수 생성
 * @param 
 * @author rocky
 */
(function($)
{
	// util 네임스페이스 생성
	$.util = 
	{
		/**
		 * 설명 : 숫자만 입력가능
		 * @author rocky
		 */
		onlyNum : function()
		{
			$(".onlyNum").keyup(function(){
				$(this).val( $(this).val().replace(/[^0-9]/g,"") );} 
			);
			
		},
		
		
		/**
		 * 설명 : 영문만 입력가능
		 * @author rocky
		 */
		onlyEng : function()
		{
			$(".onlyEng").keyup(function(){
				$(this).val( $(this).val().replace(/[^a-z,A-Z]/g,"") );
			});
		},
		
		
		/**
		 * 설명 : 한글만 입력가능
		 * @author rocky
		 */
		onlyHan : function()
		{
			$(".onlyHan").keyup(function(){
				$(this).val( $(this).val().replace(/[^a-z,A-Z]/g,"") );
			});
		},
		
		
		/**
		  * 설명 : 금액형식
		 * @author rocky
		 */
		onlyMoney : function()
		{
			$(".onlyMoney").keyup(function(){
				var val = $(this).val();
				var value = Number(val).toLocaleString('en').split(".")[0];
				$(this).val(value);
			});
		},
		
		
		/**
		 * 설명 : 페이지 이동
		 * @author rocky
		 */
		pageMove : function()
		{
			$(".page").on("click",function(){
				var pageNo = $(this).attr("dir");
				$("#pageNo").val(pageNo);
				$("#form").submit();
			});
		},
		
		
		/**
		 * 설명 : 엔터 검색
		 * @author rocky
		 * @param target
		 * @param target2
		 */
		enterSet : function(target, target2)
		{
			$("#" + target).keydown(function (key) {
				if (key.keyCode == 13)
				{
					$("." + target2).click();
				}
			});
		},
		
		
		/**
		 * 설명 : 정렬 변경
		 * @author rocky
		 */
		orderSet : function()
		{
			$(".order").on("click",function(){
				var order = $(this).attr("id");
				$("#order").val(order);
				$("#form").submit();
			});
		},
		
		
		/**
		 * 설명 : 정렬 항목 컬럴 설정
		 * @author rocky
		 * @param target
		 */
		orderColorSet : function(target)
		{
			var orderId = $("#" + target).val();
			if(orderId != "")
			{
				$("#" + orderId).removeClass("label-info");
				$("#" + orderId).addClass("label-success");
			}
		},
		
		
		/**
		 * 설명 : 필수 Input 값 확인후 채크
		 * @author rocky
		 */
		mustInput : function()
		{
			$("label.check").append(" <font color='red'>*</font>");
		},
		
		
		/**
		 * 설명 : null체크 유효성검사
		 * @author rocky
		 * @param id
		 * @param msg
		 * @param val
		 * @returns Boolean
		 */
		nullCheck : function(id, msg)
		{
			var $target = $("#"+id);
			if($target.val() == "" || $target.val() == null)
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 설명 : null 채크 form 추가
		 * @param id
		 * @param msg
		 * @param form
		 * @returns Boolean
		 */
		nullCheckForm : function(id, msg, form){
			var $target = $("#" + form + " #" + id);
			if($target.val() == null || $target.val() == "")
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 설명 : 데이터 동일 채크
		 * @param id
		 * @param val
		 * @param msg
		 * @returns {Boolean}
		 */
		valueSameCheck : function(id, val, msg)
		{
			var $target = $("#" + id);
			if($target.val() != val)
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 설명 : 라디오 박스 val 채크
		 * @param name
		 * @param value
		 * @param msg
		 * @returns {Boolean}
		 */
		ridioValCheck : function(name, value, msg)
		{
			var $target = $("input:radio[name="+name+"]")[0];
			var val = $("input:radio[name="+name+"]:checked").val();
			if(val != value)
			{
				alertify.alert(msg, function(e){
					$target.focus();
					return true;
				});
			}
			else
			{
				return false;
			}
		},
		
		/**
		 * 설명 :jsonObject 생성함수
		 * @author rocky
		 * @param Array
		 * @param formId
		 * @returns jsonObject
		 */
		jsonObjectMk : function(Array ,formId)
		{
			var jsonObject = {};
			for(var i=0; i<Array.length; i++)
			{
				var key = Array[i];
				var value = "";
				// from 구분이 없는경우
				if(formId == "" || formId == null)
				{
					value = $("#"+key).val();
				}
				// from 구분이 있는경우
				else
				{
					value = $("#"+formId+" #"+key).val();
				}
				jsonObject[key] = value;
			}
			return jsonObject;
		},
		
		
		/**
		 * 설명 : 선택된 값을 화면단에 출력
		 * @author rocky
		 * @param id
		 */
		selectShowHide : function(id)
		{
			// 로드시
			if($("#"+id).val() != "")
			{
				var val = $("#"+id).val();
				$.util.optionloop(id, val);
			}
			
			// 선택시
			$("#"+id).change(function()
			{
				var val = $(this).val();
				$.util.optionloop(id, val);
			});
		},
		
		
		/**
		 * 설명 : 루프 돌변서 선택값 화면단에 출력
		 * @author rocky
		 * @param id
		 */
		optionloop : function(id, val)
		{
			var size = $("#"+id+" option").size();
			for(var i=0; i<size; i++)
			{
				var optionVal =  $("#"+id+" option:eq("+i+")").val();
				$("."+id+optionVal).hide();
				if(optionVal == val)
				{
					$("."+id+optionVal).show();
				}
			}
		},
		
		
		/**
		 * 설명 : option 값으로 데이터 화면 출력
		 * @author rocky
		 * @param taget
		 * @param toggleClass1
		 * @param toggleClass2
		 */
		radioShow : function(taget, toggleClass1, toggleClass2)
		{
			// 선택값 가져옴
			if($(taget).hasClass("active"))
			{
				$.util.toggleShow(taget, toggleClass1, toggleClass2);
			}
			
			// 라디오 버튼 클릭시
			$(taget).on("click", function(){
				$.util.toggleShow(this, toggleClass1, toggleClass2);
			});
		},
		
		
		/**
		 * 설명 : 토글 화면단 출력
		 * @author rocky
		 * @param taget
		 * @param toggleClass1
		 * @param toggleClass2
		 */
		toggleShow : function(taget, toggleClass1, toggleClass2)
		{
			var myVal = $(taget).children("input").val();
			if(toggleClass1 == myVal)
			{
				$("."+toggleClass2).slideUp();
				$("."+toggleClass1).slideDown();
			}
			else
			{
				$("."+toggleClass1).slideUp();
				$("."+toggleClass2).slideDown();
			}
		},
		
		
		/**
		 * 설명 : 화면이동 함수
		 * @author rocky
		 * @param taget
		 * @param url
		 */
		urlMove : function(taget, url)
		{
			$(taget).on("click", function(){
				$(location).attr('href', url);
			});
		},
		
		
		/**
		 * 설명 : 색상설정함수
		 * @author rocky
		 * @param taget 
		 * @param cookieid 
		 * @param div 화면이동여부
		 */
		setColor : function(taget, cookieid, div)
		{
			var memuid = $.cookie(cookieid);
			// 로드시
			if(memuid!=null || memuid!="")
			{
				$("."+memuid).attr("class","active");
			}
			// 클릭시
			$(taget).on("click",function (){
				var val = $(this).attr("id");
				var url = $(this).attr("contextmenu");
				// 쿠키 생성
				$.util.cookieMk(cookieid, val);
				// 화면이동
				if(div == "Y")
				{
					$(location).attr("href",url);
				}
				
			});
		},
		
		
		/**
		 * 설명 : 쿠키 생성 함수
		 * @author rocky
		 * @param taget
		 * @param cookieid
		 */
		cookieMk : function(cookieid, val)
		{
			$.cookie(cookieid , val ,  { expires : 1, path : '/' });
		},
		
		
		/**
		 * 설명 : 데이터 이동 함수 from
		 * @author rocky
		 * @param Array
		 * @param idx
		 */
		formValueChang : function(Array, form, idx)
		{
			for(var i=0; i<Array.length; i++)
			{
				$("#"+form+" #"+Array[i]).val($("#"+form+" #"+Array[i]+"_"+idx).val());
			}
		},
		
		
		/**
		 * 설명 : map 데이터 input 으로 데이터 이동 함수
		 * @author rocky
		 * @param Array
		 */
		mapDataMove : function(Array)
		{
			for(var key in Array){
				var value = Array[key];
				$("#"+key).val(value);
			}
		},
		
		
		/**
		 * 설명 : ajax move 함수
		 * @author rocky
		 * @param url
		 * @param returnUrl
		 * @param jsonObject
		 */
		ajaxAction : function (url, returnUrl, jsonObject)
		{
			$.ajax(
			{
				type	: "POST",
				url		: url,
				data	: jsonObject,
				dataType: "json",
				// 성공
				success:function(data)
				{
					var code = data.code;
					var msg = data.msg;
					if(code=="SUCC")
					{
						alertify.alert(msg, function (e) {
							location.href = returnUrl;
						});
						
					}
					else
					{
						alertify.alert(msg);
					}
				},
				// 실패
				error:function(request,status,error){
					alertify.alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
		},
		
		
		/**
		 * 설명 : ajax alert 함수
		 * @author rocky
		 * @param url
		 * @param jsonObject
		 */
		ajaxAlert : function (url, jsonObject)
		{
			$.ajax(
			{
				type	: "POST",
				url		: url,
				data	: jsonObject,
				dataType: "json",
				// 성공
				success:function(data)
				{
					alertify.alert(data.msg);
				},
				// 실패
				error:function(request,status,error){
					alertify.alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
		},
		
		
		/**
		 * 설명 : ajax collback 함수
		 * @author rocky
		 * @param url
		 * @param jsonObject
		 * @returns returnObj
		 */
		ajaxData : function(url, jsonObject)
		{
			var returnObj = {};
			$.ajax(
			{
				type	: "POST",
				url		: url,
				data	: jsonObject,
				dataType: "json",
				async : false,
				// 성공
				success:function(data)
				{
					returnObj = data;
				},
				// 실패
				error:function(request,status,error){
					alertify.alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
			return returnObj;
		},
		
		
		/**
		 * 설명 : ajax 멀티 파일 업로드 함수
		 * @author rocky
		 * @param url
		 * @param form
		 * @returns result
		 */
		ajaxFrom : function(url, form)
		{
			var result = {};
			// 아작스 통신
			$.ajax({
				url: url,
				type: "POST",
				data: form,
				async: false,
				cache: false,
				contentType: false,
				processData: false,
				// 성공
				success:  function(data){
					result = data;
				},
				// 실패
				error:function(request,status,error){
					alertify.alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
			return result;
		},
		
		
		/**
		 * 설명 : 파일 다운로드 함수
		 * @author rocky
		 * @param url
		 * @param data
		 * @param method
		 */
		fileDown : function(url, data, method)
		{
			// url과 data를 입력받음
			if( url && data ){ 
				// data 는  string 또는 array/object 를 파라미터로 받는다.
				data = typeof data == 'string' ? data : jQuery.param(data);
				// 파라미터를 form의  input으로 만든다.
				var inputs = '';
				$.each(data.split('&'), function(){ 
					var pair = this.split('=');
					inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />'; 
				});
				// request를 보낸다.
				$('<form action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>').appendTo('body').submit().remove();
			};
		},
		
		
		/**
		 * 설명 : 쿠키값을 토클 삽입 함수
		 * @author rocky
		 * @param classNm
		 * @param cookieId
		 */
		toggleCookie : function(classNm, cookieId)
		{
			// 서브메뉴 제어
			$("." + classNm).on("click", function(){
				var val = $(this).attr("contextmenu");
				// 쿠키 생성
				$.util.cookieMk(cookieId, val);
				// 페이지 리로드
				location.reload();
			});
		},
		
		
		/**
		 * 설명 : 쿠키값을 토클 출력 함수
		 * @param cookieId
		 * @param target1
		 * @param target2
		 */
		confSideLocationSet : function (cookieId, target)
		{
			var check = $.cookie(cookieId);
			if(check == "true" || check == null)
			{
				$("." + target).addClass("position-left");
			}
			else
			{
				$("." + target).addClass("position-right");
				$(".main").removeClass("col-md-offset-2");
				$(".main").removeClass("col-sm-offset-3");
			}
		},
		
		
		/**
		 * 설명 : 사이드메뉴 출력여부 함수
		 * @param cookieId
		 * @param target1
		 * @param target2
		 */
		confSideShowSet : function (cookieId, target)
		{
			var check = $.cookie(cookieId);
			if(check == "true" || check == null)
			{
				$("." + target).show();
			}
			else
			{
				$("." + target).hide();
				$(".main").attr("class","padding-top-30 col-md-12 col-sm-12 main");
			}
		},
		
		
		/**
		 * 설명 : 쪽지 사용여부
		 * @param cookieId
		 * @param target
		 */
		confoteUesSet : function (cookieId, target)
		{
			var check = $.cookie(cookieId);
			if(check == "true" || check == null)
			{
				$("." + target).show();
			}
			else
			{
				$("." + target).hide();
			}
		},
		
		
		/**
		 * 설명 : 테이블 row 의 색상을 표시
		 * @author rocky
		 * @param thiss
		 */
		rowColor : function(target){
			// 테이블 row 색상 변경 info
			$("table tbody tr td").removeClass("info");
			$(target).addClass("info");
		},
		
		
		/**
		 * 설명 : 이메일 유효성 검사 함수
		 * @author rocky
		 * @param id
		 * @param msg
		 * @returns Boolean
		 */
		emailCheck : function(id, msg)
		{
			var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
			var $target = $("#" + id);
			if(regex.test($target.val())=== false)
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 비밀번호 유효성 검사
		 * @author rocky
		 * @param id
		 * @param msg
		 * @returns Boolean
		 */
		pwCheck : function(id, msg)
		{
			var reg_pwd = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			var $target = $("#" + id);
			
			// 비밀번호 양식 일치하지 않으면
			if(reg_pwd.test($target.val()) == false)
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 설명 : 비밀번호 일치 검사 함수
		 * @author rocky
		 * @param id
		 * @param id2
		 * @param msg
		 * @returns Boolean
		 */
		pwSameCheck : function(id, id2, msg)
		{
			var $pw = $("#" + id);
			var $target = $("#" + id2);
			
			if($pw.val() != $target.val())
			{
				alertify.alert(msg, function(e){
					$target.focus();
				});
				return true;
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * 섦영 : 이미지 업로드 리드 함수
		 * @author rocky
		 * @param input
		 * @param fileId
		 * @param imgId
		 */
		imgRead : function(input, fileId, imgClass)
		{
			var fileTypes = ["jpg", "jpeg", "png", "gif"];
			var fileName = input.files[0].name;
			var extension = input.files[0].name.split('.').pop().toLowerCase();
			var isSuccess = fileTypes.indexOf(extension) > -1;
			if (input.files && input.files[0])
			{
				// 확장자 채크
				if(isSuccess)
				{
					var reader = new FileReader();
					
					reader.onload = function (e) {
						$("." + imgClass).attr('src', e.target.result);
					}
					reader.readAsDataURL(input.files[0]);
				}
				else
				{
					alertify.alert(fileName + " 은 업로드 불가능한 파일입니다.");
					$("#" + fileId).val('');
				}
			}
		},
		
		
		/**
		 * 설명 : 권한 확인후 페이지 이동 함수
		 * @author rocky
		 * @param div
		 */
		authorityCheck : function(div){
			var authority = $("#userAuthority").val();
			
			// 권한 구분
			if(div == "m")
			{
				if(authority != "master")
				{
					location.href = "/index.do";
				}
			}
			else if(div == "u")
			{
				if(authority != "user")
				{
					location.href = "/index.do";
				}
			}
		},
		
		
		/**
		 * 섦영 : 권한 확인 출력 함수
		 * @param id
		 * @param id2
		 * @param target
		 */
		borderAuthorityCheck : function(id, id2, target)
		{
			var borderAuthority = $("#" + id).val();
			var userAuthority = $("#" + id2).val();
			var $target = $("." + target);
			if("user" == userAuthority)
			{
				$target.removeClass("hide");
			}
			else
			{
				$target.hide();
			}
		},
		
		
		
		
	}
})(jQuery);