package com.example.mytrip;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<ModelClass> modelClassList;
    public Adapter(List<ModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder viewholder, final int position) {
        int resource = modelClassList.get(position).getImageIcon();
        String title = modelClassList.get(position).getTitle();
        final String body = modelClassList.get(position).getBody();

        viewholder.btnReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AllTripInfo.class);
                intent.putExtra("tripId", position);
                v.getContext().startActivity(intent);
            }

        });
        viewholder.setData(resource, title, body);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title;
        private TextView body;
        Button  btnReadMore;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            btnReadMore = itemView.findViewById(R.id.btn_read_more);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textTitle);
            body = itemView.findViewById(R.id.textBody);
        }

        private void setData(int imageResource, String titleText, String bodyText)
        {
            imageView.setImageResource(imageResource);
            title.setText(titleText);
            body.setText(bodyText);
            }

    }

}
