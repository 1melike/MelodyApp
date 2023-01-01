package com.omerersoz.melodyapp;

import static java.util.Objects.*;

import android.content.Context;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyVieHolder> {

    private Context mContext;
    private ArrayList<MusicFiles> mFiles;

    MusicAdapter(Context mContext,ArrayList<MusicFiles> mfiles)
    {
        this.mFiles=mFiles;
        this.mContext=mContext;
    }
    @NonNull
    @Override
    public MyVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        boolean attachToRoot;
        View view= LayoutInflater.from(mContext).inflate(R.layout.music_items,parent,false);
        return new MyVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVieHolder holder, int position) {
        ObjectInputStream.GetField mfiles = null;
        assert mfiles != null;
        Objects.<MyVieHolder>requireNonNull(holder).file_name.setText(mFiles.get(position).getTitle());
         byte[] image=getAlbumArt(mFiles.get(position).getPath);
         if(image!=null)
         {
             Glide.with(mContext).asBitmap()
                     .load(image)
                     .into(holder.album_art);

         }
          else{
              Glide.with(mContext)
                      .load(R.drawable.bewedoc)
                      .into(holder.album_art);
         }
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public class MyVieHolder extends RecyclerView.ViewHolder
    {
        TextView file_name;
        ImageView album_art;
        public MyVieHolder(@NonNull View itemView) {
            super(itemView);
            file_name=itemView.findViewById(R.id.music_file_name);
            album_art=itemView.findViewById(R.id.music_img);
        }
    }
    private byte[] getAlbumArt(String uri)
    {
        MediaMetadataRetriever retriever= new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] art=retriever.getEmbeddedPicture();
        retriever.release();
        return art;
    }
}
