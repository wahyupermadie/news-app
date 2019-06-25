package com.example.newsapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.newsapp.service.network.ApiService
import com.example.newsapp.service.network.model.ResponseNews
import com.example.newsapp.service.network.model.articles.ResponseArticles
import com.example.newsapp.utils.SchedulerProvider
import com.example.newsapp.utils.TestSchedulerProvider
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainViewModelTest {
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private
    lateinit var scheduler: SchedulerProvider

    @Mock
    private
    lateinit var apiService: ApiService

    private var newsResponse = mutableListOf<ResponseNews>()
    private  var articleResponse  = mutableListOf<ResponseArticles>()

    @InjectMocks
    private lateinit var viewModel : MainViewModel

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        scheduler = TestSchedulerProvider()
        viewModel = MainViewModel(apiService)
    }

    @Test
    fun getNewsList() {
        val newsList = viewModel.repository.news.testObserver()
        viewModel.getNewsList()
        Truth.assert_()
            .that(newsList.observedValues)
            .isEqualTo(newsResponse)
    }
}