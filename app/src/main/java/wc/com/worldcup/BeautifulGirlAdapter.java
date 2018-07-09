package wc.com.worldcup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BeautifulGirlAdapter extends RecyclerView.Adapter<BeautifulGirlAdapter.ViewHolder> {

    private List<BeautifulGileItem> mSubjectList;


    static class ViewHolder extends RecyclerView.ViewHolder {

        View subjectView;
        ImageView subjectImage;
        TextView subjectName;

        public ViewHolder(View view) {
            super(view);
            subjectView = view;
            subjectImage = view.findViewById(R.id.subject_image);
            subjectName = view.findViewById(R.id.subject_name);

        }

        //public ViewHolder(List<Subject> subjectList) {
             //mSubjectList =  subjectList;
        //}
    }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.subjectView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    BeautifulGileItem subject = mSubjectList .get(position);
                    Toast.makeText(v.getContext(), "you clicked view " + subject.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.subjectImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
                    BeautifulGileItem fruit = mSubjectList.get(position);
                    Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            BeautifulGileItem subject = mSubjectList.get(position);
            holder.subjectImage.setImageResource(subject.getImageId());
            holder.subjectName.setText(subject.getName());
        }

        @Override
        public int getItemCount() {
            return mSubjectList.size();
        }
}

