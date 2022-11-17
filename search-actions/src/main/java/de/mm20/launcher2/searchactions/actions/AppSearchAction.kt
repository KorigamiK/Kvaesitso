package de.mm20.launcher2.searchactions.actions

import android.app.SearchManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import de.mm20.launcher2.ktx.tryStartActivity

data class AppSearchAction(
    override val label: String,
    val componentName: ComponentName,
    val query: String,
    override val icon: SearchActionIcon = SearchActionIcon.Custom,
    override val iconColor: Int = 1,
    override val customIcon: String? = null,
): SearchAction {

    override fun start(context: Context) {
        val intent = Intent(Intent.ACTION_SEARCH).apply {
            component = componentName
            putExtra(SearchManager.QUERY, query)
            putExtra(SearchManager.USER_QUERY, query)
        }
        context.tryStartActivity(intent)
    }
}