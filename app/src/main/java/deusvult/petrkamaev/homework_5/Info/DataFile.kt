package deusvult.petrkamaev.homework_5.Info

import deusvult.petrkamaev.homework_5.IViewModel
import deusvult.petrkamaev.homework_5.R


data class NewsList(val title: String, val body: String): IViewModel
data class NotificationsList(val title: String, val image: Int) : IViewModel


object DataFile {

    val news by lazy {
        listOf(
            NewsList(
                "test1",
                "News"
            ),
            NewsList(
                "test2",
                "News"
            ),
            NewsList(
                "test3",
                "News"
            ),
            NewsList(
                "test4",
                "News"
            ),
            NewsList(
                "test5",
                "News"
            ),
            NewsList(
                "test6",
                "News"
            ),
            NewsList(
                "test7",
                "News"
            ),
            NewsList(
                "test8",
                "News"
            ),
            NewsList(
                "test9",
                "News"
            ),
            NewsList(
                "test10",
                "News"
            )
        )

    }

    val notifications by lazy {
        listOf(
            NotificationsList(
                "Test1",
                R.drawable.feed
            ),
            NotificationsList(
                "Test2",
                R.drawable.feed
            ),
            NotificationsList(
                "Test3",
                R.drawable.feed
            ),
            NotificationsList(
                "Test4",
                R.drawable.feed
            ),
            NotificationsList(
                "Test5",
                R.drawable.feed
            ),
            NotificationsList(
                "Test6",
                R.drawable.feed
            ),
            NotificationsList(
                "Test7",
                R.drawable.feed
            ),
            NotificationsList(
                "Test8",
                R.drawable.feed
            ),
            NotificationsList(
                "Test9",
                R.drawable.feed
            ),
            NotificationsList(
                "Test10",
                R.drawable.feed
            )
        )
    }
    val allItems = news + notifications
}