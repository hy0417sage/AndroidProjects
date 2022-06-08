# 로또 번호 추첨기
===============
- **Layout**을 그리는 법
  - **ConstraintLayout** 사용하기
  - **NumberPicker**의 속성들과 사용하는 법
- **Layout**과 **Kotlin** 코드를 함께 사용하기
- **버그** 수정해 보기
- 중복 코드 정리하기
- Shape Drawable 사용하기
  - (https://developer.android.com/guide/topics/resources/drawable-resource?hl=ko)
  - XML 리소스에 적용할 수 있는 그래픽에 대한 일반적인 개념이다.
  
## Kotlin 문법
- apply
- When
- Random
- Collection
  - Set, List
- 람다함수

## 로또 번호 추첨기
- 0~5개까지 수동 선택 가능하도록 구현하기
- 수동 선택한 번호를 제외한 나머지 번호는 랜덤으로 표시하기

***
## Collection(https://kotlinlang.org/docs/collections-overview.html)

## 로또 번호 추첨기 구현 알고리즘 생각해보기!
- 나노 세컨드 값으로 랜덤값을 생성해 추천해보자
```kotlin
val random = Random()
val numberSet = mutableSetOf<Int>()

while (numberSet.size() < 6){
    val randomNumber = random.nextInt(45) + 1
    numberSet.add(randomNumber)
}

println(numberSet)
```
```kotlin
val random = Random()
val list = mutableListOf<Int>().apply { 
    for(i in 1..45){
        this.add(i) //1~45 숫자를 리스트에 넣은다.
    }
}
list.shuffle()
println(list.sublist())
```

***
## XML 
**ConstraintLayout**(https://developer.android.com/training/constraint-layout?hl=ko)
- 강제나 제약을 두고 레이아웃을 구성한다.
