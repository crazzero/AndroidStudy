package com.kwang0.lintchecker

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue


class CustomIssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(ContentViewDetector.ISSUE)

    override val api: Int = CURRENT_API
}
