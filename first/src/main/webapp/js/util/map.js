
/**
 * 제이쿼리 전역함수 생성 map
 * 위도와 경도는 반드시 Number 로 삽입되어야 한다
 * @param 
 * @author rockys
 */
(function($)
{
	$.daum = 
	{
		/**
		 * 설명 : 구글 지도 생성 함수
		 * @param mapId
		 * @param latId
		 * @param lngId
		 * @param addr11
		 * @returns {google.maps.Map}
		 */
		gmakeMap : function(mapId, latId, lngId, addr11)
		{
			// 위도 , 경도
			var lat = $("#"+latId).val();
			var lng = $("#"+lngId).val();
			
			// 데이터 초기화
			if(lat=="" || lat==null)
				lat = 33.450701;
			if(lng=="" || lng==null)
				lng = 126.570667;
			//구글 맵 옵션 설정
			var mapOptions =
			{ 
				//기본 확대율
				zoom : 16,
				// 지도 중앙 위치
				center : new google.maps.LatLng(lat, lng),
				//마우스 휠로 확대 축소 사용 여부
				scrollwheel : true,
				//맵 타입 컨트롤 사용 여부
				mapTypeControl : false
			};
			//구글 맵을 사용할 타겟
			var map = new google.maps.Map(document.getElementById(mapId), mapOptions);
			
			return map;
		},
		
		/**
		 * 설명 : 구글 마커 생성 함수
		 * @param map
		 * @param latId
		 * @param lngId
		 * @param addr11
		 */
		gmapMarker : function(map, latId, lngId, addr11)
		{
			// 위도 , 경도
			var lat = $("#"+latId).val();					// 위도
			var lng = $("#"+lngId).val();					// 경도
			var address = $("#"+addr11).val();				// 주소정보
			var markerTitle = "주소정보";					// 마커 타이틀
			var markerMaxWidth	= 300;						// 최대사이즈
			var contentString = "<div>"+address+"</div>";	// 마커 내용
			
			// 데이터 초기화
			if(lat=="" || lat==null)
				lat = 33.450701;
			if(lng=="" || lng==null)
				lng = 126.570667;
			
			var center = new google.maps.LatLng(lat, lng);
				
			var marker = new google.maps.Marker({
				position: center,
				map: map,
				title: markerTitle
			});
			
			var infowindow = new google.maps.InfoWindow(
			{
				content: contentString,
				maxWidth: markerMaxWidth
			});
			
			google.maps.event.addListener(marker, 'click', function() {
				infowindow.open(map, marker);
			});
			
			map.setCenter(center);
			
			// 리사이즈에 따른 마커 위치
			google.maps.event.addDomListener(window, "resize", function() 
			{
				var center = map.getCenter();
				google.maps.event.trigger(map, "resize");
				map.setCenter(center);
			});
		},
		
		/**
		 * 설명 : 다음 지도 객채 생성함수
		 * @param mapId
		 * @param latId
		 * @param lngId
		 * @returns {daum.maps.Map}
		 */
		makeMap : function(mapId, latId, lngId)
		{
			// 위도 , 경도
			var lat = $("#"+latId).val();
			var lng = $("#"+lngId).val();
			
			// 데이터 초기화
			if(lat=="" || lat==null)
				lat = 33.450701;
			if(lng=="" || lng==null)
				lng = 126.570667;
			
			// 지도를 표시할 div 
			var mapContainer = document.getElementById(mapId);
			var mapOption = {
				center: new daum.maps.LatLng(lat, lng),
				level: 7
			};

			var map = new daum.maps.Map(mapContainer, mapOption);
			
			//지도에 확대 축소 컨트롤을 생성한다
			var zoomControl = new daum.maps.ZoomControl();
			
			// 지도의 우측에 확대 축소 컨트롤을 추가한다
			map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
			
			// 가져다 쓰기위해 지도객체 반환
			return map;
		},
		
		
		/**
		 * 설명 : 다음 마커 생성 함수
		 * @param map
		 * @param lat
		 * @param lng
		 */
		mapMarker : function(map, latId, lngId, addr11)
		{
			// 위도 , 경도
			var lat = $("#"+latId).val();
			var lng = $("#"+lngId).val();
			var address = $("#"+addr11).val();
			//지도에 마커를 생성하고 표시한다
			var marker = new daum.maps.Marker(
			{
				// 마커의 좌표
				position: new daum.maps.LatLng(lat, lng),
				// 마커를 드래그 가능하도록 설정한다
				draggable : true,
				// 마커를 표시할 지도 객체
				map: map
			});
			
			// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
			// 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			// removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
			var iwContent = "<div>"+address+"</div>",
				iwRemoveable = true;
			
			// 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
				content : iwContent,
				removable : iwRemoveable
			});

			// 마커에 클릭이벤트를 등록합니다
			daum.maps.event.addListener(marker, 'click', function() {
				// 마커 위에 인포윈도우를 표시합니다
				infowindow.open(map, marker);  
			});
			
			
			
			// 데이터 초기화
			if(lat=="" || lat==null)
				lat = 33.450701;
			if(lng=="" || lng==null)
				lng = 126.570667;
			
			var coords = new daum.maps.LatLng(lat, lng);
			
			// map 재시작
			map.relayout();
			// 지도 중심을 변경한다.
			map.setCenter(coords);
			// 마커를 결과값으로 받은 위치로 옮긴다.
			marker.setPosition(coords);
			
		},
		
		
		/**
		 * 설명 : 데이터 설정 함수
		 * @param map
		 */
		mapOption : function(map) 
		{
			//지도 타입 정보를 가지고 있을 객체입니다
			//map.addOverlayMapTypeId 함수로 추가된 지도 타입은
			//가장 나중에 추가된 지도 타입이 가장 앞에 표시됩니다
			//이 예제에서는 지도 타입을 추가할 때 지형정보, 교통정보, 자전거도로 정보 순으로 추가하므로
			//자전거 도로 정보가 가장 앞에 표시됩니다
			var mapTypes = 
			{
				terrain : daum.maps.MapTypeId.TERRAIN,
				traffic :  daum.maps.MapTypeId.TRAFFIC,
				bicycle : daum.maps.MapTypeId.BICYCLE
			};
			
			var chkTerrain = document.getElementById('chkTerrain'),
				chkTraffic = document.getElementById('chkTraffic'),
				chkBicycle = document.getElementById('chkBicycle');
			
			// 지도 타입을 제거합니다
			for (var type in mapTypes) {
				map.removeOverlayMapTypeId(mapTypes[type]);
			}
			
			// 지형정보 체크박스가 체크되어있으면 지도에 지형정보 지도타입을 추가합니다
			if (chkTerrain.checked) {
				map.addOverlayMapTypeId(mapTypes.terrain);
			}
			
			// 교통정보 체크박스가 체크되어있으면 지도에 교통정보 지도타입을 추가합니다
			if (chkTraffic.checked) {
				map.addOverlayMapTypeId(mapTypes.traffic);
			}
			
			// 자전거도로정보 체크박스가 체크되어있으면 지도에 자전거도로정보 지도타입을 추가합니다
			if (chkBicycle.checked) {
				map.addOverlayMapTypeId(mapTypes.bicycle);
			}
		},
	}
})(jQuery);