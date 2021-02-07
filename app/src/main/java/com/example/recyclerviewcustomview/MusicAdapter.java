package com.example.recyclerviewcustomview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {


    private List<Music> musicArrayList;

     private OnItemCLickListener lickListener;

    public void setMusicArrayList(List<Music> musicArrayList) {
        this.musicArrayList = musicArrayList;
        notifyDataSetChanged();
    }

    public MusicAdapter(OnItemCLickListener lickListener) {
        this.lickListener = lickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music music = musicArrayList.get(position);
        holder.bind(music);
    }

    @Override
    public int getItemCount() {
        if (musicArrayList != null)
            return musicArrayList.size();
        return 0;
    }


    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextViewTitle;
        private ImageView mImageViewMusic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextViewTitle = itemView.findViewById(R.id.textViewMusicTitle);
            mImageViewMusic = itemView.findViewById(R.id.imageViewMusic);
        }

        public void bind(Music music) {
            mImageViewMusic.setBackgroundResource(music.getImageId());
            mTextViewTitle.setText(music.getTitle());
        }

        @Override
        public void onClick(View v) {
         lickListener.onItemClick(musicArrayList.get(getAdapterPosition()));
        }
    }

    interface OnItemCLickListener {
        void onItemClick(Music music);
    }
}
