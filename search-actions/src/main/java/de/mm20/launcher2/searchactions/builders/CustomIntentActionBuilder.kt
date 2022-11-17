package de.mm20.launcher2.searchactions.builders

import android.content.Context
import android.content.Intent
import de.mm20.launcher2.searchactions.TextClassificationResult
import de.mm20.launcher2.searchactions.actions.CustomIntentAction
import de.mm20.launcher2.searchactions.actions.SearchAction
import de.mm20.launcher2.searchactions.actions.SearchActionIcon

data class CustomIntentActionBuilder(
    override val label: String,
    val queryKey: String,
    val baseIntent: Intent,
    override val icon: SearchActionIcon = SearchActionIcon.Custom,
    override val iconColor: Int = 1,
    override val customIcon: String? = null,
) : CustomizableSearchActionBuilder {
    override val key: String
        get() = "intent://${baseIntent.toUri(0)}"

    override fun build(context: Context, classifiedQuery: TextClassificationResult): SearchAction {
        return CustomIntentAction(
            label, classifiedQuery.text, queryKey, baseIntent, icon, iconColor, customIcon
        )
    }
}