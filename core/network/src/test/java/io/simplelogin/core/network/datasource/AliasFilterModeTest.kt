package io.simplelogin.core.network.datasource

import io.simplelogin.core.model.ui.AliasFilterMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AliasFilterModeTest {
    @Test
    fun aliasFilterModesIncludeEnabledAndDisabledViews() {
        assertTrue(AliasFilterMode.entries.any { it == AliasFilterMode.ALL })
        assertTrue(AliasFilterMode.entries.any { it == AliasFilterMode.ENABLED })
        assertTrue(AliasFilterMode.entries.any { it == AliasFilterMode.DISABLED })
        assertEquals(listOf(AliasFilterMode.ALL, AliasFilterMode.PINNED, AliasFilterMode.ENABLED, AliasFilterMode.DISABLED), AliasFilterMode.entries)
    }
}
