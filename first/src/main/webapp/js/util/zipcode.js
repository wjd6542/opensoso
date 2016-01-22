
/**
 * 제이쿼리 전역함수 생성 우편번호 검색
 * @param 
 * @author rockys
 */
(function($)
{
	// util 네임스페이스 생성
	$.zipcode = 
	{
		/**
		 * 설명 : 공통 우편번호 검색 함수
		 * @param zipcode	// 우펀번호 필드
		 * @param addr11	// 주소
		 * @param addr12	// 상세주소
		 */
		zipcodeSerch : function(zipcode, addr11, addr12, latId, lngId)
		{
			// 우편번호검색
			new daum.Postcode(
			{
				oncomplete: function(data)
				{
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var fullAddr = ''; // 최종 주소 변수
					var extraAddr = ''; // 조합형 주소 변수
					//주소-좌표 변환 객체를 생성
					var geocoder = new daum.maps.services.Geocoder();
					// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R')
					{ 
						// 사용자가 도로명 주소를 선택했을 경우
						fullAddr = data.roadAddress;
					}
					else
					{ 
						// 사용자가 지번 주소를 선택했을 경우(J)
						fullAddr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
					if(data.userSelectedType === 'R')
					{
						//법정동명이 있을 경우 추가한다.
						if(data.bname !== ''){
							extraAddr += data.bname;
						}
						// 건물명이 있을 경우 추가한다.
						if(data.buildingName !== ''){
							extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
						}
						// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
						fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					$("#"+zipcode).val(data.zonecode);
					$("#"+addr11).val(fullAddr);
					$("#"+addr12).focus();
					
					
					// 주소로 좌표를 검색
					geocoder.addr2coord(fullAddr, function(status, result)
					{
						// 정상적으로 검색이 완료됐으면
						if (status === daum.maps.services.Status.OK)
						{
							// 위도
							var lat = result.addr[0].lat;
							// 경도
							var lng = result.addr[0].lng;
							// input 데이터 삽입
							$("#"+latId).val(lat);
							$("#"+lngId).val(lng);
						}
					});
				}
			}).open();
		},
	}
})(jQuery);