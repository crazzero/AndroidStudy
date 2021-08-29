package com.kwang0.lintchecker

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod

import org.jetbrains.uast.UCallExpression


class ContentViewDetector : Detector(), SourceCodeScanner {

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (context.evaluator.isMemberInClass(method, "androidx.databinding.DataBindingUtil")) {
            return
        }
        context.report(
            ISSUE,
            node,
            context.getLocation(node),
            "Use DataBindingUtil.setContentView() instead"
        )
    }

    companion object {

        val ISSUE = Issue.create(
            id = this::class.java.simpleName,
            briefDescription = "Prohibits usages of setContentView()",
            explanation = "Prohibits usages of setContentView(), use DataBindingUtil.setContentView() instead",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.ERROR,
            implementation = Implementation(ContentViewDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}
