// 사용형식 설정
function inputFormat( obj, chr, chr_pos, chr_st )
{
	// var obj = event.srcElement;
	var val = obj.value.replace(/[^0-9]/gi,"");
	var newval = "";
	if( chr_st=="left" )
	{
		for( var i=0; i<chr_pos.length; i++ )
		{
			if( val.length>chr_pos[i] )
			{
				newval+= val.substring(0,chr_pos[i]);
				if( i+1 < chr_pos.length ) newval+= chr;
				val = val.substring(chr_pos[i]);
			}
			else
			{
				newval+= val;
				break;
			}
		}
	}
	else if( chr_st=="right" )
	{
		var total_length = 0;
		for( var i=0; i<chr_pos.length; i++ ) total_length+= chr_pos[i];
		if( val.length>total_length )
		{W
			val = val.substring(0,total_length);
		}
		for( var i=0; i<chr_pos.length; i++ )
		{
			if( val.length>chr_pos[i] )
			{
				newval = val.substring(val.length-chr_pos[i]) + newval;
				if( i+1 < chr_pos.length ) newval = chr + newval;
				val = val.substring(0,val.length-chr_pos[i]);
			}
			else
			{
				newval = val + newval;
				break;
			}
		}
	}
	return 1;
}


// 사업자
function chk_com()
{
	var chr_pos = new Array(3,2,5);
	var chr = "-";
	var chr_st = "left";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}

// 주민번호
function chk_ssn()
{
	var chr_pos = new Array(6,7);
	var chr = "-";
	var chr_st = "left";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}

// 전화번호
function chk_ph()
{
	var chr_pos = new Array(4,4,3);
	var chr = "-";
	var chr_st = "right";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}

// 금액
function chk_money()
{
	var chr_pos = new Array(3,3,3,3,3);
	var chr = ",";
	var chr_st = "right";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}

// 날짜
function chk_date()
{
	var chr_pos = new Array(4,2,2);
	var chr = "-";
	var chr_st = "left";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}

// 숫자
function chk_num()
{
	var chr_pos = new Array(100);
	var chr = "";
	var chr_st = "left";	// right|left

	var obj = event.srcElement;
	obj.value = inputFormat( obj, chr, chr_pos, chr_st );
}



/**
 * 제이쿼리 전역함수 생성
 * @param 
 * @author rockys
 */
(function($)
{
	// util 네임스페이스 생성
	$.util = 
	{
		
		/**
		 * 페이지 값 이동 함수
		 * @param pageNum
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
		 * 설명 : 필수 Input 값 확인후 채크
		 */
		mustInput : function()
		{
			$("label.check").append(" <font color='red'>*</font>");
		},
		
		
		/**
		 * 설명 : null체크 유효성검사
		 * @param id
		 * @param msg
		 */
		nullCheck : function(id, msg, val)
		{
			if($("#"+id).val() == null || $("#"+id).val() == "")
			{
				if(val != "")
				{
					if(val != $("#"+id).val())
					{
						alert(msg);
						$("#"+id).focus();
						return true;
					}
				}
				else
				{
					alert(msg);
					$("#"+id).focus();
					return true;
				}
			}
			else
			{
				return false;
			}
		},
		
		
		/**
		 * * 배열을 받아서 jsonObject 로 생성후 반환한다
		 * @param Array
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
		 * 선택된 값을 화면단에 출력
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
				$("#"+memuid).attr("class","active");
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
		 * @param taget
		 * @param cookieid
		 */
		cookieMk : function(cookieid, val)
		{
			$.cookie(cookieid , val ,  { expires : 1, path : '/' });
		},
		
		
		/**
		 * 설명 : 데이터 이동 함수
		 * @param Array
		 * @param idx
		 */
		valueChang : function(Array, idx)
		{
			for(var i=0; i<Array.length; i++)
			{
				$("#"+Array[i]).val($("#"+Array[i]+"_"+idx).val());
			}
		},
		
		
		/**
		 * 설명 : 데이터 이동 함수 from
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
		 * 설명 : ajax 실행 처리
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
						alert(msg);
					}
					else
					{
						alert(msg);
					}
				},
				// 실패
				error:function(request,status,error){
					alert("시스템 에러 입니다. 에러코드 : "+request.status);
				}
			});
		},
		
		
		/**
		 * 설명 : 사이드메뉴 화면 출력여부 설정 함수
		 */
		sideMemulook : function()
		{
			var val = $.cookie("sideCheck");
			// 사이드 메뉴 출력
			if(val == "Y")
			{
				$(".sidebar").hide();
				$(".main").attr("class","padding-top-30 col-md-12 col-sm-12 main");
			}
			// 사이드 메뉴 숨김
			else
			{
				$(".sidebar").show();
			}
		},
		
		
		/**
		 * 설명 : 쿠키값을 토클 형식으로 삽입한다
		 * @param classNm
		 * @param cookieId
		 */
		toggleCookie : function(classNm, cookieId)
		{
			// 서브메뉴 제어
			$("."+classNm).on("click", function(){
				var val = $(this).attr("contextmenu");
				// 쿠키 생성
				$.util.cookieMk(cookieId, val);
				// 페이지 리로드
				location.reload();
			});
		},
		
		
		/**
		 * 설명 : 클릭한 해당 row 의 색상을 표시
		 * @param thiss
		 */
		rowColor : function(thiss){
			// 테이블 row 색상 변경 info
			$("table tbody tr td").removeClass("info");
			$(thiss).addClass("info");
		},
	}
})(jQuery);