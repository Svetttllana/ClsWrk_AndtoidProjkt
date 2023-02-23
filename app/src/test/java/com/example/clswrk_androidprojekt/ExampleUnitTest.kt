package com.example.clswrk_androidprojekt

import com.example.clswrk_androidprojekt.data.api.ApiService
import com.example.clswrk_androidprojekt.data.api.ApiServiceSecond
import com.example.clswrk_androidprojekt.data.database.FavoritesEntity
import com.example.clswrk_androidprojekt.data.database.ItemsEntity
import com.example.clswrk_androidprojekt.data.database.dao.ItemsDAO
import com.example.clswrk_androidprojekt.data.items.ItemsRepositoryImpl
import com.example.clswrk_androidprojekt.data.model.ItemsResponse
import com.example.clswrk_androidprojekt.domain.items.ItemsRepository
import com.example.clswrk_androidprojekt.domain.model.ItemsModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.createTestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response


class ExampleUnitTest {

    lateinit var itemsRepository: ItemsRepository

    @Mock // ето мы создали пустышку такую
    lateinit var apiService: ApiService

    @Mock
    lateinit var apiServiceSecond: ApiServiceSecond

    @Mock
    lateinit var itemsDAO: ItemsDAO


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        itemsRepository = ItemsRepositoryImpl(apiService, apiServiceSecond, itemsDAO)

    }

    @Test
    fun `getData request successful`() {

        val response = Response.success(ItemsResponse(listOf()))

        createTestCoroutineScope(TestCoroutineScope().testScheduler).launch {
            Mockito.`when`(apiService.getData()).thenReturn(response)
            itemsRepository.getData()

            verify(apiService, only()).getData()
        }
    }

    @Test
    fun `getData request error`() {

        val response = Response.success(ItemsResponse(listOf()))

        createTestCoroutineScope(TestCoroutineScope().testScheduler).launch {
            Mockito.`when`(apiService.getData()).thenReturn(response)

            itemsRepository.getData()

            verify(apiService, only()).getData()
        }
    }

    @Test
    fun `showData gave from database success`() {
        val itemsEntity = listOf(ItemsEntity(0, " ", "", false))
        runBlocking {
            `when`(itemsDAO.getItemsEntities()).thenReturn(itemsEntity)
            itemsRepository.showData()
            verify(itemsDAO, times(1)).getItemsEntities()
        }
    }


    @Test(expected = Exception::class)
    fun `showData gave from database error`() {
               runBlocking {
            `when`(itemsDAO.getItemsEntities()).thenThrow(java.lang.RuntimeException())
            itemsRepository.showData()
            verify(itemsDAO, never()).getItemsEntities()
        }
    }


    @Test
    fun `deliteItemsByDescription success`() {
        runBlocking {
            doNothing().`when`(itemsDAO)
                .deliteItemEntityByDescription("descr")
            itemsRepository.deliteItemByDescription("descr")

            verify(itemsDAO, times(1))
                .deliteItemEntityByDescription("descr")
        }
    }

    @Test
    fun `getFavorites success`(){
        val favEntity = listOf<FavoritesEntity>()
        runBlocking{
            `when`(itemsDAO.getFavoriteEntities()).thenReturn(listOf())
            itemsRepository.getFavorites()
            verify(itemsDAO, times(1)).getFavoriteEntities()
            assertEquals(favEntity,itemsDAO.getFavoriteEntities())
            assertNotSame(itemsDAO.getItemsEntities(),itemsDAO.getFavoriteEntities())
        }
    }
}