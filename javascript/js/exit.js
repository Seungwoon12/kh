//JS파일에는 자바스크립트 코드만 작성 가능
//외부에서 이 파일을 불러올 때는 <script src="위치"></script> 형태로 불러온다.
//(주의) jQuery를 이 파일에서 사용하고 싶다면 jquery의 CDN을 이 파일보다 먼저 불러와야 한다.

$(function(){
    //탈출 방지 코드 작성
    $(window).on("beforeunload", function(){
        //탈출하기 전 한번 더 물어보도록 설정(true는 그냥 통과)
        return false;
    });
});