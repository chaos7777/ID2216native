package com.darthvader11.bandlink.ui.post

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.darthvader11.bandlink.R
import com.darthvader11.bandlink.models.Supplier
import com.darthvader11.bandlink.ui.comment.CommentsFragment
import com.darthvader11.bandlink.ui.home.HomeFragment
import com.darthvader11.bandlink.ui.newpost.NewpostFragment

class PostFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_post, container, false)

        val btnComment : Button =  root.findViewById(R.id.btnComment)
        btnComment.setOnClickListener(this)
        val btnShare : Button = root.findViewById(R.id.btnShare)
        btnShare.setOnClickListener(this)
        val btnApply : Button = root.findViewById(R.id.btnApply)
        btnApply.setOnClickListener(this)
        val backButton : ImageView = root.findViewById(R.id.backButton)
        backButton.setOnClickListener(this)
        val args = arguments

        if(args != null) {
            Supplier.comments[3].comment = args.getString("post_id").toString()
        }








         Supplier.comments[1].comment = "This has been changed hahaa" //Testing


        return root
    }



    override fun onClick(v: View?) {
        when (v?.id){
            R.id.backButton -> {
                fragmentManager?.popBackStack()
            }
            R.id.btnComment -> {
                Toast.makeText(context, "DIZ WORKS", Toast.LENGTH_SHORT).show()
                val manager: FragmentManager? = fragmentManager
                val transaction: FragmentTransaction? = manager?.beginTransaction()
                transaction?.replace(R.id.nav_host_fragment, CommentsFragment() , CommentsFragment::class.java.simpleName  )
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
            R.id.btnShare -> {
                val intent = Intent()
                val message = "calincapitanu.com/Post.html"
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, "Share to: "))
            }

            R.id.btnApply -> {
                Toast.makeText(context, "DIZ WORKS aswell", Toast.LENGTH_SHORT).show()
                val manager: FragmentManager? = fragmentManager
                val transaction: FragmentTransaction? = manager?.beginTransaction()
                transaction?.replace(R.id.nav_host_fragment, NewpostFragment() , NewpostFragment::class.java.simpleName  )
                transaction?.addToBackStack(null)
                transaction?.commit()


            }



        }

    }
}