package edu.cvtc.jdiederich2.workorders;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jdiederich2 on 5/17/2018.
 */

public class WorkOrderListAdapter extends RecyclerView.Adapter<WorkOrderListAdapter.WorkOrderViewHolder> {

    private List<WorkOrderModel> workOrderModelList;
    private View.OnClickListener onClickListener;

    public WorkOrderListAdapter(List<WorkOrderModel> workOrderModelList, View.OnClickListener onClickListener) {
        this.workOrderModelList = workOrderModelList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public WorkOrderListAdapter.WorkOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_workorders, parent, false);
        return new WorkOrderViewHolder(itemView);
    }

    class WorkOrderViewHolder extends RecyclerView.ViewHolder {
        private final TextView mFirstName;
        private final TextView mLastName;
        private final TextView mPhone;
        private final TextView mAddress;
        private final TextView mCity;
        private final TextView mAccountNumber;
        private final TextView mInstallDate;

        private WorkOrderViewHolder(View itemView) {
            super(itemView);
            mFirstName = itemView.findViewById( R.id.editText_FirstName);
            mLastName = itemView.findViewById( R.id.editText_LastName);
            mPhone = itemView.findViewById( R.id.editText_Phone);
            mAddress = itemView.findViewById( R.id.editText_Address);
            mCity = itemView.findViewById(R.id.editText_City);
            mAccountNumber = itemView.findViewById( R.id.editText_AcctNumber);
            mInstallDate = itemView.findViewById( R.id.editText_InstallDate);
        }
    }

    private final LayoutInflater mInflater;
    private LiveData<List<WorkOrderModel>> mWorkOrders;

    WorkOrderListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }




    @Override
    public void onBindViewHolder(@NonNull WorkOrderListAdapter.WorkOrderViewHolder holder, int position) {
        if(null != mWorkOrders) {
            WorkOrderModel current = mWorkOrders.getValue().get(position);
            holder.mFirstName.setText(current.g
        } else {
            holder.mFirstName.setText("No First Name");
            holder.mLastName.setText("No Last Name");
            holder.mPhone.setText("No Phone Number");
            holder.mAddress.setText("No Address");
            holder.mCity.setText("No City");
            holder.mAccountNumber.setText("No Account Number");
            holder.mInstallDate.setText("No Install Date");
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

