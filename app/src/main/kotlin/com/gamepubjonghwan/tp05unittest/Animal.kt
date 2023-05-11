package com.gamepubjonghwan.tp05unittest

// 테스트를 받으려는 클래스, 필드, 메서드는 final/private이면 안된다.
open class Animal(
    open var name: String,
    open var age: Int,
    open var canFly: Boolean,
    open var animalList: List<String>
)