package com.kwang0.androidwisywig.ui.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.irshulx.Editor
import com.github.irshulx.EditorListener
import com.github.irshulx.models.EditorTextStyle
import com.kwang0.androidwisywig.R
import android.graphics.drawable.GradientDrawable
import android.os.PersistableBundle
import android.provider.MediaStore
import android.widget.Button
import java.io.IOException


class IrshuActivity : AppCompatActivity() {

    private var editor: Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irshu)

        editor = findViewById(R.id.editorIrshu)

        findViewById<View>(R.id.action_h1).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.H1
            )
        }
        findViewById<View>(R.id.action_h2).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.H2
            )
        }
        findViewById<View>(R.id.action_h3).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.H3
            )
        }
        findViewById<View>(R.id.action_bold).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.BOLD
            )
        }
        findViewById<View>(R.id.action_Italic).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.ITALIC
            )
        }
        findViewById<View>(R.id.action_indent).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.INDENT
            )
        }
        findViewById<View>(R.id.action_blockquote).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.BLOCKQUOTE
            )
        }
        findViewById<View>(R.id.action_outdent).setOnClickListener {
            editor?.updateTextStyle(
                EditorTextStyle.OUTDENT
            )
        }
        findViewById<View>(R.id.action_bulleted).setOnClickListener { editor?.insertList(false) }
        findViewById<View>(R.id.action_unordered_numbered).setOnClickListener {
            editor?.insertList(
                true
            )
        }
        findViewById<View>(R.id.action_hr).setOnClickListener { editor?.insertDivider() }
        findViewById<View>(R.id.action_color).setOnClickListener {
//            ColorPickerPopUp.Builder(this@EditorTestActivity)
//                .initialColor(Color.RED) // Set initial color
//                .enableAlpha(true) // Enable alpha slider or not
//                .okTitle("Choose")
//                .cancelTitle("Cancel")
//                .showIndicator(true)
//                .showValue(true)
//                .build()
//                .show(findViewById(android.R.id.content), object : ColorPickerObserver() {
//                    fun onColorPicked(color: Int) {
//                        Toast.makeText(
//                            this@EditorTestActivity,
//                            "picked" + colorHex(color),
//                            Toast.LENGTH_LONG
//                        ).show()
//                        editor?.updateTextColor(colorHex(color))
//                    }
//
//                    fun onColor(color: Int, fromUser: Boolean) {}
//
//                })
        }
        findViewById<View>(R.id.action_insert_image).setOnClickListener { editor?.openImagePicker() }
        findViewById<View>(R.id.action_insert_link).setOnClickListener { editor?.insertLink() }
        findViewById<View>(R.id.action_erase).setOnClickListener { editor?.clearAllContents() }


        //editor.dividerBackground=R.drawable.divider_background_dark;
        //editor.setFontFace(R.string.fontFamily__serif);

        //editor.dividerBackground=R.drawable.divider_background_dark;
        //editor.setFontFace(R.string.fontFamily__serif);
        val headingTypeface: Map<Int, String> = getHeadingTypeface()
        val contentTypeface: Map<Int, String> = getContentTypeface()
        editor?.headingTypeface = headingTypeface
        editor?.contentTypeface = contentTypeface
        editor?.setDividerLayout(R.layout.tmpl_divider_layout)
        editor?.setEditorImageLayout(R.layout.tmpl_image_view)
        editor?.setListItemLayout(R.layout.tmpl_list_item)
        //editor.setNormalTextSize(10);
        // editor.setEditorTextColor("#FF3333");
        //editor.StartEditor();
        //editor.setNormalTextSize(10);
        // editor.setEditorTextColor("#FF3333");
        //editor.StartEditor();
        editor?.editorListener = object : EditorListener {
            override fun onTextChanged(editText: EditText, text: Editable) {
                // Toast.makeText(EditorTestActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            override fun onUpload(image: Bitmap, uuid: String) {
                Toast.makeText(this@IrshuActivity, uuid, Toast.LENGTH_LONG).show()
                editor?.onImageUploadComplete(
                    "http://www.videogamesblogger.com/wp-content/uploads/2015/08/metal-gear-solid-5-the-phantom-pain-cheats-640x325.jpg",
                    uuid
                )
                // editor.onImageUploadFailed(uuid);
            }

            override fun onRenderMacro(
                name: String,
                props: Map<String, Any>,
                index: Int
            ): View {
                return layoutInflater.inflate(R.layout.layout_authored_by, null)
            }
        }

        val text =
            "<h1 data-tag=\"input\" style=\"color:#c00000;\"><span style=\"color:#C00000;\">textline 1 a great time and I will branch office is closed on Sundays</span></h1><hr data-tag=\"hr\"/><p data-tag=\"input\" style=\"color:#000000;\">the only one that you have received the stream free and open minded person to discuss a business opportunity to discuss my background.</p><div data-tag=\"img\"><img src=\"http://www.videogamesblogger.com/wp-content/uploads/2015/08/metal-gear-solid-5-the-phantom-pain-cheats-640x325.jpg\" /><p data-tag=\"img-sub\" style=\"color:#FF0000;\" class=\"editor-image-subtitle\"><b>it is a great weekend and we will have the same to me that the same a great time</b></p></div><p data-tag=\"input\" style=\"color:#000000;\">I have a place where I have a great time and I will branch manager state to boast a new job in a few weeks and we can host or domain to get to know.</p><div data-tag=\"img\"><img src=\"http://www.videogamesblogger.com/wp-content/uploads/2015/08/metal-gear-solid-5-the-phantom-pain-cheats-640x325.jpg\" /><p data-tag=\"img-sub\" style=\"color:#5E5E5E;\" class=\"editor-image-subtitle\">the stream of water in a few weeks and we can host in the stream free and no ippo</p></div><p data-tag=\"input\" style=\"color:#000000;\">it is that I can get it done today will online at location and I am not a big difference to me so that we are headed <a href=\"www.google.com\">www.google.com</a> it was the only way I.</p><blockquote data-tag=\"input\" style=\"color:#000000;\">I have to do the negotiation and a half years old story and I am looking forward in a few days.</blockquote><p data-tag=\"input\" style=\"color:#000000;\">it is not a good day to get the latest version to blame it to the product the.</p><ol data-tag=\"ol\"><li data-tag=\"list-item-ol\"><span style=\"color:#000000;\">it is that I can send me your email to you and I am not able a great time and consideration I have to do the needful.</span></li><li data-tag=\"list-item-ol\"><span style=\"color:#000000;\">I have to do the needful and send to me and</span></li><li data-tag=\"list-item-ol\"><span style=\"color:#000000;\">I will be a while ago to a great weekend a great time with the same.</span></li></ol><p data-tag=\"input\" style=\"color:#000000;\">it was u can do to make an offer for a good day I u u have been working with a new job to the stream free and no.</p><p data-tag=\"input\" style=\"color:#000000;\">it was u disgraced our new home in time to get the chance I could not find a good idea for you have a great.</p><p data-tag=\"input\" style=\"color:#000000;\">I have to do a lot to do the same a great time and I have a great.</p><p data-tag=\"input\" style=\"color:#000000;\"></p>"
        //editor.render("<p>Hello man, whats up!</p>");
        //String text = "<p data-tag=\"input\" style=\"color:#000000;\">I have to do the needful and send to me and my husband is in a Apple has to offer a variety is not a.</p><p data-tag=\"input\" style=\"color:#000000;\">I have to go with you will be highly grateful if we can get the latest</p><blockquote data-tag=\"input\" style=\"color:#000000;\">I have to do the negotiation and a half years old story and I am looking forward in a few days.</blockquote><p data-tag=\"input\" style=\"color:#000000;\">I have to do the needful at your to the product and the other to a new job is going well and that the same old stuff and a half day city is the stream and a good idea to get onboard the stream.</p>";
        //editor.render("<p>Hello man, whats up!</p>");
        //String text = "<p data-tag=\"input\" style=\"color:#000000;\">I have to do the needful and send to me and my husband is in a Apple has to offer a variety is not a.</p><p data-tag=\"input\" style=\"color:#000000;\">I have to go with you will be highly grateful if we can get the latest</p><blockquote data-tag=\"input\" style=\"color:#000000;\">I have to do the negotiation and a half years old story and I am looking forward in a few days.</blockquote><p data-tag=\"input\" style=\"color:#000000;\">I have to do the needful at your to the product and the other to a new job is going well and that the same old stuff and a half day city is the stream and a good idea to get onboard the stream.</p>";
        editor?.render(text)
//        findViewById<View>(R.id.btnRender).setOnClickListener { /*
//                    Retrieve the content as serialized, you could also say getContentAsHTML();
//                    */
//            val text = editor?.contentAsSerialized
//            editor?.contentAsHTML
//            val intent = Intent(applicationContext, RenderTestActivity::class.java)
//            intent.putExtra("content", text)
//            startActivity(intent)
//        }

    }


    private fun render() {
        val x =
            "<h2 id=\"installation\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;color:#c00000;background-color:#333;text-align:center; margin-top: -80px !important;\">Installation</h2>" +
                    "<h3 id=\"requires-html5-doctype\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;color:#ff0000; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Requires HTML5 doctype</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">Bootstrap uses certain HTML elements and CSS properties which require HTML5 doctype. Include&nbsp;<code style=\"font-size: 12.6px;\">&lt;!DOCTYPE html&gt;</code>&nbsp;in the beginning of all your projects.</p>" +
                    "<img src=\"http://www.scifibloggers.com/wp-content/uploads/TOR_2.jpg\" />" +
                    "<h2 id=\"integration\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-top: -80px !important;\">Integration</h2>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">3rd parties available in django, rails, angular and so on.</p>" +
                    "<h3 id=\"django\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Django</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">Handy update for your django admin page.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: #c00000;\">django-summernote</li><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://pypi.python.org/pypi/django-summernote\" target=\"_blank\">summernote plugin for Django</a></li></ul>" +
                    "<h3 id=\"ruby-on-rails\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Ruby On Rails</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">This gem was built to gemify the assets used in Summernote.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://github.com/summernote/summernote-rails\" target=\"_blank\">summernote-rails</a></li></ul>" +
                    "<h3 id=\"angularjs\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">AngularJS</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">AngularJS directive to Summernote.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://github.com/summernote/angular-summernote\">angular-summernote</a></li></ul>" +
                    "<h3 id=\"apache-wicket\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Apache Wicket</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">Summernote widget for Wicket Bootstrap.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"http://wb-mgrigorov.rhcloud.com/summernote\" target=\"_blank\">demo</a></li><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://github.com/l0rdn1kk0n/wicket-bootstrap/tree/4f97ca783f7279ca43f9e2ee790703161f59fa40/bootstrap-extensions/src/main/java/de/agilecoders/wicket/extensions/markup/html/bootstrap/editor\" target=\"_blank\">source code</a></li></ul>" +
                    "<h3 id=\"webpack\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Webpack</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">Example about using summernote with webpack.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://github.com/hackerwins/summernote-webpack-example\" target=\"_blank\">summernote-webpack-example</a></li></ul>" +
                    "<h3 id=\"meteor\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; margin-bottom: 8px; margin-right: 0px; margin-left: 0px;\">Meteor</h3>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\">Example about using summernote with meteor.</p>" +
                    "<ul style=\"color: rgb(51, 51, 51);\"><li style=\"font-size: 14px; color: rgb(104, 116, 127);\"><a href=\"https://github.com/hackerwins/summernote-meteor-example\" target=\"_blank\">summernote-meteor-example</a></li></ul>" +
                    "<p style=\"font-size: 14px; color: rgb(104, 116, 127);\"><br></p>"
        editor?.render(x)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == editor?.PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data?.data != null) {
            try {
                editor?.insertImage(MediaStore.Images.Media.getBitmap(contentResolver, data.data))
            } catch (ex: IOException) {
                Toast.makeText(applicationContext, ex.message, Toast.LENGTH_SHORT).show()
                ex.printStackTrace()
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(applicationContext, "Cancelled", Toast.LENGTH_SHORT).show()
            // editor?.RestoreState()
        }
    }

    private fun setGhost(button: Button) {
        val radius = 4
        val background = GradientDrawable()
        background.shape = GradientDrawable.RECTANGLE
        background.setStroke(4, Color.WHITE)
        background.cornerRadius = radius.toFloat()
        button.setBackgroundDrawable(background)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        setGhost(findViewById(R.id.btnRender))
    }

    private fun getHeadingTypeface(): Map<Int, String> {
        return mapOf(
            Pair(Typeface.NORMAL, "fonts/GreycliffCF-Bold.ttf"),
            Pair(Typeface.BOLD, "fonts/GreycliffCF-Heavy.ttf"),
            Pair(Typeface.ITALIC, "fonts/GreycliffCF-Heavy.ttf"),
            Pair(Typeface.BOLD_ITALIC, "fonts/GreycliffCF-Bold.ttf"),
        )
    }

    private fun getContentTypeface(): Map<Int, String> {
        return mapOf(
            Pair(Typeface.NORMAL, "fonts/Lato-Medium.ttf"),
            Pair(Typeface.BOLD, "fonts/Lato-Bold.ttf"),
            Pair(Typeface.ITALIC, "fonts/Lato-MediumItalic.ttf"),
            Pair(Typeface.BOLD_ITALIC, "fonts/Lato-BoldItalic.ttf"),
        )
    }
}
