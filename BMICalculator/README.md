# BMI 계산기

## Manifest
app에 들어있는 속성들이나 activity들 또는 권한들을 저장하는 공간
<activity android:name=".ResultActivity"/>

## Activity

### 인텐트 및 인텐트 필터(https://developer.android.com/guide/components/intents-filters?hl=ko)
- 명시적 인텐트
- 암시적 인텐트

  //다음 페이지에 결과를 나오게 한다.
  val intent = Intent(this, ResultActivity::class.java)
  intent.putExtra("height", height)
  intent.putExtra("weight", weight)
  startActivity(intent) //ResultActivity로 넘어가고 싶어 라고 선언된 Intent를 실행한다.

### 로그(Log) & 토스트(Toast)
Log.d("MainActivity", "메인 액티비티에 있습니다.")
Toast.make(this, "알림", Toast.LENGTH_SHORT) //토스트 메세지를 짧게 보여준다.
Toast.make(this, "알림", Toast.LENGTH_LONG) //토스트 메세지응 길게 보여준다.

## Listener
해당 리스너를 나온다. return 한다.
return@setOnClickListener


## XML

### LinearLayout
android:gravity="center"
android:orientation : vertical, horizontal

### orientation : vertical, horizontal
- 각각 세로, 가로로 쌓인다.

### edittext input type
- number 숫자 키패드 남

### margin, padding
- margin : 컨포넌트 밖의 양옆, 위, 아래 공간을 추가함
- padding : 컨포넌트 안쪽으로 양옆, 위, 아래 공간을 추

### dp란?
- 화면이 가지는 사이즈의 기본 단위
- 사용하는 이유 : 각각의 회면 사이즈가 다를수 있기 때문에 통합하여 알맞게 계산해서 나온 수치
- sp 핸드폰 속성에서 텍스트 사이즈를 사용할 수 있음 그 사람의 상황에 맞게 사이즈를 조절해서 출력된다.
- 핸드폰 설정에 들어가면 글을 크게, 작게, 보통 으로 설정하는 칸이 있는데 그 속성에 따라 sp는 같은 값을 넣어도 설정에 따라 다르게 출력된다.

### text
text style : 택스트 스타일을 설정할 수 있다.
text color : 텍스트 색상을 설정할 수 있다.



## res
res/values/colors : 색상을 리소스로 따로 뺴줄 수 있다.
res/values/string : 글을 리소스로 따로 뺄 수 있다.



## 단축키
xml 속성들 정렬 : option + command + L



## Error
빈 값으로 발생되는 오류
java.lang.NumberFormatException: For input string: ""
