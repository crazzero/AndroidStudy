package com.kwang0.androidwisywig.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kwang0.androidwisywig.R
import jp.wasabeef.richeditor.RichEditor


class WasaActivity : AppCompatActivity() {

    private var mEditor: RichEditor? = null
    private var mPreview: TextView? = null

    private var isTextChanged = false
    private var isBgChanged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wasa)

        mEditor = findViewById(R.id.editor)
        mEditor?.apply {
            setEditorHeight(200)
            setEditorFontSize(22)
            setEditorFontColor(Color.RED)
            // setEditorBackgroundColor(Color.BLUE)
            // setBackgroundColor(Color.BLUE)
            // setBackgroundResource(R.drawable.bg)
            setPadding(10, 10, 10, 10)
            // setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg")
            setPlaceholder("Insert text here...")
            // setInputEnabled(false)
        }

        mPreview = findViewById(R.id.preview)

        mEditor?.setOnTextChangeListener { text ->
            mPreview!!.text = text
        }

        findViewById<View>(R.id.action_undo).setOnClickListener { mEditor?.undo() }

        findViewById<View>(R.id.action_redo).setOnClickListener { mEditor?.redo() }

        findViewById<View>(R.id.action_bold).setOnClickListener { mEditor?.setBold() }

        findViewById<View>(R.id.action_italic).setOnClickListener { mEditor?.setItalic() }

        findViewById<View>(R.id.action_subscript).setOnClickListener { mEditor?.setSubscript() }

        findViewById<View>(R.id.action_superscript).setOnClickListener { mEditor?.setSuperscript() }

        findViewById<View>(R.id.action_strikethrough).setOnClickListener { mEditor?.setStrikeThrough() }

        findViewById<View>(R.id.action_underline).setOnClickListener { mEditor?.setUnderline() }

        findViewById<View>(R.id.action_heading1).setOnClickListener { mEditor?.setHeading(1) }

        findViewById<View>(R.id.action_heading2).setOnClickListener { mEditor?.setHeading(2) }

        findViewById<View>(R.id.action_heading3).setOnClickListener { mEditor?.setHeading(3) }

        findViewById<View>(R.id.action_heading4).setOnClickListener { mEditor?.setHeading(4) }

        findViewById<View>(R.id.action_heading5).setOnClickListener { mEditor?.setHeading(5) }

        findViewById<View>(R.id.action_heading6).setOnClickListener { mEditor?.setHeading(6) }

        findViewById<View>(R.id.action_txt_color).setOnClickListener {
            mEditor?.setTextColor(if (isTextChanged) Color.BLACK else Color.RED)
            isTextChanged = !isTextChanged
        }

        findViewById<View>(R.id.action_bg_color).setOnClickListener {
            mEditor?.setTextBackgroundColor(if (isBgChanged) Color.TRANSPARENT else Color.YELLOW)
            isBgChanged = !isBgChanged

        }

        findViewById<View>(R.id.action_indent).setOnClickListener { mEditor?.setIndent() }

        findViewById<View>(R.id.action_outdent).setOnClickListener { mEditor?.setOutdent() }

        findViewById<View>(R.id.action_align_left).setOnClickListener { mEditor?.setAlignLeft() }

        findViewById<View>(R.id.action_align_center).setOnClickListener { mEditor?.setAlignCenter() }

        findViewById<View>(R.id.action_align_right).setOnClickListener { mEditor?.setAlignRight() }

        findViewById<View>(R.id.action_blockquote).setOnClickListener { mEditor?.setBlockquote() }

        findViewById<View>(R.id.action_insert_bullets).setOnClickListener { mEditor?.setBullets() }

        findViewById<View>(R.id.action_insert_numbers).setOnClickListener { mEditor?.setNumbers() }

        findViewById<View>(R.id.action_insert_image).setOnClickListener {
            mEditor?.insertImage(
                "https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg",
                "dachshund", 320
            )
        }

        findViewById<View>(R.id.action_insert_youtube).setOnClickListener {
            mEditor?.insertYoutubeVideo(
                "https://www.youtube.com/embed/pS5peqApgUA"
            )
        }

        findViewById<View>(R.id.action_insert_audio).setOnClickListener { mEditor?.insertAudio("https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_5MG.mp3") }

        findViewById<View>(R.id.action_insert_video).setOnClickListener {
            mEditor?.insertVideo(
                "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_10MB.mp4",
                360
            )
        }

        findViewById<View>(R.id.action_insert_link).setOnClickListener {
            mEditor?.insertLink(
                "https://github.com/wasabeef",
                "wasabeef"
            )
        }
        findViewById<View>(R.id.action_insert_checkbox).setOnClickListener { mEditor?.insertTodo() }
    }
}
