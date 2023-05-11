package com.gamepubjonghwan.tp05unittest

import org.junit.Assert.*
import org.junit.Test
import org.mockito.kotlin.*

class MockitoTest {
    @Test
    fun animal_stubTest(){
        // 가짜 값을 가진 모의 객체 생성
        val mockAnimal = mock<Animal> {
            on { age } doReturn 30
            on { name } doReturn "참새"
            on { canFly } doReturn true
        }
        assertTrue(mockAnimal.age == 30)
        assertTrue(mockAnimal.name == "참새")
        assertTrue(mockAnimal.canFly)
    }

    @Test
    fun animal_stubTest2(){
        val mockAnimal = mock<Animal>()

        val animalList = listOf(
            "호랑이", "코끼리", "독수리"
        )

        whenever(mockAnimal.animalList).thenReturn(animalList)
        assertNotNull(animalList)
        assertEquals(animalList.size, 3)

        val n = 3
        println("\nanimalList ${n}번째: ${mockAnimal.animalList[n-1]}\n")
    }

    @Test
    fun animal_doThrowTest(){
        val mockAnimal = mock<Animal>()
        // mockAnimal의 age가 20이 되면 예외를 발생시켜라
        doThrow(RuntimeException()).whenever(mockAnimal).age = eq(20)

        mockAnimal.age = 23
        mockAnimal.age = 55
        mockAnimal.age = 20
    }

    // 해당 구문이 호출되었는지를 체크
    @Test
    fun verifyTest(){
        val mockAnimal = mock<Animal>()
        mockAnimal.name = "참새"

        // n번 호출했는지 체크
//        verify(mockAnimal, times(3)).name = any() // failure

        // 호출 안했는지 체크
        verify(mockAnimal, never()).name // success
        verify(mockAnimal, never()).name = eq("호랑이") // success
//        verify(mockAnimal, never()).name = "참새" // failure

        // 지정된 시간 안으로 1번 이상 메소드를 호출했는지 체크
        verify(mockAnimal, timeout(100).atLeast(1)).name = any() // success
    }
}