package com.example.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class LiteratureAdapter extends RecyclerView.Adapter {

    private List<Literature> mLiteratureList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView;

        switch (viewType) {
            case Literature.TYPE_BOOK:
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.book_item_layout, viewGroup, false);
                return new BookViewHolder(itemView);
            case Literature.TYPE_MAGAZINE:
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.magazine_item_layout, viewGroup, false);
                return new MagazineViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.newspaper_item_layout, viewGroup, false);
                return new NewspaperViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (getItemViewType(position)) {
            case Literature.TYPE_BOOK:
                ((BookViewHolder) viewHolder).bindView(position);
                break;
            case Literature.TYPE_MAGAZINE:
                ((MagazineViewHolder) viewHolder).bindView(position);
                break;
            case Literature.TYPE_NEWSPAPER:
                ((NewspaperViewHolder) viewHolder).bindView(position);
                break;
        }

    }

    public void setLiteratureList(List<? extends Literature> literatureList) {
        if (mLiteratureList == null)
            mLiteratureList = new ArrayList<>();
        mLiteratureList.clear();
        mLiteratureList.addAll(literatureList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mLiteratureList == null ? 0 : mLiteratureList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mLiteratureList.get(position).getType();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(int position) {
            DataObjects.Book book = (DataObjects.Book) mLiteratureList.get(position);
        }

    }

    class MagazineViewHolder extends RecyclerView.ViewHolder {
        public MagazineViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(int position) {
            DataObjects.Magazine magazine = (DataObjects.Magazine) mLiteratureList.get(position);
        }

    }

    class NewspaperViewHolder extends RecyclerView.ViewHolder {
        public NewspaperViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bindView(int position) {
            DataObjects.Newspaper newspaper = (DataObjects.Newspaper) mLiteratureList.get(position);
        }

    }

}
