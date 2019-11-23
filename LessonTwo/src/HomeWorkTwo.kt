val tagSuggestionController = TagSuggestionController()
val userSuggestionController = UserSuggestionController()


fun main() {
    fun generalSearch() {
        println("Note:hashtags should start with # and username with @")
        readLine()?.trim()?.let {
            var searchSucced = true
            when {
                it.startsWith("#") -> {
                    searchSucced = tagSuggestionController.search(it)
                }
                it.startsWith("@") -> {
                    searchSucced = userSuggestionController.search(it)
                }
                else -> generalSearch()
            }
            if (!searchSucced) {
                println("Result not fount,try again")
                generalSearch()
            }
        } ?: generalSearch()
    }


    println("Please enter username or hashtag")

    generalSearch()

   println("Type something to search again")
    readLine()
    return main()

}


open class SuggestionController<T : SearchItem> {
    open val items: List<T> = listOf()
    private val recentList: MutableSet<T> = mutableSetOf()
    private val searchedItems: MutableList<T> = mutableListOf()
    open val keyWord = "keyword"

    fun search(searchKey: String): Boolean {
        if (searchKey.length == 1) {
            println(getRecentItemsInfo())
        } else {
            if (isExistItemsWithKeyWord(searchKey)) {
                searchItem()
            } else {
                return false
            }
        }
        return true
    }

    private fun searchItem() {
        println("Select $keyWord you interested in")
        println(getSearchedItemsInfo())

        readLine()?.let {
            selectItem(it)?.let { selectItem ->
                println(selectItem.toString())
            } ?: searchItem()
        } ?: searchItem()

    }

    private fun getItemsWithKeyWord(keyWord: String): List<T> {
        return items.filter { it.contains(keyWord.drop(1)) }
    }

    private fun getRecentItemsInfo(): String {
        var searchedItemsInfo = ""
        recentList.forEach { searchedItemsInfo += it.getItemInfo() + "," }
        return "[$searchedItemsInfo]"
    }

    private fun getSearchedItemsInfo(): String {
        var searchedItemsInfo = ""
        searchedItems.forEach { searchedItemsInfo += it.getItemInfo() + "," }
        return "[$searchedItemsInfo]"
    }

    private fun isExistItemsWithKeyWord(keyWord: String): Boolean {
        searchedItems.clear()
        searchedItems.addAll(getItemsWithKeyWord(keyWord))
        return searchedItems.isNotEmpty()
    }

    private fun selectItem(keyWord: String): T? {
        val selectedItem = searchedItems.firstOrNull { it.isSearchedItem(keyWord) }
        selectedItem?.let {
            recentList.add(it)
        }
        return selectedItem
    }

    fun displayRecentList() {
        recentList.forEach {
            print(it.toString())
        }
    }
}

class TagSuggestionController : SuggestionController<Tag>() {
    override val items: List<Tag>
        get() = tagList

    override val keyWord: String
        get() = "tagname"

}

class UserSuggestionController : SuggestionController<User>() {
    override val items: List<User>
        get() = userList

    override val keyWord: String
        get() = "username"
}

interface SearchItem {
    fun contains(keyWord: String): Boolean

    fun getItemInfo(): String

    fun isSearchedItem(keyWord: String): Boolean
}

data class User(var id: String, var userName: String, var name: String, var surname: String) : SearchItem {
    override fun isSearchedItem(keyWord: String): Boolean {
        return userName == keyWord
    }

    override fun getItemInfo(): String {
        return userName
    }

    override fun contains(keyWord: String): Boolean {
        return surname.contains(keyWord) or name.contains(keyWord)
    }

}

data class Tag(var id: String, var tagName: String) : SearchItem {
    override fun isSearchedItem(keyWord: String): Boolean {
        return tagName == keyWord
    }

    override fun getItemInfo(): String {
        return tagName
    }

    override fun contains(keyWord: String): Boolean {
        return tagName.contains(keyWord)
    }


}