package com.example.comiaseokt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import com.example.comiaseokt.databinding.ItemProductoBinding

/****
 * Project: Sports
 * From: com.cursosandroidant.sports
 * Created by Alain Nicolás Tello on 29/09/21 at 12:32
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class SportListAdapter(private val listener:OnClickListener) :
    ListAdapter<Sport, RecyclerView.ViewHolder>(SportDiffCallback()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_productos, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val sport = getItem(position)

        with(holder as ViewHolder){
            setListener(sport)

            binding.txtReferencia.text = sport.Ref
            binding.txtNombre.text=sport.Nombre
            binding.txtPrecio.text=sport.Unit.toString()

            val request= ImageRequest.Builder(context)
                .data(sport.img)
                .crossfade(true)
                .transformations(listOf(
                    BlurTransformation(context,25f)
                ))
                .size(1280,720)
                .target(
                    onStart = {
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    },
                    onSuccess = {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imgPhoto.setImageDrawable(it)
                    },
                    onError = {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    }
                )
                .build()
            context.imageLoader.enqueue(request)
          /*  Glide.with(context)
                .asBitmap()
                .load(sport.imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(object : CustomTarget<Bitmap>(1280, 720){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imgPhoto.setImageBitmap(resource)
                    }

                    override fun onLoadStarted(placeholder: Drawable?) {
                        super.onLoadStarted(placeholder)
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        super.onLoadFailed(errorDrawable)
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })*/
/*
            Picasso.get()
                .load(sport.imgUrl)
                .resize(1280, 720)
                .into(object : Target{
                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imgPhoto.setImageBitmap(bitmap)
                    }

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                        binding.imgPhoto.setImageResource(R.drawable.noimg)
                    }
                })

*/
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemProductoBinding.bind(view)

        fun setListener(sport: Sport){
           // binding.root.setOnClickListener { listener.onClick(sport) }
        }
    }

    class SportDiffCallback: DiffUtil.ItemCallback<Sport>(){
        override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean = oldItem.Ref == newItem.Ref

        override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean = oldItem == newItem
    }


}