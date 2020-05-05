package id.my.avmmartin.matched.ui.approve.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.my.avmmartin.matched.R;
import id.my.avmmartin.matched.data.db.model.Schedule;
import id.my.avmmartin.matched.data.network.firestore.model.User;
import id.my.avmmartin.matched.utils.CommonUtils;

public class ApprovalAdapter extends RecyclerView.Adapter<ApprovalAdapter.ApprovalViewHolder> {

    Context context;

    public ApprovalAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ApprovalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_approval_layout, parent, false);
        return new ApprovalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovalViewHolder holder, int position) {
        //TODO:get user and event
//        User user;
//        Schedule schedule;

//        holder.tvUser.setText(user.getName());
//        holder.tvEventStartDateApproval.setText(CommonUtils.toDateFormat(schedule.getStartTime()));
//        holder.tvEventEndDateApproval.setText(CommonUtils.toDateFormat(schedule.getEndTime()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ApprovalViewHolder extends RecyclerView.ViewHolder {
        TextView tvUser, tvEventStartDateApproval, tvEventEndDateApproval;
        ImageButton ibCancelScheduleApproval, ibAddScheduleApproval;

        public ApprovalViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUser = itemView.findViewById(R.id.tvUser);
            tvEventStartDateApproval = itemView.findViewById(R.id.tvEventStartDateApproval);
            tvEventEndDateApproval = itemView.findViewById(R.id.tvEventEndDateApproval);
            ibCancelScheduleApproval = itemView.findViewById(R.id.ibCancelScheduleApproval);
            ibAddScheduleApproval = itemView.findViewById(R.id.ibAddScheduleApproval);

            ibCancelScheduleApproval.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: delete approval

                    notifyDataSetChanged();
                }
            });

            ibAddScheduleApproval.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: compare then send to menu 3

                    notifyDataSetChanged();
                }
            });
        }
    }
}
