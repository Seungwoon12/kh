jquery의 주요 명령
선택한 대상의 속성 변경
이벤트 설정 : $(선택자).on("이벤트종류", 함수);
축약 명령 가능(input 제외)
document.querySelector("선택자").addEventListener("종류", 함수);
이벤트 해제 : $(선택자).off("이벤트종류");
document.querySelector("선택자").removeEventListener(함수);
value 설정 : $(선택자).val(값);
document.querySelector("선택자").value = 값;
value 확인 : $(선택자).val();
document.querySelector("선택자").value
attribute 설정 : $(선택자).attr("항목", "값");
document.querySelector("선택자").항목 = "값";
attribute 확인 : $(선택자).attr("항목");
document.querySelector("선택자").항목
property 설정 : $(선택자).prop("항목", "값");
document.querySelector("선택자").항목 = "값";
property 확인 : $(선택자).prop("항목");
document.querySelector("선택자").항목
text 설정 : $(선택자).text("글자");
document.querySelector("선택자").textContent = "글자";
text 확인 : $(선택자).text();
document.querySelector("선택자").textContent
html 설정 : $(선택자).html("글자");
document.querySelector("선택자").innerHTML = "글자";
html 확인 : $(선택자).html();
document.querySelector("선택자").innerHTML
스타일 설정 : $(선택자).css("항목", "값");
document.querySelector("선택자").style.항목 = "값";
스타일 확인 : $(선택자).css("항목");
document.querySelector("선택자").style.항목
클래스 추가 : $(선택자).addClass("클래스명");
document.querySelector("선택자").classList.add("클래스명");
클래스 제거 : $(선택자).removeClass("클래스명");
document.querySelector("선택자").classList.remove("클래스명");
클래스 확인 : $(선택자).hasClass("클래스명");
document.querySelector("선택자").classList.contains("클래스명");
클래스 토글 : $(선택자).toggleClass("클래스명");
없음
표시 또는 제거
$("선택자").show();
$("선택자").hide();
$("선택자").toggle();
$("선택자").slideUp();
$("선택자").slideDown();
$("선택자").slideToggle();
$("선택자").fadeOut();
$("선택자").fadeIn();
$("선택자").fadeToggle();
DOM 탐색 명령
모든 명령에는 선택자를 추가할 수 있다

이전 태그 탐색
.first() : 첫 번째 태그 선택
.prev() : 인접한 한 개 선택
.prevAll() : 전부 다 선택
다음 태그 탐색
.last() : 마지막 태그 선택
.next() : 인접한 한 개 선택
.nextAll() : 전부 다 선택
상위 태그 탐색
.parent() : 인접한 한 개 선택
.parents() : 전부 다 선택
하위 태그 탐색
.children()
.find()