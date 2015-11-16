/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.tokusatsu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
/**
 * Created by Mário on 28/09/2015.
 */
public class TokusatsuListFragment extends Fragment {



    //insere os Tokusatsus na lista do reciclerview
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_toku_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(), Tokusatsu.prePopulate()));
    }


    public static class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<Tokusatsu> listTokusatsu;
        private Context context;

        public class ViewHolder extends RecyclerView.ViewHolder {

           View root;

            public ImageView imageViewAvatar;
            public TextView textViewName;



            public ViewHolder(View view) {
                super(view);
                root = view;
                imageViewAvatar = (ImageView) view.findViewById(R.id.avatar);
                textViewName = (TextView) view.findViewById(R.id.name);


            }

        }

        public SimpleStringRecyclerViewAdapter(Context context, List<Tokusatsu> items) {
            context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
            mBackground = mTypedValue.resourceId;
            listTokusatsu = items;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            view.setBackgroundResource(mBackground);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final Tokusatsu tokusatsu = listTokusatsu.get(position);
            holder.textViewName.setText(tokusatsu.name);

            Glide.with(context).load(tokusatsu.getPhotoResourceId(context)).fitCenter().into(holder.imageViewAvatar);
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, TokusatsuDetailActivity.class);
                    intent.putExtra(TokusatsuDetailActivity.EXTRA_OBJECT, tokusatsu);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return listTokusatsu.size();
        }

    }

        }
